package com.silkaitis.discount;

import com.silkaitis.exception.LogicException;

public interface DiscountService {

    /**
     * Retrieves the three for two discount if applicable.
     * @param productName - Given product name.
     * @return - true or false statement if it has discount of the product.
     * @throws LogicException - Exception is thrown if the file does not exist.
     */
    boolean getThreeForTwoDiscount(String productName) throws LogicException;

    /**
     * Retrieves the two for one discount if applicable.
     * @param productName - Given product name.
     * @return - true or false statement if it has discount of the product.
     * @throws LogicException - Exception is thrown if the file does not exist.
     */
    boolean getTwoForOneDiscount(String productName) throws LogicException;
}
