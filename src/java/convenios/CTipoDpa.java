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
public class CTipoDpa {
    private int IdTipoDpa;
    private String Descripcion;

    public CTipoDpa() {
    }

    public CTipoDpa(int IdTipoDpa, String Descripcion) {
        this.IdTipoDpa = IdTipoDpa;
        this.Descripcion = Descripcion;
    }

    public int getIdTipoDpa() {
        return IdTipoDpa;
    }

    public void setIdTipoDpa(int IdTipoDpa) {
        this.IdTipoDpa = IdTipoDpa;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
}
