package com.example.supplychainmanagement;

import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {
   public TableView<Product> productTable;

   public Pane getAllProducts(){
       TableColumn id=new TableColumn("Id");
       id.setCellValueFactory(new PropertyValueFactory<>("id"));
       TableColumn name=new TableColumn("Name");
       id.setCellValueFactory(new PropertyValueFactory<>("name"));
       TableColumn price=new TableColumn("Price");
       id.setCellValueFactory(new PropertyValueFactory<>("price"));

       ObservableList<Product> data= FXCollections.observableArrayList();
       data.add(new Product(1,"Lenovo",89999));
       data.add(new Product(2,"HP",59999));

       productTable =new TableView<>();
       productTable.setItems(data);
       productTable.getColumns().addAll(id,name,price);

       Pane tablePane=new Pane();
       tablePane.getChildren().add(productTable);
       return tablePane;
   }
}
