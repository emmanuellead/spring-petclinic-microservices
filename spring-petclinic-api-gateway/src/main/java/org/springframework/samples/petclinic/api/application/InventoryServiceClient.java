package org.springframework.samples.petclinic.api.application;

import org.springframework.samples.petclinic.api.dto.ProductDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class InventoryServiceClient {
    private final WebClient.Builder webClientBuilder;

    public InventoryServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<ProductDetails> getProducts() {
        return webClientBuilder.build().get()
            .uri("http://inventory-service/products")
            .retrieve()
            .bodyToFlux(ProductDetails.class);
    }
}
