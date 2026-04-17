package org.springframework.samples.petclinic.api.dto;

import java.math.BigDecimal;

public record ProductDetails (
    Integer id,
    String name,
    BigDecimal price,
    int stockQuantity
){
}
