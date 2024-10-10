package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Trade {
    private LocalDateTime timestamp;
    private int quantity;
    private boolean isBuy;
    private double price;
}
