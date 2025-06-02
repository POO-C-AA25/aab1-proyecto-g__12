package MC;

import java.io.Serializable;

public class Resultado implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idResultado;
    private Postulante postulante;
    private Carrera carrera;
    private double puntajeExamen;
    private double puntajeMerito;
    private double puntajeTotal;
    private boolean admitido;
    private boolean requiereNivelacion;

    public Resultado() {
        this.idResultado = "";
        this.postulante = null;
        this.carrera = null;
        this.puntajeExamen = 0.0;
        this.puntajeMerito = 0.0;
        this.puntajeTotal = 0.0;
        this.admitido = false;
        this.requiereNivelacion = false;
    }

    public Resultado(String idResultado, Postulante postulante, Carrera carrera,
                     double puntajeExamen, double puntajeMerito,
                     double puntajeTotal, boolean admitido, boolean requiereNivelacion) {
        this.idResultado = idResultado;
        this.postulante = postulante;
        this.carrera = carrera;
        this.puntajeExamen = puntajeExamen;
        this.puntajeMerito = puntajeMerito;
        this.puntajeTotal = puntajeTotal;
        this.admitido = admitido;
        this.requiereNivelacion = requiereNivelacion;
    }

    public String getIdResultado() {
        return idResultado;
    }
    public void setIdResultado(String idResultado) {
        this.idResultado = idResultado;
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

    public double getPuntajeExamen() {
        return puntajeExamen;
    }
    public void setPuntajeExamen(double puntajeExamen) {
        this.puntajeExamen = puntajeExamen;
    }

    public double getPuntajeMerito() {
        return puntajeMerito;
    }
    public void setPuntajeMerito(double puntajeMerito) {
        this.puntajeMerito = puntajeMerito;
    }

    public double getPuntajeTotal() {
        return puntajeTotal;
    }
    public void setPuntajeTotal(double puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public boolean isAdmitido() {
        return admitido;
    }
    public void setAdmitido(boolean admitido) {
        this.admitido = admitido;
    }

    public boolean isRequiereNivelacion() {
        return requiereNivelacion;
    }
    public void setRequiereNivelacion(boolean requiereNivelacion) {
        this.requiereNivelacion = requiereNivelacion;
    }

    public void calcularPuntajeTotal() {
        this.puntajeTotal = this.puntajeExamen + this.puntajeMerito;
    }

    @Override
    public String toString() {
        return "Resultado{" +
               "idResultado='" + idResultado + '\'' +
               ", postulante=" + (postulante != null ? postulante.getCedula() : "Nulo") +
               ", carrera=" + (carrera != null ? carrera.getIdCarrera() : "Nulo") +
               ", puntajeExamen=" + puntajeExamen +
               ", puntajeMerito=" + puntajeMerito +
               ", puntajeTotal=" + puntajeTotal +
               ", admitido=" + admitido +
               ", requiereNivelacion=" + requiereNivelacion +
               '}';
    }
}
