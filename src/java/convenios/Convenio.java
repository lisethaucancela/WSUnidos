/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

import java.sql.Date;

/**
 *
 * @author Liseth
 */
public class Convenio {

    private int IdConvenio;
    private CEmpresa ObjEmpresa;
    private String Descripcion;
    private Date FechaInicio;
    private Date FechaFin;
    private boolean estado;

    public Convenio() {
    }

    public Convenio(int IdConvenio, CEmpresa ObjEmpresa, String Descripcion, Date FechaInicio, Date FechaFin, boolean estado) {
        this.IdConvenio = IdConvenio;
        this.ObjEmpresa = ObjEmpresa;
        this.Descripcion = Descripcion;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.estado = estado;
    }

   

    public int getIdConvenio() {
        return IdConvenio;
    }

    public void setIdConvenio(int IdConvenio) {
        this.IdConvenio = IdConvenio;
    }

    public CEmpresa getObjEmpresa() {
        return ObjEmpresa;
    }

    public void setObjEmpresa(CEmpresa ObjEmpresa) {
        this.ObjEmpresa = ObjEmpresa;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

  

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
