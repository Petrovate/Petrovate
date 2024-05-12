package com.project;

public class Bensin {

    private Character id;
    private String name;
    private Brand brand;
    private double stock;

    Bensin(char id, String name, Brand brand, double stock){

    }

    public char getId() {
        return id;
    }

    public void id(char id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
