package com.jupitters.securedoc.event.listener;

import com.jupitters.securedoc.event.UserEvent;
import com.jupitters.securedoc.service.EmailService;
import com.jupitters.securedoc.utils.EmailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent event) {
        switch (event.getType()) {
            case REGISTRATION -> emailService.sendNewAccountEmail(event.getUser().getFirstName(),
                    event.getUser().getEmail(),
                    (String)event.getData().get("key"));
            case RESET_PASSWORD -> emailService.sendNewAccountEmail(event.getUser().getFirstName(),
                    event.getUser().getEmail(),
                    (String)event.getData().get("key"));
            default -> {}
        }
    }
}
