package org.example.IOC_WITH_XML;

public class Laptop {
    private String brand;
    private int ram;
    private String processor;
    private double price;

    public Laptop() {
        System.out.println("Laptop object created by Spring");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", price=" + price +
                '}';
    }

    public void callLaptop(){
        System.out.println("I am Laptop class");
    }

}
