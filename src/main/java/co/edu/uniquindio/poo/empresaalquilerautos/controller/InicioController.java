package co.edu.uniquindio.poo.empresaalquilerautos.controller;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioController {

    @FXML
    private Button btn_irRegistrarCliente;

    @FXML
    private Button btn_irRegistrarVehiculo;

    @FXML
    private Button btn_irRealizarReserva;

    @FXML
    private Button btn_irReservasRealizadas;

    @FXML
    public void initialize() {
        btn_irRegistrarCliente.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 400, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btn_irRegistrarVehiculo.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 400, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btn_irRealizarReserva.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 400, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        btn_irReservasRealizadas.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 400, 600);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void irRegistrarCliente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_irRegistrarCliente.getScene().getWindow();
        stag2.close();
        stage.show();
    }

    private void irRegistrarVehiculo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_irRegistrarVehiculo.getScene().getWindow();
        stag2.close();
        stage.show();
    }

    private void irRealizarReserva() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_irRealizarReserva.getScene().getWindow();
        stag2.close();
        stage.show();
    }

    private void irReservasRealizadas() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_irReservasRealizadas.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}

