package org.example;

import java.util.List;

//Manages the collection of stocks objects and
//calculates the GBCE All Share Index using the geometric mean of the volume-weighted stock prices.
public class CorporateExchange {
    private List<Stock> stocks;

    public CorporateExchange(List<Stock> stocks) {
        this.stocks = stocks;  //Attribute: A list of Stock objects that are part of the stock exchange
    }

    // Method to calculate the GBCE All Share Index using geometric mean
    public double calculateAllShareIndex() {
        double productOfVWSP = 1.0;
        int count = 0;

        for (Stock stock : stocks) {
            double vwsp = stock.calculateVolumeWeightedStockPrice();
            if (vwsp > 0) {
                productOfVWSP *= vwsp;
                count++;
            }
        }

        if (count == 0) {
            return 0; // No stocks with VWSP > 0
        }

        return Math.pow(productOfVWSP, 1.0 / count);
    }
}
