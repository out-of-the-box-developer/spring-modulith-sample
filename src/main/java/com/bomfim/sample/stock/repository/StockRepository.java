package com.bomfim.sample.stock.repository;

import com.bomfim.sample.stock.domain.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends JpaRepository<StockEntity, Long> {


    @Modifying
    @Query("UPDATE StockEntity s set s.quantity = :quantity where s.productId = :productId ")
    StockEntity incrementStock(@Param("productId") Long productId, @Param("quantity") Long quantity);
}
