package com.silkaitis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApplicationTest extends Application {

    /**
     * Simple check to see that the model is working for calculating the total price.
     */
    @Test
    public void calculateTotal() {
        String[] products = new String[]{"Coke,0.50", "Coke,0.50"};
        Application application = new Application();
        double total = application.calculateTotal(products);

        assertEquals(1, total, 0.0001);
    }
}
