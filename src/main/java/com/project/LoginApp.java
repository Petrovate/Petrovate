package com.project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LoginApp {
    private static Map<String, List<Validasi>> users;

    public static void main(String[] args) {
        try {
            // Membaca file JSON
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(new File("Validate.json"), new TypeReference<Map<String, List<Validasi>>>() {});

            try (// Lakukan login
            Scanner scanner = new Scanner(System.in)) {
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                login(username, password);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void login(String username, String password) {
        List<Validasi> userList = users.get(username);
        if (userList != null) {
            for (Validasi user : userList) {
                if (user.getPass().equals(password)) {
                    System.out.println("Login berhasil!");
                    if ("admin".equals(user.getRole())) {
                        System.out.println("Selamat datang Admin dengan ID: " + user.getId());
                    } else {
                        System.out.println("Selamat datang User!");
                    }
                    return;
                }
            }
        }
        System.out.println("Username atau password salah.");
    }
}
