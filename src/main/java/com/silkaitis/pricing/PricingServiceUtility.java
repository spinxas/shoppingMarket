package com.silkaitis.pricing;

import com.silkaitis.exception.LogicException;
import com.silkaitis.utility.CaselessProperties;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * Pricing service logic to load the prices from the properties file.
 */
public class PricingServiceUtility implements PricingService {

    public BigDecimal getProductPrice(String productName) throws LogicException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("prices.properties")) {
            CaselessProperties prop = new CaselessProperties();

            //Load a properties file
            prop.load(input);

            if (prop.getProperty(productName) == null) {
                throw new LogicException("The product is not found in our systems. Product name: " + productName);
            }

            //Get the property value and return the price.
            return new BigDecimal(prop.getProperty(productName));
        } catch (IOException ex) {
           throw new LogicException("Pricing file was not found.", ex);
        } catch (NumberFormatException e) {
            throw new LogicException("Price is incorrect format within properties file.", e);
        }
    }
}
