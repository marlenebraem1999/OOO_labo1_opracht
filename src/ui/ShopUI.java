package ui;

import model.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    //ik wil dat bij het afsluiten van mijn programma alle producten worden weggeschreven naar een bestand (shop.txt)
    public void sluitAf() {
        File producten = new File("shop.txt");
        try {
            PrintWriter writer = new PrintWriter(producten);
            List<Product> products = shop.getProducts();
            for(Product p: products) {
                writer.println(p);
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Fout bij wegschrijven", ex);
        }
    }
    //ik wil dat bij het opstarten van mijn programma alle items worden ingelezen uit een bestand (shop.txt)
    public void leesIn() {
        File productsFile = new File("shop.txt");
        try {
            Scanner scanner = new Scanner(productsFile);
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] delen = s.split(": ");
                String type = delen[0];
                String[] info = delen[1].split(" - ");
                String title = info[1];
                Product product = null;
                switch (type) {
                    case "Movie":
                        product = new Movie(title);
                        break;
                    case "Game":
                        product = new Game(title);
                        break;
                    case "CD":
                        product = new CD(title);
                        break;
                }
                shop.addProduct(product);
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("Fout bij inlezen", ex);
        }
    }
}
