package com.jupitters.securedoc;

import com.jupitters.securedoc.domain.RequestContext;
import com.jupitters.securedoc.entity.Role;
import com.jupitters.securedoc.enums.Authority;
import com.jupitters.securedoc.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class SecuredocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredocApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleRepository roleRepository) {
		return args -> {
			RequestContext.setUserId(0L);
			var userRole = new Role();
			userRole.setName(Authority.USER.name());
			userRole.setAuthorities(Authority.USER);
			roleRepository.save(userRole);

			var adminRole = new Role();
			adminRole.setName(Authority.ADMIN.name());
			adminRole.setAuthorities(Authority.ADMIN);
			roleRepository.save(adminRole);
			RequestContext.start();
		};
	}
}
