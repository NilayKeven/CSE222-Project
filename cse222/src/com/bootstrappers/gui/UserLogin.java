package com.bootstrappers.gui;

import com.bootstrappers.backend.BootStrappers;
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

import java.io.IOException;

public class UserLogin extends Application {

    @FXML
    private Button userlogin;
    @FXML
    private Button userregister;
    @FXML
    private TextField loginEmail;
    @FXML
    private TextField loginPassword;
    @FXML
    private TextField regName;
    @FXML
    private TextField regSurname;
    @FXML
    private TextField regEmail;
    @FXML
    private TextField regPhone;
    @FXML
    private TextField regPass;

    private UserScreen userScreen;

    public void initialize() throws Exception {
        userScreen = new UserScreen();
    }

    @FXML
    void userLoginSelected(ActionEvent event) throws Exception {
        Member m = new Member(null, null, loginPassword.getText(), null, loginEmail.getText(), null);
        if (!m.login(Main.bs.getUserArrayList())) {
            Stage stage = (Stage) userlogin.getScene().getWindow();
            userScreen.start(stage);
        } else {
            Main.showDialog((Stage) userlogin.getScene().getWindow(), "Giriş başarısız!");
        }
    }

    @FXML
    void userRegisterSelected(ActionEvent event) throws Exception {
        Member m = new Member(regName.getText(), regSurname.getText(), regPass.getText(),
                regPhone.getText(), regEmail.getText(), "com.bootstrappers.backend.Member");

        if (m.registeration(Main.bs.getUserArrayList())) {
            Stage stage = (Stage) userlogin.getScene().getWindow();
            userScreen.start(stage);
        } else {
            Main.showDialog((Stage) userlogin.getScene().getWindow(), "Kullanıcı zaten kayıtlı!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        primaryStage.setTitle("User Login");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
