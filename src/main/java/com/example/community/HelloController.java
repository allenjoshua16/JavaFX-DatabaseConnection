package com.example.community;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class HelloController {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label status;

    @FXML
    protected void login(ActionEvent event) throws Exception {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT COUNT(1) FROM community.login WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    status.setText("Welcome");

                    Stage stage = new Stage();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 450, 400);
                    stage.setTitle("Login!");
                    stage.setScene(scene);
                    stage.show();

                } else {
                    status.setText("Invalid Login");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // CreateAccount FXML

    }
}