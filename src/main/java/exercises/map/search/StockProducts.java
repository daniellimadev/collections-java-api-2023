package main.java.exercises.map.search;

import java.util.HashMap;
import java.util.Map;

public class StockProducts {
    private Map<Long,Product> stockProductsMap;

    public StockProducts() {
        this.stockProductsMap = new HashMap<>();
    }


    public void addProduct(long code, String name, int amount, double price) {
        stockProductsMap.put(code, new Product(name, price, amount));
    }

    public void displayProducts() {
        System.out.println(stockProductsMap);
    }

    public double calculateTotalValueStock() {
        double valueTotalStock = 0d;
        if (!stockProductsMap.isEmpty()) {
            for (Product p : stockProductsMap.values()) {
                valueTotalStock += p.getAmount() * p.getPrice();
            }
        }
        return valueTotalStock;
    }

    public Product getProductMoreExpensive() {
        Product MostExpensiveProduct = null;
        double biggestPrice = Double.MIN_VALUE;
        for (Product p : stockProductsMap.values()) {
            if (p.getPrice() > biggestPrice) {
                MostExpensiveProduct = p;
                biggestPrice = p.getPrice();
            }
        }
        return MostExpensiveProduct;
    }

    public Product getCheapestProduct() {
        Product productCheapest = null;
        double lowestPrice = Double.MAX_VALUE;
        for (Product p : stockProductsMap.values()) {
            if (p.getPrice() < lowestPrice) {
                productCheapest = p;
                lowestPrice = p.getPrice();
            }
        }
        return productCheapest;
    }

    public Product getProductLargestQuantityTotalValueInStock() {
        Product ProductLargestQuantityValueInStock = null;
        double highestTotalValueProductStock = 0d;
        if (!stockProductsMap.isEmpty()) {
            for (Map.Entry<Long, Product> entry : stockProductsMap.entrySet()) {
                double valueProductInStock = entry.getValue().getPrice() * entry.getValue().getAmount();
                if (valueProductInStock > highestTotalValueProductStock) {
                    highestTotalValueProductStock = valueProductInStock;
                    ProductLargestQuantityValueInStock = entry.getValue();
                }
            }
        }
        return ProductLargestQuantityValueInStock;
    }

    public static void main(String[] args) {
        StockProducts stockProducts = new StockProducts();

        // Displays empty stock
        stockProducts.displayProducts();

        // Add products to stock
        stockProducts.addProduct(1L, "Notebook", 1, 1500.0);
        stockProducts.addProduct(2L, "Mouse", 5, 25.0);
        stockProducts.addProduct(3L, "Monitor", 10, 400.0);
        stockProducts.addProduct(4L, "Keyboard", 2, 40.0);

        // Displays products in stock
        stockProducts.displayProducts();

        // Calculates and displays total inventory value
        System.out.println("Total stock value: $" + stockProducts.calculateTotalValueStock());

        // Gets and displays the most expensive product
        Product productMostExpensive = stockProducts.getProductMoreExpensive();
        System.out.println("Most expensive product: " + productMostExpensive);

        // Gets and displays the cheapest product
        Product productCheapest = stockProducts.getCheapestProduct();
        System.out.println("Cheapest product: " + productCheapest);

        // Gets and displays the product with the highest quantity in value in stock
        Product productGreatestQuantityTotalValue = stockProducts.getProductLargestQuantityTotalValueInStock();
        System.out.println("Product with the highest quantity in stock: " + productGreatestQuantityTotalValue);
    }
}
