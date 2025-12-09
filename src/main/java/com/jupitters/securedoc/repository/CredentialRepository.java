package com.jupitters.securedoc.repository;

import com.jupitters.securedoc.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> getCredentialsByUserId(Long id);
}
