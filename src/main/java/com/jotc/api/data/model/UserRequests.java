package com.jotc.api.data.model;

import com.jotc.api.service.dto.JOTCRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "userRequests")
@NoArgsConstructor
@AllArgsConstructor
public class UserRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String input;
    private int output;

    public static UserRequests buildUserRequestsDetails(JOTCRequest request, int jumps) {
        return builder()
                .email(request.getEmail())
                .input(request.getInput())
                .output(jumps)
                .build();
    }
}
