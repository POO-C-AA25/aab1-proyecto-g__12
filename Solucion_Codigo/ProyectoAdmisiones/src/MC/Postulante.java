package MC;

import java.io.Serializable;
import java.time.LocalDate;

public class Postulante implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos
    private String cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Carrera carreraPostulada;
    private double puntajeExamen;              
    private int puntajeAdicional;               
    private String tipoExamen;                  
    private boolean esAbanderado;
    private boolean afinidadBachillerato;
    private double porcentajeCapacidadEspecial; 
    private boolean aprobado;                   

    public Postulante() {
        this.cedula = "";
        this.nombre = "";
        this.apellido = "";
        this.fechaNacimiento = null;
        this.carreraPostulada = null;
        this.puntajeExamen = 0.0;
        this.puntajeAdicional = 0;
        this.tipoExamen = "";
        this.esAbanderado = false;
        this.afinidadBachillerato = false;
        this.porcentajeCapacidadEspecial = 0.0;
        this.aprobado = false;
    }

    public Postulante(String cedula, String nombre, String apellido, LocalDate fechaNacimiento,
                      Carrera carreraPostulada, double puntajeExamen, int puntajeAdicional,
                      String tipoExamen, boolean esAbanderado, boolean afinidadBachillerato,
                      double porcentajeCapacidadEspecial, boolean aprobado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.carreraPostulada = carreraPostulada;
        this.puntajeExamen = puntajeExamen;
        this.puntajeAdicional = puntajeAdicional;
        this.tipoExamen = tipoExamen;
        this.esAbanderado = esAbanderado;
        this.afinidadBachillerato = afinidadBachillerato;
        this.porcentajeCapacidadEspecial = porcentajeCapacidadEspecial;
        this.aprobado = aprobado;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Carrera getCarreraPostulada() {
        return carreraPostulada;
    }
    public void setCarreraPostulada(Carrera carreraPostulada) {
        this.carreraPostulada = carreraPostulada;
    }

    public double getPuntajeExamen() {
        return puntajeExamen;
    }
    public void setPuntajeExamen(double puntajeExamen) {
        this.puntajeExamen = puntajeExamen;
    }

    public int getPuntajeAdicional() {
        return puntajeAdicional;
    }
    public void setPuntajeAdicional(int puntajeAdicional) {
        this.puntajeAdicional = puntajeAdicional;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }
    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public boolean isEsAbanderado() {
        return esAbanderado;
    }
    public void setEsAbanderado(boolean esAbanderado) {
        this.esAbanderado = esAbanderado;
    }

    public boolean isAfinidadBachillerato() {
        return afinidadBachillerato;
    }
    public void setAfinidadBachillerato(boolean afinidadBachillerato) {
        this.afinidadBachillerato = afinidadBachillerato;
    }

    public double getPorcentajeCapacidadEspecial() {
        return porcentajeCapacidadEspecial;
    }
    public void setPorcentajeCapacidadEspecial(double porcentajeCapacidadEspecial) {
        this.porcentajeCapacidadEspecial = porcentajeCapacidadEspecial;
    }

    public boolean isAprobado() {
        return aprobado;
    }
    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    public void calcularPuntajeAdicional() {
        int total = 0;
        if (esAbanderado) {
            total += 5;
        }
        if (afinidadBachillerato) {
            total += 2;
        }
        if (porcentajeCapacidadEspecial >= 35.0) {
            total += 3;
        }
        this.puntajeAdicional = total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Postulante{")
          .append("cedula='").append(cedula).append('\'')
          .append(", nombre='").append(nombre).append('\'')
          .append(", apellido='").append(apellido).append('\'')
          .append(", fechaNacimiento=").append(fechaNacimiento)
          .append(", carreraPostulada=").append(carreraPostulada != null ? carreraPostulada.getNombre() : "Ninguna")
          .append(", puntajeExamen=").append(puntajeExamen)
          .append(", puntajeAdicional=").append(puntajeAdicional)
          .append(", tipoExamen='").append(tipoExamen).append('\'')
          .append(", esAbanderado=").append(esAbanderado)
          .append(", afinidadBachillerato=").append(afinidadBachillerato)
          .append(", porcentajeCapacidadEspecial=").append(porcentajeCapacidadEspecial)
          .append(", aprobado=").append(aprobado)
          .append('}');
        return sb.toString();
    }
}