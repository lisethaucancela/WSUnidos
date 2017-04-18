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
public class CTipoEmpresa {
    private int IdTipoEmpresa;
    private String Descripcion;

    public CTipoEmpresa() {
    }

    public CTipoEmpresa(int IdTipoEmpresa, String Descripcion) {
        this.IdTipoEmpresa = IdTipoEmpresa;
        this.Descripcion = Descripcion;
    }
           
    public int getIdTipoEmpresa() {
        return IdTipoEmpresa;
    }

    public void setIdTipoEmpresa(int IdTipoEmpresa) {
        this.IdTipoEmpresa = IdTipoEmpresa;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
}
