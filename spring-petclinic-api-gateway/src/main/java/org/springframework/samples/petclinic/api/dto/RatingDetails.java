package org.springframework.samples.petclinic.api.dto;

public record RatingDetails(
    Integer id,
    int visitId,
    int vetId,
    Integer stars,
    String comment
) {
}
