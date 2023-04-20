package com.jotc.api.service;

import com.jotc.api.data.model.UserDetails;
import com.jotc.api.data.model.UserRequests;
import com.jotc.api.data.repository.UserDetailsRepository;
import com.jotc.api.data.repository.UserRequestsRepository;
import com.jotc.api.service.dto.JOTCRequest;
import com.jotc.api.service.dto.JOTCResponse;
import com.jotc.api.service.dto.User;
import com.jotc.api.service.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.jotc.api.utils.JOTCUtils.jumpingOnTheClouds;
import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
@Slf4j
@RequiredArgsConstructor
public class JOTCService {

    private final UserRequestsRepository userRequestsRepository;
    private final UserDetailsRepository userDetailsRepository;

    public JOTCResponse getJOTCResults(JOTCRequest request) {
        List<Integer> c = Arrays.stream(request.getInput().split("\\s+"))
                .map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());

        int jumps = jumpingOnTheClouds(c);
        runAsync(() -> {
            UserDetails userDetails = UserDetails.buildUserDetails(request);
            UserRequests userRequests = UserRequests.buildUserRequestsDetails(request, jumps);
            userRequestsRepository.save(userRequests);
            userDetailsRepository.save(userDetails);
        });
        return JOTCResponse.builder().jumps(jumps).build();
    }

    public UserRequest getRequests() {
        List<UserRequests> userRequests = (List<UserRequests>) userRequestsRepository.findAll();
        List<User> userList = new ArrayList<>();
        userRequests.stream()
                .collect(groupingBy(UserRequests::getEmail, LinkedHashMap::new, counting()))
                .forEach((email, requests) -> userList.add(User.builder().email(email).requests(requests).build()));
        return UserRequest.builder()
                .totalRequests(userRequests.size())
                .users(userList)
                .build();
    }

    public void removeUserRequests(String userEmail) {
        userRequestsRepository.deleteByEmail(userEmail);
    }
}
