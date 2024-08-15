package com.bomfim.sample.stock.service;

import com.bomfim.sample.stock.IStockService;
import com.bomfim.sample.stock.controller.StockInputDto;
import com.bomfim.sample.stock.domain.StockEntity;
import com.bomfim.sample.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService implements IStockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Optional<StockEntity> getStock(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public StockEntity incrementStock(StockInputDto stockInputDto) {
        return stockRepository.incrementStock(stockInputDto.productId(), stockInputDto.quantity());
    }
}
