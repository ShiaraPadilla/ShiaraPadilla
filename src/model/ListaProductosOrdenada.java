/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisg
 */
public class ListaProductosOrdenada {

    private Nodo<Producto> cabeza;

    public void agregarOrdenado(Producto p) {
        Nodo<Producto> nuevo = new Nodo<>(p);

        if (cabeza == null || p.getNombre().compareToIgnoreCase(cabeza.getDato().getNombre()) < 0) {
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;
        } else {
            Nodo<Producto> actual = cabeza;
            while (actual.getSiguiente() != null && 
                   p.getNombre().compareToIgnoreCase(actual.getSiguiente().getDato().getNombre()) > 0) {
                actual = actual.getSiguiente();
            }
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }
    }

    public Producto buscarPorNombre(String nombre) {
        Nodo<Producto> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
}

    

