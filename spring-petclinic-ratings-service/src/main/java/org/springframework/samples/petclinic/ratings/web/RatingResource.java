package org.springframework.samples.petclinic.ratings.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.samples.petclinic.ratings.model.Rating;
import org.springframework.samples.petclinic.ratings.model.RatingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ratings")
@RestController
public class RatingResource {

    private static final Logger log = LoggerFactory.getLogger(RatingResource.class);

    private final RatingRepository ratingRepository;

    public RatingResource(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @PostMapping("/visit/{visitId}")
    public Rating create(@Valid @RequestBody Rating rating, @PathVariable("visitId") @Min(1) int visitId) {
        rating.setVisitId(visitId);
        log.info("Saving rating {}", rating);
        return ratingRepository.save(rating);
    }

    @GetMapping("/visit/{visitId}")
    public Rating getVisitRating(@PathVariable("visitId") @Min(1) int visitId){
        return ratingRepository.findByVisitId(visitId);
    }

    @GetMapping("/stats/vet/{vetId}")
    public Double getAverageRatingForVet(@PathVariable("vetId") int vetId) {
        List<Rating> ratings = ratingRepository.findByVetId(vetId);
        return ratings.stream()
            .filter(r -> r.getStars() != null)
            .mapToInt(Rating::getStars)
            .average()
            .orElse(0.0);
    }

    @GetMapping("/vet/{vetId}")
    public List<Rating> getRatingsForVet(@PathVariable("vetId") int vetId) {
        return  ratingRepository.findByVetId(vetId);
    }
}
//@Timed usage cache benefit
