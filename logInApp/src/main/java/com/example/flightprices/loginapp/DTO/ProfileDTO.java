package com.example.flightprices.loginapp.DTO;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {
   @Positive(message = "user id most be positive number only")
    private Integer user_id;

    @NotBlank(message = "First name cannot be empty")
    private String firstName;


    @NotBlank(message = "Last name cannot be empty")
    private String lastName;


    @NotBlank(message = "Address cannot be empty")
    private String address;


    @NotEmpty(message = "Phone number cannot be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Phone number must start with '05' and be exactly 10 digits.")
    private String phoneNumber;


    private String bio;
}
