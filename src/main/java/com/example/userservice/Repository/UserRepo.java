package com.example.userservice.Repository;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
