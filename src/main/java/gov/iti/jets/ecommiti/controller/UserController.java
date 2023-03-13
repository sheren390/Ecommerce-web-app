package gov.iti.jets.ecommiti.controller;

import gov.iti.jets.ecommiti.models.ResponseViewModel;
import gov.iti.jets.ecommiti.models.User;
import gov.iti.jets.ecommiti.repositories.UserRepository;
import gov.iti.jets.ecommiti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test/users")
// @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class UserController {
    @Autowired
    UserService userService;

    // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseViewModel getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseViewModel getUserById(@PathVariable("id") Integer id) {
        return userService.getuserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        return updatedUser;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
