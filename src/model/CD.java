package model;

public class CD extends Product {
    public CD(String title) {
        super(title);
    }

    @Override
    public double getPrice(int days) {
        return days * 1.5;
    }

    @Override
    public String toString() {
        return "CD: " + super.toString();
    }
}
