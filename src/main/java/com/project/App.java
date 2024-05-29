package com.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;

import com.project.model.Object.SPBU;

import com.project.model.Parsing.JsonFileReader;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        
        scene = new Scene(loadFXML("view/primary"));
        stage.setTitle("Petrovate");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

// public static void main(String[] args){
// private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
// private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

// public static String generateNewToken() {
//     byte[] randomBytes = new byte[24];
//     secureRandom.nextBytes(randomBytes);
//     return base64Encoder.encodeToString(randomBytes);
// }
}

