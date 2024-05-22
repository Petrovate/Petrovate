package com.project;
public class SPBU extends JsonFileReader {
    
    private int id;
    private Brand brand;
    private String alamat;
    private Bensin bensin;

    SPBU(char id, Brand brand, Bensin name, String alamat){
      this.id = id;
        this.brand = brand;
        this.alamat = alamat;  
    }

    public int getId() {
        return this.id;
    }

    public void setId(char id) {
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
    
    public void printSPBU(){
        JsonFileReader.getSPBUData(this.id);
    }
    
}
