package com.bomfim.sample.stock.controller;

import com.bomfim.sample.stock.domain.StockEntity;
import com.bomfim.sample.stock.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PutMapping
    public ResponseEntity<StockEntity> incrementStock(@RequestBody StockInputDto stockInputDto) {
        StockEntity stock = stockService.incrementStock(stockInputDto);
        return ResponseEntity.status(HttpStatus.OK).body(stock);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockEntity> getStock(@PathVariable Long id) {
        var stock = stockService.getStock(id).orElseThrow();
        return ResponseEntity.ok(stock);
    }
}
