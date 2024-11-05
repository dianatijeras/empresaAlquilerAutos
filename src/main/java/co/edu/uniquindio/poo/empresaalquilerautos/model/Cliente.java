package co.edu.uniquindio.poo.empresaalquilerautos.model;

public class Cliente extends Persona{
    private String telefono;

    /**
     * Constructor de la clase Cliente
     * @param nombre
     * @param apellidos
     * @param correo
     * @param id
     * @param telefono
     */
    public Cliente(String nombre, String apellidos, String correo, String id, String telefono) {
        super(nombre, apellidos, correo, id);
        this.telefono = telefono;

        assert telefono != null : "el telefono no puede ser null";
    }

    /**
     * Get de telefono
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Set de telefono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
