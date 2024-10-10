package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create some stock objects
        Stock tea = new Stock("TEA", "common", 0, 0, 100);
        Stock pop = new Stock("POP", "common", 8, 0, 100);
        Stock ale = new Stock("ALE", "common", 23, 0, 60);
        Stock gin = new Stock("GIN", "preferred", 8, 0.02, 100);
        Stock joe = new Stock("JOE", "common", 13, 0, 250);

        // Record some trades
        tea.recordTrade(100, true, 110);
        pop.recordTrade(50, true, 120);
        ale.recordTrade(60,true,23);
        gin.recordTrade(150, true, 130);
        joe.recordTrade(150, true, 120);

        // Calculate dividend yield and P/E Ratio for a stock
        double teaDividendYield = tea.calculateDividendYield(110);
        double teaPERatio = tea.calculatePERatio(110);

        System.out.println("TEA Dividend Yield: " + teaDividendYield);
        System.out.println("TEA P/E Ratio: " + teaPERatio);

        // Calculate Volume Weighted Stock Price for the last 5 minutes
        double teaVWSP = tea.calculateVolumeWeightedStockPrice();
        System.out.println("TEA Volume Weighted Stock Price: " + teaVWSP);

        // Create a CorporateExchange instance and calculate the All Share Index
        List<Stock> stocks = Arrays.asList(tea, pop, gin,joe,ale);
        CorporateExchange corporateExchange = new CorporateExchange(stocks);
        double allShareIndex = corporateExchange.calculateAllShareIndex();

        System.out.println("CorporateExchange All Share Index: " + allShareIndex);
        }
    }