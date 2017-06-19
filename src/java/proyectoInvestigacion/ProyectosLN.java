/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import cvcc.practicas.ad.conexion.AccesoDatos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paola_Cajilema
 */
public class ProyectosLN {

    public swCProyectoss loadListaProyectos(String codidoEntidad) {
        ProyectossAD FAD = new ProyectossAD();
        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            if (accesoDatos.Connectar() == 2) {

                FAD.loadListaProyectos(accesoDatos, codidoEntidad);
                accesoDatos.Desconectar();
            }
        } catch (Exception e) {
            System.out.println("error" + e);
            //
        }
        return FAD;
    }

   

    //loadListaInstitucionesEjecutorasPorProyecto
    public List<swCInstitucionEjecutora> loadListaInstitucionesEjecutorasPorProyecto(int idPractica) {
        ProyectossAD FAD = new ProyectossAD();
        List<swCInstitucionEjecutora> result = new ArrayList<>();
        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            if (accesoDatos.Connectar() == 2) {

                result = FAD.loadListaInstitucionesEjecutorasPorProyecto(accesoDatos, idPractica);
                accesoDatos.Desconectar();
            }
        } catch (Exception e) {
            System.out.println("error" + e);
            //
        }
        return result;
    }
}
