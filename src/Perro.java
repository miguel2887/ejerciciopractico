public class Perro {
    private String placa;
    private String nombre;
    private String raza;
    private int edad;
    private String tamaño;
    private boolean adoptado;

    // Constructor
    public Perro(String placaPerro, String nombrePerro, String razaPerro, int edadPerro, String tamañoPerro) {
        placa = placaPerro;
        nombre = nombrePerro;
        raza = razaPerro;
        edad = edadPerro;
        tamaño = tamañoPerro;
        adoptado = false;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String p) {
        placa = p;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String r) {
        raza = r;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int e) {
        edad = e;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String t) {
        tamaño = t;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean estado) {
        adoptado = estado;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "placa='" + placa + '\'' +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", edad=" + edad +
                ", tamaño='" + tamaño + '\'' +
                ", adoptado=" + adoptado +
                '}';
    }
}
