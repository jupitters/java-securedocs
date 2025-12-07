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


}
