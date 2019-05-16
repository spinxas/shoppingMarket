package com.silkaitis.pricing;

import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;

import java.util.List;

public interface PriceCalculator {

    /**
     * Calculates the shopping cart total price.
     * @param products - List of products.
     * @return - Total price.
     */
    Double calculateTotalPrice(List<Product> products) throws LogicException;
}
