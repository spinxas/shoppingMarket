package com.silkaitis.discount;

import com.silkaitis.exception.LogicException;
import com.silkaitis.utility.CaselessProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class DiscountServiceUtility implements DiscountService {

    public boolean getThreeForTwoDiscount(String productName) throws LogicException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("discount.properties")) {
            CaselessProperties prop = new CaselessProperties();

            //Load a properties file
            prop.load(input);

            if (prop.getProperty("3for2") == null) {
                throw new LogicException("The discount is not setup in our systems. Discount name name: 3for2" );
            } else {
                List<String> applicableProducts = Arrays.asList(prop.getProperty("3for2").split(","));
                return applicableProducts.contains(productName.toLowerCase());
            }
        } catch (IOException ex) {
            throw new LogicException("Pricing file was not found.", ex);
        } catch (NumberFormatException e) {
            throw new LogicException("Price is incorrect format within properties file.", e);
        }
    }

    public boolean getTwoForOneDiscount(String productName) throws LogicException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("discount.properties")) {
            CaselessProperties prop = new CaselessProperties();

            //Load a properties file
            prop.load(input);

            if (prop.getProperty("2for1") == null) {
                throw new LogicException("The discount is not setup in our systems. Discount name name: 2for1" );
            } else {
                List<String> applicableProducts = Arrays.asList(prop.getProperty("2for1").split(","));
                return applicableProducts.contains(productName.toLowerCase());
            }
        } catch (IOException ex) {
            throw new LogicException("Pricing file was not found.", ex);
        } catch (NumberFormatException e) {
            throw new LogicException("Price is incorrect format within properties file.", e);
        }
    }
}
