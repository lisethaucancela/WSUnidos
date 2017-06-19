/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.ServiciosWeb.institucionales;

import ec.edu.espoch.academico.ArrayOfDictadoMateria;
import ec.edu.espoch.academico.ArrayOfFacultad;
import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.ArrayOfPeriodo;
import ec.edu.espoch.academico.Persona;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Paola_Cajilema
 */
@WebService(serviceName = "WSservicioEspoch")
public class WSservicioEspoch {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

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

    @WebMethod(operationName = "PeriodosAcademicos")
    public ArrayOfPeriodo PeriodosAcademicos() {
        return serviciosEspoch.getPeriodosAcademicos();
    }
//---SERVICIOS WEB

    //servicios
    @WebMethod(operationName = "FacultadesTotales")
    public ArrayOfFacultad FacultadesTotales() {
        return serviciosEspoch.getFacultadesTotales();
    }

    @WebMethod(operationName = "DatosPeriodo")
    public ArrayOfPeriodo DatosPeriodo() {
        return serviciosEspoch.getPeriodosAcademicos();
    }
    
   
}
