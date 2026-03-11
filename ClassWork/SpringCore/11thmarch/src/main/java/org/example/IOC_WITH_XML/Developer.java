package org.example.IOC_WITH_XML;

import java.sql.SQLOutput;

public class Developer {
    private Laptop laptop;
    public void setLaptop(Laptop laptop){
        this.laptop=laptop;
    }

    public void buildDev(){
        laptop.callLaptop();
        System.out.println("Buil dev is ,,.....");
    }
}
