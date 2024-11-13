package com.example.flightprices.loginapp.Service;

import com.example.flightprices.loginapp.Api.ApiException;
import com.example.flightprices.loginapp.DTO.ProfileDTO;
import com.example.flightprices.loginapp.Model.Profile;
import com.example.flightprices.loginapp.Model.User;
import com.example.flightprices.loginapp.Repository.AuthRepository;
import com.example.flightprices.loginapp.Repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final AuthRepository authRepository;

    public void addProfile(ProfileDTO profileDTO, User user) {
        User oldUser=authRepository.findUserByUsername(user.getUsername());
        Profile newProfile=new Profile(null,profileDTO.getFirstName(),profileDTO.getLastName(),profileDTO.getAddress(),profileDTO.getPhoneNumber(),profileDTO.getBio(),oldUser);
        profileRepository.save(newProfile);
    }
    public void updateProfile(ProfileDTO profileDTO,User user) {
        Profile oldProfile=profileRepository.findProfileById(user.getId());
        if (oldProfile==null){
            throw new ApiException("something went wrong try again later");
        }
        oldProfile.setFirstName(profileDTO.getFirstName());
        oldProfile.setLastName(profileDTO.getLastName());
        oldProfile.setAddress(profileDTO.getAddress());
        oldProfile.setPhoneNumber(profileDTO.getPhoneNumber());
        oldProfile.setBio(profileDTO.getBio());
        profileRepository.save(oldProfile);
    }


}
