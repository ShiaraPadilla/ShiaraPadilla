/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatosCompartidos {
    private static ObservableList<Producto> historialCompras = FXCollections.observableArrayList();

    public static void agregarAlHistorial(Producto producto) {
        historialCompras.add(producto);
    }

    public static ObservableList<Producto> obtenerHistorial() {
        return historialCompras;
    }

    public static void limpiarHistorial() {
        historialCompras.clear();
    }
}