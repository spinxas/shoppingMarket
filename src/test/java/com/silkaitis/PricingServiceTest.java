package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.pricing.PricingService;
import com.silkaitis.pricing.PricingServiceUtility;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PricingServiceTest {

    /**
     * Checks to handle exception when given product does not exist in pricing service.
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

    /**
     * Checks to handle exception when given product does not exist in pricing service.
     */
    @Test
    public void checkForPrice() throws LogicException {
        PricingService pricingService = new PricingServiceUtility();

        double price = pricingService.getProductPrice("Coke");

        assertEquals(price, 0.7, 0.0001);
    }
}
