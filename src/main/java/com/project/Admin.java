package com.project;


public class Admin extends Pengguna{
    static String FILEPATH = "src\\main\\java\\com\\project\\db\\";
    Admin(char id, String name, String pass){

    }
    public void SPUGetAllData(){
        JsonFileReader.getSPBUData();
    }

}
