package org.springframework.samples.petclinic.api.dto;

import java.util.List;

public record VetWithRatings(
    VetDetails vet,
    List<RatingDetails> ratings
) {
}
