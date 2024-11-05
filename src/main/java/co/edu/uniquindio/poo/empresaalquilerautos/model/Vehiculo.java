package co.edu.uniquindio.poo.empresaalquilerautos.model;

public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int anioFabricacion;

    /**
     * Constructor de la clase Vehiculo
     *
     * @param matricula
     * @param marca
     * @param modelo
     * @param anioFabricacion
     */
    public Vehiculo(String matricula, String marca, String modelo, int anioFabricacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;

        assert matricula != null : "la matricula no puede ser null";
        assert marca != null : "la marca no puede ser null";
        assert modelo != null : "el modelo no puede ser null";
        assert anioFabricacion != 0 : "el anio no puede ser 0";
    }

    /**
     * Get de matricula
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Set de matricula
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Get de marca
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Set de marca
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Get de modelo
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Set de modelo
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Get de anio de fabricacion
     * @return
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Set de anio de fabricacion
     * @param anioFabricacion
     */
    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }


    /**
     * Metodo abstracto que implementaran las clases hijas para calcular el costo total de reserva
     * @param dias
     * @return
     */
    public abstract double calcularCostoReserva(int dias);

}
