/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import java.util.List;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Paola_Cajilema
 */
@WebService(serviceName = "WSProyectosInvestigacion")
public class WSProyectosInvestigacion {
    //private ProyectosInvestigacion_Service service;

    /**
     * This is a sample web service operation
     *
     * @return
     */
    @WebMethod(operationName = "loadListaProyectosPorEntidad")
    public swCProyectoss loadListaProyectosPorEntidad(@WebParam(name = "codidoEntidad") String codidoEntidad) {
        swCProyectoss result;
        ProyectosLN obj = new ProyectosLN();
        result = obj.loadListaProyectos(codidoEntidad);
        return result;
    }

    @WebMethod(operationName = "loadListaInstitucionesEjecutorasPorProyecto")
    public List<swCInstitucionEjecutora> loadListaInstitucionesEjecutorasPorProyecto(@WebParam(name = "idPractica") int idPractica) {
        List<swCInstitucionEjecutora> result = new ArrayList<>();
        ProyectosLN obj = new ProyectosLN();
        result = obj.loadListaInstitucionesEjecutorasPorProyecto(idPractica);
        return result;
    }

}
