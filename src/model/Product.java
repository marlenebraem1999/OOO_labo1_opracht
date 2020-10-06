package model;

public abstract class Product {

    private String title;
    private String id;
    //ik wil dat de ID's van nieuwe producten automatisch worden berekend (nieuw ID is 1 hoger dan hoogste ID in productenlijst.
    private static int serialId = 0;

    public Product(String title) {
        this.setTitle(title);
        serialId++;
        this.setId(Integer.toString(serialId));
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public abstract double getPrice(int days);

    @Override
    public String toString() {
        return this.getId() + " - " + this.getTitle();
    }
}
