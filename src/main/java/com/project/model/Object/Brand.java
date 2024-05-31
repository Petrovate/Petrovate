package com.project.model.Object;

public class Brand {
    private String brand;
    private int id;

    public Brand(){
        this.brand = "";
        this.id = 0;
}

    public Brand(String brand){
        this.brand = brand;
}

    public Brand(String brand, int id){
        this.brand = brand;
        this.id = id;
    }
        
    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return this.id;
    }

    public void setId(char id) {
        this.id = id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ID: " + this.id + "\n" + "Brand: " + this.brand + "\n";
    }
}
