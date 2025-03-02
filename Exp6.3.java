import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void display() {
        System.out.println(name + " (" + category + ") - $" + price);
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("T-Shirt", "Clothing", 30),
            new Product("Shoes", "Footwear", 100),
            new Product("Watch", "Accessories", 200),
            new Product("Jeans", "Clothing", 50),
            new Product("Sneakers", "Footwear", 120),
            new Product("Headphones", "Electronics", 150)
        );

        Map<String, List<Product>> groupedProducts = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(Product::getPrice));

        System.out.println("Grouped Products by Category:");
        groupedProducts.forEach((category, productList) -> 
            System.out.println(category + ": " + productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", ")))
        );

        System.out.println("\nMost Expensive Product in Each Category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + ": " + 
                product.map(p -> p.getName() + " - $" + p.getPrice()).orElse("No Products"))
        );

        System.out.printf("\nAverage Price of All Products: $%.2f\n", averagePrice);
    }
}
