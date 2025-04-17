package org.example;

import org.example.model.Trade;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

//models the concept of a stock and provides methods to calculate financial metrics
public class Stock {
    private String symbol;
    private String type; // common or preferred
    private double lastDividend;
    private double fixedDividend; // only for preferred stock
    private double parValue;
    private List<Trade> trades;

    //constructors are used to create instances of the Stock and Trade classes
    public Stock(String symbol, String type, double lastDividend, double fixedDividend, double parValue) {
        this.symbol = symbol;
        this.type = type;
        this.lastDividend = lastDividend;
        this.fixedDividend = fixedDividend;
        this.parValue = parValue;
        this.trades = new ArrayList<>();
    }

    // Method to calculate dividend yield
    public double calculateDividendYield(double price) {
        if (type.equalsIgnoreCase("common")) {
            return lastDividend / price;
        } else if (type.equalsIgnoreCase("preferred")) {
            return (fixedDividend * parValue) / price;
        } else {
            throw new IllegalArgumentException("Invalid stock type");
        }
    }

    // Method to calculate P/E Ratio
    public double calculatePERatio(double price) {
        if (lastDividend == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return price / lastDividend;
    }

    // Method to record a trade
    public void recordTrade(int quantity, boolean isBuy, double price) {
        trades.add(new Trade( LocalDateTime.now(),quantity, isBuy, price));
    }

    // Method to calculate Volume Weighted Stock Price in last 5 minutes
    public double calculateVolumeWeightedStockPrice() { //the system filters trades based on their timestamps
        LocalDateTime now = LocalDateTime.now();
        double totalTradePriceQuantity = 0;
        int totalQuantity = 0;

        for (Trade trade : trades) {
            if (ChronoUnit.MINUTES.between(trade.getTimestamp(), now) <= 5) { //to calculate the difference between the current time and the trade's timestamp.
                totalTradePriceQuantity += trade.getPrice() * trade.getQuantity();
                totalQuantity += trade.getQuantity();
            }
        }

        if (totalQuantity == 0) {
            return 0; // No trades in the last 5 minutes
        }
        return totalTradePriceQuantity / totalQuantity;
    }
}
