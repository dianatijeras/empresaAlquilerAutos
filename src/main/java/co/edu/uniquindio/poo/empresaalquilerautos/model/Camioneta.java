package co.edu.uniquindio.poo.empresaalquilerautos.model;

public class Camioneta extends Vehiculo{
    private double capacidadToneladas;
    private static final double TARIFA_CAMIONETA = 250000.0;
    private static final double PORCENTAJE_EXTRA_TONELADA = 0.1;

    /**
     * Constructor de la clase Camioneta
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     * @param capacidadToneladas
     */
    public Camioneta(String matricula, String marca, String modelo, int anioFabricacion, double capacidadToneladas) {
        super(matricula, marca, modelo, anioFabricacion);
        this.capacidadToneladas = capacidadToneladas;
    }

    /**
     * Get de capacidad toneladas
     * @return
     */
    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    /**
     * Set de capacidad toneladas
     * @param capacidadToneladas
     */
    public void setCapacidadToneladas(double capacidadToneladas) {
        this.capacidadToneladas = capacidadToneladas;

        assert capacidadToneladas != 0: "la capacidad toneladas no puede ser 0";
    }

    @Override
    /**
     * Metodo que calcula el costo de reserva de una camioneta teniendo en cuenta las toneladas
     */
    public double calcularCostoReserva(int dias) {
        double tarifaConExtra = TARIFA_CAMIONETA + (TARIFA_CAMIONETA * PORCENTAJE_EXTRA_TONELADA * capacidadToneladas);
        return tarifaConExtra * dias;
    }
}
