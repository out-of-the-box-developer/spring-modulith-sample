package com.bomfim.sample.stock.event;

import com.bomfim.sample.product.event.ProductCreatedEvent;
import com.bomfim.sample.stock.domain.StockEntity;
import com.bomfim.sample.stock.repository.StockRepository;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ProductEventListener {

    private final StockRepository stockRepository;

    public ProductEventListener(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @ApplicationModuleListener
    void on(ProductCreatedEvent event) {

        if (new Random().nextBoolean()) {
            throw new RuntimeException("Some internal error");
        }
        var productId = event.productId();

        stockRepository.save(new StockEntity(productId, 1L));

    }

}
