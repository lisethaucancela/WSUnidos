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
public class CSectorEconomico {
    private int IdSectorEconomico;
    private String Descripcion;

    public CSectorEconomico() {
    }

    public CSectorEconomico(int IdSectorEconomico, String Descripcion) {
        this.IdSectorEconomico = IdSectorEconomico;
        this.Descripcion = Descripcion;
    }

    public int getIdSectorEconomico() {
        return IdSectorEconomico;
    }

    public void setIdSectorEconomico(int IdSectorEconomico) {
        this.IdSectorEconomico = IdSectorEconomico;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
