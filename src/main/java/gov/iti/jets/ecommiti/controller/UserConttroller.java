package gov.iti.jets.ecommiti.controller;

import gov.iti.jets.ecommiti.models.User;
import gov.iti.jets.ecommiti.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserConttroller {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll(){
        return userRepository.findAll();
    }
}
