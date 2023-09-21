package com.example.StockWeb.service;

import com.example.StockWeb.StockWebApplication;
import com.example.StockWeb.model.StockDTO;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.Supplier;
import java.util.logging.Logger;


@Service
@Component
public class StockInformationService implements StockService {

    private static final String baseURL = "https://finance.yahoo.com/quote/";
    private static final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.79 Safari/537.36";
    static Logger logger = Logger.getLogger(StockInformationService.class.getName());

    @Override
    public  StockDTO extractStockDataFromYahoo(String stockTicker) {
        StockDTO stockInfo = new StockDTO();
        try {
            //connecting and getting the HTML from the URL
            Document doc = Jsoup.connect(baseURL.concat(stockTicker + "?p=" + stockTicker)).userAgent(userAgent).get();

            //getting the name of the stock from the h1 tag
            Element companyNameElement = doc.getElementsByTag("h1").first();
            stockInfo.setName(companyNameElement.text());
            logger.info(companyNameElement.text());

            //getting the stock price data from the tag
            Elements priceData = doc.getElementsByAttributeValue("data-test", "qsp-price");
            getStockPrices(priceData, stockInfo);

            //call method to get the regular market stock price change information
            getRegularMarketStockPriceInformation(doc, stockInfo);

            //call method to get the post market stock price change information
            getPostMarketStockPriceInformation(doc, stockInfo);

            //get the information from the left side table on the Yahoo page
            Elements leftTable = doc.getElementsByAttributeValue("data-test", "left-summary-table").get(0).getElementsByTag("tr");
            getLeftTable(leftTable, stockInfo);

            //get the information from the right side table on the Yahoo page
            Elements rightTable = doc.getElementsByAttributeValue("data-test", "right-summary-table").get(0).getElementsByTag("tr");
            getRightTable(rightTable, stockInfo);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return stockInfo;
    }

    private void getRegularMarketStockPriceInformation(Document doc, StockDTO stockInfo){
        //get the regular market price change
        Elements regularPriceChange = doc.getElementsByAttributeValue("data-test", "qsp-price-change").get(0).getElementsByTag("span");
        stockInfo.setRegularPriceChange(regularPriceChange.text());

        //get the regular market price percent change
        Elements regularPriceChangePercentage = doc.getElementsByAttributeValue("data-field", "regularMarketChangePercent").get(5).getElementsByTag("span");
        stockInfo.setRegularPriceChangePercent(regularPriceChangePercentage.text());
    }

    private void getPostMarketStockPriceInformation(Document doc, StockDTO stockInfo){
        //get the post market price change
        Elements postMarketChange = doc.getElementsByAttributeValue("data-field", "postMarketChange").get(0).getElementsByTag("span");
        stockInfo.setPostMarketChange(postMarketChange.text());

        //get the post market price percent change
        Elements postMarketChangePercent = doc.getElementsByAttributeValue("data-field", "postMarketChangePercent").get(0).getElementsByTag("span");
        stockInfo.setPostMarketChangePercent(postMarketChangePercent.text());
    }

    private void getStockPrices(Elements priceData, StockDTO stockInfo){
        stockInfo.setRegularMarketPrice(Double.parseDouble(priceData.get(0).text()));

        //get the post market price
        stockInfo.setPostMarketPrice(Double.parseDouble(priceData.get(1).text()));
        logger.info(priceData.text());
    }

    private void getLeftTable(Elements leftTable, StockDTO stockInfo) {
        for (Element element : leftTable) {
            String title = element.getElementsByTag("td").get(0).text();
            String value = element.getElementsByTag("td").get(1).text();
            if (title.equals("Previous Close")) {
                stockInfo.setPrevClosePrice(Double.parseDouble(value));
            } else if (title.equals("Open")) {
                stockInfo.setOpenPrice(Double.parseDouble(value));
            } else if (title.equals("Bid")) {
                stockInfo.setBid(value);
            } else if (title.equals("Ask")) {
                stockInfo.setAsk(value);
            } else if (title.equals("Day's Range")) {
                stockInfo.setDayRange(value);
            } else if (title.equals("52 Week Range")) {
                stockInfo.setFiftyTwoWeekRange(value);
            } else if (title.equals("Volume")) {
                stockInfo.setVolume(value);
            } else if (title.equals("Avg. Volume")) {
                stockInfo.setAvgVolume(value);
            }

        }
    }

    private void getRightTable(Elements rightTable, StockDTO stockInfo) {
        for (Element element : rightTable) {
            String title = element.getElementsByTag("td").get(0).text();
            String value = element.getElementsByTag("td").get(1).text();

            if (title.equals("Market Cap")) {
                stockInfo.setMarketCap(value);
            } else if (title.equals("Beta (5Y Monthly)")) {
                stockInfo.setBeta(Double.parseDouble(value));
            } else if (title.equals("PE Ratio (TTM)")) {
                stockInfo.setPERatio(Double.parseDouble(value));
            } else if (title.equals("EPS (TTM)")) {
                stockInfo.setEPS(Double.parseDouble(value));
            } else if (title.equals("Earnings Date")) {
                stockInfo.setEarningsDate(value);
            } else if (title.equals("Forward Dividend & Yield")) {
                stockInfo.setForwardDividendAndYield(value);
            } else if (title.equals("Ex-Dividend Date")) {
                stockInfo.setExDividendDate(value);
            } else if (title.equals("1y Target Est")) {
                stockInfo.setOneYearTarget(Double.parseDouble(value));
            }
        }
    }
}

