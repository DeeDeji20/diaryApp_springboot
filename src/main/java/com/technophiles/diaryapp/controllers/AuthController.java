package com.technophiles.diaryapp.controllers;

import com.technophiles.diaryapp.controllers.requests.AuthToken;
import com.technophiles.diaryapp.controllers.requests.LoginRequest;
import com.technophiles.diaryapp.models.User;
import com.technophiles.diaryapp.security.jwt.TokenProvider;
import com.technophiles.diaryapp.security.jwt.TokenProviderImpl;
import com.technophiles.diaryapp.services.UserService;
import com.technophiles.diaryapp.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v3/diaryApp/auth")
@Slf4j
public class AuthController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    TokenProviderImpl tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
       Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateJWTToken(authentication);
        User user = userService.findUserByEmail(loginRequest.getEmail());
        log.info("Hit endpointchain");
        return new ResponseEntity<>(new AuthToken(token, user.getId()), HttpStatus.OK);
    }
}
