/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

//import cvcc.practicas.entidades.CFuncionario;
import cvcc.practicas.ad.conexion.AccesoDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Paola_Cajilema
 */
public class ProyectossAD extends swCProyectoss {

    public ProyectossAD() {
    }

    public void loadListaProyectos(AccesoDatos accesoDatos) throws SQLException, ParseException {
        // generate a list with functionary by enterprise's code
        String strSQL2 = "SELECT \n"
           + "  _proyectos.id_proyecto, \n"
           + "  _proyectos.nombre_proyecto, \n"
           + "  _proyectos.fecha_inicio, \n"
           + "  _proyectos.fecha_fin, \n"
           + "  _usuarios.nombresapellidos, \n"
           + "  _tipo_investigacion.descripcion, \n"
           + "  _tipo_proyecto.descripcion, \n"
           + "  _estado_proyectos.descripcion\n"
           + "FROM \n"
           + "  practicas._estado_proyectos,  \n"
           + "  practicas._proyectos, \n"
           + "  practicas._tipo_investigacion, \n"
           + "  practicas._tipo_proyecto, \n"
           + "  practicas._usuarios \n"
           + "WHERE \n"
           + "  _estado_proyectos.id_estado_proyecto = _proyectos.id_estado_proyecto AND\n"
           + "  _tipo_investigacion.id_tipo_investigacion = _proyectos.id_tipo_investigacion AND\n"
           + "  _tipo_proyecto.id_tipo_proyecto = _proyectos.id_tipo_proyecto AND\n"
           + "  _usuarios.id_usuarios = _proyectos.id_investigador_responsable ;";
        if (accesoDatos.EjecutarSQL(strSQL2) == 1) {
            ResultSet rslDatos = accesoDatos.getRs();

            while (rslDatos.next()) {

                swCProyectos objetoProyecto = new swCProyectos();
                objetoProyecto.setId(rslDatos.getInt(1));
                objetoProyecto.setNombre(rslDatos.getString(2));

                Date fecha = (rslDatos.getDate(3));
                Date fecha1 = (rslDatos.getDate(4));
                java.sql.Date sqlDate = new java.sql.Date(rslDatos.getDate(3).getTime());
                java.sql.Date sqlDate2 = new java.sql.Date(rslDatos.getDate(4).getTime());

                objetoProyecto.setFecha_inicio(sqlDate.toString());
                objetoProyecto.setFecha_fin(sqlDate2.toString());
                swCUsuario objU = new swCUsuario();
                objU.setNombresApellidos(rslDatos.getString(5));
                objetoProyecto.setObjUsuario(objU);
                swCTipoInvestigacion objTI = new swCTipoInvestigacion();
                objTI.setDescripcion(rslDatos.getString(6));
                objetoProyecto.setObjTipoInvestigacion(objTI);
                swCTipoProyecto objTP = new swCTipoProyecto();
                objTP.setDescripcion(rslDatos.getString(7));
                objetoProyecto.setObjTipoProyecto(objTP);
                swCEstadoProyecto objEP = new swCEstadoProyecto();
                objEP.setDescripcion(rslDatos.getString(8));
                objetoProyecto.setObjEstadoProyecto(objEP);

                objetoProyecto.setLstInstitucionEjecutora(loadListaInstitucionesEjecutorasPorProyecto(accesoDatos, rslDatos.getInt(1)));
                getProyectos().add(objetoProyecto);

            }
        }
    }

    public ArrayList<swCInstitucionEjecutora> loadListaInstitucionesEjecutorasPorProyecto(AccesoDatos accesoDatos, int idProyecto) throws SQLException {
        ArrayList<swCInstitucionEjecutora> obj = new ArrayList<>();
        String strSQL2 = "SELECT \n"
           + "  _instituciones_ejecutoras.id_instituciones_ejecutoras,\n"
           + "  _instituciones_ejecutoras.descripcion\n"
           + "FROM \n"
           + "  practicas._instituciones_ejecutoras, \n"
           + "  practicas._proyectos_intituciones_ejecutoras\n"
           + "WHERE \n"
           + "  _proyectos_intituciones_ejecutoras.id_instituciones_ejecutoras = _instituciones_ejecutoras.id_instituciones_ejecutoras AND\n"
           + "   _proyectos_intituciones_ejecutoras.id_proyecto='" + idProyecto + "';";
        if (accesoDatos.EjecutarSQL(strSQL2) == 1) {
            ResultSet rslDatos = accesoDatos.getRs();
            while (rslDatos.next()) {

                swCInstitucionEjecutora objetoProyecto = new swCInstitucionEjecutora();
                objetoProyecto.setId(rslDatos.getInt(1));
                objetoProyecto.setDescripcion(rslDatos.getString(2));
                obj.add(objetoProyecto);
            }
        }
        return obj;

    }
}
