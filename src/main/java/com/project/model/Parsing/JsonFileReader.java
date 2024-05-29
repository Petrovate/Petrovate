package com.project.model.Parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.App;
import com.project.model.Object.Brand;
import com.project.model.Object.SPBU;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class JsonFileReader extends App {
    static String FILEPATH = "src\\main\\java\\com\\project\\db\\";
    public static void searchSPBU(int p) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode arrayNode = objectMapper
                    .readTree(new File(FILEPATH + "db.json"));
            for (JsonNode jsonNode : arrayNode) {
                if (jsonNode.get("id").asInt() == p) {
                    String brand = jsonNode.has("brand") ? jsonNode.get("brand").asText() : "Field not found";
                    int id = jsonNode.has("id") ? jsonNode.get("id").asInt() : 0;
                    String alamat = jsonNode.has("alamat") ? jsonNode.get("alamat").asText() : "Field not found";

                    System.out.println("Brand: " + brand);
                    System.out.println("id " + id);
                    System.out.println("Alamat: " + alamat);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static ArrayList<SPBU> getSPBUAddress(String address){
    //     try {
    //         ObjectMapper objectMapper = new ObjectMapper();
    //         JsonNode arrayNode = objectMapper
    //                 .readTree(new File(FILEPATH + "db.json"));
    //         for (JsonNode jsonNode : arrayNode) {
    //             if (jsonNode.get("id").asInt() == p) {
    //                 String brand = jsonNode.has("brand") ? jsonNode.get("brand").asText() : "Field not found";
    //                 int id = jsonNode.has("id") ? jsonNode.get("id").asInt() : 0;
    //                 String alamat = jsonNode.has("alamat") ? jsonNode.get("alamat").asText() : "Field not found";

    //                 System.out.println("Brand: " + brand);
    //                 System.out.println("id " + id);
    //                 System.out.println("Alamat: " + alamat);
    //             }
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    public static ArrayList<SPBU> getSPBUData() {
        try {
            ArrayList<SPBU> SPBUList = new ArrayList<SPBU>();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode SPBUArray = objectMapper
                    .readTree(new File(FILEPATH + "db.json"));
            JsonNode brandArray = objectMapper
                    .readTree(new File(FILEPATH + "brand.json"));
            for (JsonNode SPBUDict : SPBUArray) {
                String brandName = SPBUDict.has("brand") ? SPBUDict.get("brand").asText() : "Field not found";
                int id = SPBUDict.has("id") ? SPBUDict.get("id").asInt() : 0;
                String alamat = SPBUDict.has("alamat") ? SPBUDict.get("alamat").asText() : "Field not found";

                Brand brand = null;
                for (JsonNode brandDict : brandArray) {
                    String name = brandDict.has("brand") ? brandDict.get("brand").asText() : "Field not found";
                    int idBrand = brandDict.has("id") ? brandDict.get("id").asInt() : 0;
                    if (brandName.equals(name)) {
                        brand = new Brand(name, idBrand);
                        break;
                    }
                }

                if (brand == null) {
                    new Exception("Brand not found");
                }

                SPBU spbu = new SPBU(id, brand, alamat);
                SPBUList.add(spbu);
            }
            return SPBUList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    };
    public static ArrayList<SPBU> searchAddress(String input){
        ArrayList<SPBU> spbulist = JsonFileReader.getSPBUData();
        ArrayList<SPBU> hasil = new ArrayList<SPBU>();
        if (input != null){
        String[] words = input.split("\\s"); 
  
        StringBuilder result = new StringBuilder(); 

        for (String word : words) { 
            result.append(Character.toTitleCase(word.charAt(0))) 
                  .append(word.substring(1)) 
                  .append(" "); 
        }
        input = result.toString().trim(); 
    }
    try{
        for(SPBU search : spbulist){
            if (search.getAlamat().contains((input))){
                hasil.add(search);
            }
        }
        if(hasil.isEmpty()){
            return null;
        }
        return hasil;
    } 
    finally{
        System.out.println("hasil: ");
        }

    }
}
    




