package model;

public abstract class Product {

    private String title;
    private String id;

    public Product(String title, String id) {
        this.setTitle(title);
        this.setId(id);
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

}
