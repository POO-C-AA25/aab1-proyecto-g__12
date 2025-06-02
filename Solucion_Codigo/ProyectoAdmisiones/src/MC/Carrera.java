package MC;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrera implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos
    private String idCarrera;
    private String nombre;
    private int cuposRegulares;
    private double puntajeMinimoAdmi;
    private double umbralDiagnostico;     
    private boolean requiereDiagnostico;
    private ArrayList<Postulante> postulantes; 

    public Carrera() {
        this.idCarrera = "";
        this.nombre = "";
        this.cuposRegulares = 0;
        this.puntajeMinimoAdmi = 0.0;
        this.umbralDiagnostico = 0.0;
        this.requiereDiagnostico = false;
        this.postulantes = new ArrayList<>();
    }

    public Carrera(String idCarrera, String nombre, int cuposRegulares,
                   double puntajeMinimoAdmi, double umbralDiagnostico,
                   boolean requiereDiagnostico, ArrayList<Postulante> postulantes) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.cuposRegulares = cuposRegulares;
        this.puntajeMinimoAdmi = puntajeMinimoAdmi;
        this.umbralDiagnostico = umbralDiagnostico;
        this.requiereDiagnostico = requiereDiagnostico;
        this.postulantes = postulantes != null ? postulantes : new ArrayList<>();
    }

    public String getIdCarrera() {
        return idCarrera;
    }
    public void setIdCarrera(String idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuposRegulares() {
        return cuposRegulares;
    }
    public void setCuposRegulares(int cuposRegulares) {
        this.cuposRegulares = cuposRegulares;
    }

    public double getPuntajeMinimoAdmi() {
        return puntajeMinimoAdmi;
    }
    public void setPuntajeMinimoAdmi(double puntajeMinimoAdmi) {
        this.puntajeMinimoAdmi = puntajeMinimoAdmi;
    }

    public double getUmbralDiagnostico() {
        return umbralDiagnostico;
    }
    public void setUmbralDiagnostico(double umbralDiagnostico) {
        this.umbralDiagnostico = umbralDiagnostico;
    }

    public boolean isRequiereDiagnostico() {
        return requiereDiagnostico;
    }
    public void setRequiereDiagnostico(boolean requiereDiagnostico) {
        this.requiereDiagnostico = requiereDiagnostico;
    }

    public ArrayList<Postulante> getPostulantes() {
        return postulantes;
    }
    public void setPostulantes(ArrayList<Postulante> postulantes) {
        this.postulantes = postulantes;
    }


    public void agregarPostulante(Postulante p) {
        if (p != null) {
            postulantes.add(p);
        }
    }
    
    public int getCantidadPostulantes() {
        return postulantes.size();
    }

    @Override
    public String toString() {
        return "Carrera{" +
               "idCarrera='" + idCarrera + '\'' +
               ", nombre='" + nombre + '\'' +
               ", cuposRegulares=" + cuposRegulares +
               ", puntajeMinimoAdmi=" + puntajeMinimoAdmi +
               ", umbralDiagnostico=" + umbralDiagnostico +
               ", requiereDiagnostico=" + requiereDiagnostico +
               ", postulantesInscritos=" + postulantes.size() +
               '}';
    }
}