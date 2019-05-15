package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;
import com.silkaitis.pricing.PricingService;
import com.silkaitis.pricing.PricingServiceUtility;
import com.silkaitis.utility.PriceCalculator;
import com.silkaitis.utility.PriceCalculatorUtility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ApplicationTest extends Application {

    /**
     * Simple check to see that the main application is working.
     */
    @Test
    public void mainApplicationTest() {
        String[] products = new String[]{"Coke", "Coke", "Beans"};
        Application application = new Application();
        double total = application.calculateTotal(products);

        assertEquals(1.9, total, 0.0001);
    }

    /**
     * Checks if the calculations are done correctly by the calculator.
     */
    @Test
    public void calculateTotal() {
        PriceCalculator priceCalculator = new PriceCalculatorUtility();

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Coke", 0.7));
        productList.add(new Product("Beans", 0.5));

        double total = priceCalculator.calculateTotalPrice(productList);

        assertEquals(1.2, total, 0.0001);
    }

    /**
     * Checks to handle exception when given product does not exist.
     */
    @Test
    public void nonExistingProduct() {
        PricingService pricingService = new PricingServiceUtility();

        try {
            pricingService.getProductPrice("Test");
        } catch (LogicException e) {
            assertThat(e.getMessage(), is("The product is not found in our systems. Product name: Test"));
        }
    }
}
