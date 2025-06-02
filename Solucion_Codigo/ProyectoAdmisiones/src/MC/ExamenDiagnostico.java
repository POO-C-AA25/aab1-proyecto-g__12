package MC;

import java.time.LocalDate;

public class ExamenDiagnostico extends Examen {
    private static final long serialVersionUID = 1L;

    private double umbralNivelacion; // Ejemplo: 30.0 (30%)

    public ExamenDiagnostico() {
        super();
        this.umbralNivelacion = 0.0;
    }

    public ExamenDiagnostico(String idExamen, LocalDate fechaExamen,
                             double puntajeObtenido, double umbralNivelacion) {
        super(idExamen, fechaExamen, puntajeObtenido);
        this.umbralNivelacion = umbralNivelacion;
    }

    public double getUmbralNivelacion() {
        return umbralNivelacion;
    }
    public void setUmbralNivelacion(double umbralNivelacion) {
        this.umbralNivelacion = umbralNivelacion;
    }

    @Override
    public boolean calcularAprobado(double requisito) {
        // Se ignora “requisito” externo, se compara contra umbralNivelacion interno
        return getPuntajeObtenido() >= umbralNivelacion;
    }

    @Override
    public String toString() {
        return "ExamenDiagnostico{" +
               "idExamen='" + getIdExamen() + '\'' +
               ", fechaExamen=" + getFechaExamen() +
               ", puntajeObtenido=" + getPuntajeObtenido() +
               ", umbralNivelacion=" + umbralNivelacion +
               '}';
    }
}