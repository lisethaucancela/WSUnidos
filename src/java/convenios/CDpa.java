/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;
//
/**
 *
 * @author Liseth
 */
public class CDpa {

    private int IdDpa;
    private CTipoDpa ObjTipoDpa;
    private CDpa ObjPadre;
    private String Descripcion;

    public CDpa() {
    }

    public CDpa(int IdDpa, CTipoDpa ObjTipoDpa, CDpa ObjPadre, String Descripcion) {
        this.IdDpa = IdDpa;
        this.ObjTipoDpa = ObjTipoDpa;
        this.ObjPadre = ObjPadre;
        this.Descripcion = Descripcion;
    }

    public CDpa(int IdDpa, String Descripcion) {
        this.IdDpa = IdDpa;
        this.Descripcion = Descripcion;
    }

    public int getIdDpa() {
        return IdDpa;
    }

    public void setIdDpa(int IdDpa) {
        this.IdDpa = IdDpa;
    }

    public CTipoDpa getObjTipoDpa() {
        return ObjTipoDpa;
    }

    public void setObjTipoDpa(CTipoDpa ObjTipoDpa) {
        this.ObjTipoDpa = ObjTipoDpa;
    }

    public CDpa getObjPadre() {
        return ObjPadre;
    }

    public void setObjPadre(CDpa ObjPadre) {
        this.ObjPadre = ObjPadre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
