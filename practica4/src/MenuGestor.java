import java.util.ArrayList;
import java.util.Scanner;

public class MenuGestor {
    private ArrayList<Hospital> hospitales;
    private ArrayList<Areas> areas;
    private ArrayList<Medico> medicos;
    private ArrayList<Contrato> contratos;

    private static Scanner sc = new Scanner(System.in);

    public MenuGestor(ArrayList<Hospital> hospitales, ArrayList<Areas> areas,
                      ArrayList<Medico> medicos, ArrayList<Contrato> contratos) {
        this.hospitales = hospitales;
        this.areas = areas;
        this.medicos = medicos;
        this.contratos = contratos;
    }

    //funcion que muestra el menu
    public static void ejecutarMenuGestor() {
        //variable para elegir la opcion que queramos por teclado
        int opcion;
    //bucle do while que ejecuta las opciones mientras que no elijamos 0
        do {
            System.out.println("------------MENÚ PRINCIPAL-----------");
            System.out.println("1. Crear Hospital");
            System.out.println("2. Crear Área");
            System.out.println("3. Crear Médico y Registrar Contrato");
            System.out.println("4. Modificar Médico");
            System.out.println("5. Modificar Hospital");
            System.out.println("6. Calcular Antigüedad");
            System.out.println("7. Calcular Sueldo Neto");
            System.out.println("8. Comprobar Edad");
            System.out.println("9. Proporción de Médicos");
            System.out.println("10. Capacidad de Área");
            System.out.println("11. Comparar Áreas");
            System.out.println("12. Contratos por Año");
            System.out.println("0. Salir");

            //introducimos la opcion por teclado
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            // limpiar buffer
            sc.nextLine();

            //utilizamos un switch para desarrollar cada caso, cada opcion que elijamos
            switch(opcion) {
                case 1: crearHospital(); break;
                case 2: crearArea(); break;
                case 3: crearMedico(); break;
                case 4: modificarMedico(); break;
                case 5: modificarHospital(); break;
                case 6: calcularAntiguedad(); break;
                case 7: calcularSueldoNeto(); break;
                case 8: comprobarEdad(); break;
                case 9: proporcionMedicos(); break;
                case 10: capacidadArea(); break;
                case 11: compararAreas(); break;
                case 12: contratosPorAnio(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción incorrecta");
            }

        } while (opcion != 0);
    }

    // funciones de creacion

    //funcion para crear hospital y direccion
    private static void crearHospital() {
        System.out.print("Nombre del hospital: ");
        String nombre = sc.nextLine();
        System.out.print("CIF: ");
        String cif = sc.nextLine();
        System.out.print("Calle: ");
        String calle = sc.nextLine();
        System.out.print("Número: ");
        int numero = sc.nextInt();
        System.out.print("CP: ");
        int cp = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Localidad: ");
        String localidad = sc.nextLine();
        System.out.print("Provincia: ");
        String provincia = sc.nextLine();

        //creacion de direccion y hospital como objetos con lo que hemos introducido por teclado
        Direccion d = new Direccion(calle, numero, cp, localidad, provincia);
        Hospital h = new Hospital(nombre, cif, d);
        //añadimos el hospital al array de hospitales
        Main.hospitales.add(h);

        System.out.println("Hospital creado correctamente.");
    }

    //funcion para crearArea
    private static void crearArea() {
        System.out.print("CIF del hospital:");
        String cif = sc.nextLine();
        System.out.print("ID del área: ");
        String id = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Planta: ");
        int planta = sc.nextInt();
        sc.nextLine();


        //llamamos a la funcion buscarhospital para que compruebe a través del cif que hemos introducido, si es error no devuelve nada y si lo encuentra lo añade al array de areas del hospital
        Hospital h = Main.buscarHospital(cif);
        if (h == null) {
            System.out.println("Hospital no encontrado");
            return;
        }

        Areas a = new Areas(nombre, id, planta, h);
        h.añadirAreas(a);
        Main.areas.add(a);

        System.out.println("Área creada correctamente.");
    }
    //funcion para crear medico
    private static void crearMedico() {
        System.out.print("DNI: ");
        String dni = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Sexo: ");
        String sexo = sc.nextLine();
        System.out.print("Sueldo bruto: ");
        double sueldo = sc.nextDouble();
        sc.nextLine();

        System.out.print("Día inicio: ");
        int dia = sc.nextInt();
        System.out.print("Mes inicio: ");
        int mes = sc.nextInt();
        System.out.print("Año inicio: ");
        int anio = sc.nextInt();
        sc.nextLine();

        int fecha_i = anio;

        System.out.println("Selecciona el área del médico:");
        for (int i = 0; i < Main.areas.size(); i++) {
            System.out.println(i + ": " + Main.areas.get(i).getNombre() +
                    " (ID: " + Main.areas.get(i).getIdentificador() + ")");
        }
        int indexArea = sc.nextInt();
        sc.nextLine();
        Areas areaSeleccionada = Main.areas.get(indexArea);

        Medico m = new Medico(dni, nombre, edad, sexo, sueldo, fecha_i, areaSeleccionada);
        Main.medicos.add(m);
        System.out.println("Médico creado correctamente.");

        System.out.println("Selecciona el hospital para el contrato:");
        for (int i = 0; i < Main.hospitales.size(); i++) {
            System.out.println(i + ": " + Main.hospitales.get(i).getNombre());
        }
        int indexHospital = sc.nextInt();
        sc.nextLine();
        Hospital h = Main.hospitales.get(indexHospital);

        Contrato c = new Contrato(fecha_i, m, h);
        Main.contratos.add(c);
        System.out.println("Contrato creado correctamente.");
    }

    // funciones para modificar

    private static void modificarMedico() {
        Medico m = pedirMedico();
        if (m == null) return;

        System.out.println("1. Cambiar sueldo");
        System.out.println("2. Cambiar área");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nuevo sueldo: ");
            m.setSueldo(sc.nextDouble());
            sc.nextLine();
        } else if (op == 2) {
            System.out.print("ID nueva área: ");
            String id = sc.nextLine();
            Areas nueva = Main.buscarArea(id);
            if (nueva != null) {
                m.cambiarArea(nueva);
                System.out.println("Área cambiada correctamente.");
            } else {
                System.out.println("Área no encontrada.");
            }
        }
    }

    private static void modificarHospital() {
        System.out.print("CIF: ");
        String cif = sc.nextLine();
        Hospital h = Main.buscarHospital(cif);
        if (h == null) {
            System.out.println("Hospital no encontrado");
            return;
        }

        System.out.println("1. Cambiar nombre");
        System.out.println("2. Cambiar dirección");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nuevo nombre: ");
            h.setNombre(sc.nextLine());
        } else {
            System.out.print("Calle nueva: ");
            String calle = sc.nextLine();
            h.getDireccion().setCalle(calle);
            System.out.print("Calle cambiada a: " + calle );
        }
    }

    // funciones para calculos

    private static void calcularAntiguedad() {
        Medico m = pedirMedico();
        if (m != null)
            System.out.println("Años de antigüedad: " + m.getAniosAntiguedad());
    }

    private static void calcularSueldoNeto() {
        Medico m = pedirMedico();
        if (m != null) {
            System.out.print("Retención (%): ");
            double r = sc.nextDouble();
            sc.nextLine();
            System.out.println("Sueldo neto: " + m.sueldoNeto(r));
        }
    }

    private static void comprobarEdad() {
        Medico m = pedirMedico();
        if (m != null) {
            System.out.print("Edad mínima: ");
            int e = sc.nextInt();
            sc.nextLine();
            System.out.println("Mayor o igual que " + e + "? " + m.mayorEdad(e));
        }
    }

    private static void proporcionMedicos() {

        System.out.print("CIF hospital: ");
        String cif = sc.nextLine();

        Hospital h = Main.buscarHospital(cif);

        if (h == null) {
            System.out.println("Hospital no encontrado.");
            return;
        }

        System.out.print("ID área: ");
        String id = sc.nextLine();

        if (!h.existeArea(id)) {
            System.out.println("El área no existe en ese hospital.");
            return;
        }

        double proporcion = h.getProporcionMedicosArea(id);

        System.out.println("Proporción de médicos en el área: " + proporcion);
    }

    private static void capacidadArea() {
        System.out.print("ID área: ");
        String id = sc.nextLine();
        Areas a = Main.buscarArea(id);

        if (a != null) {
            System.out.print("Capacidad máxima: ");
            int c = sc.nextInt();
            sc.nextLine();
            System.out.println("Capacidad restante: " + a.capacidadRestante(c));
        }
    }

    private static void compararAreas() {
        System.out.print("ID Área 1: ");
        Areas a1 = Main.buscarArea(sc.nextLine());
        System.out.print("ID Área 2: ");
        Areas a2 = Main.buscarArea(sc.nextLine());

        if (a1 != null && a2 != null) {
            System.out.println("Comparación: " + a1.compararMedicos(a2));
        }
    }

    private static void contratosPorAnio() {
        System.out.print("Año: ");
        int anio = sc.nextInt();
        sc.nextLine();

        for (Contrato c : Main.contratos) {
            if (c.esDeAnio(anio)) {
                System.out.println(c.getMedico().getNombre());
            }
        }
    }

    // funciones utiles

    private static Medico pedirMedico() {
        System.out.print("DNI del médico: ");
        String dni = sc.nextLine();
        Medico m = Main.buscarMedico(dni);
        if (m == null) System.out.println("Médico no encontrado");
        return m;
    }

}
