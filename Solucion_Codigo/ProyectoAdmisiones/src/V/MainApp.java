package V;

import C.AdmisionController;
import MC.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private AdmisionController sistema;
    private Scanner sc;
    private DateTimeFormatter fmt;

    public MainApp() {
        this.sistema = new AdmisionController();
        this.sc = new Scanner(System.in);
        this.fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public MainApp(AdmisionController sistema) {
        this.sistema = sistema;
        this.sc = new Scanner(System.in);
        this.fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    public AdmisionController getSistema() {
        return sistema;
    }
    public void setSistema(AdmisionController sistema) {
        this.sistema = sistema;
    }

    public static void main(String[] args) {
    MainApp app = new MainApp();
    app.sistema.cargarDatosIniciales();

    if (app.sistema.getListaCarreras().isEmpty()) {
        ArrayList<MC.Postulante> listaVacia = new ArrayList<>();

        MC.Carrera c1  = new MC.Carrera("C001", "Administración de Empresas",      100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c2  = new MC.Carrera("C002", "Agropecuaria",                    100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c3  = new MC.Carrera("C003", "Alimentos",                       25, 0.0, 60.0, true, listaVacia);
        MC.Carrera c4  = new MC.Carrera("C004", "Artes Escénicas",                 50, 0.0, 60.0, true, listaVacia);
        MC.Carrera c5  = new MC.Carrera("C005", "Artes Visuales",                  50, 0.0, 60.0, true, listaVacia);
        MC.Carrera c6  = new MC.Carrera("C006", "Biología",                        150, 0.0, 60.0, true, listaVacia);
        MC.Carrera c7  = new MC.Carrera("C007", "Computación",                     200, 0.0, 60.0, true, listaVacia);
        MC.Carrera c8  = new MC.Carrera("C008", "Contabilidad y Auditoría",        100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c9  = new MC.Carrera("C009", "Derecho",                         300, 0.0, 60.0, true, listaVacia);
        MC.Carrera c10 = new MC.Carrera("C010", "Economía",                        100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c11 = new MC.Carrera("C011", "Finanzas",                        50, 0.0, 60.0, true, listaVacia);
        MC.Carrera c12 = new MC.Carrera("C012", "Geología",                        100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c13 = new MC.Carrera("C013", "Ingeniería Ambiental",            50, 0.0, 60.0, true, listaVacia);
        MC.Carrera c14 = new MC.Carrera("C014", "Ingeniería Química",              50, 0.0, 60.0, true, listaVacia);
        MC.Carrera c15 = new MC.Carrera("C015", "Pedagogía de Idiomas Nacionales y Extranjeros", 100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c16 = new MC.Carrera("C016", "Psicopedagogía",                  100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c17 = new MC.Carrera("C017", "Telecomunicaciones",              100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c18 = new MC.Carrera("C018", "Arquitectura",                    100, 60.0, 0.0, false, listaVacia);
        MC.Carrera c19 = new MC.Carrera("C019", "Bioquímica y Farmacia",           100, 90.0, 0.0, false, listaVacia);
        MC.Carrera c20 = new MC.Carrera("C020", "Enfermería",                      200, 90.0, 0.0, false, listaVacia);
        MC.Carrera c21 = new MC.Carrera("C021", "Fisioterapia",                    200, 90.0, 0.0, false, listaVacia);
        MC.Carrera c22 = new MC.Carrera("C022", "Gastronomía",                     100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c23 = new MC.Carrera("C023", "Ingeniería Civil",                200, 60.0, 0.0, false, listaVacia);
        MC.Carrera c24 = new MC.Carrera("C024", "Ingeniería Industrial",           50, 0.0, 60.0, true, listaVacia);
        MC.Carrera c25 = new MC.Carrera("C025", "Medicina",                        200, 90.0, 0.0, false, listaVacia);
        MC.Carrera c26 = new MC.Carrera("C026", "Nutrición y Dietética",           100, 90.0, 0.0, false, listaVacia);
        MC.Carrera c27 = new MC.Carrera("C027", "Psicología",                      100, 0.0, 60.0, true, listaVacia);
        MC.Carrera c28 = new MC.Carrera("C028", "Psicología Clínica",              200, 90.0, 0.0, false, listaVacia);

        app.sistema.getListaCarreras().add(c1);
        app.sistema.getListaCarreras().add(c2);
        app.sistema.getListaCarreras().add(c3);
        app.sistema.getListaCarreras().add(c4);
        app.sistema.getListaCarreras().add(c5);
        app.sistema.getListaCarreras().add(c6);
        app.sistema.getListaCarreras().add(c7);
        app.sistema.getListaCarreras().add(c8);
        app.sistema.getListaCarreras().add(c9);
        app.sistema.getListaCarreras().add(c10);
        app.sistema.getListaCarreras().add(c11);
        app.sistema.getListaCarreras().add(c12);
        app.sistema.getListaCarreras().add(c13);
        app.sistema.getListaCarreras().add(c14);
        app.sistema.getListaCarreras().add(c15);
        app.sistema.getListaCarreras().add(c16);
        app.sistema.getListaCarreras().add(c17);
        app.sistema.getListaCarreras().add(c18);
        app.sistema.getListaCarreras().add(c19);
        app.sistema.getListaCarreras().add(c20);
        app.sistema.getListaCarreras().add(c21);
        app.sistema.getListaCarreras().add(c22);
        app.sistema.getListaCarreras().add(c23);
        app.sistema.getListaCarreras().add(c24);
        app.sistema.getListaCarreras().add(c25);
        app.sistema.getListaCarreras().add(c26);
        app.sistema.getListaCarreras().add(c27);
        app.sistema.getListaCarreras().add(c28);

        app.sistema.guardarDatos();
        System.out.println("Carreras cargadas por defecto en el sistema.");
    }

    app.mostrarMenuPrincipal();
}


    public void mostrarMenuPrincipal() {
        int opcion = -1;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE ADMISIONES UTPL ===");
            System.out.println("===    BY JUAN TACURI / ANTHONY VICENTE   ===");
            System.out.println("1) Registrar nuevo postulante");
            System.out.println("2) Listar carreras disponibles");
            System.out.println("3) Inscribir postulante a una carrera");
            System.out.println("4) Registrar resultado de examen");
            System.out.println("5) Procesar admisiones para una carrera");
            System.out.println("6) Mostrar reportes/estadísticas");
            System.out.println("7) Salir");
            System.out.print("Selecciona una opción [1-7]: ");

            opcion = leerEntero("");
            switch (opcion) {
                case 1:
                    opcionRegistrarPostulante();
                    break;
                case 2:
                    opcionListarCarreras();
                    break;
                case 3:
                    opcionInscribirACarrera();
                    break;
                case 4:
                    opcionRegistrarResultadoExamen();
                    break;
                case 5:
                    opcionProcesarAdmisiones();
                    break;
                case 6:
                    opcionMostrarEstadisticas();
                    break;
                case 7:
                    System.out.println("Saliendo del sistema… ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 7);
    }

    private void opcionRegistrarPostulante() {
        System.out.println("\n--- Registrar Nuevo Postulante ---");
        String cedula = leerTexto("Cédula: ");
        String nombre = leerTexto("Nombre: ");
        String apellido = leerTexto("Apellido: ");

        LocalDate fechaNac = null;
        while (fechaNac == null) {
            String fechaStr = leerTexto("Fecha de nacimiento (yyyy-MM-dd): ");
            try {
                fechaNac = LocalDate.parse(fechaStr, fmt);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intenta nuevamente.");
            }
        }

        System.out.println("Selecciona la carrera postulada (ID): ");
        opcionListarCarreras(); // Muestra las carreras
        String idCar = leerTexto("ID de carrera: ");
        Carrera carrera = null;
        for (Carrera c : sistema.getListaCarreras()) {
            if (c.getIdCarrera().equals(idCar)) {
                carrera = c;
                break;
            }
        }
        if (carrera == null) {
            System.out.println("Carrera no encontrada. El postulante se registra sin carrera asignada.");
        }

        boolean esAbanderado = leerTexto("¿Es abanderado? (s/n): ").equalsIgnoreCase("s");
        boolean afinidad = leerTexto("¿Afinidad de bachillerato con la carrera? (s/n): ").equalsIgnoreCase("s");
        double porcentajeCE = -1;
        while (porcentajeCE < 0) {
            porcentajeCE = leerDouble("Porcentaje de capacidad especial (0 a 100): ");
            if (porcentajeCE < 0 || porcentajeCE > 100) {
                System.out.println("Valor inválido. Debe estar entre 0 y 100.");
                porcentajeCE = -1;
            }
        }

        Postulante p = new Postulante(
                cedula, nombre, apellido, fechaNac, carrera,
                0.0, 0, "", esAbanderado, afinidad, porcentajeCE, false
        );
        sistema.registrarPostulante(p);
        System.out.println("Postulante registrado: " + p);
    }

    private void opcionListarCarreras() {
        System.out.println("\n--- Carreras Disponibles ---");
        if (sistema.getListaCarreras().isEmpty()) {
            System.out.println("No hay carreras registradas.");
            return;
        }
        for (Carrera c : sistema.getListaCarreras()) {
            System.out.println(c);
        }
    }

    private void opcionInscribirACarrera() {
        System.out.println("\n--- Inscribir Postulante a Carrera ---");
        String cedula = leerTexto("Cédula del postulante: ");
        String idCarrera = leerTexto("ID de la carrera: ");

        LocalDate fecha = null;
        while (fecha == null) {
            String fechaStr = leerTexto("Fecha de inscripción (yyyy-MM-dd): ");
            try {
                fecha = LocalDate.parse(fechaStr, fmt);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intenta nuevamente.");
            }
        }

        sistema.inscribirPostulanteACarrera(cedula, idCarrera, fecha);
    }

    private void opcionRegistrarResultadoExamen() {
        System.out.println("\n--- Registrar Resultado de Examen ---");
        // Mostrar inscripciones disponibles
        if (sistema.getListaInscripciones().isEmpty()) {
            System.out.println("No hay inscripciones registradas.");
            return;
        }
        for (Inscripcion i : sistema.getListaInscripciones()) {
            System.out.println(i);
        }
        String idIns = leerTexto("Ingresa ID de Inscripción: ");

        // Preguntar tipo de examen
        System.out.println("Tipo de examen:");
        System.out.println(" 1) Admisión");
        System.out.println(" 2) Diagnóstico");
        int tipo = -1;
        while (tipo != 1 && tipo != 2) {
            tipo = leerEntero("Selecciona 1 o 2: ");
        }

        // Leer puntaje del examen
        double puntaje = -1;
        while (puntaje < 0 || puntaje > 100) {
            puntaje = leerDouble("Puntaje obtenido (0-100): ");
            if (puntaje < 0 || puntaje > 100) {
                System.out.println("Puntaje inválido, debe ser entre 0 y 100.");
            }
        }

        // Para examen de admisión necesitamos conocer el puntaje mínimo de la carrera
        // y para diagnóstico, el umbral de nivelación
        Examen examen;
        if (tipo == 1) { // Admisión
            String idCarrera = "";
            for (Inscripcion i : sistema.getListaInscripciones()) {
                if (i.getIdInscripcion().equals(idIns)) {
                    idCarrera = i.getCarrera().getIdCarrera();
                    break;
                }
            }
            Carrera c = null;
            for (Carrera car : sistema.getListaCarreras()) {
                if (car.getIdCarrera().equals(idCarrera)) {
                    c = car;
                    break;
                }
            }
            if (c == null) {
                System.out.println("Carrera no encontrada. No se puede asignar examen de admisión.");
                return;
            }
            examen = new ExamenAdmision("EXA" + System.currentTimeMillis(), LocalDate.now(),
                                        puntaje, c.getPuntajeMinimoAdmi());
        } else { // Diagnóstico
            String idCarrera = "";
            for (Inscripcion i : sistema.getListaInscripciones()) {
                if (i.getIdInscripcion().equals(idIns)) {
                    idCarrera = i.getCarrera().getIdCarrera();
                    break;
                }
            }
            Carrera c = null;
            for (Carrera car : sistema.getListaCarreras()) {
                if (car.getIdCarrera().equals(idCarrera)) {
                    c = car;
                    break;
                }
            }
            if (c == null) {
                System.out.println("Carrera no encontrada. No se puede asignar examen de diagnóstico.");
                return;
            }
            examen = new ExamenDiagnostico("EXD" + System.currentTimeMillis(), LocalDate.now(),
                                           puntaje, c.getUmbralDiagnostico());
        }

        // Asignar el examen al postulante correspondiente
        sistema.asignarExamenAInscripcion(idIns, examen);
    }

    private void opcionProcesarAdmisiones() {
        System.out.println("\n--- Procesar Admisiones por Carrera ---");
        if (sistema.getListaCarreras().isEmpty()) {
            System.out.println("No hay carreras registradas.");
            return;
        }
        for (Carrera c : sistema.getListaCarreras()) {
            System.out.println("ID: " + c.getIdCarrera() + " → " + c.getNombre());
        }
        String idCar = leerTexto("ID de la carrera a procesar: ");
        sistema.procesarAdmisionesPorCarrera(idCar);
    }

    private void opcionMostrarEstadisticas() {
        System.out.println("\n--- Reportes y Estadísticas ---");
        sistema.generarEstadisticas();
    }

    private String leerTexto(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.print(prompt);
        }
        return sc.nextLine().trim();
    }

    private int leerEntero(String prompt) {
        int valor = -1;
        boolean ok = false;
        while (!ok) {
            try {
                if (!prompt.isEmpty()) {
                    System.out.print(prompt);
                }
                String line = sc.nextLine().trim();
                valor = Integer.parseInt(line);
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println("Número inválido. Intenta de nuevo.");
            }
        }
        return valor;
    }

    private double leerDouble(String prompt) {
        double valor = -1;
        boolean ok = false;
        while (!ok) {
            try {
                if (!prompt.isEmpty()) {
                    System.out.print(prompt);
                }
                String line = sc.nextLine().trim();
                valor = Double.parseDouble(line);
                ok = true;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Intenta de nuevo.");
            }
        }
        return valor;
    }
}