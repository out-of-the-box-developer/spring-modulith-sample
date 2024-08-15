package com.bomfim.sample.product;

import com.bomfim.sample.product.controller.ProductInputDto;
import com.bomfim.sample.product.domain.ProductEntity;

import java.util.Optional;

public interface IProductService {
    Optional<ProductEntity> getProductById(Long id);
    ProductEntity createProduct(ProductInputDto productInputDto);
}
