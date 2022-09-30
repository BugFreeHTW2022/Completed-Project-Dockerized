package htw.kbe.identitymanagementservice.api.controllers;

import htw.kbe.identitymanagementservice.persistence.entities.UserEntity;
import htw.kbe.identitymanagementservice.api.payload.request.LoginRequest;
import htw.kbe.identitymanagementservice.api.payload.request.SignupRequest;
import htw.kbe.identitymanagementservice.api.payload.response.JwtResponse;
import htw.kbe.identitymanagementservice.api.payload.response.MessageResponse;
import htw.kbe.identitymanagementservice.persistence.repository.UserRepository;
import htw.kbe.identitymanagementservice.security.jwt.JwtUtils;
import htw.kbe.identitymanagementservice.security.services.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    final static String ERROR_USERNAME_IS_ALREADY_TAKEN = "Error: Username is already taken!";

    final static String ERROR_EMAIL_IS_ALREADY_TAKEN = "Error: Email is already in use!";

    final static String MESSAGE_USER_WAS_SUCCESSFULLY_CREATED = "User registered successfully!";

    final AuthenticationManager authenticationManager;

    final UserRepository userRepository;

    final PasswordEncoder encoder;

    final JwtUtils jwtUtils;

    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generate(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()
        ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        // check if user already exists in Database
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(ERROR_USERNAME_IS_ALREADY_TAKEN));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(ERROR_EMAIL_IS_ALREADY_TAKEN));
        }

        // Create new user's account
        UserEntity user = new UserEntity(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword())
        );

        // save user to database
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse(MESSAGE_USER_WAS_SUCCESSFULLY_CREATED));
    }
}
