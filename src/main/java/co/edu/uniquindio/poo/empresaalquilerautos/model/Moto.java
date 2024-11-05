package co.edu.uniquindio.poo.empresaalquilerautos.model;

public class Moto extends Vehiculo{
    private boolean esAutomatica;
    private static final double TARIFA_MOTO = 150000.0;
    private static final double TARIFA_EXTRA_MOTO_MANUAL = 10000.0;

    /**
     * Constructor de la clase Moto
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param esAutomatica
     */
    public Moto(String matricula, String marca, String modelo, int anioFabricacion, boolean esAutomatica) {
        super(matricula, marca, modelo, anioFabricacion);
        this.esAutomatica = esAutomatica;

    }

    /**
     * Get esAutomatica
     * @return
     */
    public boolean isEsAutomatica() {
        return esAutomatica;
    }

    /**
     * Set esAutomatica
     * @param esAutomatica
     */
    public void setEsAutomatica(boolean esAutomatica) {
        this.esAutomatica = esAutomatica;
    }

    @Override
    /**
     * Metodo que calcula el costo de reserva de una moto ya sea manual o no
     */
    public double calcularCostoReserva(int dias) {
        double costoReservaMoto = (TARIFA_MOTO+ (esAutomatica ? TARIFA_EXTRA_MOTO_MANUAL : 0)) * dias;
        return costoReservaMoto;
    }
}
