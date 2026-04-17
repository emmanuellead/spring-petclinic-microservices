package org.springframework.samples.petclinic.recommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RecommanderApplicationService {
    public static void main(String[] args) {
        SpringApplication.run(RecommanderApplicationService.class, args);
    }

}
