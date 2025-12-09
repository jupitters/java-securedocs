package com.jupitters.securedoc.service.impl;

import com.jupitters.securedoc.entity.Confirmation;
import com.jupitters.securedoc.entity.Credential;
import com.jupitters.securedoc.entity.Role;
import com.jupitters.securedoc.entity.User;
import com.jupitters.securedoc.enums.Authority;
import com.jupitters.securedoc.enums.EventType;
import com.jupitters.securedoc.event.UserEvent;
import com.jupitters.securedoc.exception.ApiException;
import com.jupitters.securedoc.repository.ConfirmationRepository;
import com.jupitters.securedoc.repository.CredentialRepository;
import com.jupitters.securedoc.repository.RoleRepository;
import com.jupitters.securedoc.repository.UserRepository;
import com.jupitters.securedoc.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.jupitters.securedoc.utils.UserUtils.createUserEntity;

@Service
@Transactional(rollbackOn =  Exception.class)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;
    private final BCryptPasswordEncoder encoder;
    private final ApplicationEventPublisher publisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
        var user = userRepository.save(createNewUser(firstName, lastName, email));
        var credential = new Credential(user, password);
        credentialRepository.save(credential);
        var confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);
        publisher.publishEvent(new UserEvent(user, EventType.REGISTRATION, Map.of("key", confirmation.getKey())));
    }

    @Override
    public Role getRoleName(String name) {
        var role = roleRepository.findByNameIgnoreCase(name);
        return role.orElseThrow(() -> new ApiException("Role not found!"));
    }

    private User createNewUser(String firstName, String lastName, String email) {
        var role = getRoleName(Authority.USER.name());
        return createUserEntity(firstName, lastName, email, role);
    }
}
