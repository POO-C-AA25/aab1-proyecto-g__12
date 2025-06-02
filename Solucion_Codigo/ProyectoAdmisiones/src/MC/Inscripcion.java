package MC;

import java.io.Serializable;
import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idInscripcion;
    private Postulante postulante;
    private Carrera carrera;
    private LocalDate fechaInscripcion;

    public Inscripcion() {
        this.idInscripcion = "";
        this.postulante = null;
        this.carrera = null;
        this.fechaInscripcion = null;
    }

    public Inscripcion(String idInscripcion, Postulante postulante,
                       Carrera carrera, LocalDate fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.postulante = postulante;
        this.carrera = carrera;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getIdInscripcion() {
        return idInscripcion;
    }
    public void setIdInscripcion(String idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Postulante getPostulante() {
        return postulante;
    }
    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Carrera getCarrera() {
        return carrera;
    }
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
               "idInscripcion='" + idInscripcion + '\'' +
               ", postulante=" + (postulante != null ? postulante.getCedula() : "Nulo") +
               ", carrera=" + (carrera != null ? carrera.getIdCarrera() : "Nulo") +
               ", fechaInscripcion=" + fechaInscripcion +
               '}';
    }
}
