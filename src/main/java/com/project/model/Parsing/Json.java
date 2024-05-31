package com.project.model.Parsing;

import com.fasterxml.jackson.databind.*;
import com.project.App;
import com.project.model.Object.Brand;
import com.project.model.Object.SPBU;
import com.project.model.Object.Bensin;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter; // Import the missing class

public class Json extends App {
    static String FILEPATH = "src\\main\\java\\com\\project\\db\\";

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

    public static void searchId(int idInput) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode arrayNode = objectMapper
                    .readTree(new File(FILEPATH + "db.json"));
            for (JsonNode jsonNode : arrayNode) {
                if (jsonNode.get("id").asInt() == idInput) {
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

    public static ArrayList<SPBU> searchAddress(String input) {
        ArrayList<SPBU> spbulist = Json.getSPBUData();
        ArrayList<SPBU> hasil = new ArrayList<SPBU>();
        if (input != null) {
            String[] words = input.split("\\s");

            StringBuilder result = new StringBuilder();

            for (String word : words) {
                result.append(Character.toTitleCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
            input = result.toString().trim();
        }
        try {
            for (SPBU search : spbulist) {
                if (search.getAlamat().contains((input))) {
                    hasil.add(search);
                }
            }
            if (hasil.isEmpty()) {
                return null;
            }
            return hasil;
        } finally {
            System.out.println("hasil: ");
        }

    }

    public static List<Bensin> getBensinList() {
        try {
            List<Bensin> bensinList = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode bensinArray = objectMapper
                    .readTree(new File(FILEPATH + "bensin.json"));
            JsonNode brandArray = objectMapper
                    .readTree(new File(FILEPATH + "brand.json"));

            for (int i = 0; i < bensinArray.size(); i++) {
                JsonNode data = bensinArray.get(i);
                String name = "";
                int id = 0;
                double stock = 0.0;
                Brand brand = null;
                String brandName = "";
                brandName = data.has("brandName") ? data.get("brandName").asText() : "Field not found";
                name = data.has("name") ? data.get("name").asText() : "Field not found";
                id = data.has("id") ? data.get("id").asInt() : 0;
                stock = data.has("stock") ? data.get("stock").asDouble() : 0.0;

                for (JsonNode brandDict : brandArray) {
                    String nama = brandDict.has("brand") ? brandDict.get("brand").asText() : "Field not found";
                    int idBrand = brandDict.has("id") ? brandDict.get("id").asInt() : 0;
                    if (brandName.equals(nama)) {
                        brand = new Brand(nama, idBrand);
                        break;
                    }
                }

                if (brand == null) {
                    new Exception("Brand not found");
                }

                Bensin bensin = new Bensin(id, name, brand, stock);
                bensinList.add(bensin);
            }
            return bensinList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void updateBensinStock(int idBensin, double newStock) {
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Bensin> bensinList = new ArrayList<>();
            JsonNode bensinArray = objectMapper
                    .readTree(new File(FILEPATH + "bensin.json"));
            for (int i = 0; i < bensinArray.size(); i++) {
                JsonNode data = bensinArray.get(i);
                int id = 0;
                String name = "";
                String brand = "";
                double stock = 0.0;
                id = data.has("id") ? data.get("id").asInt() : 0;
                name = data.has("name") ? data.get("name").asText() : "Field not found";
                brand = data.has("brandName") ? data.get("brandName").asText() : "Field not found";
                stock = data.has("stock") ? data.get("stock").asDouble() : 0.0;
                Bensin bensin = new Bensin(id, name, brand, stock);
                System.out.println(bensin.getBrandName());
                bensinList.add(bensin);
            }
            for (Bensin uBensin : bensinList) {
                if (uBensin.getId() == idBensin) {
                    uBensin.setStock(newStock);
                    System.out.println(bensinList);
                    System.out.println("...........................");
                    String tes = objectMapper.writeValueAsString(bensinList);
                    System.out.println(tes);
                    break;
                }
            }
            objectMapper.writeValue(new File(FILEPATH + "bensin.json"), bensinList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Brand> getBrandList() {
        try {
            List<Brand> brandList = new ArrayList<>();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode brandArray = objectMapper
                    .readTree(new File(FILEPATH + "brand.json"));

            for (JsonNode brandDict : brandArray) {
                String name = brandDict.has("brand") ? brandDict.get("brand").asText() : "Field not found";
                int id = brandDict.has("id") ? brandDict.get("id").asInt() : 0;
                Brand brand = new Brand(name, id);
                brandList.add(brand);
            }
            return brandList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
