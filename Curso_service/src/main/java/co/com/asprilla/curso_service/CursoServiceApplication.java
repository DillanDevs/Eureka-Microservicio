package co.com.asprilla.curso_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {
		"co.com.asprilla.entitylibrary",
		"co.com.asprilla.curso_service"
})
@EntityScan(basePackages = {
		"co.com.asprilla.entitylibrary.models.entity",
		"co.com.asprilla.curso_service.models.entity"
})
public class CursoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoServiceApplication.class, args);
	}

}