package org.springframework.samples.petclinic.recommender.web;

import jakarta.validation.Valid;
import org.springframework.samples.petclinic.recommender.dto.PetType;
import org.springframework.samples.petclinic.recommender.dto.Product;
import org.springframework.samples.petclinic.recommender.dto.RecommendationRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecommenderResource {

    @PostMapping("/recommendations")
    public List<Product>getRecommendations( @RequestBody RecommendationRequest recommendationRequest){
        List<Product> products = recommendationRequest.products();
        List<String> petTypes = recommendationRequest.petTypes().stream().map(PetType::name).toList();
       return  products.stream().filter(p->petTypes.stream().anyMatch(type-> p.name().toLowerCase().contains(type))).collect(Collectors.toList());
    }


}
