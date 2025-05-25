/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import model.CNodo;
/**
 *
 * @author ASUS
 */
public class ColaHistorial {
    private Nodo frente;
    private Nodo fin;

    public void encolar(Producto producto) {
        Nodo nuevo = new Nodo(producto);
        if (frente == null) {
            frente = nuevo;
            fin = nuevo;
            frente.setSiguiente(frente);
            frente.setAnterior(frente);
        } else {
            nuevo.setAnterior(fin);
            nuevo.setSiguiente(frente);
            fin.setSiguiente(nuevo);
            frente.setAnterior(nuevo);
            fin = nuevo;
        }
    }

    public List<Producto> obtenerComoLista() {
        List<Producto> lista = new ArrayList<>();
        if (frente == null) return lista;

        Nodo actual = frente;
        do {
            lista.add(actual.getProducto());
            actual = actual.getSiguiente();
        } while (actual != frente);

        return lista;
    }


    void eliminar(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

   
