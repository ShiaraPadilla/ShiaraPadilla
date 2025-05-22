/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luisg
 */

public class PilaCarrito {
    private Nodo<Producto> cima;

    public void push(Producto p) {
        Nodo<Producto> nuevo = new Nodo<>(p);
        nuevo.setSiguiente(cima);
        cima = nuevo;
    }

    public Producto pop() {
        if (cima == null) return null;
        Producto p = cima.getDato();
        cima = cima.getSiguiente();
        return p;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public double total() {
        double suma = 0;
        Nodo<Producto> actual = cima;
        while (actual != null) {
            suma += actual.getDato().getPrecio();
            actual = actual.getSiguiente();
        }
        return suma;
    }

    public String resumen() {
        StringBuilder sb = new StringBuilder();
        Nodo<Producto> actual = cima;
        while (actual != null) {
            sb.append(actual.getDato().getNombre()).append(" - $").append(actual.getDato().getPrecio()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
    public List<Producto> obtenerProductos() {
    List<Producto> productos = new ArrayList<>();
    Nodo<Producto> actual = cima;
    while (actual != null) {
        productos.add(actual.getDato());
        actual = actual.getSiguiente();
    }
    return productos;
}

}


