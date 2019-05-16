package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;
import com.silkaitis.pricing.PricingService;
import com.silkaitis.pricing.PricingServiceUtility;
import com.silkaitis.pricing.PriceCalculator;
import com.silkaitis.pricing.PriceCalculatorUtility;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Main Application class.
 */
public class Application {

    private final PriceCalculator priceCalculator = new PriceCalculatorUtility();
    private final PricingService pricingService = new PricingServiceUtility();

    /**
     * Main method to begin the program.
     *
     * @param args - shopping cart array of products.
     */
    public static void main(String[] args) {
        //Getting away from static context.
        Application app = new Application();
        app.calculateTotal(args);
    }

    /**
     * Default constructor.
     */
    Application() {
    }

    /**
     * Main method that runs the application with provided data.
     */
    BigDecimal calculateTotal(String[] args) {
        List<Product> shoppingCart = new ArrayList<>();
        BigDecimal total = new BigDecimal(0);

        try {
            //Iterates through argument array to retrieve product details.
            for (String arg : args) {
                createProductModel(shoppingCart, arg.toLowerCase());
            }
            //Calculate the shopping price
            total = priceCalculator.calculateTotalPrice(shoppingCart);
        } catch (LogicException e) {
            System.out.println(e.getMessage());
        }

        return total;
    }

    /**
     * Creates product model based on given input.
     *
     * @param shoppingCart - The list of Products.
     * @param productName  - Supplied product name.
     * @throws LogicException - If the data is incorrect throws error with reason.
     */
    private void createProductModel(List<Product> shoppingCart, String productName) throws LogicException {
        Product product = new Product(productName, pricingService.getProductPrice(productName));
        shoppingCart.add(product);
    }
}
