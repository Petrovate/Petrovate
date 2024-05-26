package com.project;

import java.io.IOException;

import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}