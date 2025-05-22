/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
    

import java.util.ArrayList;
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
import model.PilaCarrito;
import model.Producto;
import model.Sesion;

import java.util.Collections;
import java.util.List;

public class MeGustaController {

    @FXML private TableView<Producto> tablaFavoritos;
    @FXML private TableColumn<Producto, String> colNombreFav;
    @FXML private TableColumn<Producto, Double> colPrecioFav;
    @FXML private TableColumn<Producto, Void> colAccionFav;

    @FXML private Button btnEliminarFav;
    @FXML private Button btnVolverFav;

    private final ObservableList<Producto> favoritosProductos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colNombreFav.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecioFav.setCellValueFactory(new PropertyValueFactory<>("precio"));

        // colAccionFav puede ser configurada si quieres agregar botones en cada fila

        favoritosProductos.addAll(Sesion.getFavoritos().obtenerProductos());
        tablaFavoritos.setItems(favoritosProductos);

        btnEliminarFav.disableProperty().bind(tablaFavoritos.getSelectionModel().selectedItemProperty().isNull());
    }
    private void sincronizarPilaConTabla() {
        PilaCarrito nueva = new PilaCarrito();
        List<Producto> copia = favoritosProductos;
        Collections.reverse(copia);
        for (Producto p : copia) {
            nueva.push(p);
        }
        Collections.reverse(copia);
        Sesion.reemplazarFavoritos(nueva);
    }
    
    @FXML
private void handleEliminarFavorito(ActionEvent event) {
    Producto seleccionado = tablaFavoritos.getSelectionModel().getSelectedItem();

    if (seleccionado != null) {
        favoritosProductos.remove(seleccionado);
        PilaCarrito nuevaPila = new PilaCarrito();
        List<Producto> copia = new ArrayList<>(favoritosProductos);
        Collections.reverse(copia);
        for (Producto p : copia) {
            nuevaPila.push(p);
        }
        Sesion.reemplazarFavoritos(nuevaPila);
    } else {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setHeaderText(null);
        alerta.setContentText("Selecciona un producto para eliminar.");
        alerta.showAndWait();
    }
}
    @FXML
private void handleVolverCatalogo(ActionEvent event) {
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

}
