/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Liseth
 */
public class CEntidades {

    private List<Entidad> Entidades;

    public CEntidades() {
        this.Entidades = new ArrayList<>();
    }

    public CEntidades(List<Entidad> Entidades) {
        this.Entidades = Entidades;
    }

    public List<Entidad> getEntidades() {
        return Entidades;
    }

    public void setEntidades(List<Entidad> Entidades) {
        this.Entidades = Entidades;
    }

    public void addEntidades(Entidad OF) {
        try {
            if (this.Entidades == null) {
                this.Entidades = new ArrayList<>();
            }
            this.Entidades.add(OF);
        } catch (Exception e) {
            Logger.getLogger("CListEntidades").severe(e.getMessage());
        }
    }

}
