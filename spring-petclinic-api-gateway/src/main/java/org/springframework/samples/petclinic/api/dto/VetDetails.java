package org.springframework.samples.petclinic.api.dto;

import java.util.Set;

public record VetDetails (
    Integer id,
    String firstName,
    String lastName,
    Set<SpecialtyDetails> specialties,
    Double averageRating
) {
    public VetDetails withAverageRating(Double averageRating) {
        return new VetDetails(id, firstName, lastName, specialties, averageRating);
    }
}
