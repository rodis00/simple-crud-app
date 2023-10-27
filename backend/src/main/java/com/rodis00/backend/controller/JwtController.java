package com.rodis00.backend.controller;

import com.rodis00.backend.dto.TokenReqResponse;
import com.rodis00.backend.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class JwtController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<Object> generateToken(@RequestBody TokenReqResponse tokenReqResponse) {
        if (tokenReqResponse.getEmail().equals("harry.potter@magic.com") && tokenReqResponse.getPassword().equals("password123")) {
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
