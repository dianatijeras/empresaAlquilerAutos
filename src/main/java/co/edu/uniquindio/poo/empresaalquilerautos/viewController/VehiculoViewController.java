package co.edu.uniquindio.poo.empresaalquilerautos.viewController;

import co.edu.uniquindio.poo.empresaalquilerautos.App;
import co.edu.uniquindio.poo.empresaalquilerautos.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VehiculoViewController {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    @FXML
    private ComboBox<String> cb_tipoDeVehiculo;

    @FXML
    private TextField txt_espacioModelo;

    @FXML
    private TextField txt_espacioMarca;

    @FXML
    private Label lbl_marca;

    @FXML
    private Separator sp_separacionRegistros;

    @FXML
    private Button btn_BuscarVehiculo;

    @FXML
    private Separator sp_separacionTipoCamioneta;

    @FXML
    private Label lbl_tipoCaroNumPuertas;

    @FXML
    private Label lbl_CamionetaCapCarga;

    @FXML
    private Label lbl_tipoVehiculo;

    @FXML
    private Button btn_registrarVehiculo;

    @FXML
    private Label lbl_tituloAuto;

    @FXML
    private Label lbl_tituloCamioneta;

    @FXML
    private CheckBox Cbx_MotoEsAutomatica;

    @FXML
    private Pane pn_registroVehiculo;

    @FXML
    private Separator sp_separacionTipoVehiculo;

    @FXML
    private TextField txt_numPuertas;

    @FXML
    private Label lbl_modelo;

    @FXML
    private Separator sp_separacionTipoAuto;

    @FXML
    private Label lbl_Vehiculo;

    @FXML
    private Label lbl_tituloMoto;

    @FXML
    private TextField txt_espacioMatricula;

    @FXML
    private Label lbl_MotoEsAutomatica;

    @FXML
    private Separator sp_separacionTipoMoto;

    @FXML
    private Label lbl_anioFabricacion;

    @FXML
    private TextField txt_espacioAnioFabricacion;

    @FXML
    private Separator sp_separacionRegistrarVehiculo;

    @FXML
    private Button btn_volverMenuPrincipal;

    @FXML
    private TextField txt_capacidadCarga;

    @FXML
    private Label lbl_matricula;

    @FXML
    void onClickRegistrarVehiculo(ActionEvent event) throws IOException {
            registrarVehiculo();
    }

    @FXML
    void onClickVolverInicio(ActionEvent event) throws IOException {
            volver();
    }

    @FXML
    void onClickBuscarVehiculo(ActionEvent event) {
            buscarVehiculo();
    }

    @FXML
    private Label lbl_resultadoBusqueda;

    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Carro", "Camioneta", "Moto");
        cb_tipoDeVehiculo.setItems(list);

        // Ocultar el campo de entrada de la moto
        Cbx_MotoEsAutomatica.setVisible(false);

        cb_tipoDeVehiculo.setOnAction(event -> {
            String tipoSeleccionado = cb_tipoDeVehiculo.getValue();
            Cbx_MotoEsAutomatica.setVisible("Moto".equals(tipoSeleccionado));
            txt_numPuertas.setVisible("Carro".equals(tipoSeleccionado));
            lbl_tipoCaroNumPuertas.setVisible("Carro".equals(tipoSeleccionado));
            txt_capacidadCarga.setVisible("Camioneta".equals(tipoSeleccionado));
            lbl_CamionetaCapCarga.setVisible("Camioneta".equals(tipoSeleccionado));
        });
    }

    @FXML
    public void registrarVehiculo() {
        String matricula = txt_espacioMatricula.getText().trim();
        String marca = txt_espacioMarca.getText().trim();
        String modelo = txt_espacioModelo.getText().trim();
        int anioFabricacion;

        try {
            anioFabricacion = Integer.parseInt(txt_espacioAnioFabricacion.getText().trim());
        } catch (NumberFormatException e) {
            System.out.println("El año de fabricación debe ser un número válido.");
            return;
        }

        String tipoVehiculo = cb_tipoDeVehiculo.getValue();
        Vehiculo vehiculo = null;

        switch (tipoVehiculo) {
            case "Carro":
                int numPuertas;
                try {
                    numPuertas = Integer.parseInt(txt_numPuertas.getText().trim());
                    vehiculo = new Auto(matricula, marca, modelo, anioFabricacion, numPuertas);
                } catch (NumberFormatException e) {
                    System.out.println("El número de puertas debe ser un número válido.");
                    return;
                }
                break;

            case "Camioneta":
                double capacidadCarga;
                try {
                    capacidadCarga = Double.parseDouble(txt_capacidadCarga.getText().trim());
                    vehiculo = new Camioneta(matricula, marca, modelo, anioFabricacion, capacidadCarga);
                } catch (NumberFormatException e) {
                    System.out.println("La capacidad de carga debe ser un número válido.");
                    return;
                }
                break;

            case "Moto":
                boolean esAutomatica = Cbx_MotoEsAutomatica.isSelected();
                vehiculo = new Moto(matricula, marca, modelo, anioFabricacion, esAutomatica);
                break;

            default:
                System.out.println("Selecciona un tipo de vehículo válido.");
                return;
        }

        // Aquí se agrega el vehículo a una lista o realizar más acciones
        System.out.println("Vehículo registrado: " + vehiculo.getMarca() + " " + vehiculo.getModelo());
    }

    private void buscarVehiculo() {
        String matricula = lbl_matricula.getText().trim();

        Vehiculo vehiculoEncontrado = null;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculoEncontrado = vehiculo;
                break;
            }
        }

        if (vehiculoEncontrado != null) {
            // Muestra los detalles del cliente encontrado en la interfaz
            lbl_resultadoBusqueda.setText("Vehiculo encontrado: " + vehiculoEncontrado.getMatricula());
        } else {
            lbl_resultadoBusqueda.setText("Vehiculo no encontrado con Matricula: " + matricula);
        }
    }


    /**
     * Metodo para volver al menu principal con el boton
     */
    @FXML
    private void volver() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menuInicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        Stage stage = new Stage();
        stage.setTitle("MenuVehiculo!");
        stage.setScene(scene);
        Stage stag2 = (Stage) btn_volverMenuPrincipal.getScene().getWindow();
        stag2.close();
        stage.show();
    }
}
