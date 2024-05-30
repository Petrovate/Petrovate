package com.project.model.Parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project.App;
import com.project.model.Object.Brand;
import com.project.model.Object.SPBU;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/*import java.util.InputMismatchException;*/
import java.util.Map;
import java.util.Scanner;

public class UpdateFuelStock extends App {
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
        ArrayList<SPBU> spbulist = UpdateFuelStock.getSPBUData();
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

    public static boolean updateFuelStock(int id, String fuelName, double change) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(FILEPATH + "bensin.json"));

            // Iterate through the entries in the root node
            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                String key = entry.getKey();
                JsonNode fuelList = entry.getValue();

                // Check if the current key matches the given ID
                if (key.equals(String.valueOf(id))) {
                    for (JsonNode fuelNode : fuelList) {
                        String name = fuelNode.has("name") ? fuelNode.get("name").asText() : fuelNode.get("nama").asText();
                        if (name.equalsIgnoreCase(fuelName)) {
                            double currentStock = fuelNode.get("stock").asDouble();
                            ((ObjectNode) fuelNode).put("stock", currentStock + change);
                            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILEPATH + "bensin.json"), rootNode);
                            return true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID: ");
        int id = scanner.nextInt();

        scanner.nextLine();  // Consume newline

        System.out.print("Masukkan nama bahan bakar: ");
        String fuelName = scanner.nextLine();

        System.out.print("Masukkan perubahan stok (positif untuk menambah, negatif untuk mengurangi): ");
        double change = scanner.nextDouble();

        boolean result = updateFuelStock(id, fuelName, change);

        if (result) {
            System.out.println("Stok berhasil diperbarui.");
        } else {
            System.out.println("ID atau nama bahan bakar tidak ditemukan.");
        }

        scanner.close();
    }
}
    




