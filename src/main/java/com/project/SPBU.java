package com.project;
public class SPBU {
    
    private char id;
    private Brand brand;
    private Bensin name;
    private String alamat;

    SPBU(char id, Brand brand, Bensin name, String alamat){
      this.id = id;
        this.brand = brand;
        this.name = name;
        this.alamat = alamat;  
    }

    public char getId() {
        return this.id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public Bensin getName() {
        return this.name;
    }

    public String getAlamat(){
        return this.alamat;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public void printSPBU(){
        System.out.println("ID SPBU: " + this.id);
        System.out.println("Brand: " + this.brand);
        System.out.println("Nama Bensin: " + this.name);
        System.out.println("Alamat: " + this.alamat);
    }
    
}
