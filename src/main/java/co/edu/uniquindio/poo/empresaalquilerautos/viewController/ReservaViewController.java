package co.edu.uniquindio.poo.empresaalquilerautos.viewController;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Cliente;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Reserva;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservaViewController {

    @FXML
    private Label lbl_realizarReserva;

    @FXML
    private Separator sp_realizarReserva;

    @FXML
    private Button btn_VolverDeRealizarReserva;

    @FXML
    private Pane pn_Reserva;

    @FXML
    private ComboBox<String> cb_seleccionarVehiculo;

    @FXML
    private ComboBox<String> cb_seleccionarCliente;

    @FXML
    private TextField txt_diasReserva;

    @FXML
    private Button btn_realizarReserva;

    @FXML
    private Label lbl_seleccionarVehiculo;

    @FXML
    private Label lbl_diasReserva;

    @FXML
    private Label lbl_seleccionarCliente;

    @FXML
    private Separator sp_camposReserva;

    @FXML
    void OnClickVolverInicio(ActionEvent event) throws IOException {
        volver();
    }

    @FXML
    void OnClickRealizarReserva(ActionEvent event) throws IOException {
        realizarReserva();
    }

    // Listas para almacenar clientes y vehículos
    private List<Cliente> clientes = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();

    @FXML
    public void initialize() {
        btn_realizarReserva.setOnAction(event -> realizarReserva());
    }

    /**
     * Metodo para realizar la reserva
     */
    private void realizarReserva() {
        String vehiculoSeleccionado = cb_seleccionarVehiculo.getValue();
        String clienteSeleccionado = cb_seleccionarCliente.getValue();
        String diasTexto = txt_diasReserva.getText();

        if (vehiculoSeleccionado == null || clienteSeleccionado == null || diasTexto.isEmpty()) {
            System.out.println("Por favor, complete todos los campos para realizar la reserva.");
            return;
        }

        try {
            int dias = Integer.parseInt(diasTexto);
            Cliente cliente = buscarClientePorNombre(clienteSeleccionado);
            Vehiculo vehiculo = buscarVehiculoPorMatricula(vehiculoSeleccionado);

            if (cliente != null && vehiculo != null) {
                Reserva reserva = new Reserva(cliente, vehiculo, dias);
                double costo = reserva.calcularCosto();

                System.out.println("Reserva realizada exitosamente:");
                System.out.println("Vehículo: " + vehiculoSeleccionado);
                System.out.println("Cliente: " + clienteSeleccionado);
                System.out.println("Días de reserva: " + dias);
                System.out.println("Costo total de la reserva: " + costo);
            } else {
                System.out.println("Error: Cliente o vehículo no encontrado.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido para los días de reserva.");
        }
    }

    private Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null; // Cliente no encontrado
    }

    private Vehiculo buscarVehiculoPorMatricula(String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null; // Vehículo no encontrado
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.vehiculos = listaVehiculos;
        ObservableList<String> vehiculoMatriculas = FXCollections.observableArrayList();
        for (Vehiculo vehiculo : listaVehiculos) {
            vehiculoMatriculas.add(vehiculo.getMatricula());
        }
        cb_seleccionarVehiculo.setItems(vehiculoMatriculas);
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.clientes = listaClientes;
        ObservableList<String> clienteNombres = FXCollections.observableArrayList();
        for (Cliente cliente : listaClientes) {
            clienteNombres.add(cliente.getNombre());
        }
        cb_seleccionarCliente.setItems(clienteNombres);
    }

    /**
     * Metodo para volver al menu principal con el boton
     * @param
     */
    @FXML
    private void volver() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuInicio!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_realizarReserva.getScene().getWindow();
        stag2.close();
        stage.show();
    }


}
