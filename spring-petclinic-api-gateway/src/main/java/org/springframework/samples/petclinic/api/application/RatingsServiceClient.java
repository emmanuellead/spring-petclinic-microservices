package org.springframework.samples.petclinic.api.application;

import org.springframework.samples.petclinic.api.dto.RatingDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RatingsServiceClient {

    private final WebClient.Builder webClientBuilder;

    public RatingsServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Double> getAverageRatingForVet(Integer vetId) {
        return webClientBuilder.build().get()
            .uri("http://ratings-service/ratings/stats/vet/{vetId}", vetId)
            .retrieve()
            .bodyToMono(Double.class)
            .onErrorReturn(0.0);
    }

    public Flux<RatingDetails> getRatingsForVet(Integer vetId) {
        return webClientBuilder.build().get()
            .uri("http://ratings-service/ratings/vet/{vetId}", vetId)
            .retrieve()
            .bodyToFlux(RatingDetails.class);
    }
}
