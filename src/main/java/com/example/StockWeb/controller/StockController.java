package com.example.StockWeb.controller;

import com.example.StockWeb.model.StockDTO;
import com.example.StockWeb.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StockController {
    private StockService stockService;

    public StockController(StockService stockService){
        this.stockService = stockService;
    }

    @RequestMapping(path = "/stock/{stockTicker}", method = RequestMethod.GET)
    public StockDTO stockInfo(@PathVariable String stockTicker){
        return stockService.extractStockDataFromYahoo(stockTicker);
    }
}
