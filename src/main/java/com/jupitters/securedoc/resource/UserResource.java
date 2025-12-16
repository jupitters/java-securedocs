package com.jupitters.securedoc.resource;

import com.jupitters.securedoc.domain.Response;
import com.jupitters.securedoc.dtorequest.UserRequest;
import com.jupitters.securedoc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

import static com.jupitters.securedoc.utils.RequestUtils.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request, emptyMap(), "Account Created! Check your email to enable your account.", CREATED));
    }

    @GetMapping("/verify/account")
    public ResponseEntity<Response> verifyAccount(@RequestParam("token") String token, HttpServletRequest request) {
        userService.verifyAccountKey(token);
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "Account verified!", OK));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequest user) {
        Authentication authenticate = authenticationManager.authenticate(UsernamePasswordAuthenticationToken
                        .unauthenticated(user.getEmail(), user.getPassword()));
        return ResponseEntity.ok().body(Map.of("user", authenticate));
    }

    private URI getUri() {
        return URI.create("");
    }
}
