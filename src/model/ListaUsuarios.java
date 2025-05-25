/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class ListaUsuarios {
    private NodoUsuario cabeza;

   
    public void agregarUsuario(String usuario, String contraseña) {
        Usuario nuevo = new Usuario(usuario, contraseña);
        NodoUsuario nodo = new NodoUsuario(nuevo, null); 

        if (cabeza == null) {
            cabeza = nodo;
        } else {
            NodoUsuario actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nodo);
        }
    }

    public boolean validarUsuario(String usuario, String contraseña) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.getUsuario().getUsuario().equals(usuario) &&
                actual.getUsuario().getContraseña().equals(contraseña)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean usuarioYaExiste(String usuario) {
        NodoUsuario actual = cabeza;
        while (actual != null) {
            if (actual.getUsuario().getUsuario().equals(usuario)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}

    
