package com.jotc.api.data.model;

import com.jotc.api.service.dto.JOTCRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "userDetails")
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;

    public static UserDetails buildUserDetails(JOTCRequest request) {
        return builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
