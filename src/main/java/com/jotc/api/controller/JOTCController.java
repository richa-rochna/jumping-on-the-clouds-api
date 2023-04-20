package com.jotc.api.controller;

import com.jotc.api.service.JOTCService;
import com.jotc.api.service.dto.JOTCRequest;
import com.jotc.api.service.dto.JOTCResponse;
import com.jotc.api.service.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jotc")
public class JOTCController {

    private final JOTCService jotcService;

    @PostMapping("/results")
    public ResponseEntity<JOTCResponse> getJOTCResults(@RequestBody JOTCRequest request) {

        JOTCResponse JOTCResponse = jotcService.getJOTCResults(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(JOTCResponse);
    }

    @GetMapping("/admin/requests")
    public ResponseEntity<UserRequest> getRequests(){
        return ResponseEntity.ok(jotcService.getRequests());
    }

    @DeleteMapping("/admin/users/remove")
    public ResponseEntity<Void> removeUserRequests(@RequestParam("userEmail") String userEmail){
        jotcService.removeUserRequests(userEmail);
        return ResponseEntity.noContent().build();
    }
}
