package co.edu.uniquindio.poo.empresaalquilerautos.viewController;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class InicioViewController {

    @FXML
    private Pane pn_seleccion;

    @FXML
    private Button btn_registrarBuscarVehiculo;

    @FXML
    private Button btn_registrarBuscarCliente;

    @FXML
    private Button btn_realizarReserva;

    @FXML
    private Button btn_reservasRealizadas;

    @FXML
    void onClickRegistrarVehiculo(ActionEvent event) throws IOException {
        registrarBuscarVehiculo();
    }

    @FXML
    void onClickRegistrarCliente(ActionEvent event) throws IOException {
        registrarBuscarCliente();
    }

    @FXML
    void onClickRealizarReserva(ActionEvent event) throws IOException {
        realizarReserva();
    }

    @FXML
    void onClickListadoReservas(ActionEvent event) throws IOException {
        listarReservas();
    }

    @FXML
    public void initialize() {

    }

    public void registrarBuscarVehiculo() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuVehiculo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_realizarReserva.getScene().getWindow();
        stag2.close();
        stage.show();
    }

    public void registrarBuscarCliente() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuCliente.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_realizarReserva.getScene().getWindow();
        stag2.close();
        stage.show();
    }

    public void realizarReserva() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuReserva.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_realizarReserva.getScene().getWindow();
        stag2.close();
        stage.show();
    }

    public void listarReservas() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuReservasRealizadas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_realizarReserva.getScene().getWindow();
        stag2.close();
        stage.show();
    }

}


