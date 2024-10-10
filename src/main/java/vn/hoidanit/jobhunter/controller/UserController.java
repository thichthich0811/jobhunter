package vn.hoidanit.jobhunter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

@RequestMapping("/api/v1")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.handleCreateUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchAllUser() {
        return userService.fetchAllUser();
    }

    @GetMapping("/users/{id}")
    public User fetchUserById(@PathVariable("id") Long id) {
        return userService.fetchUserById(id);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        return userService.handleUpdateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "delete success";
    }
}
