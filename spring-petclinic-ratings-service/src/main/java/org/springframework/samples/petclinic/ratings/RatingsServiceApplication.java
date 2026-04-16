package org.springframework.samples.petclinic.ratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RatingsServiceApplication {
    public static void main(String[] args) {
    SpringApplication.run(RatingsServiceApplication.class, args);
    }
}
