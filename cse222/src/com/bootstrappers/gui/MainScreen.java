package com.bootstrappers.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainScreen {

    private AdminLogin adminLoginScreen;
    private UserLogin userLoginScreen;

    @FXML
    private Button adminbutton;
    @FXML
    private Button userbutton;

    public void initialize() throws Exception {
        adminLoginScreen = new AdminLogin();
        userLoginScreen = new UserLogin();
    }

    @FXML
    void adminSelected(ActionEvent event) throws Exception {
        Stage stage = (Stage) adminbutton.getScene().getWindow();
        adminLoginScreen.start(stage);
    }

    @FXML
    void userSelected(ActionEvent event) throws Exception {
        Stage stage = (Stage) userbutton.getScene().getWindow();
        userLoginScreen.start(stage);
    }
}
