package co.edu.uniquindio.poo.empresaalquilerautos.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Empresa {
    private String nombre;
    private String direccion;
    private Collection<Cliente> listaClientes;
    private Collection<Vehiculo> listaVehiculos;
    private Collection<Reserva> listaReservas;
    private static Empresa instancia;

    /**
     * Constructor de la clase principal Empresa
     * @param nombre
     * @param direccion
     */
    private Empresa(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaClientes = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
    }

    private static Empresa empresa;

    /**
     * Get de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set de nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get de direccion
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Set de direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Get de la lista de clientes
     * @return
     */
    public Collection<Cliente> getListaClientes() {
        return listaClientes;
    }

    /**
     * Set de la lista de clientes
     * @param listaClientes
     */
    public void setListaClientes(Collection<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    /**
     * Get de la lista de vehiculos
     * @return
     */
    public Collection<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    /**
     * Set de la lista de vehiculos
     * @param listaVehiculos
     */
    public void setListaVehiculos(Collection<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    /**
     * Get de la lista de reservas
     * @return
     */
    public Collection<Reserva> getListaReservas() {
        return listaReservas;
    }

    /**
     * Set de la lista de reservas
     * @param listaReservas
     */
    public void setListaReservas(Collection<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    /**
     * Metodo que obtiene la instancia de singleton
     * @param nombre
     * @param direccion
     * @return
     */
    public static Empresa getInstance(String nombre, String direccion) {
        if (instancia == null) {
            instancia = new Empresa(nombre, direccion);
        }
        return instancia;
    }

    /**
     * Metodo para agregar un vehiculo a la lista de vehiculos
     * @param vehiculo
     */
    public void agregarVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }

    /**
     * Metodo que busca un vehiculo
     * @param matricula
     */
    public void buscarVehiculo(String matricula){
        for(Vehiculo vehiculo : listaVehiculos){
            if(vehiculo.getMatricula().equals(matricula)){
                System.out.println("Vehiculo encontrado: " + vehiculo);
                return;
            }
        }

        System.out.println("No se encontro el Vehiculo");
    }

    /**
     * Metodo que agregar un cliente a la lista de clientes
     * @param cliente
     */
    public void agregarCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    /**
     * Metodo que busca a un cliente
     * @param id
     */
    public void buscarCliente(String id){
        for(Cliente cliente : listaClientes){
            if(cliente.getId().equals(id)){
                System.out.println("Se encontro al cliente: " + cliente);
                return;
            }
        }

        System.out.println("No se encontro al cliente");
    }

    /**
     * Metodo que agrega una reserva
     * @param reserva
     */
    public void agregarReserva(Reserva reserva){
        listaReservas.add(reserva);
    }

    /**
     * Metodo que busca reservas por cliente
     * @param id
     * @return
     */
    public Collection<Reserva> buscarReservasPorCliente(String id){
        Collection<Reserva> reservasCliente = new ArrayList<>();
        for(Reserva reserva : listaReservas){
            if(reserva.getCliente().getId().equals(id)){
                reservasCliente.add(reserva);
            }
        }

        return reservasCliente;
    }

    /**
     * Metodo para listar todas las reservas
     * @return
     */
    public Collection<Reserva> listarReservas(){
        return new ArrayList<>(listaReservas);
    }

}
