package com.silkaitis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
