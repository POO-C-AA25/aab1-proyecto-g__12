package C;

import MC.*;
import java.time.LocalDate;
import java.util.*;

public class AdmisionController {

    private ArrayList<Carrera> listaCarreras;
    private ArrayList<Postulante> listaPostulantes;
    private ArrayList<Inscripcion> listaInscripciones;
    private ArrayList<Resultado> listaResultados;
    private GestorDatos gestor;

    public AdmisionController() {
        this.gestor = new GestorDatos();
        this.listaCarreras = new ArrayList<>();
        this.listaPostulantes = new ArrayList<>();
        this.listaInscripciones = new ArrayList<>();
        this.listaResultados = new ArrayList<>();
    }

    public AdmisionController(GestorDatos gestor,
                              ArrayList<Carrera> listaCarreras,
                              ArrayList<Postulante> listaPostulantes,
                              ArrayList<Inscripcion> listaInscripciones,
                              ArrayList<Resultado> listaResultados) {
        this.gestor = gestor;
        this.listaCarreras = listaCarreras != null ? listaCarreras : new ArrayList<>();
        this.listaPostulantes = listaPostulantes != null ? listaPostulantes : new ArrayList<>();
        this.listaInscripciones = listaInscripciones != null ? listaInscripciones : new ArrayList<>();
        this.listaResultados = listaResultados != null ? listaResultados : new ArrayList<>();
    }

    public ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }
    public void setListaCarreras(ArrayList<Carrera> listaCarreras) {
        this.listaCarreras = listaCarreras;
    }

    public ArrayList<Postulante> getListaPostulantes() {
        return listaPostulantes;
    }
    public void setListaPostulantes(ArrayList<Postulante> listaPostulantes) {
        this.listaPostulantes = listaPostulantes;
    }

    public ArrayList<Inscripcion> getListaInscripciones() {
        return listaInscripciones;
    }
    public void setListaInscripciones(ArrayList<Inscripcion> listaInscripciones) {
        this.listaInscripciones = listaInscripciones;
    }

    public ArrayList<Resultado> getListaResultados() {
        return listaResultados;
    }
    public void setListaResultados(ArrayList<Resultado> listaResultados) {
        this.listaResultados = listaResultados;
    }

    public GestorDatos getGestor() {
        return gestor;
    }
    public void setGestor(GestorDatos gestor) {
        this.gestor = gestor;
    }

    public void cargarDatosIniciales() {
        gestor.inicializarDatos();
        listaPostulantes = gestor.cargarPostulantes();
        listaCarreras = gestor.cargarCarreras();
        listaInscripciones = gestor.cargarInscripciones();
        listaResultados = gestor.cargarResultados();
    }

    public void guardarDatos() {
        gestor.guardarPostulantes(listaPostulantes);
        gestor.guardarCarreras(listaCarreras);
        gestor.guardarInscripciones(listaInscripciones);
        gestor.guardarResultados(listaResultados);
    }

    public void registrarPostulante(Postulante p) {
        if (p != null) {
            listaPostulantes.add(p);
            guardarDatos();
        }
    }

    public void inscribirPostulanteACarrera(String cedulaPostulante, String idCarrera, LocalDate fecha) {
        Postulante encontrado = null;
        for (Postulante p : listaPostulantes) {
            if (p.getCedula().equals(cedulaPostulante)) {
                encontrado = p;
                break;
            }
        }
        if (encontrado == null) {
            System.out.println("No existe postulante con cédula " + cedulaPostulante);
            return;
        }

        Carrera carreraEncontrada = null;
        for (Carrera c : listaCarreras) {
            if (c.getIdCarrera().equals(idCarrera)) {
                carreraEncontrada = c;
                break;
            }
        }
        if (carreraEncontrada == null) {
            System.out.println("No existe carrera con ID " + idCarrera);
            return;
        }

        // Crear objeto Inscripcion
        String nuevoId = "INS" + (listaInscripciones.size() + 1);
        Inscripcion ins = new Inscripcion(nuevoId, encontrado, carreraEncontrada, fecha);
        listaInscripciones.add(ins);

        // Añadir el postulante a la lista interna de la carrera
        carreraEncontrada.agregarPostulante(encontrado);

        guardarDatos();
        System.out.println("Inscripción registrada con ID: " + nuevoId);
    }

    public void asignarExamenAInscripcion(String idInscripcion, Examen examen) {
        Inscripcion ins = null;
        for (Inscripcion i : listaInscripciones) {
            if (i.getIdInscripcion().equals(idInscripcion)) {
                ins = i;
                break;
            }
        }
        if (ins == null) {
            System.out.println("No existe inscripción con ID " + idInscripcion);
            return;
        }

        Postulante p = ins.getPostulante();
        if (p == null) {
            System.out.println("La inscripción no está vinculada a un postulante.");
            return;
        }

        if (examen instanceof ExamenAdmision) {
            p.setTipoExamen("ADMISION");
            p.setPuntajeExamen(examen.getPuntajeObtenido());
            p.setAprobado(((ExamenAdmision) examen).calcularAprobado(0.0));
        } else if (examen instanceof ExamenDiagnostico) {
            p.setTipoExamen("DIAGNOSTICO");
            p.setPuntajeExamen(examen.getPuntajeObtenido());
            p.setAprobado(((ExamenDiagnostico) examen).calcularAprobado(0.0));
        } else {
            System.out.println("Tipo de examen no reconocido.");
            return;
        }

        // Calcular puntaje adicional por mérito
        p.calcularPuntajeAdicional();

        guardarDatos();
        System.out.println("Examen asignado a postulante " + p.getCedula());
    }

    public void procesarAdmisionesPorCarrera(String idCarrera) {
        // 1. Encontrar la carrera
        Carrera carrera = null;
        for (Carrera c : listaCarreras) {
            if (c.getIdCarrera().equals(idCarrera)) {
                carrera = c;
                break;
            }
        }
        if (carrera == null) {
            System.out.println("No existe carrera con ID " + idCarrera);
            return;
        }

        ArrayList<Postulante> todos = carrera.getPostulantes();
        if (todos.isEmpty()) {
            System.out.println("No hay postulantes inscritos para la carrera " + idCarrera);
            return;
        }

        List<Postulante> listaExamenAdmi = new ArrayList<>();
        List<Postulante> listaDiagnostico = new ArrayList<>();

        for (Postulante p : todos) {
            if ("ADMISION".equalsIgnoreCase(p.getTipoExamen())) {
                listaExamenAdmi.add(p);
            } else if ("DIAGNOSTICO".equalsIgnoreCase(p.getTipoExamen())) {
                listaDiagnostico.add(p);
            } else {
            }
        }

        listaExamenAdmi.sort((p1, p2) -> {
            double total1 = p1.getPuntajeExamen() + p1.getPuntajeAdicional();
            double total2 = p2.getPuntajeExamen() + p2.getPuntajeAdicional();
            return Double.compare(total2, total1);
        });

        int cupos = carrera.getCuposRegulares();
        int admitidosCount = Math.min(cupos, listaExamenAdmi.size());
        for (int i = 0; i < listaExamenAdmi.size(); i++) {
            Postulante p = listaExamenAdmi.get(i);
            p.setAprobado(i < admitidosCount); 
        }

        for (int i = 0; i < listaExamenAdmi.size(); i++) {
            Postulante p = listaExamenAdmi.get(i);
            boolean admitido = p.isAprobado();
            boolean requiereNivelacion = false; 
            double puntajeMerito = p.getPuntajeAdicional();
            double puntajeExamen = p.getPuntajeExamen();
            double puntajeTotal = puntajeExamen + puntajeMerito;

            String idRes = "RES" + (listaResultados.size() + 1);
            Resultado res = new Resultado(
                    idRes,
                    p,
                    carrera,
                    puntajeExamen,
                    puntajeMerito,
                    puntajeTotal,
                    admitido,
                    requiereNivelacion
            );
            listaResultados.add(res);
        }

        for (Postulante p : listaDiagnostico) {
            double umbral = carrera.getUmbralDiagnostico();
            boolean aprob = p.getPuntajeExamen() >= umbral;
            p.setAprobado(aprob);
            boolean requiereNivelacion = !aprob;

            double puntajeMerito = p.getPuntajeAdicional();
            double puntajeExamen = p.getPuntajeExamen();
            double puntajeTotal = puntajeExamen + puntajeMerito;
            String idRes = "RES" + (listaResultados.size() + 1);

            Resultado res = new Resultado(
                    idRes,
                    p,
                    carrera,
                    puntajeExamen,
                    puntajeMerito,
                    puntajeTotal,
                    aprob,            
                    requiereNivelacion
            );
            listaResultados.add(res);
        }

        guardarDatos();
        System.out.println("Proceso de admisiones completado para la carrera " + carrera.getNombre());
    }

    public Map<String, Double> obtenerCarrerasConOcupacionMenor50() {
        Map<String, Double> mapa = new HashMap<>();
        for (Carrera c : listaCarreras) {
            int inscritos = c.getCantidadPostulantes();
            int cupos = c.getCuposRegulares();
            if (cupos > 0) {
                double porcentaje = (inscritos * 100.0) / cupos;
                if (porcentaje < 50.0) {
                    mapa.put(c.getIdCarrera(), porcentaje);
                }
            }
        }
        return mapa;
    }

    public Map<String, Integer> obtenerCarrerasConRechazos() {
        Map<String, Integer> mapa = new HashMap<>();
        for (Carrera c : listaCarreras) {
            // Contar cuántos postulantes de tipo ADMISION superan cuposRegulares
            int cuentaAdmi = 0;
            int rechazados = 0;
            for (Postulante p : c.getPostulantes()) {
                if ("ADMISION".equalsIgnoreCase(p.getTipoExamen())) {
                    cuentaAdmi++;
                }
            }
            if (cuentaAdmi > c.getCuposRegulares()) {
                rechazados = cuentaAdmi - c.getCuposRegulares();
                mapa.put(c.getIdCarrera(), rechazados);
            }
        }
        return mapa;
    }

    public void generarEstadisticas() {
        System.out.println("=== Estadísticas de Admisiones ===");

        // Carreras con ocupación menor al 50%
        Map<String, Double> ocMenor50 = obtenerCarrerasConOcupacionMenor50();
        if (ocMenor50.isEmpty()) {
            System.out.println("Ninguna carrera tiene ocupación < 50%.");
        } else {
            System.out.println("Carreras con ocupación < 50%:");
            for (Map.Entry<String, Double> entry : ocMenor50.entrySet()) {
                System.out.printf(" • %s → %.2f%% ocupado%n", entry.getKey(), entry.getValue());
            }
        }

        // Carreras con rechazos
        Map<String, Integer> cRechazos = obtenerCarrerasConRechazos();
        if (cRechazos.isEmpty()) {
            System.out.println("Ninguna carrera ha rechazado postulantes por falta de cupo.");
        } else {
            System.out.println("Carreras que rechazaron postulantes por cupos insuficientes:");
            for (Map.Entry<String, Integer> entry : cRechazos.entrySet()) {
                System.out.printf(" • %s → %d rechazados%n", entry.getKey(), entry.getValue());
            }
        }

        System.out.println("==================================");
    }
}