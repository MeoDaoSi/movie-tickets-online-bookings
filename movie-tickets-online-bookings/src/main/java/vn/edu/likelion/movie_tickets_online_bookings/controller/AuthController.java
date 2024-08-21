package vn.edu.likelion.movie_tickets_online_bookings.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.likelion.movie_tickets_online_bookings.dto.request.LoginRequest;
import vn.edu.likelion.movie_tickets_online_bookings.dto.response.TokenResponse;
import vn.edu.likelion.movie_tickets_online_bookings.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping
    private ResponseEntity<TokenResponse> userLogin(@RequestBody LoginRequest loginRequest){
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(authService.login(loginRequest));
        return new ResponseEntity<>(tokenResponse, HttpStatus.OK );
    }
}
