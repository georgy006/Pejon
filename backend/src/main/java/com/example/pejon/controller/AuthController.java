package com.example.pejon.controller;

import com.example.pejon.jwt_security.JwtUtil;
import com.example.pejon.model.User;
import com.example.pejon.model.dto.auth.AuthRequest;
import com.example.pejon.model.dto.auth.AuthResponse;
import com.example.pejon.model.dto.auth.RegisterRequest;
import com.example.pejon.repository.UserRepository;
import com.example.pejon.service.Impl.CustomUserDetailsServiceImpl;
import com.example.pejon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> createToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.login(), authRequest.password())
            );
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid login or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.login());
        final String jwt = jwtUtil.generateToken(userDetails);
        final User user = userRepository.findByLogin(authRequest.login())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return ResponseEntity.ok(new AuthResponse(jwt, user.getId()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest request) {
        try {
            userService.register(request);
            return ResponseEntity.ok("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}