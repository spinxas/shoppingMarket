package com.silkaitis.utility;

import com.silkaitis.model.Product;

import java.util.List;

public class PriceCalculatorUtility implements PriceCalculator {

    public Double calculateTotalPrice(List<Product> products) {
        double total = 0;

        //Sums up all the product prices.
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}
