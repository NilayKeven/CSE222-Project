package com.bootstrappers.gui;

import com.bootstrappers.backend.Admin;
import com.bootstrappers.backend.Member;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminLogin extends Application {

    @FXML
    private Button adminlogin;
    @FXML
    private TextField adminEmail;
    @FXML
    private TextField adminPassword;
    @FXML
    private AdminScreen adminScreen;

    public static void main(String[] args) {
        launch(args);
    }


    public void initialize() throws Exception {
        adminScreen = new AdminScreen();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        primaryStage.setTitle("Admin Login");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    void adminLoginSelected(ActionEvent event) throws Exception {
        Admin m = new Admin(null, null, adminPassword.getText(), null, adminEmail.getText(), null);
        if (!m.login(Main.bs.getUserArrayList())) {
            Stage stage = (Stage) adminlogin.getScene().getWindow();
            adminScreen.start(stage);
        } else {
            Main.showDialog((Stage) adminlogin.getScene().getWindow(), "Email kayıtlı değil!");
        }
    }
}
