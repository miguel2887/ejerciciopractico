import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Persona> listaPersonas = new ArrayList<>();
        List<Perro> listaPerrosDisponibles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        listaPerrosDisponibles.add(new Perro("P001", "Roco", "Labrador", 3, "Grande"));
        listaPerrosDisponibles.add(new Perro("P002", "Max", "Bulldog", 5, "Mediano"));
        listaPerrosDisponibles.add(new Perro("P003", "Nala", "Beagle", 2, "Pequeño"));
        listaPerrosDisponibles.add(new Perro("P004", "Bella", "golden retriever", 1, "Grande"));
        listaPerrosDisponibles.add(new Perro("P005", "Luna", "inu", 6, "Mediano"));
        listaPerrosDisponibles.add(new Perro("P006", "Rocky", "Pitbull", 4, "Mediano"));
        listaPerrosDisponibles.add(new Perro("P007", "Daisy", "Bulldog Frances", 3, "Pequeño"));
        listaPerrosDisponibles.add(new Perro("P008", "Milo", "cocker spaniel", 8, "Mediano"));
        listaPerrosDisponibles.add(new Perro("P009", "Coco", "chihuahua", 1, "Pequeño"));
        listaPerrosDisponibles.add(new Perro("P010", "Toby", "Beagle", 1, "Mediano"));
        listaPerrosDisponibles.add(new Perro("P011", "Nina", "Dalmata", 9, "grande"));
        listaPerrosDisponibles.add(new Perro("P012", "Penny", "Yorkshire Terrier", 10, "Pequeño"));

        boolean salir = false;
        while (!salir) {
            // Mostrar el menú
            System.out.println("\nMenú:");
            System.out.println("1. Registrar persona");
            System.out.println("2. Registrar perro");
            System.out.println("3. Ver personas registradas");
            System.out.println("4. Ver perros disponibles");
            System.out.println("5. Adoptar perro");
            System.out.println("6. Consultar perro más viejo adoptado por una persona");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese la edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el documento: ");
                    String documento = scanner.nextLine();
                    listaPersonas.add(new Persona(nombre, apellido, edad, documento));
                    System.out.println("Persona registrada con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese la placa del perro: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese el nombre del perro: ");
                    String nombrePerro = scanner.nextLine();
                    System.out.print("Ingrese la raza del perro: ");
                    String raza = scanner.nextLine();
                    System.out.print("Ingrese la edad del perro: ");
                    int edadPerro = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese el tamaño del perro: ");
                    String tamaño = scanner.nextLine();
                    listaPerrosDisponibles.add(new Perro(placa, nombrePerro, raza, edadPerro, tamaño));
                    System.out.println("Perro registrado con éxito.");
                    break;

                case 3:
                    if (listaPersonas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        System.out.println("Personas registradas:");
                        for (Persona p : listaPersonas) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    if (listaPerrosDisponibles.isEmpty()) {
                        System.out.println("No hay perros disponibles.");
                    } else {
                        System.out.println("Perros disponibles:");
                        for (Perro p : listaPerrosDisponibles) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el documento de la persona que adopta: ");
                    String docPersona = scanner.nextLine();
                    Persona persona = null;
                    for (Persona p : listaPersonas) {
                        if (p.getDocumento().equals(docPersona)) {
                            persona = p;
                            break;
                        }
                    }
                    if (persona == null) {
                        System.out.println("Persona no encontrada.");
                    } else {
                        System.out.print("Ingrese la placa del perro que desea adoptar: ");
                        String placaPerro = scanner.nextLine();
                        Perro perro = null;
                        for (Perro p : listaPerrosDisponibles) {
                            if (p.getPlaca().equals(placaPerro)) {
                                perro = p;
                                break;
                            }
                        }
                        if (perro == null) {
                            System.out.println("Perro no encontrado.");
                        } else {
                            if (persona.adoptarPerro(perro)) {
                                listaPerrosDisponibles.remove(perro); // El perro ya no está disponible
                                System.out.println("Perro adoptado con éxito.");
                            } else {
                                System.out.println("No se pudo adoptar el perro (máximo 3 perros o ya está adoptado).");
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el documento de la persona: ");
                    String docConsulta = scanner.nextLine();
                    Persona personaConsulta = null;
                    for (Persona p : listaPersonas) {
                        if (p.getDocumento().equals(docConsulta)) {
                            personaConsulta = p;
                            break;
                        }
                    }
                    if (personaConsulta == null) {
                        System.out.println("Persona no encontrada.");
                    } else {
                        Perro perroMasViejo = personaConsulta.perroMasGrande();
                        if (perroMasViejo != null) {
                            System.out.println("El perro más viejo adoptado por " + personaConsulta.getNombre() + " es: " + perroMasViejo.getNombre() + " con " + perroMasViejo.getEdad() + " años.");
                        } else {
                            System.out.println("Esta persona no ha adoptado ningún perro.");
                        }
                    }
                    break;

                case 7:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida, por favor elija una opción válida.");
                    break;
            }
        }

        scanner.close();
    }
}
