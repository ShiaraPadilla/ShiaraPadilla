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

    // Botones para Bolso dama
    @FXML private Button btnComprarBolso;
    @FXML private Button btnAgregarCarritoBolso;
    @FXML private Button btnMeGustaBolso;

    // Botones para Blusa dama
    @FXML private Button btnComprarBlusa;
    @FXML private Button btnAgregarCarritoBlusa;
    @FXML private Button btnMeGustaBlusa;

    // Botones para Falda dama
    @FXML private Button btnComprarFalda;
    @FXML private Button btnAgregarCarritoFalda;
    @FXML private Button btnMeGustaFalda;

    // Botones para Tacones
    @FXML private Button btnComprarTacones;
    @FXML private Button btnAgregarCarritoTacones;
    @FXML private Button btnMeGustaTacones;

    // Botones para Zapatos deportivos
    @FXML private Button btnComprarZapatos;
    @FXML private Button btnAgregarCarritoZapatos;
    @FXML private Button btnMeGustaZapatos;

    // Botones para Jeans caballero
    @FXML private Button btnComprarJeans;
    @FXML private Button btnAgregarCarritoJeans;
    @FXML private Button btnMeGustaJeans;

    // Listas para carrito y favoritos
    private List<Producto> carrito = new ArrayList<>();
    private List<Producto> favoritos = new ArrayList<>();

    @FXML
    public void initialize() {
        // Bolso dama
        btnComprarBolso.setOnAction(e -> comprarProducto(new Producto("Bolso dama", 35.99)));
        btnAgregarCarritoBolso.setOnAction(e -> agregarAlCarrito(new Producto("Bolso dama", 35.99)));
        btnMeGustaBolso.setOnAction(e -> agregarAFavoritos(new Producto("Bolso dama", 35.99)));

        // Blusa dama
        btnComprarBlusa.setOnAction(e -> comprarProducto(new Producto("Blusa dama", 25.99)));
        btnAgregarCarritoBlusa.setOnAction(e -> agregarAlCarrito(new Producto("Blusa dama", 25.99)));
        btnMeGustaBlusa.setOnAction(e -> agregarAFavoritos(new Producto("Blusa dama", 25.99)));

        // Falda dama
        btnComprarFalda.setOnAction(e -> comprarProducto(new Producto("Falda dama", 29.99)));
        btnAgregarCarritoFalda.setOnAction(e -> agregarAlCarrito(new Producto("Falda dama", 29.99)));
        btnMeGustaFalda.setOnAction(e -> agregarAFavoritos(new Producto("Falda dama", 29.99)));

        // Tacones
        btnComprarTacones.setOnAction(e -> comprarProducto(new Producto("Tacones", 40.99)));
        btnAgregarCarritoTacones.setOnAction(e -> agregarAlCarrito(new Producto("Tacones", 40.99)));
        btnMeGustaTacones.setOnAction(e -> agregarAFavoritos(new Producto("Tacones", 40.99)));

        // Zapatos deportivos
        btnComprarZapatos.setOnAction(e -> comprarProducto(new Producto("Zapatos deportivos", 55.99)));
        btnAgregarCarritoZapatos.setOnAction(e -> agregarAlCarrito(new Producto("Zapatos deportivos", 55.99)));
        btnMeGustaZapatos.setOnAction(e -> agregarAFavoritos(new Producto("Zapatos deportivos", 55.99)));

        // Jeans caballero
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
    // Agregar el producto al historial
    DatosCompartidos.agregarAlHistorial(producto);

    // Mostrar alerta de compra
    Alert alerta = new Alert(AlertType.INFORMATION);
    alerta.setTitle("Compra Realizada");
    alerta.setHeaderText(null);
    alerta.setContentText("Comprando: " + producto.getNombre() + " por $" + producto.getPrecio());
    alerta.showAndWait();

    // Cambiar a la pantalla del historial
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Historial.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnComprarBolso.getScene().getWindow(); // o cualquier botón que esté en la escena actual

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
