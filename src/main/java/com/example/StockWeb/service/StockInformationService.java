package com.example.StockWeb.service;

import com.example.StockWeb.model.StockDTO;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class StockInformationService implements StockService{

    @Override
    public StockDTO getStockTicker(String tickerSymbol) {
        return null;
    }

    private void extractDataFromCnn(){
        try{
            //loading the HTML to a Document Object
            Document document = Jsoup.connect(url).get();

            //Select the element that contains the stock price information
            Element element = document.get
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
