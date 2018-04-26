package com.bootstrappers.gui;

import com.bootstrappers.backend.Address;
import com.bootstrappers.backend.BootStrappers;
import com.bootstrappers.backend.Home;
import com.bootstrappers.backend.Member;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AdminScreen extends Application implements Initializable {

    private AdminLogin adminLoginScreen;
    private UserLogin userLoginScreen;
    @FXML
    private Button adminbutton;
    @FXML
    private Button userbutton;
    @FXML
    private TableView usertable;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillTable();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
        primaryStage.setTitle("Admin");
        primaryStage.setScene(new Scene(root, 1300, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void fillTable() {
        BootStrappers bs = new BootStrappers();
        List<Home> homelist = bs.getHomeArrayList();
        ObservableList data = FXCollections.observableList(homelist);
        usertable.setItems(data);

        TableColumn col1 = new TableColumn("Ad Number");
        col1.setCellValueFactory(new PropertyValueFactory("adNumber"));
        TableColumn col2 = new TableColumn("Owner");
        col2.setCellValueFactory(new PropertyValueFactory("owner"));
        TableColumn col3 = new TableColumn("Location");
        col3.setCellValueFactory(new PropertyValueFactory("address"));
        TableColumn col4 = new TableColumn("Price");
        col4.setCellValueFactory(new PropertyValueFactory("price"));
        TableColumn col5 = new TableColumn("Rooms");
        col5.setCellValueFactory(new PropertyValueFactory("countOfRoom"));
        TableColumn col6 = new TableColumn("Status");
        col6.setCellValueFactory(new PropertyValueFactory("status"));
        TableColumn col7 = new TableColumn("Type");
        col7.setCellValueFactory(new PropertyValueFactory("type"));

        usertable.getColumns().setAll(col1, col2, col3, col4, col5, col6, col7);
        usertable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    void applyFiltersSelected(ActionEvent event) throws Exception {
        fillTable();
    }
}
