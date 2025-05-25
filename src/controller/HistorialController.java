/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DatosCompartidos;
import model.Producto;

/**
 *
 * @author ASUS
 */
public class HistorialController {

    @FXML
    private TableView<Producto> tablaCarrito;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnVolver;


@FXML
public void initialize() {
    colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

    tablaCarrito.setItems(DatosCompartidos.obtenerHistorial());
}

@FXML
private void handleEliminarHistorial(ActionEvent event) {
    DatosCompartidos.limpiarHistorial();
    tablaCarrito.setItems(DatosCompartidos.obtenerHistorial());
}

@FXML
private void handleCatalogo(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Catalogo1.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Catálogo");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    }

  
