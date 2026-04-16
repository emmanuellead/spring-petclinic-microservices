package org.springframework.samples.petclinic.ratings.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    Rating findByVisitId(int visitId);

    List<Rating> findByVetId(int vetId);
}
