package co.edu.uniquindio.poo.empresaalquilerautos.controller;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    @FXML
    private TextField txt_nombre;

    @FXML
    private TextField txt_apellidos;

    @FXML
    private TextField txt_correo;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_telefono;

    @FXML
    private Button btn_registrarCliente;

    @FXML
    private Button btn_volverMenuPrincipal;

    private List<Cliente> clientes = new ArrayList<>();

    @FXML
    public void initialize() {
        btn_registrarCliente.setOnAction(event -> registrarCliente());
        btn_volverMenuPrincipal.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCliente.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 400, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void registrarCliente() {
        String nombre = txt_nombre.getText().trim();
        String apellidos = txt_apellidos.getText().trim();
        String correo = txt_correo.getText().trim();
        String id = txt_id.getText().trim();
        String telefono = txt_telefono.getText().trim();

        if (nombre.isEmpty() || apellidos.isEmpty() || id.isEmpty()) {
            System.out.println("Por favor, complete todos los campos.");
            return;
        }

        Cliente cliente = new Cliente(nombre, apellidos, correo, id, telefono);
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNombre() + " " + cliente.getApellidos());
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuCliente!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_volverMenuPrincipal.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}

