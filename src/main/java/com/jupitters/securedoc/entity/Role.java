package com.jupitters.securedoc.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jupitters.securedoc.enums.Authority;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Role extends Auditable{
    private String name;
    private Authority authorities;
}
