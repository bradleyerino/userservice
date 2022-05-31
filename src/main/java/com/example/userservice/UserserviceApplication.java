package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Bradley Sawyer", "Bradley", "0603", new ArrayList<>()));
			userService.saveUser(new User(null, "Allison Jadever", "Allison", "8854", new ArrayList<>()));
			userService.saveUser(new User(null, "Charlie Sawyer", "Charlie", "1223", new ArrayList<>()));
			userService.saveUser(new User(null, "ghost", "unknown", "6666", new ArrayList<>()));

			userService.addRoleToUser("Bradley", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Allison", "ROLE_MANAGER");
			userService.addRoleToUser("Charlie", "ROLE_ADMIN");
			userService.addRoleToUser("ghost", "ROLE_USER");
		};
	}
}
