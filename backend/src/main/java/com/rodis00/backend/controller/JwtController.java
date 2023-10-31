package com.rodis00.backend.controller;

import com.rodis00.backend.dto.TokenReqResponse;
import com.rodis00.backend.model.User;
import com.rodis00.backend.service.AuthService;
import com.rodis00.backend.service.UserService;
import com.rodis00.backend.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class JwtController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthService authService;
    @Autowired
    public JwtController(JwtTokenUtil jwtTokenUtil, AuthService authService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.authService = authService;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<Object> generateToken(@RequestBody TokenReqResponse tokenReqResponse) {
        User user = authService.authenticateUser(tokenReqResponse.getEmail(), tokenReqResponse.getPassword());
        if (user != null) {
            String token = jwtTokenUtil.generateToken(tokenReqResponse.getEmail());
            TokenReqResponse tokenResponse = new TokenReqResponse();
            tokenResponse.setToken(token);
            tokenResponse.setExpirationDate("3 min");
            return ResponseEntity.accepted().body(tokenResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid credentials");
        }
    }

    @PostMapping("/validate-token")
    public ResponseEntity<Object> validateToken(@RequestBody TokenReqResponse tokenReqResponse) {
        return ResponseEntity.ok(jwtTokenUtil.validateToken(tokenReqResponse.getToken()));
    }
}
