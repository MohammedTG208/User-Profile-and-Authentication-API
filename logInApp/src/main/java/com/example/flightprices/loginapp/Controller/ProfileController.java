package com.example.flightprices.loginapp.Controller;

import com.example.flightprices.loginapp.DTO.ProfileDTO;
import com.example.flightprices.loginapp.Model.User;
import com.example.flightprices.loginapp.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/add-profile")
    public ResponseEntity addNewProfile(@Valid @RequestBody ProfileDTO profileDTO, @AuthenticationPrincipal User user) {
        profileService.addProfile(profileDTO,user);
        return ResponseEntity.status(200).body("Profile added successfully");
    }

    @PutMapping("/update-profile")
    public ResponseEntity updateProfile(@Valid @RequestBody ProfileDTO profileDTO, @AuthenticationPrincipal User user) {
        profileService.updateProfile(profileDTO,user);
        return ResponseEntity.status(200).body("Profile updated Successfully");
    }

}
