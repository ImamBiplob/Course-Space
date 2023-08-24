package com.imambiplob.coursespace.service;

import com.imambiplob.coursespace.dto.Advisor;
import com.imambiplob.coursespace.dto.UserProfile;
import com.imambiplob.coursespace.entity.User;
import com.imambiplob.coursespace.repository.UserRepository;
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

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        User user = null;
        if(userRepository.findById(id).isPresent())
            user = userRepository.findById(id).get();
        return user;
    }

    public UserProfile addAdvisor(Advisor advisor) {
        User user = new User();
        user.setRole("Advisor");
        user.setName(advisor.getName());
        user.setPassword(advisor.getPassword());
        user.setEmail(advisor.getEmail());

        return convertUserToUserProfile(userRepository.save(user));
    }

    public List<UserProfile> getAdvisors() {
        return userRepository.findAll().stream()
                .filter(user -> Objects.equals(user.getRole(), "Advisor"))
                .map(UserService::convertUserToUserProfile).toList();
    }

    public UserProfile getAdvisor(long id) {
        UserProfile userProfile = null;
        if(userRepository.findById(id).isPresent())
            userProfile = convertUserToUserProfile(userRepository.findById(id).get());

        return userProfile;
    }
}