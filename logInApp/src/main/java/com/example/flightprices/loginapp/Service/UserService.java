package com.example.flightprices.loginapp.Service;

import com.example.flightprices.loginapp.Api.ApiException;
import com.example.flightprices.loginapp.Model.User;
import com.example.flightprices.loginapp.Repository.AuthRepository;
import com.example.flightprices.loginapp.Repository.ProfileRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.integrator.spi.Integrator;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AuthRepository authRepository;
    private final ProfileRepository profileRepository;
    private final AuthenticationManager authenticationManager;

    public void registerUser(User user) {
        user.setRole("USER");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        authRepository.save(user);
    }

    public void logInUser(User user) {
       try {
           if (authRepository.findUserByUsername(user.getUsername()) == null) {
               throw new ApiException("This user does not exist register");
           }
           Authentication authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
           SecurityContextHolder.getContext().setAuthentication(authentication);
       }catch (ApiException e){
           throw e;
       }
       catch(Exception e) {
           throw new ApiException("Invalid username or password");
       }
    }


    public List<User> getAllUsersForAdmin() {
        return authRepository.findAll().isEmpty()?null:authRepository.findAll();
    }

    public User displayUserInfo(User user) {
        return authRepository.findUserByUsername(user.getUsername());
    }

    public User searchForAdmin(Integer id) {
        return authRepository.findUserById(id);
    }
}
