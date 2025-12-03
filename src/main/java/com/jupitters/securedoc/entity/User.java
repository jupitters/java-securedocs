package com.jupitters.securedoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class User extends Auditable{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(
                                name = "user_id", referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(
                                        name = "role_id", referencedColumnName = "id"))
    private Role role;
}
