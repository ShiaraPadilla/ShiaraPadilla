/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Luisg
 */
public class Sesion {
   
    private static PilaCarrito carrito = new PilaCarrito();
    private static PilaCarrito favoritos = new PilaCarrito();
    private static PilaCarrito historial = new PilaCarrito();
    
    public static void agregarAlCarrito(Producto producto) {
        carrito.push(producto);
    }

    public static PilaCarrito getCarrito() {
        return carrito;
    }

    public static void agregarAFavoritos(Producto producto) {
        favoritos.push(producto);
    }

    public static PilaCarrito getFavoritos() {
        return favoritos;
    }
    public static void reemplazarFavoritos(PilaCarrito nuevoFavoritos) {
        favoritos = nuevoFavoritos;
    }
    public static void reemplazarCarrito(PilaCarrito nuevoCarrito) {
        carrito = nuevoCarrito;
    }
    public static void agregarAlHistorial(Producto producto) {
        historial.push(producto);
    }
    public static PilaCarrito getHistorial() {
        return historial;
    } 
}
    

