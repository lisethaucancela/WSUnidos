/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

/**
 *
 * @author Liseth
 */
public class CTipoEntidad {

    private int IdTipoEntidad;
    private String Descripcion;

    public CTipoEntidad() {
    }

    public CTipoEntidad(int IdTipoEntidad, String Descripcion) {
        this.IdTipoEntidad = IdTipoEntidad;
        this.Descripcion = Descripcion;
    }

    public CTipoEntidad(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    
    public int getIdTipoEntidad() {
        return IdTipoEntidad;
    }

    public void setIdTipoEntidad(int IdTipoEntidad) {
        this.IdTipoEntidad = IdTipoEntidad;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
