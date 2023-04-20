package com.jotc.api.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Setter
@Getter
@JsonInclude(NON_NULL)
public class JOTCRequest {

    @NonNull
    String input;
    String firstName;
    String lastName;
    @NonNull
    String email;
}
