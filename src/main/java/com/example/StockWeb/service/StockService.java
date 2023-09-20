package com.example.StockWeb.service;

import com.example.StockWeb.model.StockDTO;

import java.util.Set;

public interface StockService {
    StockDTO extractStockDataFromYahoo(String stockTicker);

}
