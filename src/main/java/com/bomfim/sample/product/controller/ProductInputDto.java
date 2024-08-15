package com.bomfim.sample.product.controller;

import java.math.BigDecimal;

public record ProductInputDto(String name, BigDecimal price) {
}
