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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserScreen extends Application {

    private AdminLogin adminLoginScreen;
    private UserLogin userLoginScreen;
    @FXML
    private Button adminbutton;
    @FXML
    private Button userbutton;
    @FXML
    private TableView usertable;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UserScreen.fxml"));
        primaryStage.setTitle("User");
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private ObservableList<String> getCharacters(){
        ObservableList<String> homes = FXCollections.observableArrayList();
        //homes.add(new Home("asd", "asd", "asd", new Address("asdad", "as", "asd"), 1 ,
         //       null, 1, 1));
        homes.add("asd");
        return homes;
    }

    @FXML
    void applyFiltersSelected(ActionEvent event) throws Exception {
        BootStrappers bs = new BootStrappers();
        ArrayList<Home> homelist = bs.getHomeArrayList();
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
        //usertable.setPrefWidth(700);
        //usertable.setPrefHeight(700);
        usertable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void addColumn(TableView table, String row) {
        TableColumn<Map, String> column = new TableColumn<>(row);
        column.setMinWidth(130);
        table.getColumns().add(column);
    }

    private void addRow(TableView table, String data) {
        ObservableList<Map> allData = table.getItems();
        Map<String, String> dataRow = new HashMap<>();
        for (int j = 0; j < table.getColumns().size(); j++) {
            System.out.println(j + "asd");
            String mapKey = "Ad Number";
            String value1 = data;
            dataRow.put(mapKey, value1);
        }
        allData.add(dataRow);
        table.setItems(allData);
    }
}
