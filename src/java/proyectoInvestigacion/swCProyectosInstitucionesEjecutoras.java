/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

/**
 *
 * @author Paola_Cajilema
 */
public class swCProyectosInstitucionesEjecutoras {

    private int id;
    private int idInstitucionesEjecutoras;
    private int idProyecto;

    public swCProyectosInstitucionesEjecutoras() {
        this.id = -1;
        this.idInstitucionesEjecutoras = -1;
        this.idProyecto = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdInstitucionesEjecutoras() {
        return idInstitucionesEjecutoras;
    }

    public void setIdInstitucionesEjecutoras(int idInstitucionesEjecutoras) {
        this.idInstitucionesEjecutoras = idInstitucionesEjecutoras;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

}
