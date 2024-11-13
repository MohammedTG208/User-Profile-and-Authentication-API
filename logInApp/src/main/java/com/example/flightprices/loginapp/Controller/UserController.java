package com.example.flightprices.loginapp.Controller;

import com.example.flightprices.loginapp.Model.User;
import com.example.flightprices.loginapp.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/auth/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.status(200).body("User registered successfully");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> loginUser( @Valid @RequestBody User user) {
        userService.logInUser(user);
        return ResponseEntity.status(200).body("login successful");
    }
    @GetMapping("/display-Info")
    public ResponseEntity<User> displayInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.status(200).body(userService.displayUserInfo(user));
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsersForAdmin());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<User> searchForAdmin(@PathVariable Integer id){
       return ResponseEntity.status(200).body(userService.searchForAdmin(id));
    }
}
