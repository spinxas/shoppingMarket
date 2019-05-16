# Shopping Market

Shopping market application that counts the price of the shopping cart.

## Prices
  The prices are configured using prices.proprties file within the resource folder.   
  New products can be added there as well. It is based on key and value pair. E.g. coke=0.7

## Discounts
The discounts are configured using discount.properties file within the resource folder. There are two types of discounts:    
* ThreeForTwo - Three products which are the same will be for the price of two.   
* TwoForOne - Two products which are the same will cost 1£    
Products with discounts are seperated by comma seperator within the properties file.

## Running the application
The application takes string array as an argument, which contains the list of products that the user provides. E.g. ["Coke", "Coke", "Beans"]
