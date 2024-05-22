package com.project;
import com.fasterxml.jackson.databind.JsonNode; 
import com.fasterxml.jackson.databind.ObjectMapper; 
import java.io.File; 
import java.io.IOException;
public class JsonFileReader { 
    public static void main(String[] args) throws IOException { 
        ObjectMapper objectMapper = new ObjectMapper(); 
        JsonNode arrayNode = objectMapper.readTree(new File("D:/Petrovate/Petrovate/src/main/java/com/project/db.json")); 

        if(arrayNode.isArray()) { 
            for(JsonNode jsonNode : arrayNode) { 
                String nama = jsonNode.has("nama") ? jsonNode.get("nama").asText() : "Field not found"; 
            String brand = jsonNode.has("brand") ? jsonNode.get("brand").asText() : "Field not found"; 
            String jenis = jsonNode.has("jenis") ? jsonNode.get("jenis").asText() : "Field not found"; 
            int stock = jsonNode.has("stock") ? jsonNode.get("stock").asInt() : 0; 
            String alamat = jsonNode.has("alamat") ? jsonNode.get("alamat").asText() : "Field not found"; 

            System.out.println("Nama: " + nama); 
            System.out.println("Brand: " + brand); 
            System.out.println("Jenis: " + jenis); 
            System.out.println("Stock: " + stock); 
            System.out.println("Alamat: " + alamat);
        }
          
    } 
}}