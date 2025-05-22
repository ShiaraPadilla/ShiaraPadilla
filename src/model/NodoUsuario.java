/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisg
 */
public class NodoUsuario {
    public Usuario usuario;
    public NodoUsuario siguiente;

    public NodoUsuario(Usuario usuario, NodoUsuario siguiente) {
        this.usuario = usuario;
        this.siguiente = null;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public NodoUsuario getSiguiente(){
        return siguiente;
    }
    public void setSiguiente(NodoUsuario siguiente){
        this.siguiente = siguiente;
    }
}
