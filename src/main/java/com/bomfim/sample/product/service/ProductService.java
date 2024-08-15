package com.bomfim.sample.product.service;

import com.bomfim.sample.product.IProductService;
import com.bomfim.sample.product.controller.ProductInputDto;
import com.bomfim.sample.product.domain.ProductEntity;
import com.bomfim.sample.product.event.ProductCreatedEvent;
import com.bomfim.sample.product.repository.ProductRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ApplicationEventPublisher events;

    private final ProductRepository productRepository;

    public ProductService(ApplicationEventPublisher events, ProductRepository productRepository) {
        this.events = events;
        this.productRepository = productRepository;
    }

    @Override
    public Optional<ProductEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public ProductEntity createProduct(ProductInputDto productInputDto) {
        ProductEntity product = productRepository.save(new ProductEntity(productInputDto.name(), productInputDto.price()));
        events.publishEvent(new ProductCreatedEvent(product.getId()));
        return product;
    }

}
