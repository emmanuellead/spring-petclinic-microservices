package org.springframework.samples.petclinic.recommender.dto;

import java.util.List;

public record RecommendationRequest(List<PetType> petTypes, List<Product> products) {
}
