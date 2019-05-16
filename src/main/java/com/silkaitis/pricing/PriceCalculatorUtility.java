package com.silkaitis.pricing;

import com.silkaitis.discount.DiscountService;
import com.silkaitis.discount.DiscountServiceUtility;
import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pricing calculator for calculating the total price and discounts being applied.
 */
public class PriceCalculatorUtility implements PriceCalculator {

    private static final int THREE = 3;
    private static final int TWO = 2;
    private DiscountService discountService = new DiscountServiceUtility();

    public BigDecimal calculateTotalPrice(List<Product> products) throws LogicException {
        BigDecimal total = new BigDecimal(0);

        //Sums up all the product prices.
        for (Product product : products) {
            total = total.add(product.getPrice());
        }

        System.out.println("Sub-Total: " + total);

        //Apply discounts
        List<Product> uniqueProducts = products.stream().distinct().collect(Collectors.toList());
        for (Product product : uniqueProducts) {
            int frequency = Collections.frequency(products, product);

            //Check for three for two discounts.
            if (frequency >= 3 && discountService.getThreeForTwoDiscount(product.getName())) {
                int discountApplicable = frequency / 3;

                //Calculates the discount by multiplying the price by three and subtracting the result of multiplication by two.
                //The discount is multiplied by the frequency of repeating products of threes.
                BigDecimal discount = (product.getPrice().multiply(BigDecimal.valueOf(THREE))
                        .subtract(product.getPrice().multiply(BigDecimal.valueOf(TWO))))
                        .multiply(BigDecimal.valueOf(discountApplicable));
                System.out.println("Three for Two discount: " + discount);

                total = total.subtract(discount);
            }

            //Check for two for one discounts.
            if (frequency >= 2 && discountService.getTwoForOneDiscount(product.getName())) {
                int discountApplicable = frequency / 2;

                //Calculates the discount by multiplying the price by the frequency of repeating products of twos.
                BigDecimal discount = (product.getPrice().multiply(BigDecimal.valueOf(discountApplicable)));

                System.out.println("Two for One discount: " + discount);
                total = total.subtract(discount);
            }

        }

        System.out.println("Total to Pay: " + total);
        return total;
    }
}
