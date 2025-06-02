package MC;

import java.io.Serializable;

public class CriterioMerito implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descripcion;
    private double puntajeExtra;

    public CriterioMerito() {
        this.descripcion = "";
        this.puntajeExtra = 0.0;
    }

    public CriterioMerito(String descripcion, double puntajeExtra) {
        this.descripcion = descripcion;
        this.puntajeExtra = puntajeExtra;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPuntajeExtra() {
        return puntajeExtra;
    }
    public void setPuntajeExtra(double puntajeExtra) {
        this.puntajeExtra = puntajeExtra;
    }

    @Override
    public String toString() {
        return "CriterioMerito{" +
               "descripcion='" + descripcion + '\'' +
               ", puntajeExtra=" + puntajeExtra +
               '}';
    }
}