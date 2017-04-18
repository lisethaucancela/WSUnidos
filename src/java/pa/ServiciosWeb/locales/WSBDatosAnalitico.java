package pa.ServiciosWeb.locales;
import com.google.gson.Gson;
import ec.edu.espoch.academico.ArrayOfDictadoMateria;
import ec.edu.espoch.academico.ArrayOfEscuelaEntidad;
import ec.edu.espoch.academico.ArrayOfFacultad;
import ec.edu.espoch.academico.ArrayOfHorarioClaseParalelo;
import ec.edu.espoch.academico.ArrayOfMateria;
import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.ArrayOfMateriasAprobadas;
import ec.edu.espoch.academico.ArrayOfRolCarrera;
import ec.edu.espoch.academico.ArrayOfTitulosDocente;
import ec.edu.espoch.academico.Docente;
import ec.edu.espoch.academico.Estudiante;
import ec.edu.espoch.academico.Facultad;
import ec.edu.espoch.academico.Materia;
import ec.edu.espoch.academico.ParamCarrera;
import ec.edu.espoch.academico.Periodo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceRef;
import misserviciosespochseguridad.WsEspochSeguridad_Service;
import misserviciosinfocarrera.WsInfoCarrera_Service;
import misserviciosinfogeneral.WsInfoGeneral_Service;
import pa.clases.ClaseCaracterizacion;
import pa.clases.ClaseConexion;
import pa.clases.ClaseContenidos;
import pa.clases.ClaseEscuela;
import pa.clases.ClaseFacultad;
import pa.clases.ClaseLNPACaracterizacion;
import pa.clases.ClaseLNPAContenidos;
import pa.clases.ClaseListEscuelas;
import pa.clases.ClaseListFacultades;
import pa.clases.ClaseListRoles;
import pa.clases.ClasePADatosGenerales;
import pa.clases.ClaseProgramaAnalitico;
import pa.clases.ClaseRol;
import pa.clases.ClaseUsuario;
import pa.clases.ClaseLNPADatosGenerales;
import pa.clases.ClaseLNPAMetodologia;
import pa.clases.ClaseLNPAObjetivos;
import pa.clases.ClasePAMetodologia;
import pa.clases.ClasePAObjetivos;
import pa.clases.ClasePerfilDocente;
import pa.clases.personaBorrar;

@WebService(serviceName = "WSBDatosAnalitico")
public class WSBDatosAnalitico {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsEspochSeguridad/wsEspochSeguridad.wsdl")
    private WsEspochSeguridad_Service service;

    @Resource
    WebServiceContext wsCtxt;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsEspochInfoGeneral/wsInfoGeneral.wsdl")
    private WsInfoGeneral_Service service_2;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/wsEspochInfoCarrera/wsInfoCarrera.wsdl")
    private WsInfoCarrera_Service service_1;

    //ENVIAR UNA CEDULA DEVOLVER UNA LISTA CON LOS ROLES
    @WebMethod(operationName = "lDevolverRolesDocente")
    public List<ClaseRol> lDevolverRolesDocente(@WebParam(name = "cedula") String cedula) {
        List<ClaseRol> listaRoles = new ArrayList<>();
        ClaseRol objRol1 = new ClaseRol();
        objRol1.setNombreRol("Admin");
        listaRoles.add(objRol1);
        ClaseRol objRol2 = new ClaseRol();
        objRol2.setNombreRol("Superadmin");
        listaRoles.add(objRol2);

//        List<ClaseRol> listaRoles = null;
//        try {
//            ClaseListRoles objListar = new ClaseListRoles();
//            listaRoles = objListar.devolverRolesUsuario(cedula);
//        } catch (Exception e) {
//        }
        return listaRoles;
    }

    //ENVIAR UNA CÉDULA Y DEVOLVER UN BOOL SI EXISTE O NO EL USUARIO EN NUESTRA BD
    @WebMethod(operationName = "lAutenticarUsuario")
    public Boolean lAutenticarUsuario(@WebParam(name = "cedula") String cedula, @WebParam(name = "password") String password) {
        Boolean existe = false;
        try {
            ClaseUsuario objUsr = new ClaseUsuario();
            ClaseListRoles listaRoles = new ClaseListRoles();
            //existe = (objUsr.existeUsuarioLocal(cedula) && objUsr.existeUsuarioOASIS(cedula, password) && (listaRoles.devolverRolesUsuario(cedula).size()>0));
            existe = (objUsr.existeUsuarioOASIS(cedula, password));
        } catch (Exception e) {
        }
        return existe;
    }

    //ENVIAR EL CÓDIGO DE CARRERA Y DE MATERIA Y DEVOLVER UN PLAN ANALÍTICO
    @WebMethod(operationName = "lDevolverPlanAnalitico")
    public ClaseProgramaAnalitico lDevolverPlanAnalitico(@WebParam(name = "codCarrera") String codCarrera, @WebParam(name = "codMateria") String codMateria) {
        ClaseProgramaAnalitico progAnalitico = null;
        try {
            progAnalitico = new ClaseProgramaAnalitico(codCarrera, codMateria);
        } catch (Exception e) {
        }
        return progAnalitico;
    }

    //ENVIAR UN LISTADO CON TODAS LAS FACULTADES DE LA ESPOCH
    @WebMethod(operationName = "lDevolverFacultades")
    public List<ClaseFacultad> lDevolverFacultades() {
//        List<ClaseFacultad> listaFac = new ArrayList<>();
//        ClaseFacultad objFacultad = new ClaseFacultad();
//        objFacultad.setCodFacultad("FIE");
//        listaFac.add(objFacultad);
//        ClaseFacultad objFacultad2 = new ClaseFacultad();
//        objFacultad2.setCodFacultad("FADE");
//        listaFac.add(objFacultad2);
//        ClaseFacultad objFacultad3 = new ClaseFacultad();
//        objFacultad3.setCodFacultad("CIENCIAS");
//        listaFac.add(objFacultad3);
//        return listaFac;
        ClaseListFacultades listaFacultades = new ClaseListFacultades();
        return (listaFacultades.getFacultades());
    }

    @WebMethod(operationName = "lDevolverEscuelasFacultad")
    public List<ClaseEscuela> lDevolverEscuelasFacultad(@WebParam(name = "codigoFacultad") String facultad) {
        ClaseListEscuelas objLista = new ClaseListEscuelas();
        List<ClaseEscuela> listaEscuelas = objLista.getEscuelas(facultad);
        return (listaEscuelas);
    }

    //ENVIAR EL CÓDIGO DE UNA FACULTAD, DEVOLVER EL ADMINISTRADOR(CLASE USUARIO)
    @WebMethod(operationName = "lDevolverAdminFacultad")
    public ClaseUsuario lDevolverAdminFacultad(@WebParam(name = "codigoFacultad") String facultad) {
        ClaseUsuario admin = null;
        try {
            //Debe consultar a la base de datos y extraer el admin
            ClaseConexion c = new ClaseConexion();
            if (c.conectar() != null) {
                String strConsultaSQL = "SELECT * FROM rolesusuario WHERE ((\"CodEntidad\"='" + facultad + "') AND (idrol=2));";
                ResultSet rsAdmin = c.execSQL(strConsultaSQL);
                rsAdmin.next();

                String strNRegistros = "SELECT COUNT(*) FROM rolesusuario WHERE ((\"CodEntidad\"='" + facultad + "') AND (idrol=2));";
                ResultSet rsNRegistros = c.execSQL(strNRegistros);

                Integer nRegistros = 0;
                while (rsNRegistros.next()) {
                    nRegistros = rsNRegistros.getInt("count");
                }

                if (nRegistros == 1) {
                    String nombreAdmin = getDatosCompletosEstudiante(rsAdmin.getString("cedula")).getNombres() + " " + getDatosCompletosEstudiante(rsAdmin.getString("cedula")).getApellidos();
                    admin = new ClaseUsuario();
                    admin.setCedula(rsAdmin.getString("cedula"));
                    admin.setNombre(nombreAdmin);
                }
            }
        } catch (Exception e) {
        }
        return admin;
    }

    //ENVIAR EL CÓDIGO DE ASIGNATURA Y EL CÓDIGO DE ESCUELA Y DEVOLVER EL PERFIL DOCENTE DE ESA ASIGNATURA
    @WebMethod(operationName = "lPADevolverPerfilDocente")
    public ClasePerfilDocente lPADevolverPerfilDocente(@WebParam(name = "codigoEscuela") String codEscuela, @WebParam(name = "codigoMateria") String codMateria) {
        ClasePerfilDocente objPerfilDocente = null;
        try {
            objPerfilDocente = new ClasePerfilDocente();
            //Recibir los datos de la BD local
            objPerfilDocente.setCampoAmplio("Ingeniero en Sistemas");
            objPerfilDocente.setCampoEspecifico("Matestría en segurdiad informática");
        } catch (Exception e) {
        }
        return objPerfilDocente;

    }

    //****************************************************************************************************************
    // INICIO SERVICIOS WEB ITERACIÓN 5
    //****************************************************************************************************************
    //DEVOLVER DATOS GENERALES DE UN PROGRAMA ANALÍTICO
    @WebMethod(operationName = "lPADevolverDatosGenerales")
    public ClasePADatosGenerales lPADevolverDatosGenerales(@WebParam(name = "codigoEscuela") String codEscuela, @WebParam(name = "codigoAsignatura") String codAsignatura) {
        ClaseLNPADatosGenerales objLN = new ClaseLNPADatosGenerales(codEscuela, codAsignatura);
        ClasePADatosGenerales datosGenerales = null;
        try {
            datosGenerales = objLN.getDatosGenerales();
        } catch (Exception e) {
        }
        return datosGenerales;
    }

    //DEVOLVER CARACTERIZACIÓN DE UN PROGRAMA ANALÍTICO
    @WebMethod(operationName = "lDevolverCaracterizacionPA")
    public ClaseCaracterizacion lDevolverCaracterizacionPA(@WebParam(name = "strCodPrograma") String strCodPrograma) {
        ClaseLNPACaracterizacion objLNC = new ClaseLNPACaracterizacion(strCodPrograma);
        ClaseCaracterizacion ojbCar = new ClaseCaracterizacion();
        try {
            ojbCar = objLNC.getObjcaracterizacion();
        } catch (Exception e) {
        }
        return ojbCar;
    }

    //DEVOLVER OBJETIVOS DE UN PROGRAMA ANALÍTICO
    @WebMethod(operationName = "lDevolverObjetivoPA")
    public ClasePAObjetivos lDevolverObjetivoPA(@WebParam(name = "codigo") String codPrograma) {
        ClaseLNPAObjetivos objLN = new ClaseLNPAObjetivos(codPrograma);
        ClasePAObjetivos Objetivo = null;
        try {
            Objetivo = objLN.getObjetivo();
        } catch (Exception e) {
        }
        return (Objetivo);
    }

    //DEVOLVER METODOLOGIA DE UN PROGRAMA ANALITICO
    @WebMethod(operationName = "lDevolverMetodologia")
    public ClasePAMetodologia lDevolverMetodologia(@WebParam(name = "codigo") String codPrograma) {
        ClaseLNPAMetodologia objLN = new ClaseLNPAMetodologia(codPrograma);
        ClasePAMetodologia Metodologia = null;
        try {
            Metodologia = objLN.getMetodologia();

        } catch (Exception e) {
        }
        return Metodologia;
    }

    @WebMethod(operationName = "lEjemploJson")
    public personaBorrar lEjemploJson(@WebParam(name = "cadena") String cadena) {
        personaBorrar objPersona = null;
        try {
            Gson gson = new Gson();
            objPersona = new personaBorrar();
            objPersona = gson.fromJson(cadena, personaBorrar.class);
        } catch (Exception e) {
        }

        return objPersona;
    }

    //****************************************************************************************************************
    // FIN SERVICIOS WEB ITERACIÓN 5
    //****************************************************************************************************************
    //****************************************************************************************************************
    // INICIO SERVICIOS WEB ITERACIÓN 6
    //****************************************************************************************************************
    //WS QUE DEVUELVE LOS CONTENIDOS DE UN PLAN ANALÍTICO DADO SU CÓDIGO
    @WebMethod(operationName = "lPADevolverContenidos")
    public ClaseContenidos lPADevolverContenidos(@WebParam(name = "codigo") String codPrograma) {
        ClaseContenidos objContenidos = null;
        try {
            ClaseLNPAContenidos objLogica = new ClaseLNPAContenidos(codPrograma);
            objContenidos = objLogica.getObjContenidos();
        } catch (Exception e) {
        }
        return objContenidos;
    }

    //****************************************************************************************************************
    // FIN SERVICIOS WEB ITERACIÓN 6
    //****************************************************************************************************************
//    @WebMethod(operationName = "guardarJson")
//    public Boolean guardarJson() {
//        Boolean exito = false;
//        try {
//            //Instrucciones
//            exito = true;
//        } catch (Exception e) {
//        }
//        return exito;
//    }
    private Estudiante getDatosCompletosEstudiante(java.lang.String strCedula) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getDatosCompletosEstudiante(strCedula);
    }

    private Periodo getPeriodoActual() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfogeneral.WsInfoGeneral port = service_2.getWsInfoGeneralPort();
        return port.getPeriodoActual();
    }

    //**************************************************************************************************************
    // INICIO MÉTODOS WEB FACULTAD ESCUELA ASIGNATURA
    //**************************************************************************************************************
    @WebMethod(operationName = "lPADevolverFacultad")
    public Facultad lPADevolverFacultad(@WebParam(name = "codigoFacultad") String codFacultad) {
        Facultad objFac = null;
        ArrayOfFacultad objFacultades = null;
        try {
            misserviciosinfogeneral.WsInfoGeneral port = service_2.getWsInfoGeneralPort();
            objFacultades = port.getFacultadesTotales();
        } catch (Exception e) {
        }
        return objFac;

    }

    //**************************************************************************************************************
    // FIN MÉTODOS WEB FACULTAD ESCUELA ASIGNATURA
    //**************************************************************************************************************
    //**************************************************************************************************************
    // INICIO MÉTODOS WEB DATOS DEL PROFESOR
    //**************************************************************************************************************
    @WebMethod(operationName = "lPADictadosMateria")
    public ArrayOfDictadoMateria getDictadosMateria(@WebParam(name = "codigoCarrera") java.lang.String codCarrera, @WebParam(name = "codigoAsignatura") java.lang.String codMateria) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getDictadosMateria(codCarrera, codMateria);
    }

    @WebMethod(operationName = "lPATitulosDocentes")
    public ArrayOfTitulosDocente getTitulosDocentes(@WebParam(name = "codigoCarrera") java.lang.String strCodCarrera, @WebParam(name = "cedula") java.lang.String strCedula) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getTitulosDocentes(strCodCarrera, strCedula);
    }

    @WebMethod(operationName = "lPARolUsuarioCarrera")
    private ArrayOfRolCarrera getRolUsuarioCarrera(@WebParam(name = "cedula") java.lang.String login) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosespochseguridad.WsEspochSeguridad port = service.getWsEspochSeguridadPort();
        return port.getRolUsuarioCarrera(login);
    }

    @WebMethod(operationName = "lPAMateriasDocente")
    public ArrayOfMateria getMateriasDocente(@WebParam(name = "codCarrera") java.lang.String codCarrera, @WebParam(name = "cedula") java.lang.String cedula, @WebParam(name = "periodo") java.lang.String codPeriodo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getMateriasDocente(codCarrera, cedula, codPeriodo);
    }

    @WebMethod(operationName = "lPADatosMateria")
    public Materia getDatosMateria(@WebParam(name = "codCarrera") java.lang.String codCarrera, @WebParam(name = "codMateria") java.lang.String codMateria) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getDatosMateria(codCarrera, codMateria);
    }

    @WebMethod(operationName = "lPADictadosMateria_1")
    public ArrayOfDictadoMateria getDictadosMateria_1(@WebParam(name = "codCarrera") java.lang.String codCarrera, @WebParam(name = "codMateria") java.lang.String codMateria) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getDictadosMateria(codCarrera, codMateria);
    }

    @WebMethod(operationName = "lPAMateriasAprobadas")
    public ArrayOfMateriasAprobadas getMateriasAprobadas(@WebParam(name = "codCarrera") java.lang.String strCodCarrera, @WebParam(name = "cedula") java.lang.String strCedula) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getMateriasAprobadas(strCodCarrera, strCedula);
    }

    @WebMethod(operationName = "lPAParametrosCarrera")
    public ParamCarrera getParametrosCarrera(@WebParam(name = "codCarrera") java.lang.String strCodCarrera) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getParametrosCarrera(strCodCarrera);
    }

    private void getMallaCurricularPensumVigente(java.lang.String strCodCarrera, javax.xml.ws.Holder<java.lang.String> pensum, javax.xml.ws.Holder<ec.edu.espoch.academico.ArrayOfMateriaPensum> getMallaCurricularPensumVigenteResult) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        port.getMallaCurricularPensumVigente(strCodCarrera, pensum, getMallaCurricularPensumVigenteResult);
    }

    @WebMethod(operationName = "MallaCurricularPensumVigenteSinDescripcion")
    public ArrayOfMateriaPensum getMallaCurricularPensumVigenteSinDescripcion(@WebParam(name = "codCarrera") java.lang.String strCodCarrera) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getMallaCurricularPensumVigenteSinDescripcion(strCodCarrera);
    }

    @WebMethod(operationName = "DatosDocente")
    public Docente getDatosDocente(@WebParam(name = "codCarrera") java.lang.String codCarrera, @WebParam(name = "cedula") java.lang.String cedula) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getDatosDocente(codCarrera, cedula);
    }

    @WebMethod(operationName = "Titulos")
    ArrayOfTitulosDocente getTitulosDocentes_1(@WebParam(name = "codCarrera") java.lang.String strCodCarrera, @WebParam(name = "cedula") java.lang.String strCedula) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getTitulosDocentes(strCodCarrera, strCedula);
    }

    @WebMethod(operationName = "DatosCompletosEstudiantes")
    public Estudiante getDatosCompletosEstudiante_1(@WebParam(name = "cedula") java.lang.String strCedula) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getDatosCompletosEstudiante(strCedula);
    }

    @WebMethod(operationName = "EscuelaEntidad")
    public ArrayOfEscuelaEntidad getEscuelaEntidad() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfogeneral.WsInfoGeneral port = service_2.getWsInfoGeneralPort();
        return port.getEscuelaEntidad();
    }

    @WebMethod(operationName = "getHorariosDocenteParalelo")
    public ArrayOfHorarioClaseParalelo getHorariosDocenteParalelo(@WebParam(name = "codCarrera") java.lang.String strCodCarrera, @WebParam(name = "cedula") java.lang.String strCedula, @WebParam(name = "codPeriodo") java.lang.String strCodPeriodo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        misserviciosinfocarrera.WsInfoCarrera port = service_1.getWsInfoCarreraPort();
        return port.getHorariosDocenteParalelo(strCodCarrera, strCedula, strCodPeriodo);
    }
//
    
}