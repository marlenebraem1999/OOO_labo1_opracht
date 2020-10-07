package ui;

import model.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ShopUI {
    private Shop shop = new Shop();

    public void addProduct() {
        String title = JOptionPane.showInputDialog("Enter the title:");
        String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/C for CD):");

        Product product = null;
        if (type.equals("M")) {
            product = new Movie(title);
        } else if (type.equals("G")) {
            product = new Game(title);
        } else if (type.equals("C")) {
            product = new CD(title);
        }

        shop.addProduct(product);
    }

    public void showProduct(){
        String id = JOptionPane.showInputDialog("Enter the id:");
        Product product = shop.getProduct(id);

        if(product != null)
        {
            JOptionPane.showMessageDialog(null, product);
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
    //ik wil een lijst kunnen opvragen van alle producten in de winkel, geordend als volgt: eerst de films, dan de games, dan de CD's. De lijst toon de categorie, id en omschrijving van de producten
    public void showProductList() {
        List<Product> products = shop.getProducts();
        if (products.size() != 0) {
            String message = "";
            for (Product product : products) {
                message += product.toString() + '\n';
            }

            JOptionPane.showMessageDialog(null, message);

        }

    }

    public void sluitAf() {
        File producten = new File("shop.txt");
        try {
            PrintWriter writer = new PrintWriter(producten);
            writer.println();
            List<Product> products = shop.getProducts();
            for(Product p: products) {
                writer.println(p);
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Fout bij wegschrijven", ex);
        }
    }
}
