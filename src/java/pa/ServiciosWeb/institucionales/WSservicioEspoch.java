/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.ServiciosWeb.institucionales;

import convenios.Convenio;
import convenios.Entidad;
import convenios.EntidadLN;
import ec.edu.espoch.academico.ArrayOfDictadoMateria;
import ec.edu.espoch.academico.ArrayOfFacultad;
import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.ArrayOfPeriodo;
import ec.edu.espoch.academico.Persona;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import misserviciosinfocarrera.WsInfoCarrera_Service;
import misserviciosinfogeneral.WsInfoGeneral_Service;

/**
 *
 * @author Paola_Cajilema
 */
@WebService(serviceName = "WSservicioEspoch")
public class WSservicioEspoch {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsEspochInfoGeneral/wsInfoGeneral.wsdl")
    private WsInfoGeneral_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsEspochInfoCarrera/wsInfoCarrera.wsdl")
    private WsInfoCarrera_Service service;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "MallaCurricularPensumVigenteSinDescripcion")
    public ArrayOfMateriaPensum MallaCurricularPensumVigenteSinDescripcion(@WebParam(name = "strCodCarrera") String strCodCarrera) {
        return serviciosEspoch.getMallaCurricularPensumVigenteSinDescripcion(strCodCarrera);
    }

    @WebMethod(operationName = "DictadosMateria")
    public ArrayOfDictadoMateria DictadosMateria(@WebParam(name = "strCodCarrera") String strCodCarrera, @WebParam(name = "strCodMateria") String strCodMateria) {
        return serviciosEspoch.getDictadosMateria(strCodCarrera, strCodMateria);

    }

    @WebMethod(operationName = "DatosUsuarioCarrera")
    public Persona DatosUsuarioCarrera(@WebParam(name = "strCodCarrera") String strCodCarrera, @WebParam(name = "strCedula") String strCedula) {
        return serviciosEspoch.getDatosUsuarioCarrera(strCodCarrera, strCedula);
    }
    
     @WebMethod(operationName = "FacultadesTotales")
    public ArrayOfFacultad FacultadesTotales() {
        return serviciosEspoch.getFacultadesTotales();
    }

    @WebMethod(operationName = "DatosPeriodo")
    public ArrayOfPeriodo DatosPeriodo() {
        return serviciosEspoch.getPeriodosAcademicos();
    }

    @WebMethod(operationName = "Convenios")
    public Entidad Convenios(@WebParam(name = "idEntidad") int idEntidad) {
        Entidad result;
        EntidadLN entidadln = new EntidadLN();
        result = entidadln.loadConvenios(idEntidad);
        return result;
    }

}
