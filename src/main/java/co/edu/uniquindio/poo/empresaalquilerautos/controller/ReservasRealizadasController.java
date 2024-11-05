package co.edu.uniquindio.poo.empresaalquilerautos.controller;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservasRealizadasController {

    @FXML
    private Button btn_volver;

    @FXML
    private TableView<String> tb_reservasRealizadas;

    @FXML
    public void initialize() {
        btn_volver.setOnAction(event -> {
            try {
                volver(event);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

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

