package com.ijse.posdatabase.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.posdatabase.entity.Item;
import com.ijse.posdatabase.entity.Stock;
import com.ijse.posdatabase.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemService itemService;

    @Override
    public Stock getStockById(Long id){
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Integer getStockByItem(Long itemId){
        Item item = itemService.getItemById(itemId);
        if (item != null) {
            Optional<Stock> stockOptional = stockRepository.findByItem(item);
            return stockOptional.map(Stock::getQty).orElse(null);
        } else {
            throw new IllegalArgumentException("Item not found");
        }
    }

    @Override
    public Stock addStock(Long itemId, int qty){
        validateQuantity(qty);
        Item item = itemService.getItemById(itemId);
        if(item !=  null){
            Stock stock = new Stock();
            stock.setItem(item);
            stock.setQty(qty);

            stockRepository.save(stock);
        }
        throw new IllegalArgumentException("Item not found");
    }

    @Override
    public Stock updateStock(Long stockId, int qty){
        validateQuantity(qty);
        Stock stock = getStockById(stockId);
        if (stock != null) {
            stock.setQty(qty);
            stockRepository.save(stock);
        }
        throw new IllegalArgumentException("Stock not found");
    }

    private void validateQuantity(int qty){
        if(qty <= 0){
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }
    
}
