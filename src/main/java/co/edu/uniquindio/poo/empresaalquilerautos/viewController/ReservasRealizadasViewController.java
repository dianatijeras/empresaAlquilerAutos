package co.edu.uniquindio.poo.empresaalquilerautos.viewController;


import co.edu.uniquindio.poo.empresaalquilerautos.App;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Empresa;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Reserva;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;

public class ReservasRealizadasViewController {

    @FXML
    private Pane pn_menuReservasRealizadas;

    @FXML
    private Button btn_VolverReservasRealizadas;

    @FXML
    private Separator sp_separacionReservasRealizadas;

    @FXML
    private Label lbl_ReservasRealizadas;

    @FXML
    private TableColumn<Reserva, String> tbc_Cliente;

    @FXML
    private TableColumn<Reserva, String> tbc_vehiculo;

    @FXML
    private TableView<Reserva> tb_reservasRealizadas;

    @FXML
    private TableColumn<Reserva, String> tbc_diasDeReserva;

    @FXML
    void onClickVolverInicio(ActionEvent event) throws IOException {
            volverMenuPrincipal();
    }

    @FXML
    private TableColumn<Reserva, String> tbc_costoTotal;

    private Empresa empresa;

    @FXML
    public void initialize() {
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
        cargarReservas();
    }

    private void configurarTablaReservas() {
        tbc_Cliente.setCellValueFactory(cellData ->
                new SimpleObjectProperty(cellData.getValue().getCliente().getNombre() + " " + cellData.getValue().getCliente().getApellidos()));
        tbc_vehiculo.setCellValueFactory(cellData ->
                new SimpleObjectProperty(cellData.getValue().getVehiculo().getMatricula()));
        tbc_diasDeReserva.setCellValueFactory(cellData ->
                new SimpleObjectProperty(String.valueOf(cellData.getValue().getDias())));
        tbc_costoTotal.setCellValueFactory(cellData ->
                new SimpleObjectProperty(String.valueOf(cellData.getValue().calcularCosto())));
    }

    private void cargarReservas() {
        ObservableList<Reserva> reservas = FXCollections.observableArrayList(empresa.listarReservas());
        tb_reservasRealizadas.setItems(reservas);
    }
    /**
     * Metodo para volver al menu principal con el boton
     * @param
     */
    @FXML
    private void volverMenuPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_VolverReservasRealizadas.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}
