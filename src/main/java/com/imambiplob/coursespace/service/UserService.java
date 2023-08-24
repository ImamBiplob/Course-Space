package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.dto.Advisor;
import com.imambiplob.coursespace.dto.UserProfile;
import com.imambiplob.coursespace.entity.User;
import com.imambiplob.coursespace.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserProfile convertUserToUserProfile(User user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setName(user.getName());
        userProfile.setEmail(user.getEmail());
        userProfile.setRole(user.getRole());

        return userProfile;
    }

    public ResponseEntity<?> saveUser(User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> getUser(long id) {
        User user = null;
        if(userRepository.findById(id).isPresent())
            user = userRepository.findById(id).get();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    public ResponseEntity<?> addAdvisor(Advisor advisor) {
        User user = new User();
        user.setRole("Advisor");
        user.setName(advisor.getName());
        user.setPassword(advisor.getPassword());
        user.setEmail(advisor.getEmail());

        return new ResponseEntity<>(convertUserToUserProfile(userRepository.save(user)),HttpStatus.OK);
    }

    public List<UserProfile> getAdvisors() {
        return userRepository.findAll().stream()
                .filter(user -> Objects.equals(user.getRole(), "Advisor"))
                .map(UserService::convertUserToUserProfile).toList();
    }

    public ResponseEntity<?> getAdvisor(long id) {
        UserProfile userProfile = null;
        if(userRepository.findById(id).isPresent())
            userProfile = convertUserToUserProfile(userRepository.findById(id).get());

        return new ResponseEntity<>( userProfile,HttpStatus.OK);
    }
}