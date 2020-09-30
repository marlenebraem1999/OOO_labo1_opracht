package ui;

import model.Game;
import model.Movie;
import model.Product;
import model.Shop;

import javax.swing.*;

public class ShopUI {
    private Shop shop = new Shop();

    public void addProduct() {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String id = JOptionPane.showInputDialog("Enter the id:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

        Product product = null;
        if (type.equals("M")) {
            product = new Movie(title, id);
        } else if (type.equals("G")) {
            product = new Game(title, id);
        }

        shop.addProduct(product);
    }

    public void showProduct(){
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product product = shop.getProduct(id);

        if(product != null)
        {
            JOptionPane.showMessageDialog(null, product.getTitle());
        }
    }

    public void showPrice(){
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product product = shop.getProduct(id);

        if(product != null){
            String daysString = JOptionPane.showInputDialog("Enter the number of days:");
            int days = Integer.parseInt(daysString);
            JOptionPane.showMessageDialog(null, product.getPrice(days));
        }
    }
}
