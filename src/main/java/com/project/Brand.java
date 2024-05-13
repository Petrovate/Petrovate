package com.project;

public class Brand {

    private String brand;
    private char id;

    Brand(String brand, char id){

    }
        
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
