package com.project;

public class SPBU {
    
    private char id;
    private Brand brand;
    private Bensin name;
    private String alamat;

    SPBU(char id, Brand brand, Bensin name, String alamat){
        
    }

    public char getId() {
        return id;
    }

    public void setId(SPBU id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public Bensin getName() {
        return name;
    }

    public String getAlamat(){
        return alamat;
    }

    public void setAlamat(SPBU alamat){
        this.alamat = alamat;
    }
    
}
