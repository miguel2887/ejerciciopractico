import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String documento;
    private List<Perro> perrosAdoptados;

    public Persona(String nom, String ape, int ed, String doc) {
        nombre = nom;
        apellido = ape;
        edad = ed;
        documento = doc;
        perrosAdoptados = new ArrayList<>();
    }

    public boolean adoptarPerro(Perro perro) {
        if (perrosAdoptados.size() >= 3) {
            return false;
        }
        if (perro.isAdoptado()) {
            return false;
        }
        perro.setAdoptado(true);
        return perrosAdoptados.add(perro);
    }


    public Perro perroMasGrande() {
        if (perrosAdoptados.isEmpty()) {
            return null;
        }

        Perro mayor = perrosAdoptados.get(0);
        for (Perro p : perrosAdoptados) {
            if (p.getEdad() > mayor.getEdad()) {
                mayor = p;
            }
        }
        return mayor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDocumento() {
        return documento;
    }

    public List<Perro> getPerrosAdoptados() {
        return perrosAdoptados;
    }

    @Override
    public String toString() {
        String info = "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", documento='" + documento + '\'' +
                ", perrosAdoptados=[";

        for (Perro p : perrosAdoptados) {
            info += "\n  " + p.toString();
        }

        info += "\n]}";
        return info;
    }
}

