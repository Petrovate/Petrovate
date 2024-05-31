package com.project.model.Object;
import java.util.ArrayList;

import com.project.model.Parsing.Json;
public class SPBU {
    
    private int id;
    private Brand brand;
    private String brandName;
    private String alamat;
    private Bensin bensin;

    public SPBU(int id, Brand brand, String alamat){
        this.id = id;
        this.brand = brand;
        this.alamat = alamat;  

    }

    public SPBU(int id, String brandName, String alamat){
        this.id = id;
        this.brandName = brandName;
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
        Json.searchId(this.id);
    }

    public ArrayList<SPBU> getSPBUData(){
        return Json.getSPBUData();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ID: " + this.id + "\n" + "Brand: " + this.brand.getBrand() + "\n" + "Alamat: " + this.alamat + "\n";
    }
    
}
