package com.ijse.posdatabase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.posdatabase.entity.Item;
import com.ijse.posdatabase.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {

    Optional<Stock> findByItem(Item item);
    
}
