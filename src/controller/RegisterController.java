/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import View.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.ListaUsuarios;

public class RegisterController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField ConfirPassword;

    @FXML
    private void handleRegister() {
        String usuario = txtUsuario.getText();
        String contraseña = txtPassword.getText();
        String confirmar = ConfirPassword.getText();

        ListaUsuarios listaUsuarios = LoginController.getListaUsuarios();

        if (usuario.isEmpty() || contraseña.isEmpty() || confirmar.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, completa todos los campos.");
            return;
        }

        if (listaUsuarios.usuarioYaExiste(usuario)) {
            mostrarAlerta("Usuario duplicado", "Este nombre de usuario ya está registrado.");
            return;
        }

        if (!contraseña.equals(confirmar)) {
            mostrarAlerta("Error de contraseña", "Las contraseñas no coinciden.");
            return;
        }

        listaUsuarios.agregarUsuario(usuario, contraseña);
        mostrarAlerta("Éxito", "Usuario registrado correctamente.");

        // Redirige a la pantalla de login
        MainApp.showLogin();
    }

    @FXML
    private void handleGoToLogin() {
        MainApp.showLogin();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}



    

