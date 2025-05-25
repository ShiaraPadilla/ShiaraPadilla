/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

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
import model.DatosCompartidos;
import model.Producto;
import model.Sesion;

/**
 *
 * @author luisg
 */
public class Catalogo2Controller {

   
    @FXML private Button btnComprarBolso;
    @FXML private Button btnAgregarCarritoBolso;
    @FXML private Button btnMeGustaBolso;

 
    @FXML private Button btnComprarBlusa;
    @FXML private Button btnAgregarCarritoBlusa;
    @FXML private Button btnMeGustaBlusa;

 
    @FXML private Button btnComprarFalda;
    @FXML private Button btnAgregarCarritoFalda;
    @FXML private Button btnMeGustaFalda;

 
    @FXML private Button btnComprarTacones;
    @FXML private Button btnAgregarCarritoTacones;
    @FXML private Button btnMeGustaTacones;


    @FXML private Button btnComprarZapatos;
    @FXML private Button btnAgregarCarritoZapatos;
    @FXML private Button btnMeGustaZapatos;

 
    @FXML private Button btnComprarJeans;
    @FXML private Button btnAgregarCarritoJeans;
    @FXML private Button btnMeGustaJeans;

  
    private List<Producto> carrito = new ArrayList<>();
    private List<Producto> favoritos = new ArrayList<>();

    @FXML
    public void initialize() {
     
        btnComprarBolso.setOnAction(e -> comprarProducto(new Producto("Bolso dama", 35.99)));
        btnAgregarCarritoBolso.setOnAction(e -> agregarAlCarrito(new Producto("Bolso dama", 35.99)));
        btnMeGustaBolso.setOnAction(e -> agregarAFavoritos(new Producto("Bolso dama", 35.99)));

   
        btnComprarBlusa.setOnAction(e -> comprarProducto(new Producto("Blusa dama", 25.99)));
        btnAgregarCarritoBlusa.setOnAction(e -> agregarAlCarrito(new Producto("Blusa dama", 25.99)));
        btnMeGustaBlusa.setOnAction(e -> agregarAFavoritos(new Producto("Blusa dama", 25.99)));

   
        btnComprarFalda.setOnAction(e -> comprarProducto(new Producto("Falda dama", 29.99)));
        btnAgregarCarritoFalda.setOnAction(e -> agregarAlCarrito(new Producto("Falda dama", 29.99)));
        btnMeGustaFalda.setOnAction(e -> agregarAFavoritos(new Producto("Falda dama", 29.99)));

   
        btnComprarTacones.setOnAction(e -> comprarProducto(new Producto("Tacones", 40.99)));
        btnAgregarCarritoTacones.setOnAction(e -> agregarAlCarrito(new Producto("Tacones", 40.99)));
        btnMeGustaTacones.setOnAction(e -> agregarAFavoritos(new Producto("Tacones", 40.99)));

   
        btnComprarZapatos.setOnAction(e -> comprarProducto(new Producto("Zapatos deportivos", 55.99)));
        btnAgregarCarritoZapatos.setOnAction(e -> agregarAlCarrito(new Producto("Zapatos deportivos", 55.99)));
        btnMeGustaZapatos.setOnAction(e -> agregarAFavoritos(new Producto("Zapatos deportivos", 55.99)));

   
        btnComprarJeans.setOnAction(e -> comprarProducto(new Producto("Jeans caballero", 45.99)));
        btnAgregarCarritoJeans.setOnAction(e -> agregarAlCarrito(new Producto("Jeans caballero", 45.99)));
        btnMeGustaJeans.setOnAction(e -> agregarAFavoritos(new Producto("Jeans caballero", 45.99)));
    }
     @FXML
    private void handleVolver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Catalogo1.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Catálogo 1");
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
    private void handleIrAFavoritos(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MeGusta.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Favoritos");
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
    alerta.setContentText("Comprando: " + producto.getNombre() + " por $" + producto.getPrecio());
    alerta.showAndWait();

  
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Historial.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnComprarBolso.getScene().getWindow(); 

        stage.setScene(new Scene(root));
        stage.setTitle("Historial de Compra");
        stage.show();
    } catch (Exception e) {
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
