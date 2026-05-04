package org.springframework.samples.petclinic.api.application;

import org.springframework.samples.petclinic.api.dto.VetDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class VetsServiceClient {

    private final WebClient.Builder webClientBuilder;

    public VetsServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Flux<VetDetails> getVets() {
        return webClientBuilder.build().get()
            .uri("http://vets-service/vets")
            .retrieve()
            .bodyToFlux(VetDetails.class);
    }

    public Mono<VetDetails> getVet(final int vetId) {
        return webClientBuilder.build().get()
            .uri("http://vets-service/vets/{vetId}", vetId)
            .retrieve()
            .bodyToMono(VetDetails.class);
    }
}
