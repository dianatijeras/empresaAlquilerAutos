package co.edu.uniquindio.poo.empresaalquilerautos.model;

public class Reserva {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private int dias;

    /**
     * Constructor de la clase Reserva
     * @param cliente
     * @param vehiculo
     * @param dias
     */
    public Reserva(Cliente cliente, Vehiculo vehiculo, int dias) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.dias = dias;

        assert dias > 0 : "los dias deben ser mayores a 0";
    }

    /**
     * Get Cliente
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Set Cliente
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Get Vehiculo
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Set Vehiculo
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Get de dias
     * @return
     */
    public int getDias() {
        return dias;
    }

    /**
     * Set de Dias
     * @param dias
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    /**
     * Metodo que obtiene el costo de una reserva de un vehiculo segun el numero de dias de alquiler
     * @return
     */
    public double calcularCosto(){
        return vehiculo.calcularCostoReserva(dias);
    }

}
