/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisg
 */

public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    void setAnterior(Nodo frente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Producto getProducto() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    Object getAnterior() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
