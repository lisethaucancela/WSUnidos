/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Paola_Cajilema
 */
public class swCProyectoss {

    private List<swCProyectos> proyectos;

    public swCProyectoss() {
        this.proyectos = new ArrayList<>();
    }

    public List<swCProyectos> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<swCProyectos> proyectos) {
        this.proyectos = proyectos;
    }

    public void addProyectos(swCProyectos OF) {
        try {
            if (this.proyectos == null) {
                this.proyectos = new ArrayList<>();
            }
            this.proyectos.add(OF);
        } catch (Exception e) {
            Logger.getLogger("CProyectos").severe(e.getMessage());
        }
    }
}
