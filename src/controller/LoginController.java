/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.ListaUsuarios;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button ButtonLogin;

    @FXML
    private void handleLogin(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String contrasena = txtPassword.getText();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor ingresa usuario y contraseña.");
            return;
        }

        if (listaUsuarios.validarUsuario(usuario, contrasena)) {
            mostrarAlerta("Login exitoso", "¡Bienvenido, " + usuario + "!");
            MainApp.showCatalogo1();
            // Aquí puedes cargar el catálogo o pantalla principal
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrectos.");
        }
    }

    @FXML
    private void handleGoToRegister(ActionEvent event) {
        MainApp.showRegister(); 
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

   
    private static ListaUsuarios listaUsuarios = new ListaUsuarios();
    public static ListaUsuarios getListaUsuarios() {
        return listaUsuarios;
    }
}

