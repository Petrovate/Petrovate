package com.project.model.Object;
import com.project.App;
import com.project.model.Object.Brand;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Bensin extends App{
    @JsonIgnore
    private Object hostServices; // replace Object with the actual type if you know it
    private int id;
    private String name;
    private Brand Brand;
    private String brand;
    private double stock;
    private Object parameters; // replace Object with the actual type if you know it

    public Bensin(){
        this.id = 0;
        this.name = "";
        this.Brand = null;
        this.stock = 0;
    }

    public Bensin(int id, String name, Brand brand, double stock){
        this.id = id;
        this.name = name;
        this.Brand = brand;
        this.stock = stock;
    }

    public Bensin(int id, String name, String brand, double stock){
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

    public String getBrandName(){
        return this.brand;
    }
    public Brand getBrand() {
        return this.Brand;
    }

    public double getStock() {
        return this.stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }


    public String toString() {
        // TODO Auto-generated method stub
        if(this.Brand != null){
            return "{ID: " + this.id + "\n" + "Nama Bensin: " + this.name + "\n" + "Brand: " + this.Brand.getBrand() + "\n" + "Stock: " + this.stock + "\n" + "}";
        }else{
            return "{ID: " + this.id + "\n" + "Nama Bensin: " + this.name + "\n" + "Brand: " + this.brand + "\n" + "Stock: " + this.stock + "\n" + "}";
        }
    }


}