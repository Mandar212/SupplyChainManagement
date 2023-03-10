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
       name.setCellValueFactory(new PropertyValueFactory<>("name"));
       TableColumn price=new TableColumn("Price");
       price.setCellValueFactory(new PropertyValueFactory<>("price"));

//       ObservableList<Product> data= FXCollections.observableArrayList();
//       data.add(new Product(1,"Lenovo",89999));
//       data.add(new Product(2,"HP",59999));

       ObservableList<Product> products=Product.getAllPrducts();

       productTable =new TableView<>();
       productTable.setItems(products);
       productTable.getColumns().addAll(id,name,price);
       productTable.setMinSize(SupplyChain.width,SupplyChain.height);
       productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

       Pane tablePane=new Pane();
       tablePane.setStyle("-fx-background-color:GREY");
       tablePane.setMinSize(SupplyChain.width,SupplyChain.height);
       tablePane.getChildren().add(productTable);
       return tablePane;
   }
    public Pane getProductsByName(String productName){
        TableColumn id=new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name=new TableColumn("Name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price=new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//       ObservableList<Product> data= FXCollections.observableArrayList();
//       data.add(new Product(1,"Lenovo",89999));
//       data.add(new Product(2,"HP",59999));

        ObservableList<Product> products=Product.getPrductsByName(productName);

        productTable =new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);
        productTable.setMinSize(SupplyChain.width,SupplyChain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Pane tablePane=new Pane();
        tablePane.setStyle("-fx-background-color:GREY");
        tablePane.setMinSize(SupplyChain.width,SupplyChain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }
}
