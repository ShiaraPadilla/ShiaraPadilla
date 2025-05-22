/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisg
 */
public class NodoProducto {
   
    public Producto producto;
    public NodoProducto siguiente;

    public NodoProducto(Producto producto) {
        this.producto = producto;
    }
}


