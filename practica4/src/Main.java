import java.util.ArrayList;


public class Main {
    //Arraylist para almacenar los hospitales, areas y contratos
    public static ArrayList<Hospital> hospitales = new ArrayList<>();
    public static ArrayList<Areas> areas = new ArrayList<>();
    public static ArrayList<Medico> medicos = new ArrayList<>();
    public static ArrayList<Contrato> contratos = new ArrayList<>();

    //realiza la carga de datos y ejecuta el menu
    public static void main(String[] args) {
        cargarDatos();
        MenuGestor.ejecutarMenuGestor();
    }

    //funcion que realiza la carga de los datos
    public static void cargarDatos() {

        //creamoos los datos de la direccion y los hospitales
        Direccion dir1 = new Direccion("Culebra", 2, 11406, "Jerez", "Cádiz");
        Hospital h1 = new Hospital("Hospital Aliñó", "12345", dir1);

        Direccion dir2 = new Direccion("Paloma", 5, 11408, "Jerez", "Cádiz");
        Hospital h2 = new Hospital("Hospital palomo", "34567", dir2);

        //añadimos los hospitales creados al array de hospitales
        hospitales.add(h1);
        hospitales.add(h2);

        //Creamos las areas
        Areas a1 = new Areas("Urgencias", "a1", 1, h1);
        Areas a2 = new Areas("Pediatria", "a2", 2, h1);
        Areas a3 = new Areas("Enfermeria", "a3", 0, h2);

        //utilizamos la funcion añadirAreas para añadir las areas creadas a los hospitales
        h1.añadirAreas(a1);
        h1.añadirAreas(a2);
        h2.añadirAreas(a3);

        //añadimos las areas al array de areas
        areas.add(a1);
        areas.add(a2);
        areas.add(a3);

        //Creamos los medicos
        Medico m1 = new Medico("23562354w", "alberto", 43, "hombre", 2304.45, 2014, a1);
        Medico m2 = new Medico("21456343f", "carlos", 36, "hombre", 2800.42, 2022, a2);
        Medico m3 = new Medico("43567433n", "carlota", 53, "mujer", 2678.23, 2007, a3);

        //añadimos los medicos al array de medicos
        medicos.add(m1);
        medicos.add(m2);
        medicos.add(m3);

        //Creamos los contratos
        Contrato c1 = new Contrato(2014, m1, h1);
        Contrato c2 = new Contrato(2022, m2, h1);
        Contrato c3 = new Contrato(2007, m3, h2);

        //añadimos los contratos al array de contratos
        contratos.add(c1);
        contratos.add(c2);
        contratos.add(c3);
    }

    //funcion que inicia el menu gestor

    //Funcion para buscar medico por dni
    public static Medico buscarMedico(String dni) {
        for (int i = 0; i < medicos.size(); i++) {
            Medico m=medicos.get(i);
            if (m.getDni().equals(dni))
                return m;
        }
        return null;
    }

    //funcion para buscar area por id
    public static Areas buscarArea(String id) {
        for (int i = 0; i < areas.size(); i++) {
            Areas a=areas.get(i);
            if (a.getIdentificador().equals(id))
                return a;
        }
        return null;
    }

    //Funcion para buscar hospitales por cif
    public static Hospital buscarHospital(String cif) {
        for (int i = 0; i < hospitales.size(); i++) {
            Hospital h=hospitales.get(i);
            if (h.getCif().equals(cif))
                return h;
        }
        return null;
    }

}
