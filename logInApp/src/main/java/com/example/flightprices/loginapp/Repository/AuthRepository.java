package com.example.flightprices.loginapp.Repository;

import com.example.flightprices.loginapp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
    User findUserById(Integer id);
}
