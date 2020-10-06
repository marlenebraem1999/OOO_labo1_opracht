package model;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();

    public Shop() {
        Product p1 = new Movie("The Hungergames");
        Product p2 = new CD("Map of the soul");
        Product p3 = new Game("Tomb Raider");

        products.add(p1);
        products.add(p2);
        products.add(p3);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Product getProduct(String id) {
        for (Product product : products) {
            if(product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        ArrayList<Product> sortedProducts = new ArrayList<>();
        for (Product product : products) {
            if(product instanceof Movie) {
                sortedProducts.add(product);
            }
        }
        for (Product product : products) {
            if(product instanceof Game) {
                sortedProducts.add(product);
            }
        }
        for (Product product : products) {
            if(product instanceof CD) {
                sortedProducts.add(product);
            }
        }
        return sortedProducts;
    }
}
