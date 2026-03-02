package CollectionProject;

import java.util.Objects;

public class Shirt {

    private String brand;
    private double price;
    private String colour;
    private int size;

    public Shirt(String brand, double price, String colour, int size) {
        this.brand = brand;
        this.price = price;
        this.colour = colour;
        this.size = size;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public String getColour() { return colour; }
    public int getSize() { return size; }


    @Override
    public String toString() {
        return brand + " | ₹" + price + " | " + colour + " | Size: " + size;
    }

    // dd. Override equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shirt)) return false;
        Shirt shirt = (Shirt) o;
        return Double.compare(shirt.price, price) == 0 &&
                size == shirt.size &&
                Objects.equals(brand, shirt.brand) &&
                Objects.equals(colour, shirt.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, colour, size);
    }
}