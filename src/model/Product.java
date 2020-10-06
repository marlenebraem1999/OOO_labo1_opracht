package model;

public abstract class Product {

    private String title;
    private String id;
    //ik wil dat de ID's van nieuwe producten automatisch worden berekend (nieuw ID is 1 hoger dan hoogste ID in productenlijst.
    private static int serialId = 0;
    private boolean isUitgeleend;

    public Product(String title) {
        this.setTitle(title);
        serialId++;
        this.setId(Integer.toString(serialId));
        isUitgeleend = false;
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

    //ik wil met het programma kunnen ingeven dat een beschikbaar product nu uitgeleend wordt
    public boolean getIsUitgeleend(){
        return isUitgeleend;
    }

    public boolean productUitlenen(){
        isUitgeleend = true;
        return isUitgeleend;
    }



    @Override
    public String toString() {
        return this.getId() + " - " + this.getTitle();
    }
}
