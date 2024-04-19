public class Asistente {
    private String nombre;
    private String email;

    // Constructor que inicializa el nombre y el email del asistente
    public Asistente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Getter para el email
    public String getEmail() {
        return email;
    }
}
