package MC;

import java.time.LocalDate;

public class ExamenAdmision extends Examen {
    private static final long serialVersionUID = 1L;

    private double puntajeMinimo; 

    public ExamenAdmision() {
        super();
        this.puntajeMinimo = 0.0;
    }

    public ExamenAdmision(String idExamen, LocalDate fechaExamen,
                          double puntajeObtenido, double puntajeMinimo) {
        super(idExamen, fechaExamen, puntajeObtenido);
        this.puntajeMinimo = puntajeMinimo;
    }

    public double getPuntajeMinimo() {
        return puntajeMinimo;
    }
    public void setPuntajeMinimo(double puntajeMinimo) {
        this.puntajeMinimo = puntajeMinimo;
    }

    @Override
    public boolean calcularAprobado(double requisito) {
        return getPuntajeObtenido() >= puntajeMinimo;
    }

    @Override
    public String toString() {
        return "ExamenAdmision{" +
               "idExamen='" + getIdExamen() + '\'' +
               ", fechaExamen=" + getFechaExamen() +
               ", puntajeObtenido=" + getPuntajeObtenido() +
               ", puntajeMinimo=" + puntajeMinimo +
               '}';
    }
}