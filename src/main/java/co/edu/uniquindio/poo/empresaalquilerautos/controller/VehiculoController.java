package co.edu.uniquindio.poo.empresaalquilerautos.controller;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
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

public class VehiculoController {

    @FXML
    private TextField txt_matricula;

    @FXML
    private TextField txt_marca;

    @FXML
    private TextField txt_modelo;

    @FXML
    private TextField txt_anioFabricacion;

    @FXML
    private Button btn_registrarVehiculo;

    @FXML
    private Button btn_volver;

    @FXML
    public void initialize() {
        btn_registrarVehiculo.setOnAction(event -> registrarVehiculo());
        btn_volver.setOnAction(event -> {
            try {
                volver(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void registrarVehiculo() {
        String matricula = txt_matricula.getText();
        String marca = txt_marca.getText();
        String modelo = txt_modelo.getText();
        int anioFabricacion;

        try {
            anioFabricacion = Integer.parseInt(txt_anioFabricacion.getText());
            Vehiculo vehiculo = new Vehiculo(matricula, marca, modelo, anioFabricacion) {

                @Override
                public double calcularCostoReserva(int dias) {
                    return 0;
                }
            };
            System.out.println("Vehículo registrado: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
        } catch (NumberFormatException e) {
            System.out.println("Año de fabricación no válido.");
        }
    }

    @FXML
    private void volver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_volver.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}

