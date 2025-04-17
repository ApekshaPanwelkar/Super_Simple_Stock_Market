package org.example.model;

import lombok.AllArgsConstructor; //automatically generates a constructor that takes parameters for all the fields of the Trade class.
import lombok.Getter;//which automatically generates getter methods for all fields

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Trade {
    private LocalDateTime timestamp;
    private int quantity;
    private boolean isBuy;
    private double price;
}

//Stores information about each trade, including timestamp, quantity, buy/sell indicator, and price.