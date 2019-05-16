package com.silkaitis;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ApplicationTest extends Application {

    /**
     * Simple check to see that the main application is working.
     */
    @Test
    public void mainApplicationTest() {
        String[] products = new String[]{"Coke", "Coke", "Beans"};
        Application application = new Application();
        BigDecimal total = application.calculateTotal(products);

        assertEquals(BigDecimal.valueOf(1.5), total);
    }
}
