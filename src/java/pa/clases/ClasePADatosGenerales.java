package pa.clases;

import java.util.ArrayList;
import java.util.List;

public class ClasePADatosGenerales {        
    String facultad,escuela,carrera,sede,modalidad,asignatura,nivel,campoFormacion,codigoMateria,codigoEscuela;

    public void setCodigoMateria(String codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public void setCodigoEscuela(String codigoEscuela) {
        this.codigoEscuela = codigoEscuela;
    }
    Integer nHorasSemanal;
    Float nCreditos;
    List<String> correquisitos = new ArrayList<>(); 
    List<String>prerequisitos = new ArrayList<>();

    public ClasePADatosGenerales(String codEscuela, String codMateria) {
        this.codigoEscuela = codEscuela;
        this.codigoMateria = codMateria;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public void setCampoFormacion(String campoFormacion) {
        this.campoFormacion = campoFormacion;
    }

    public void setnCreditos(Float nCreditos) {
        this.nCreditos = nCreditos;
    }

    public void setnHorasSemanal(Integer nHorasSemanal) {
        this.nHorasSemanal = nHorasSemanal;
    }

    public void setCorrequisitos(List<String> correquisitos) {
        this.correquisitos = correquisitos;
    }

    public void setPrerequisitos(List<String> prerequisitos) {
        this.prerequisitos = prerequisitos;
    }

    public String getFacultad() {
        return facultad;
    }

    public String getEscuela() {
        return escuela;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSede() {
        return sede;
    }

    public String getModalidad() {
        return modalidad;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getNivel() {
        return nivel;
    }

    public String getCampoFormacion() {
        return campoFormacion;
    }

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public String getCodigoEscuela() {
        return codigoEscuela;
    }

    public Float getnCreditos() {
        return nCreditos;
    }

    public Integer getnHorasSemanal() {
        return nHorasSemanal;
    }

    public List<String> getCorrequisitos() {
        return correquisitos;
    }

    public List<String> getPrerequisitos() {
        return prerequisitos;
    }
    
    
}
