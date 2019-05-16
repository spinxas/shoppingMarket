package com.silkaitis.pricing;

import com.silkaitis.discount.DiscountService;
import com.silkaitis.discount.DiscountServiceUtility;
import com.silkaitis.exception.LogicException;
import com.silkaitis.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Pricing calculator for calculating the total price and discounts being applied.
 */
public class PriceCalculatorUtility implements PriceCalculator {

    private DiscountService discountService = new DiscountServiceUtility();

    public Double calculateTotalPrice(List<Product> products) throws LogicException {
        double total = 0;

        //Sums up all the product prices.
        for (Product product : products) {
            total += product.getPrice();
        }

        System.out.println("Sub-Total: " + total);

        //Apply discounts
        List<Product> uniqueProducts = products.stream().distinct().collect(Collectors.toList());
        for (Product product : uniqueProducts) {
            int frequency = Collections.frequency(products, product);

            if (frequency >= 3 && discountService.getThreeForTwoDiscount(product.getName())) {
                int discountApplicable = frequency / 3;

                total = total - ((product.getPrice() * 3 - product.getPrice() * 2) * discountApplicable);
            }
        }

        return total;
    }
}
