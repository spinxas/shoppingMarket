package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;
import com.silkaitis.pricing.PriceCalculator;
import com.silkaitis.pricing.PriceCalculatorUtility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PricingCalculatorTest {

    /**
     * Checks if the calculations are done correctly by the calculator.
     */
    @Test
    public void calculateTotal() throws LogicException {
        PriceCalculator priceCalculator = new PriceCalculatorUtility();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coke", 0.7));
        productList.add(new Product("Beans", 0.5));

        double total = priceCalculator.calculateTotalPrice(productList);

        assertEquals(1.2, total, 0.0001);
    }

    /**
     * Checks if the calculations are done correctly by the calculator.
     */
    @Test
    public void calculateWithDiscountTotal() throws LogicException {
        PriceCalculator priceCalculator = new PriceCalculatorUtility();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coke", 0.7));
        productList.add(new Product("Beans", 0.5));
        productList.add(new Product("Beans", 0.5));
        productList.add(new Product("Beans", 0.5));

        double total = priceCalculator.calculateTotalPrice(productList);

        assertEquals(1.7, total, 0.0001);
    }
}
