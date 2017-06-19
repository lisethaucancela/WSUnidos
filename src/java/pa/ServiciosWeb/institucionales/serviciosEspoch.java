package pa.ServiciosWeb.institucionales;

import ec.edu.espoch.academico.Acta;
import ec.edu.espoch.academico.ActaCalGrado;
import ec.edu.espoch.academico.ArrayOfActaNotasEscritasGrado;
import ec.edu.espoch.academico.ArrayOfActasNotasOralesGrado;
import ec.edu.espoch.academico.ArrayOfCarrera;
import ec.edu.espoch.academico.ArrayOfCarreraTitulos;
import ec.edu.espoch.academico.ArrayOfCiudad;
import ec.edu.espoch.academico.ArrayOfConvalidacion;
import ec.edu.espoch.academico.ArrayOfDatosGrado;
import ec.edu.espoch.academico.ArrayOfDatosInscritosInstSexo;
import ec.edu.espoch.academico.ArrayOfDictadoMateria;
import ec.edu.espoch.academico.ArrayOfEscuela;
import ec.edu.espoch.academico.ArrayOfEscuelaEntidad;
import ec.edu.espoch.academico.ArrayOfEstudiante;
import ec.edu.espoch.academico.ArrayOfFacultad;
import ec.edu.espoch.academico.ArrayOfHorarioClase;
import ec.edu.espoch.academico.ArrayOfHorarioClaseParalelo;
import ec.edu.espoch.academico.ArrayOfHorarioDocente;
import ec.edu.espoch.academico.ArrayOfHorarioEstudiante;
import ec.edu.espoch.academico.ArrayOfHorarioExamenesEstudiante;
import ec.edu.espoch.academico.ArrayOfInscripcion;
import ec.edu.espoch.academico.ArrayOfInstitucionEstudiante;
import ec.edu.espoch.academico.ArrayOfMateria;
import ec.edu.espoch.academico.ArrayOfMateriaParalelo;
import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.ArrayOfMateriasAprobadas;
import ec.edu.espoch.academico.ArrayOfMateriasCre;
import ec.edu.espoch.academico.ArrayOfMateriasNoAprobadas;
import ec.edu.espoch.academico.ArrayOfMateriasR;
import ec.edu.espoch.academico.ArrayOfNotas;
import ec.edu.espoch.academico.ArrayOfPais;
import ec.edu.espoch.academico.ArrayOfParametro;
import ec.edu.espoch.academico.ArrayOfPeriodo;
import ec.edu.espoch.academico.ArrayOfPromocionesEst;
import ec.edu.espoch.academico.ArrayOfProvincia;
import ec.edu.espoch.academico.ArrayOfRolCarrera;
import ec.edu.espoch.academico.ArrayOfTiposInstituciones;
import ec.edu.espoch.academico.ArrayOfTitulosDocente;
import ec.edu.espoch.academico.ArrayOfTitulosEst;
import ec.edu.espoch.academico.ArrayOfTodasMatriculaEstudiantes;
import ec.edu.espoch.academico.ArrayOfUnidadAcademica;
import ec.edu.espoch.academico.Docente;
import ec.edu.espoch.academico.Estudiante;
import ec.edu.espoch.academico.InscripcionGratuidad;
import ec.edu.espoch.academico.Materia;
import ec.edu.espoch.academico.Matricula;
import ec.edu.espoch.academico.ParamCarrera;
import ec.edu.espoch.academico.Periodo;
import ec.edu.espoch.academico.Persona;

public class serviciosEspoch {

    public serviciosEspoch() {
    }

//    public static void main(String[] args) {        
//        //SERVICIO WEB 1
//        Estudiante objEstudiante = getDatosCompletosEstudiante("060336496-9");
//        System.out.println(objEstudiante.getNombres());
//        
//        Holder<String> p = new Holder<>();    //Pensum
//        Holder<ArrayOfMateriaPensum> m = new Holder<>();      //Malla
//        
//        getMallaCurricularPensumVigente("EIS",p,m);
//        
//        
//        System.out.println(m.value.getMateriaPensum().get(10).getArea());
//     
//        System.out.println(p.value);
//        
//        System.out.println(m.value.getMateriaPensum().size());
//        
//        
//        ArrayOfFacultad objFacultad = getTodasFacultades();
//        for(int n=0; n<objFacultad.getFacultad().size(); n++){
//            System.out.println(objFacultad.getFacultad().get(n).getNombre());            
//        }
//       
//        
//        //SERVICIO WEB 2
//        ArrayOfCarrera objCarrera = getCarrerasAbiertas();
//        for (int i = 0; i <= 49; i++) {
//        //    System.out.println(objCarrera.getCarrera().get(i).getNombre());
//        }
//        
//        //SERVICIO WEB 3
//        ArrayOfRolCarrera objUsr = getRolUsuarioCarrera("060336496-9");
//        System.out.println(objUsr.getRolCarrera().get(0).getNombreRol());
//        System.out.println(objUsr.getRolCarrera().get(1).getNombreRol());
//        System.out.println(objUsr.getRolCarrera().get(2).getNombreRol());
//        System.out.println(objUsr.getRolCarrera().get(3).getNombreRol());
//
//        Docente objDocente = getDatosDocente("EIS","060336496-9");
//        System.out.println(objDocente.getApellidos());
//        
    //}
    //**************************************************************************
    //WS 1 INFO CARRERA
    //**************************************************************************
    public static Acta getActaGradoEstudiante(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodTitulo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getActaGradoEstudiante(strCodCarrera, strCedula, strCodTitulo);
    }

    public static ArrayOfEstudiante getAlumnosMateria(java.lang.String strCodCarrera, java.lang.String strCodNivel, java.lang.String strCodParalelo, java.lang.String strCodPeriodo, java.lang.String strCodMateria) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getAlumnosMateria(strCodCarrera, strCodNivel, strCodParalelo, strCodPeriodo, strCodMateria);
    }

    public static ArrayOfConvalidacion getConvalidaciones(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getConvalidaciones(strCodCarrera, strCedula);
    }

    public static double getCreditosAprobadosCS(java.lang.String codCarrera, java.lang.String cedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getCreditosAprobadosCS(codCarrera, cedula);
    }

    public static Estudiante getDatosCompletosEstudiante(java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosCompletosEstudiante(strCedula);
    }

    public static Docente getDatosDocente(java.lang.String codCarrera, java.lang.String cedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosDocente(codCarrera, cedula);
    }

    public static Persona getDatosEstudianteMatriculado(java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosEstudianteMatriculado(strCedula);
    }

    public static ArrayOfDatosInscritosInstSexo getDatosInscInstSexo(java.lang.String strPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosInscInstSexo(strPeriodo);
    }

    public static Materia getDatosMateria(java.lang.String codCarrera, java.lang.String codMateria) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosMateria(codCarrera, codMateria);
    }

    public static Matricula getDatosMatricula(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosMatricula(strCodCarrera, strCedula, strCodPeriodo);
    }

    public static Persona getDatosUsuarioCarrera(java.lang.String codCarrera, java.lang.String cedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDatosUsuarioCarrera(codCarrera, cedula);
    }

    public static ArrayOfDictadoMateria getDictadosMateria(java.lang.String codCarrera, java.lang.String codMateria) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getDictadosMateria(codCarrera, codMateria);
    }

    public static String getEstadoEstudianteCarrera(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getEstadoEstudianteCarrera(strCodCarrera, strCedula);
    }

    public static ArrayOfActaNotasEscritasGrado getEvaluacionesEscritasGrado(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodTitulo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getEvaluacionesEscritasGrado(strCodCarrera, strCedula, strCodTitulo);
    }

    public static ArrayOfActasNotasOralesGrado getEvaluacionesOralGrado(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodTitulo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getEvaluacionesOralGrado(strCodCarrera, strCedula, strCodTitulo);
    }

    public static ArrayOfDatosGrado getGradosEstudiante(java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getGradosEstudiante(strCedula);
    }

    public static ArrayOfHorarioDocente getHorarioDocente(java.lang.String codCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getHorarioDocente(codCarrera, strCedula);
    }

    public static ArrayOfHorarioEstudiante getHorarioEstudiante(java.lang.String codCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getHorarioEstudiante(codCarrera, strCedula);
    }

    public static ArrayOfHorarioExamenesEstudiante getHorarioExamenesEstudiante(java.lang.String strCodCarrera, java.lang.String strCodPeriodo, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getHorarioExamenesEstudiante(strCodCarrera, strCodPeriodo, strCedula);
    }

    public static ArrayOfHorarioClase getHorariosDocente(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getHorariosDocente(strCodCarrera, strCedula, strCodPeriodo);
    }

    public static ArrayOfHorarioClaseParalelo getHorariosDocenteParalelo(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getHorariosDocenteParalelo(strCodCarrera, strCedula, strCodPeriodo);
    }

    public static ActaCalGrado getInfoGeneralGradoEstudiante(java.lang.String strCodCarrera, java.lang.String strCedula, java.lang.String strCodTitulo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getInfoGeneralGradoEstudiante(strCodCarrera, strCedula, strCodTitulo);
    }

    public static InscripcionGratuidad getInscripcionGratuidad(java.lang.String strCedula, java.lang.String strCodCarrera) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getInscripcionGratuidad(strCedula, strCodCarrera);
    }

    public static ArrayOfInscripcion getInscripcionesEstudiante(java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getInscripcionesEstudiante(strCedula);
    }

    public static ArrayOfInscripcion getInscripcionesEstudianteNoActivados(java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getInscripcionesEstudianteNoActivados(strCedula);
    }

    public static void getMallaCurricularPensumVigente(java.lang.String strCodCarrera, javax.xml.ws.Holder<java.lang.String> pensum, javax.xml.ws.Holder<ec.edu.espoch.academico.ArrayOfMateriaPensum> getMallaCurricularPensumVigenteResult) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        port.getMallaCurricularPensumVigente(strCodCarrera, pensum, getMallaCurricularPensumVigenteResult);
    }

    public static ArrayOfMateriaPensum getMallaCurricularPensumVigenteSinDescripcion(java.lang.String strCodCarrera) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMallaCurricularPensumVigenteSinDescripcion(strCodCarrera);
    }

    public static ArrayOfMateriasAprobadas getMateriasAprobadas(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasAprobadas(strCodCarrera, strCedula);
    }

    public static ArrayOfMateria getMateriasDocente(java.lang.String codCarrera, java.lang.String cedula, java.lang.String codPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasDocente(codCarrera, cedula, codPeriodo);
    }

    public static ArrayOfMateria getMateriasEstudiante(java.lang.String codCarrera, java.lang.String cedula, java.lang.String codPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasEstudiante(codCarrera, cedula, codPeriodo);
    }

    public static ArrayOfMateriasCre getMateriasEstudianteCreditos(java.lang.String codCarrera, java.lang.String cedula, java.lang.String codPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasEstudianteCreditos(codCarrera, cedula, codPeriodo);
    }

    public static ArrayOfMateriasNoAprobadas getMateriasNoAprobadas(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasNoAprobadas(strCodCarrera, strCedula);
    }

    public static ArrayOfMateriaParalelo getMateriasParaleloEstudiante(java.lang.String codCarrera, java.lang.String cedula, java.lang.String codPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasParaleloEstudiante(codCarrera, cedula, codPeriodo);
    }

    public static ArrayOfMateriasR getMateriasReprobados(java.lang.String strCodCarrera, java.lang.String strcedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getMateriasReprobados(strCodCarrera, strcedula);
    }

    public static ParamCarrera getParametrosCarrera(java.lang.String strCodCarrera) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getParametrosCarrera(strCodCarrera);
    }

    public static ArrayOfParametro getParametrosCarreraTotal(java.lang.String strCodCarrera) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getParametrosCarreraTotal(strCodCarrera);
    }

    public static ArrayOfPromocionesEst getPromocionesEstudiante(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getPromocionesEstudiante(strCodCarrera, strCedula);
    }

    public static ArrayOfCarreraTitulos getTitulosCarrera(java.lang.String strCodCarrera) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getTitulosCarrera(strCodCarrera);
    }

    public static ArrayOfTitulosDocente getTitulosDocentes(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getTitulosDocentes(strCodCarrera, strCedula);
    }

    public static ArrayOfTitulosEst getTitulosEstudiante(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getTitulosEstudiante(strCodCarrera, strCedula);
    }

    public static ArrayOfTodasMatriculaEstudiantes getTodasMatriculaEstudiantes(java.lang.String strCodCarrera, java.lang.String strCodPeriodo) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getTodasMatriculaEstudiantes(strCodCarrera, strCodPeriodo);
    }

    public static ArrayOfNotas getUltimasNotasEstudianteCarrera(java.lang.String strCodCarrera, java.lang.String strCedula) {
        misserviciosinfocarrera.WsInfoCarrera_Service service = new misserviciosinfocarrera.WsInfoCarrera_Service();
        misserviciosinfocarrera.WsInfoCarrera port = service.getWsInfoCarreraPort();
        return port.getUltimasNotasEstudianteCarrera(strCodCarrera, strCedula);
    }

    //**************************************************************************
    //WS 2 INFO GENERAL
    //**************************************************************************
    public static ArrayOfCarrera getCarrerasAbiertas() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getCarrerasAbiertas();
    }

    public static ArrayOfCiudad getCiudades() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getCiudades();
    }

    public static ArrayOfEscuelaEntidad getEscuelaEntidad() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getEscuelaEntidad();
    }

    public static ArrayOfInstitucionEstudiante getInstitucionEstudiante(java.lang.String strcedula) {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getInstitucionEstudiante(strcedula);
    }

    public static ArrayOfPais getPaises() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getPaises();
    }

    public static Periodo getPeriodoActual() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getPeriodoActual();
    }

    public static ArrayOfPeriodo getPeriodosAcademicos() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getPeriodosAcademicos();
    }

    public static ArrayOfProvincia getProvincias() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getProvincias();
    }

    public static ArrayOfTiposInstituciones getTiposInstituciones() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTiposInstituciones();
    }

    public static ArrayOfUnidadAcademica getTodasCarreras() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTodasCarreras();
    }

    public static ArrayOfUnidadAcademica getTodasCarrerasTotales() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTodasCarrerasTotales();
    }

    public static ArrayOfEscuela getTodasEscuelas() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTodasEscuelas();
    }

    public static ArrayOfEscuela getTodasEscuelasTotales() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTodasEscuelasTotales();
    }

    public static ArrayOfFacultad getTodasFacultades() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTodasFacultades();
    }

    //**************************************************************************
    //WS 3 SEGURIDAD
    //**************************************************************************        
    public static ArrayOfRolCarrera autenticarUsuarioCarrera(java.lang.String login, java.lang.String password) {
        misserviciosespochseguridad.WsEspochSeguridad_Service service = new misserviciosespochseguridad.WsEspochSeguridad_Service();
        misserviciosespochseguridad.WsEspochSeguridad port = service.getWsEspochSeguridadPort();
        return port.autenticarUsuarioCarrera(login, password);
    }

    public static ArrayOfRolCarrera getRolUsuarioCarrera(java.lang.String login) {
        misserviciosespochseguridad.WsEspochSeguridad_Service service = new misserviciosespochseguridad.WsEspochSeguridad_Service();
        misserviciosespochseguridad.WsEspochSeguridad port = service.getWsEspochSeguridadPort();
        return port.getRolUsuarioCarrera(login);
    }

    public static Persona getUsuarioFacultad(java.lang.String login, java.lang.String password) {
        misserviciosespochseguridad.WsEspochSeguridad_Service service = new misserviciosespochseguridad.WsEspochSeguridad_Service();
        misserviciosespochseguridad.WsEspochSeguridad port = service.getWsEspochSeguridadPort();
        return port.getUsuarioFacultad(login, password);
    }

    public static ArrayOfFacultad getFacultadesTotales() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getFacultadesTotales();
    }

}
