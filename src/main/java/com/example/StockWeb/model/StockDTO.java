package com.example.StockWeb.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Objects;

public class StockDTO {
    @Getter
    @Setter
    private double regularMarketPrice;

    @Getter
    @Setter
    private double postMarketPrice;

    @Getter
    @Setter
    private double prevClosePrice;

    @Getter
    @Setter
    private double openPrice;

    @Getter
    @Setter
    private String bid;

    @Getter
    @Setter
    private String ask;

    @Getter
    @Setter
    private String dayRange;

    @Getter
    @Setter
    private String fiftyTwoWeekRange;

    @Getter
    @Setter
    private double volume;

    @Getter
    @Setter
    private double avgVolume;

    @Getter
    @Setter
    private String marketCap;

    @Getter
    @Setter
    private double beta;

    @Getter
    @Setter
    private double PERatio;

    @Getter
    @Setter
    private double EPS;

    @Getter
    @Setter
    private String earningsDate;

    @Getter
    @Setter
    private String forwardDividendAndYield;

    @Getter
    @Setter
    private String exDividendDate;

    @Getter
    @Setter
    private double oneYearTarget;

    @Getter
    @Setter
    private String name;

    public StockDTO(){}

    public StockDTO(double regularMarketPrice, double postMarketPrice, double prevClosePrice, double openPrice, String bid, String ask, String dayRange, String fiftyTwoWeekRange, double volume, double avgVolume, String marketCap, double beta, double PERatio, double EPS, String earningsDate, String forwardDividendAndYield, String exDividendDate, double oneYearTarget, String name) {
        this.regularMarketPrice = regularMarketPrice;
        this.postMarketPrice = postMarketPrice;
        this.prevClosePrice = prevClosePrice;
        this.openPrice = openPrice;
        this.bid = bid;
        this.ask = ask;
        this.dayRange = dayRange;
        this.fiftyTwoWeekRange = fiftyTwoWeekRange;
        this.volume = volume;
        this.avgVolume = avgVolume;
        this.marketCap = marketCap;
        this.beta = beta;
        this.PERatio = PERatio;
        this.EPS = EPS;
        this.earningsDate = earningsDate;
        this.forwardDividendAndYield = forwardDividendAndYield;
        this.exDividendDate = exDividendDate;
        this.oneYearTarget = oneYearTarget;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockDTO stockDTO = (StockDTO) o;
        return Double.compare(regularMarketPrice, stockDTO.regularMarketPrice) == 0 && Double.compare(postMarketPrice, stockDTO.postMarketPrice) == 0 && Double.compare(prevClosePrice, stockDTO.prevClosePrice) == 0 && Double.compare(openPrice, stockDTO.openPrice) == 0 && Double.compare(volume, stockDTO.volume) == 0 && Double.compare(avgVolume, stockDTO.avgVolume) == 0 && Double.compare(beta, stockDTO.beta) == 0 && Double.compare(PERatio, stockDTO.PERatio) == 0 && Double.compare(EPS, stockDTO.EPS) == 0 && Double.compare(oneYearTarget, stockDTO.oneYearTarget) == 0 && Objects.equals(bid, stockDTO.bid) && Objects.equals(ask, stockDTO.ask) && Objects.equals(dayRange, stockDTO.dayRange) && Objects.equals(fiftyTwoWeekRange, stockDTO.fiftyTwoWeekRange) && Objects.equals(marketCap, stockDTO.marketCap) && Objects.equals(earningsDate, stockDTO.earningsDate) && Objects.equals(forwardDividendAndYield, stockDTO.forwardDividendAndYield) && Objects.equals(exDividendDate, stockDTO.exDividendDate) && Objects.equals(name, stockDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regularMarketPrice, postMarketPrice, prevClosePrice, openPrice, bid, ask, dayRange, fiftyTwoWeekRange, volume, avgVolume, marketCap, beta, PERatio, EPS, earningsDate, forwardDividendAndYield, exDividendDate, oneYearTarget, name);
    }

    @Override
    public String toString() {
        return "StockDTO{" +
                "regularMarketPrice=" + regularMarketPrice +
                ", postMarketPrice=" + postMarketPrice +
                ", prevClosePrice=" + prevClosePrice +
                ", openPrice=" + openPrice +
                ", bid='" + bid + '\'' +
                ", ask='" + ask + '\'' +
                ", dayRange='" + dayRange + '\'' +
                ", fiftyTwoWeekRange='" + fiftyTwoWeekRange + '\'' +
                ", volume=" + volume +
                ", avgVolume=" + avgVolume +
                ", marketCap='" + marketCap + '\'' +
                ", beta=" + beta +
                ", PERatio=" + PERatio +
                ", EPS=" + EPS +
                ", earningsDate='" + earningsDate + '\'' +
                ", forwardDividendAndYield='" + forwardDividendAndYield + '\'' +
                ", exDividendDate='" + exDividendDate + '\'' +
                ", oneYearTarget=" + oneYearTarget +
                ", name='" + name + '\'' +
                '}';
    }
}
