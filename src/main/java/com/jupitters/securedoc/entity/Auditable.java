package com.jupitters.securedoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jupitters.securedoc.domain.RequestContext;
import com.jupitters.securedoc.exception.ApiException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt"}, allowGetters = true)
public abstract class Auditable {


    @PrePersist
    public void beforePersists(){
        var userId = RequestContext.getUserId();
        if(userId == null) {
            throw new ApiException("Cannot persist entity without user ID in Request Context for this thread");
        };
        setCreatedAt(LocalDateTime.now());
        setCreatedBy(userId);
        setUpdatedBy(userId);
        setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void beforeUpdate(){
        var userId = RequestContext.getUserId();
        if(userId == null) {
            throw new ApiException("Cannot update entity without user ID in Request Context for this thread");
        };
        setUpdatedAt(LocalDateTime.now());
        setUpdatedBy(userId);

    }
}
