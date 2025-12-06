package com.jupitters.securedoc.event;

import com.jupitters.securedoc.entity.User;
import com.jupitters.securedoc.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {
    private User user;
    private EventType type;
    private Map<?, ?> data;
}
