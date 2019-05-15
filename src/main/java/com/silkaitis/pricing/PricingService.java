package com.silkaitis.pricing;

import com.silkaitis.exception.LogicException;

public interface PricingService {

    /**
     * Retrieves the price of a product from the properties file provided.
     * @param productName - Given product name.
     * @return - price of the product.
     * @throws LogicException - Exception is thrown if the file does not exist or price is formatted incorrectly.
     */
    double getProductPrice(String productName) throws LogicException;
}
