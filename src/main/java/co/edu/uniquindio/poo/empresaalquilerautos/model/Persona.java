package co.edu.uniquindio.poo.empresaalquilerautos.model;

public class Persona {
    private String nombre;
    private String apellidos;
    private String correo;
    private String id;

    /**
     * Contructor de la clase Persona
     * @param nombre
     * @param apellidos
     * @param correo
     * @param id
     */
    public Persona(String nombre, String apellidos, String correo, String id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.id = id;

        assert nombre != null : "el nombre no puede ser null";
        assert apellidos != null : "los apellidos no pueden ser null";
        assert correo != null : "el correo no puede ser null";
        assert id != null: "el id no puede ser null";
    }

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
     * Get de apellidos
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Set de apellidos
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Get de correo
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Set de correo
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Get de ID
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Set de ID
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
