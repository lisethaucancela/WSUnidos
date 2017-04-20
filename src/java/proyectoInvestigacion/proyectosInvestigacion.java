/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Paola_Cajilema
 */
@WebService(serviceName = "proyectosInvestigacion")
public class proyectosInvestigacion {
    //private ProyectosInvestigacion_Service service;

    /**
     * This is a sample web service operation
     *
     * @return
     */
    @WebMethod(operationName = "loadListaProyectos")
    public swCProyectoss loadListaProyectos() {
        swCProyectoss result;
        ProyectosLN obj = new ProyectosLN();
        result = obj.loadListaProyectos();
        return result;
    }

}
