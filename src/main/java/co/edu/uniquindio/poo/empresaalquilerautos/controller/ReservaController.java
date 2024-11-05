package co.edu.uniquindio.poo.empresaalquilerautos.controller;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Cliente;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Reserva;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Vehiculo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservaController {

    @FXML
    private ComboBox<Cliente> cb_clientes;

    @FXML
    private ComboBox<Vehiculo> cb_vehiculos;

    @FXML
    private TextField txt_dias;

    @FXML
    private Button btn_realizarReserva;

    @FXML
    private Button btn_volverMenuPrincipal;

    @FXML
    public void initialize() {
        btn_realizarReserva.setOnAction(event -> realizarReserva());
        btn_volverMenuPrincipal.setOnAction(event -> {
            try {
                volver(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void realizarReserva() {
        // Obtener el cliente y el vehículo seleccionados directamente como objetos
        Cliente clienteSeleccionado = cb_clientes.getValue();
        Vehiculo vehiculoSeleccionado = cb_vehiculos.getValue();
        int dias;

        // Verificar que el cliente y el vehículo no sean nulos
        if (clienteSeleccionado == null || vehiculoSeleccionado == null) {
            System.out.println("Por favor, seleccione un cliente y un vehículo.");
            return;
        }

        try {
            // Obtener el número de días desde el campo de texto
            dias = Integer.parseInt(txt_dias.getText());

            // Crear la reserva usando los objetos seleccionados
            Reserva reserva = new Reserva(clienteSeleccionado, vehiculoSeleccionado, dias);
            System.out.println("Reserva realizada para: " + clienteSeleccionado.getNombre() + " con el vehículo: " + vehiculoSeleccionado.getMatricula());

        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido para los días.");
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_volverMenuPrincipal.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}

