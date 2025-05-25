/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class CNodo {
    private Producto producto;
    private CNodo siguiente;
    private CNodo anterior;

    public CNodo(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public CNodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(CNodo siguiente) {
        this.siguiente = siguiente;
    }

    public CNodo getAnterior() {
        return anterior;
    }

    public void setAnterior(CNodo anterior) {
        this.anterior = anterior;
    }
    
}
