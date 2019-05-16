package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;
import com.silkaitis.pricing.PriceCalculator;
import com.silkaitis.pricing.PriceCalculatorUtility;
import org.junit.Test;

import java.math.BigDecimal;
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
        productList.add(new Product("Coke", BigDecimal.valueOf(0.7)));
        productList.add(new Product("Beans", BigDecimal.valueOf(0.5)));

        BigDecimal total = priceCalculator.calculateTotalPrice(productList);

        assertEquals(BigDecimal.valueOf(1.2), total);
    }

    /**
     * Checks if the calculations are done correctly by the calculator.
     */
    @Test
    public void calculateWithThreeForTwoDiscount() throws LogicException {
        PriceCalculator priceCalculator = new PriceCalculatorUtility();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coke", BigDecimal.valueOf(0.7)));
        productList.add(new Product("Beans", BigDecimal.valueOf(0.5)));
        productList.add(new Product("Beans", BigDecimal.valueOf(0.5)));
        productList.add(new Product("Beans", BigDecimal.valueOf(0.5)));

        BigDecimal total = priceCalculator.calculateTotalPrice(productList);

        assertEquals(BigDecimal.valueOf(1.7), total);
    }

    /**
     * Checks if the calculations are done correctly by the calculator.
     */
    @Test
    public void calculateWithTwoForOneDiscount() throws LogicException {
        PriceCalculator priceCalculator = new PriceCalculatorUtility();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coke", BigDecimal.valueOf(0.7)));
        productList.add(new Product("Coke", BigDecimal.valueOf(0.7)));
        productList.add(new Product("Beans", BigDecimal.valueOf(0.5)));

        BigDecimal total = priceCalculator.calculateTotalPrice(productList);

        assertEquals(BigDecimal.valueOf(1.5), total);
    }
}
