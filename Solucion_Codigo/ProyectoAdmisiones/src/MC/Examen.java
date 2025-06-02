package MC;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Examen implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idExamen;
    private LocalDate fechaExamen;
    private double puntajeObtenido;

    public Examen() {
        this.idExamen = "";
        this.fechaExamen = null;
        this.puntajeObtenido = 0.0;
    }

    public Examen(String idExamen, LocalDate fechaExamen, double puntajeObtenido) {
        this.idExamen = idExamen;
        this.fechaExamen = fechaExamen;
        this.puntajeObtenido = puntajeObtenido;
    }

    public String getIdExamen() {
        return idExamen;
    }
    public void setIdExamen(String idExamen) {
        this.idExamen = idExamen;
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }
    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public double getPuntajeObtenido() {
        return puntajeObtenido;
    }
    public void setPuntajeObtenido(double puntajeObtenido) {
        this.puntajeObtenido = puntajeObtenido;
    }

    public abstract boolean calcularAprobado(double requisito);

    @Override
    public String toString() {
        return "Examen{" +
               "idExamen='" + idExamen + '\'' +
               ", fechaExamen=" + fechaExamen +
               ", puntajeObtenido=" + puntajeObtenido +
               '}';
    }
}