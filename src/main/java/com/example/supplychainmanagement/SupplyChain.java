package com.example.supplychainmanagement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SupplyChain extends Application {

    public static final int width=700, height =600, header=50;

    Pane bodypane=new Pane();
    Login login=new Login();
    ProductDetails productDetails=new ProductDetails();

    private GridPane headerBar(){
        TextField searchText=new TextField();
        Button searchButton=new Button("Search");

        GridPane gridpane=new GridPane();
        gridpane.setMinSize(bodypane.getMinWidth(),header-10);
        gridpane.setVgap(5);
        gridpane.setHgap(5);
//        gridpane.setStyle("-fx-background-color:BLUE");

        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(searchText,0,0);
        gridpane.add(searchButton,1,0);

        return gridpane;
    }

    private GridPane loginPage(){
        Label emailLabel=new Label("Email");
        Label passwordLabel =new Label("Password");
        Label messageLabel=new Label("I am message");

        TextField emailTextField=new TextField();
        PasswordField passwordfield=new PasswordField();

        Button loginButton =new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email=emailTextField.getText();
                String password=passwordfield.getText();
                //messageLabel.setText(email+" $$ " +password);
                if(login.customerLogin(email,password)){
                    messageLabel.setText("Login Successful");
                }else{
                    messageLabel.setText("Login Failed");
                }

            }
        });

        GridPane gridpane=new GridPane();
        gridpane.setMinSize(bodypane.getMinWidth(),bodypane.getMinHeight());
        gridpane.setVgap(5);
        gridpane.setHgap(5);
//        gridpane.setStyle("-fx-background-color:BLUE");

        gridpane.setAlignment(Pos.CENTER);

        gridpane.add(emailLabel,0,0);
        gridpane.add(emailTextField,1,0);
        gridpane.add(passwordLabel,0,1);
        gridpane.add(passwordfield,1,1);
        gridpane.add(loginButton,0,2);
        gridpane.add(messageLabel,1,2);
        return gridpane;
    }

    private Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width,height+header);

        bodypane.setMinSize(width,height);
        bodypane.setTranslateY(header);

        bodypane.getChildren().addAll(productDetails.getAllProducts());

        root.getChildren().addAll(headerBar(),bodypane);

        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}