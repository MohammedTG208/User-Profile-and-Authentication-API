package com.example.flightprices.loginapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "Varchar(255) not null")
    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @Column(columnDefinition = "Varchar(255) not null")
    @NotBlank(message = "Last name cannot be empty")
    private String lastName;

    @Column(columnDefinition = "Varchar(255) not null")
    @NotBlank(message = "Address cannot be empty")
    private String address;

    @Column(columnDefinition = "Varchar(10) not null", unique = true)
    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and be exactly 10 digits.")
    private String phoneNumber;

    @Column(columnDefinition = "Varchar(255)")
    private String bio;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

}
