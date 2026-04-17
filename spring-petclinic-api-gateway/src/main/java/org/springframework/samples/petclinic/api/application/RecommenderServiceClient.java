package org.springframework.samples.petclinic.api.application;

import org.springframework.samples.petclinic.api.dto.ProductDetails;
import org.springframework.samples.petclinic.api.dto.RecommendationRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class RecommenderServiceClient {
    private final WebClient.Builder webClientBuilder;
    public RecommenderServiceClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;


    }

    public Flux<ProductDetails> getRecommendationsForOwner(RecommendationRequest recommendationRequest){
        return webClientBuilder.build().post()
            .uri("http://recommender-service/recommendations")
            .bodyValue(recommendationRequest)
            .retrieve()
            .bodyToFlux(ProductDetails.class);
    }
}
