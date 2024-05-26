package com.project;
import java.util.ArrayList;
public class SPBU {
    
    private int id;
    private Brand brand;
    private String alamat;
    private Bensin bensin;

    SPBU(int id, Brand brand, String alamat){
        this.id = id;
        this.brand = brand;
        this.alamat = alamat;  
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public String getAlamat(){
        return this.alamat;
    }

    public Bensin getBensin(){
        return this.bensin;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public void searchSPBU(){
        JsonFileReader.searchSPBU(this.id);
    }

    public ArrayList<SPBU> getSPBUData(){
        return JsonFileReader.getSPBUData();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ID: " + this.id + "\n" + "Brand: " + this.brand + "\n" + "Alamat: " + this.alamat + "\n";
    }
    
}
