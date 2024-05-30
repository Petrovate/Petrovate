package com.project.model.Object;
import com.project.App;

public class Bensin extends App{
    private int id;
    private String name;
    private Brand brand;
    private double stock;

    public Bensin(int id, String name, Brand brand, double stock){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.stock = stock;
    }

    public int getId() {
        return this.id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public double getStock() {
        return this.stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }


    public String toString() {
        // TODO Auto-generated method stub
        return "ID: " + this.id + "\n" + "Nama Bensin: " + this.name + "\n" + "Brand: " + this.brand + "\n" + "Stock: " + this.stock + "\n";
    }

}