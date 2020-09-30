package model;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> products = new ArrayList<>();

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
}
