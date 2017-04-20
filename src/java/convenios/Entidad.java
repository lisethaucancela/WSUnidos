/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liseth
 */
public class Entidad {

    private int IdEntidad;
    private CTipoEntidad ObjTipoEntidad;
    private Entidad ObjPadre;
    private String Descripcion;
    private List<Convenio> ListConvenios;
    private String Codigo;

    public Entidad() {
    }

    public Entidad(int IdEntidad, CTipoEntidad ObjTipoEntidad, Entidad ObjPadre, String Descripcion, List<Convenio> ListConvenios) {
        this.IdEntidad = IdEntidad;
        this.ObjTipoEntidad = ObjTipoEntidad;
        this.ObjPadre = ObjPadre;
        this.Descripcion = Descripcion;
        this.ListConvenios = ListConvenios;
    }
    

    public List<Convenio> getListConvenios() {
        return ListConvenios;
    }

    public void setListConvenios(List<Convenio> ListConvenios) {
        this.ListConvenios = ListConvenios;
    }

    public int getIdEntidad() {
        return IdEntidad;
    }

    public void setIdEntidad(int IdEntidad) {
        this.IdEntidad = IdEntidad;
    }

    public CTipoEntidad getObjTipoEntidad() {
        return ObjTipoEntidad;
    }

    public void setObjTipoEntidad(CTipoEntidad ObjTipoEntidad) {
        this.ObjTipoEntidad = ObjTipoEntidad;
    }

    public Entidad getObjPadre() {
        return ObjPadre;
    }

    public void setObjPadre(Entidad ObjPadre) {
        this.ObjPadre = ObjPadre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    public void addConvenios(Convenio OP) {
        try {
            if (this.ListConvenios == null) {
                this.ListConvenios = new ArrayList<>();
            }
            this.ListConvenios.add(OP);
        } catch (Exception e) {
            System.out.println("e:" + e.getMessage());
        }
    }

}
