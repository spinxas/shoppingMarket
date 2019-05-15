package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.pricing.PricingService;
import com.silkaitis.pricing.PricingServiceUtility;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ApplicationTest extends Application {

    /**
     * Simple check to see that the model is working for calculating the total price.
     */
    @Test
    public void calculateTotal() {
        String[] products = new String[]{"Coke", "Coke", "Beans"};
        Application application = new Application();
        double total = application.calculateTotal(products);

        assertEquals(1.9, total, 0.0001);
    }

    /**
     * Simple check to see that the model is working for calculating the total price.
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
