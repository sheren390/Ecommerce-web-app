package gov.iti.jets.ecommiti.controller;

import gov.iti.jets.ecommiti.models.User;
import gov.iti.jets.ecommiti.repositories.UserRepository;
import gov.iti.jets.ecommiti.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class UserConttroller {
    @Autowired
    UserService userService;

    @GetMapping("/users")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAll(){
        return userService.getAll();
    }
}
