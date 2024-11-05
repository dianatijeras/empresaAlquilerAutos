package co.edu.uniquindio.poo.empresaalquilerautos.model;

public class Auto extends Vehiculo{
    private int numPuertas;
    private static final double TARIFA_AUTO = 200000.0;

    /**
     * Constructor de la clase Auto
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param numPuertas
     */
    public Auto(String matricula, String marca, String modelo, int anioFabricacion, int numPuertas) {
        super(matricula, marca, modelo, anioFabricacion);
        this.numPuertas = numPuertas;

        assert numPuertas != 0 : "el numero de puertas no puede ser 0";
    }

    /**
     * Get de numero de puertas
     * @return
     */
    public int getNumPuertas() {
        return numPuertas;
    }

    /**
     * Set de numero de puertas
     * @param numPuertas
     */
    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    /**
     * Metodo que calcula el costo de reserva para autos
     */
    public double calcularCostoReserva(int dias) {
        return TARIFA_AUTO * dias;
    }
}
