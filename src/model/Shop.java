package model;

import java.util.ArrayList;
import java.util.List;

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

    //ik wil van een product kunnen zien of het beschikbaar is of uitgeleend via ingave van zijn ID
    public boolean isProductUitgeleend(String id){
       return getProduct(id).getIsUitgeleend();
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
