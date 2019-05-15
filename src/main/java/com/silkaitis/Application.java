package com.silkaitis;

import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;
import com.silkaitis.utility.PriceCalculator;
import com.silkaitis.utility.PriceCalculatorUtility;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Application class.
 */
public class Application {

    private final PriceCalculator priceCalculator = new PriceCalculatorUtility();

    /**
     * Main method to begin the program.
     * @param args - shopping cart array, where ',' is a separator for product details. E.g. [coke, 0.70],[beans, 0.50]
     */
    public static void main(String[] args) {
        //Getting away from static context.
        Application app = new Application();
        Double total = app.calculateTotal(args);
        System.out.println("Total to Pay: " + total);
    }

    /**
     * Default constructor.
     */
    Application() {
    }

    /**
     * Main method that runs the application with provided data.
     */
    Double calculateTotal(String[] args) {
        List<Product> shoppingCart = new ArrayList<Product>();
        double total = 0;

        try {
            //Iterates through argument array to retrieve product details.
            for (String arg : args) {
                createProductModel(shoppingCart, arg);
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
     * @param shoppingCart - The list of Products.
     * @param arg - Supplied data, which is formatted in commas.
     * @throws LogicException - If the data is incorrect throws error with reason.
     */
    private void createProductModel(List<Product> shoppingCart, String arg) throws LogicException {
        String[] productDetails = arg.split(",");

        //Constructs the product model, if the price is given in incorrect format, it would print out the error.
        try {
            if (productDetails.length != 2) {
                throw new LogicException("The supplied product information is not in correct format.");
            }
            Product product = new Product(productDetails[0], Double.valueOf(productDetails[1]));
            shoppingCart.add(product);
        } catch (NumberFormatException ex) {
            throw new LogicException("Sorry, but the price was not in correct format.", ex);
        }
    }
}
