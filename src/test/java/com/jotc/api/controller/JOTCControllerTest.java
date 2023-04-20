package com.jotc.api.controller;

import com.jotc.api.service.JOTCService;
import com.jotc.api.service.dto.JOTCRequest;
import com.jotc.api.service.dto.JOTCResponse;
import com.jotc.api.service.dto.UserRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JOTCControllerTest {

    @InjectMocks
    private JOTCController controller;

    @Mock
    private JOTCService service;

    @Test
    void test_getJOTCResults() {
        when(service.getJOTCResults(any())).thenReturn(JOTCResponse.builder().build());
        ResponseEntity<JOTCResponse> response = controller.getJOTCResults(new JOTCRequest());
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void test_getRequests() {
        ResponseEntity<UserRequest> response = controller.getRequests();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void test_removeUserRequests() {
        ResponseEntity<Void> response = controller.removeUserRequests("email");
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
