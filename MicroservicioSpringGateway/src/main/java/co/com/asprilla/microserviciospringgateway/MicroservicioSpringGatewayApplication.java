package co.com.asprilla.microserviciospringgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicioSpringGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioSpringGatewayApplication.class, args);
    }

}
