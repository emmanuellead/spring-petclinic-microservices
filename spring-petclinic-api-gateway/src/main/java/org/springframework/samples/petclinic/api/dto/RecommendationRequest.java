package org.springframework.samples.petclinic.api.dto;

import java.util.List;

public record RecommendationRequest(List<PetType> petTypes, List<ProductDetails> products) {
}
