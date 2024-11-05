package co.edu.uniquindio.poo.empresaalquilerautos.viewController;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import co.edu.uniquindio.poo.empresaalquilerautos.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteViewController {
    private List<Cliente> clientes = new ArrayList<>(); // Lista para almacenar clientes

    @FXML
    private TextField txt_correoCliente;

    @FXML
    private Separator sp_separacionCamposRegistro;

    @FXML
    private Label lbl_apellidosCliente;

    @FXML
    private TextField txt_telefonoCliente;

    @FXML
    private Button btn_volver;

    @FXML
    private Label lbl_telefonoCliente;

    @FXML
    private Button btn_registrarCliente;

    @FXML
    private Button btn_BuscarCliente;

    @FXML
    private Label lbl_nombreCliente;

    @FXML
    private TextField txt_cedulaCliente;

    @FXML
    private TextField txt_nombreCliente;

    @FXML
    private Label lbl_cedulaCliente;

    @FXML
    private Label lbl_correoCliente;

    @FXML
    private Pane pn_registroCliente;

    @FXML
    private Label lbl_Cliente;

    @FXML
    private TextField txt_apellidosCliente;

    @FXML
    void onClickRegistrarCliente(ActionEvent event) throws IOException {
        registrarCliente();
    }

    @FXML
    void onClickVolver(ActionEvent event)  throws IOException {
        volver();
    }

    @FXML
    void onClickBuscar(ActionEvent event)  throws IOException {
        buscarCliente();
    }

    @FXML
    private Separator sp_separacionRegistroCliente;

    @FXML
    private Label lbl_resultadoBusqueda;

    @FXML
    /**
     * Metodo que registra un cliente
     */
    public void registrarCliente() {
        String nombre = txt_nombreCliente.getText().trim();
        String apellidos = txt_apellidosCliente.getText().trim();
        String correo = txt_correoCliente.getText().trim();
        String id = txt_cedulaCliente.getText().trim();
        String telefono = txt_telefonoCliente.getText().trim();

        // Validación de entrada
        if (nombre.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || id.isEmpty() || telefono.isEmpty()) {
            System.out.println("Todos los campos deben ser completados.");
            return;
        }

        // Crear el cliente
        Cliente cliente = new Cliente(nombre, apellidos, correo, id, telefono);
        clientes.add(cliente); // Agregar el cliente a la lista

        System.out.println("Cliente registrado: " + cliente.getNombre() + " " + cliente.getApellidos());
    }

    @FXML
    /**
     * Metodo que busca un cliente por ID
     */
    private void buscarCliente() {
        String id = txt_cedulaCliente.getText().trim();

        Cliente clienteEncontrado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado != null) {
            // Muestra los detalles del cliente encontrado en la interfaz
            lbl_resultadoBusqueda.setText("Cliente encontrado: " + clienteEncontrado.getNombre() + " " + clienteEncontrado.getApellidos() +
                    "\nCorreo: " + clienteEncontrado.getCorreo() +
                    "\nTeléfono: " + clienteEncontrado.getTelefono());
        } else {
            lbl_resultadoBusqueda.setText("Cliente no encontrado con ID: " + id);
        }
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
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_registrarCliente.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}
