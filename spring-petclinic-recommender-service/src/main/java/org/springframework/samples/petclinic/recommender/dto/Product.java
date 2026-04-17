package org.springframework.samples.petclinic.recommender.dto;

import java.math.BigDecimal;

public record Product(Integer id, String name, String description, BigDecimal price, int stockQuantity) {
}
