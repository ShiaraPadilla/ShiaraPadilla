/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.DatosCompartidos;
import model.Producto;
import model.Sesion;

/**
 *
 * @author luisg
 */
public class Catalogo1Controller {


    @FXML private Button btnComprarPijama;
    @FXML private Button btnAgregarCarritoPijama;
    @FXML private Button btnMeGustaPijama;


    @FXML private Button btnComprarGorra;
    @FXML private Button btnAgregarCarritoGorra;
    @FXML private Button btnMeGustaGorra;


    @FXML private Button btnComprarConjuntoMujer;
    @FXML private Button btnAgregarCarritoConjuntoMujer;
    @FXML private Button btnMeGustaConjuntoMujer;


    @FXML private Button btnComprarOversize;
    @FXML private Button btnAgregarCarritoOversize;
    @FXML private Button btnMeGustaOversize;


    @FXML private Button btnComprarConjuntoHombre;
    @FXML private Button btnAgregarCarritoConjuntoHombre;
    @FXML private Button btnMeGustaConjuntoHombre;


    @FXML private Button btnComprarBody;
    @FXML private Button btnAgregarCarritoBody;
    @FXML private Button btnMeGustaBody;


    private List<Producto> carrito = new ArrayList<>();
    private List<Producto> favoritos = new ArrayList<>();

    @FXML
    public void initialize() {
        btnComprarPijama.setOnAction(e -> comprarProducto(new Producto("Pijama mujer", 29.999)));
        btnAgregarCarritoPijama.setOnAction(e -> agregarAlCarrito(new Producto("Pijama mujer", 29.999)));
        btnMeGustaPijama.setOnAction(e -> agregarAFavoritos(new Producto("Pijama mujer", 29.999)));

        btnComprarGorra.setOnAction(e -> comprarProducto(new Producto("Gorra beisbolera", 15.999)));
        btnAgregarCarritoGorra.setOnAction(e -> agregarAlCarrito(new Producto("Gorra beisbolera", 15.999)));
        btnMeGustaGorra.setOnAction(e -> agregarAFavoritos(new Producto("Gorra beisbolera", 15.999)));

        btnComprarPijama.setOnAction(e -> comprarProducto(new Producto("Pijama mujer", 29.99)));
        btnAgregarCarritoPijama.setOnAction(e -> agregarAlCarrito(new Producto("Pijama mujer", 29.99)));
        btnMeGustaPijama.setOnAction(e -> agregarAFavoritos(new Producto("Pijama mujer", 29.99)));


        btnComprarGorra.setOnAction(e -> comprarProducto(new Producto("Gorra beisbolera", 15.99)));
        btnAgregarCarritoGorra.setOnAction(e -> agregarAlCarrito(new Producto("Gorra beisbolera", 15.99)));
        btnMeGustaGorra.setOnAction(e -> agregarAFavoritos(new Producto("Gorra beisbolera", 15.99)));

        btnComprarConjuntoMujer.setOnAction(e -> comprarProducto(new Producto("Conjunto mujer", 49.999)));
        btnAgregarCarritoConjuntoMujer.setOnAction(e -> agregarAlCarrito(new Producto("Conjunto mujer", 49.999)));
        btnMeGustaConjuntoMujer.setOnAction(e -> agregarAFavoritos(new Producto("Conjunto mujer", 49.999)));

        btnComprarOversize.setOnAction(e -> comprarProducto(new Producto("Oversize", 39.999)));
        btnAgregarCarritoOversize.setOnAction(e -> agregarAlCarrito(new Producto("Oversize", 39.999)));
        btnMeGustaOversize.setOnAction(e -> agregarAFavoritos(new Producto("Oversize", 39.999)));

        btnComprarConjuntoHombre.setOnAction(e -> comprarProducto(new Producto("Conjunto hombre", 54.999)));
        btnAgregarCarritoConjuntoHombre.setOnAction(e -> agregarAlCarrito(new Producto("Conjunto hombre", 54.999)));
        btnMeGustaConjuntoHombre.setOnAction(e -> agregarAFavoritos(new Producto("Conjunto hombre", 54.999)));

        btnComprarBody.setOnAction(e -> comprarProducto(new Producto("Body", 22.999)));
        btnAgregarCarritoBody.setOnAction(e -> agregarAlCarrito(new Producto("Body", 22.999)));
        btnMeGustaBody.setOnAction(e -> agregarAFavoritos(new Producto("Body", 22.999)));
      
        btnComprarOversize.setOnAction(e -> comprarProducto(new Producto("Oversize", 39.99)));
        btnAgregarCarritoOversize.setOnAction(e -> agregarAlCarrito(new Producto("Oversize", 39.99)));
        btnMeGustaOversize.setOnAction(e -> agregarAFavoritos(new Producto("Oversize", 39.99)));


        btnComprarConjuntoHombre.setOnAction(e -> comprarProducto(new Producto("Conjunto hombre", 54.99)));
        btnAgregarCarritoConjuntoHombre.setOnAction(e -> agregarAlCarrito(new Producto("Conjunto hombre", 54.99)));
        btnMeGustaConjuntoHombre.setOnAction(e -> agregarAFavoritos(new Producto("Conjunto hombre", 54.99)));


        btnComprarBody.setOnAction(e -> comprarProducto(new Producto("Body", 22.99)));
        btnAgregarCarritoBody.setOnAction(e -> agregarAlCarrito(new Producto("Body", 22.99)));
        btnMeGustaBody.setOnAction(e -> agregarAFavoritos(new Producto("Body", 22.99)));

    }
    @FXML
    private void handleSiguiente(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Catalogo2.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Catálogo 2");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleIrAlCarrito(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Carrito.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Carrito de Compras");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@FXML
    private void handleMeGusta(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MeGusta.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Me Gusta");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @FXML
private void handleIrHistorial(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Historial.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Historial de Compra");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    private void comprarProducto(Producto producto) {
 
    DatosCompartidos.agregarAlHistorial(producto);


    Alert alerta = new Alert(AlertType.INFORMATION);
    alerta.setTitle("Compra Realizada");
    alerta.setHeaderText(null);
    alerta.setContentText("Has comprado: " + producto.getNombre() + " por $" + producto.getPrecio());
    alerta.showAndWait();


    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Historial.fxml"));
        Parent root = loader.load();


        Stage stage = (Stage) btnComprarPijama.getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Historial de Compra");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void agregarAlCarrito(Producto producto) {
    Sesion.agregarAlCarrito(producto);
    mostrarAlerta("Agregado al carrito", producto.getNombre() + " ha sido agregado al carrito.");
}

private void agregarAFavoritos(Producto producto) {
    Sesion.agregarAFavoritos(producto);
    mostrarAlerta("Agregado a favoritos", producto.getNombre() + " ha sido agregado a favoritos.");
}

private void mostrarAlerta(String titulo, String mensaje) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(mensaje);
    alert.showAndWait();
}


}
    

