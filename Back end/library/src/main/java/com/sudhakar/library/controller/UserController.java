package com.sudhakar.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.library.entity.Role;
import com.sudhakar.library.entity.User;
import com.sudhakar.library.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity<List<User>> getAllMember() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{usernameOrEmail}")
    public ResponseEntity<User> getMemberByUsernameOrEmail(@PathVariable String usernameOrEmail) {
        return userService.getUserByUsernameOrEmail(usernameOrEmail);
    }

    @PostMapping("/save/user")
    public ResponseEntity<User> saveMember(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/update/{usernameOrEmail}")
    public ResponseEntity<User> updateUserByUsernameOrEmail(@PathVariable String usernameOrEmail,
            @RequestBody User updateUser) {
        return userService.updateUserByUsernameOrEmail(usernameOrEmail, updateUser);
    }

    @DeleteMapping("/delete/{usernameOrEmail}")
    public ResponseEntity<Void> deleteUserByUsernameOrEmail(@PathVariable String usernameOrEmail) {
        return userService.deleteUserByUsernameOrEmail(usernameOrEmail);
    }

    @GetMapping("/get/by-role/{role}")
    public ResponseEntity<List<User>> getUserByRole(@PathVariable Role role) {
        return userService.getUsersByRole(role);
    }
}