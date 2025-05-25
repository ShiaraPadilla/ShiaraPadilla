/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    private ObservableList<Producto> historialCompras;

    @FXML
    public void initialize() {
      
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

      
        historialCompras = DatosCompartidos.getHistorialCompras();
        tablaCarrito.setItems(historialCompras);
    }
    @FXML
private void handleEliminarHistorial(ActionEvent event) {
    Producto seleccionado = tablaCarrito.getSelectionModel().getSelectedItem();

    if (seleccionado != null) {
        historialCompras.remove(seleccionado);
    } else {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText("Selecciona un producto para eliminar del historial.");
        alerta.showAndWait();
    }
}
    @FXML
    private void handleCatalogo(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/Catalogo1.fxml"));
            Stage stage = (Stage) btnVolver.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

  
