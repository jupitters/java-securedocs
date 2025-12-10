package com.jupitters.securedoc.resource;

import com.jupitters.securedoc.domain.Response;
import com.jupitters.securedoc.dtorequest.UserRequest;
import com.jupitters.securedoc.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.jupitters.securedoc.utils.RequestUtils.getResponse;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
        userService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request, emptyMap(), "Account Created! Check your email to enable your account.", CREATED));
    }

    private URI getUri() {
        return URI.create("");
    }
}
