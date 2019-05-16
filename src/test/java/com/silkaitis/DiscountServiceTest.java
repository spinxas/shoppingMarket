package com.silkaitis;

import com.silkaitis.discount.DiscountService;
import com.silkaitis.discount.DiscountServiceUtility;
import com.silkaitis.exception.LogicException;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountServiceTest {


    /**
     * Confirms that it can find applicable discount for given product.
     */
    @Test
    public void checkForThreeForTwoDiscount() throws LogicException {
        DiscountService discountService = new DiscountServiceUtility();
        boolean exists = discountService.getThreeForTwoDiscount("Beans");
        assertTrue(exists);
    }

    /**
     * Confirms that it cannot find applicable discount for given product.
     */
    @Test
    public void checkForDiscountToNotExist() throws LogicException {
        DiscountService discountService = new DiscountServiceUtility();
        boolean exists = discountService.getThreeForTwoDiscount("Coke");
        assertFalse(exists);
    }
}
