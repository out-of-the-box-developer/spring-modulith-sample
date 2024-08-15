
package com.bomfim.sample.stock;

import com.bomfim.sample.stock.controller.StockInputDto;
import com.bomfim.sample.stock.domain.StockEntity;

import java.util.Optional;

public interface IStockService {
    Optional<StockEntity> getStock(Long id);

    StockEntity incrementStock(StockInputDto stockInputDto);
}
