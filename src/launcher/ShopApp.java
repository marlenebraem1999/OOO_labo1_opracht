package launcher;

import model.Shop;
import ui.ShopUI;

import javax.swing.*;

public class ShopApp {
    public static void main(String[] args) {
        ShopUI ui = new ShopUI();

        String menu = "1. Add product\n2. Show product\n3. Show products\n4. Show rental price\n\n0. Quit";
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                ui.addProduct();
            } else if (choice == 2) {
                ui.showProduct();
            } else if (choice == 3) {
                ui.showProductList();
            } else if (choice == 4){
                ui.showPrice();
            }
        }
    }
}
