package com.imambiplob.coursespace.controller;

import com.imambiplob.coursespace.dto.Advisor;
import com.imambiplob.coursespace.dto.UserProfile;
import com.imambiplob.coursespace.entity.User;
import com.imambiplob.coursespace.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admins")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/addAdvisor")
    public ResponseEntity<?> addAdvisor(@RequestBody Advisor advisor) {
        return userService.addAdvisor(advisor);
    }

    @GetMapping("/getAdvisors")
    public List<UserProfile> getAdvisors() {
        return userService.getAdvisors();
    }

    @GetMapping("/getAdvisor/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable long id) {
        return userService.getAdvisor(id);
    }

    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

}
