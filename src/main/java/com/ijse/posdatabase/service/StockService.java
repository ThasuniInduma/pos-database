package com.ijse.posdatabase.service;

import org.springframework.stereotype.Service;

import com.ijse.posdatabase.entity.Stock;

@Service
public interface StockService {

    Stock getStockById(Long id);
    Integer getStockByItem(Long itemId);
    Stock addStock(Long itemId, int qty);
    Stock updateStock(Long stockId, int qty);
    
}
