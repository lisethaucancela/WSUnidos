/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paola_Cajilema
 */
public class swCProyectos {

    private int id;
    private String nombre;
    private String fecha_inicio;
    private String fecha_fin;
    private swCUsuario objUsuario;
    private swCTipoInvestigacion objTipoInvestigacion;
    private swCTipoProyecto objTipoProyecto;
    private swCEstadoProyecto objEstadoProyecto;
    private List<swCInstitucionEjecutora> lstInstitucionEjecutora;

    public swCProyectos() {

        this.id = -1;
        this.nombre = "";
        this.fecha_inicio = "";
        this.fecha_fin = "";
        this.objUsuario = new swCUsuario();
        this.objTipoInvestigacion = new swCTipoInvestigacion();
        this.objTipoProyecto = new swCTipoProyecto();
        this.objEstadoProyecto = new swCEstadoProyecto();
        this.lstInstitucionEjecutora = new ArrayList<>();

    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public swCUsuario getObjUsuario() {
        return objUsuario;
    }

    public void setObjUsuario(swCUsuario objUsuario) {
        this.objUsuario = objUsuario;
    }

    public swCTipoInvestigacion getObjTipoInvestigacion() {
        return objTipoInvestigacion;
    }

    public void setObjTipoInvestigacion(swCTipoInvestigacion objTipoInvestigacion) {
        this.objTipoInvestigacion = objTipoInvestigacion;
    }

    public swCTipoProyecto getObjTipoProyecto() {
        return objTipoProyecto;
    }

    public void setObjTipoProyecto(swCTipoProyecto objTipoProyecto) {
        this.objTipoProyecto = objTipoProyecto;
    }

    public swCEstadoProyecto getObjEstadoProyecto() {
        return objEstadoProyecto;
    }

    public void setObjEstadoProyecto(swCEstadoProyecto objEstadoProyecto) {
        this.objEstadoProyecto = objEstadoProyecto;
    }

    public List<swCInstitucionEjecutora> getLstInstitucionEjecutora() {
        return lstInstitucionEjecutora;
    }

    public void setLstInstitucionEjecutora(List<swCInstitucionEjecutora> lstInstitucionEjecutora) {
        this.lstInstitucionEjecutora = lstInstitucionEjecutora;
    }

}
