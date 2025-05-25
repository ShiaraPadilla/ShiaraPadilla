/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.PilaCarrito;
import model.Producto;
import model.Sesion;

import javafx.scene.control.Alert;

import model.Sesion;

import javafx.scene.control.Alert;

public class CarritoController {

    @FXML private TableView<Producto> tablaCarrito;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private Button btnEliminar;
    @FXML private Button btnVolver;
    @FXML private Button btnComprar;

    private final ObservableList<Producto> carritoProductos = FXCollections.observableArrayList();
    
    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        carritoProductos.addAll(Sesion.getCarrito().obtenerProductos());
        tablaCarrito.setItems(carritoProductos);

        tablaCarrito.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        btnEliminar.disableProperty().bind(tablaCarrito.getSelectionModel().selectedItemProperty().isNull());
    }

    @FXML
    private void handleEliminarDelCarrito(ActionEvent event) {
        Producto seleccionado = tablaCarrito.getSelectionModel().getSelectedItem();

        if (seleccionado != null) {
            carritoProductos.remove(seleccionado);
            sincronizarPilaConTabla();
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Advertencia");
            alerta.setHeaderText(null);
            alerta.setContentText("Selecciona un producto para eliminar del carrito.");
            alerta.showAndWait();
        }
    }

    private void sincronizarPilaConTabla() {
        PilaCarrito nueva = new PilaCarrito();
        List<Producto> copia = new ArrayList<>(carritoProductos);
        Collections.reverse(copia);
        for (Producto p : copia)  nueva.push(p);
        Sesion.reemplazarCarrito(nueva);
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
            new Alert(Alert.AlertType.ERROR, "No se pudo cargar la vista del catálogo.").showAndWait();
        }
    }

    @FXML
    private void handleComprarSeleccion(ActionEvent event) {
        ObservableList<Producto> seleccionados = tablaCarrito.getSelectionModel().getSelectedItems();

        if (seleccionados == null || seleccionados.isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "No has seleccionado ningún producto para comprar.").showAndWait();
            return;
        }

        seleccionados.forEach(Sesion::agregarAlHistorial);

        carritoProductos.removeAll(seleccionados);
        sincronizarPilaConTabla();

        new Alert(Alert.AlertType.INFORMATION, "Compra realizada exitosamente.").showAndWait();
    }
}

