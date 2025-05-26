/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package View;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        showLogin();
    }

    public static void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/View/Login.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Iniciar Sesión");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void showRegister() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/View/Register.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Registrarse");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void showCatalogo1() {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/View/Catalogo1.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Catálogo 1 ");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void showCatalogo2() {
        try {
            Parent root = FXMLLoader.load(MainApp.class.getResource("/View/Catalogo2.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Catálogo 2 ");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}



   









