package com.jotc.api.service;

import com.jotc.api.data.model.UserRequests;
import com.jotc.api.data.repository.UserDetailsRepository;
import com.jotc.api.data.repository.UserRequestsRepository;
import com.jotc.api.service.dto.JOTCRequest;
import com.jotc.api.service.dto.JOTCResponse;
import com.jotc.api.service.dto.UserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JOTCServiceTest {

    @InjectMocks
    JOTCService service;

    @Mock
    UserRequestsRepository userRequestsRepository;

    @Mock
    UserDetailsRepository userDetailsRepository;

    @Test
    void test_getJOTCResults() {
        JOTCRequest request = new JOTCRequest();
        request.setEmail("abc@gmail.com");
        request.setInput("0 0 0 1 0 1 0 0");
        request.setFirstName("abc");
        JOTCResponse response = service.getJOTCResults(request);
        assertNotNull(response);
        assertEquals(4, response.getJumps());
    }

    @Test
    void test_getRequests() {
        List<UserRequests> userRequestsList = new ArrayList<>();
        userRequestsList.add(UserRequests
                .builder()
                .input("0 0 0 1 0 1 0 0")
                .email("abc@gmail.com")
                .build());
        when(userRequestsRepository.findAll()).thenReturn(userRequestsList);
        UserRequest userRequest = service.getRequests();
        assertNotNull(userRequest);
        assertEquals(1, userRequest.getTotalRequests());
    }
}
