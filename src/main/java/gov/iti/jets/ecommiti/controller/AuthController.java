package gov.iti.jets.ecommiti.controller;

import gov.iti.jets.ecommiti.dtos.request.LoginRequest;
import gov.iti.jets.ecommiti.dtos.request.SignupRequest;

import gov.iti.jets.ecommiti.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        return authService.signin(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {

        return authService.signup(signUpRequest);


    }
}
