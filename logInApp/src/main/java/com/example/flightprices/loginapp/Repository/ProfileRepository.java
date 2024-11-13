package com.example.flightprices.loginapp.Repository;

import com.example.flightprices.loginapp.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    Profile findProfileById(Integer id);
}
