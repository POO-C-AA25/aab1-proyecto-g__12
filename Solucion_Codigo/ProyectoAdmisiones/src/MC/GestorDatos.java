package MC;

import java.io.*;
import java.util.ArrayList;

public class GestorDatos {

    private String rutaArchivoPostulantes;
    private String rutaArchivoCarreras;
    private String rutaArchivoInscripciones;
    private String rutaArchivoResultados;

    public GestorDatos() {
        this.rutaArchivoPostulantes = "postulantes.dat";
        this.rutaArchivoCarreras = "carreras.dat";
        this.rutaArchivoInscripciones = "inscripciones.dat";
        this.rutaArchivoResultados = "resultados.dat";
    }

    public GestorDatos(String rutaPostulantes, String rutaCarreras,
                       String rutaInscripciones, String rutaResultados) {
        this.rutaArchivoPostulantes = rutaPostulantes;
        this.rutaArchivoCarreras = rutaCarreras;
        this.rutaArchivoInscripciones = rutaInscripciones;
        this.rutaArchivoResultados = rutaResultados;
    }

    public String getRutaArchivoPostulantes() {
        return rutaArchivoPostulantes;
    }
    public void setRutaArchivoPostulantes(String rutaArchivoPostulantes) {
        this.rutaArchivoPostulantes = rutaArchivoPostulantes;
    }

    public String getRutaArchivoCarreras() {
        return rutaArchivoCarreras;
    }
    public void setRutaArchivoCarreras(String rutaArchivoCarreras) {
        this.rutaArchivoCarreras = rutaArchivoCarreras;
    }

    public String getRutaArchivoInscripciones() {
        return rutaArchivoInscripciones;
    }
    public void setRutaArchivoInscripciones(String rutaArchivoInscripciones) {
        this.rutaArchivoInscripciones = rutaArchivoInscripciones;
    }

    public String getRutaArchivoResultados() {
        return rutaArchivoResultados;
    }
    public void setRutaArchivoResultados(String rutaArchivoResultados) {
        this.rutaArchivoResultados = rutaArchivoResultados;
    }

    public void inicializarDatos() {
        try {
            File f1 = new File(rutaArchivoPostulantes);
            if (!f1.exists()) {
                f1.createNewFile();
                guardarPostulantes(new ArrayList<>());
            }
            File f2 = new File(rutaArchivoCarreras);
            if (!f2.exists()) {
                f2.createNewFile();
                guardarCarreras(new ArrayList<>());
            }
            File f3 = new File(rutaArchivoInscripciones);
            if (!f3.exists()) {
                f3.createNewFile();
                guardarInscripciones(new ArrayList<>());
            }
            File f4 = new File(rutaArchivoResultados);
            if (!f4.exists()) {
                f4.createNewFile();
                guardarResultados(new ArrayList<>());
            }
        } catch (IOException e) {
            System.err.println("Error al inicializar archivos: " + e.getMessage());
        }
    }

    public void guardarPostulantes(ArrayList<Postulante> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivoPostulantes))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al guardar postulantes: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Postulante> cargarPostulantes() {
        ArrayList<Postulante> lista = new ArrayList<>();
        File archivo = new File(rutaArchivoPostulantes);
        if (!archivo.exists() || archivo.length() == 0) {
            return lista;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivoPostulantes))) {
            lista = (ArrayList<Postulante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar postulantes: " + e.getMessage());
        }
        return lista;
    }

    public void guardarCarreras(ArrayList<Carrera> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivoCarreras))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al guardar carreras: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Carrera> cargarCarreras() {
        ArrayList<Carrera> lista = new ArrayList<>();
        File archivo = new File(rutaArchivoCarreras);
        if (!archivo.exists() || archivo.length() == 0) {
            return lista;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivoCarreras))) {
            lista = (ArrayList<Carrera>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar carreras: " + e.getMessage());
        }
        return lista;
    }

    public void guardarInscripciones(ArrayList<Inscripcion> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivoInscripciones))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al guardar inscripciones: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Inscripcion> cargarInscripciones() {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        File archivo = new File(rutaArchivoInscripciones);
        if (!archivo.exists() || archivo.length() == 0) {
            return lista;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivoInscripciones))) {
            lista = (ArrayList<Inscripcion>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar inscripciones: " + e.getMessage());
        }
        return lista;
    }

    public void guardarResultados(ArrayList<Resultado> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivoResultados))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al guardar resultados: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Resultado> cargarResultados() {
        ArrayList<Resultado> lista = new ArrayList<>();
        File archivo = new File(rutaArchivoResultados);
        if (!archivo.exists() || archivo.length() == 0) {
            return lista;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivoResultados))) {
            lista = (ArrayList<Resultado>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar resultados: " + e.getMessage());
        }
        return lista;
    }
}
