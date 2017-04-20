/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import cvcc.practicas.ad.conexion.AccesoDatos;



/**
 *
 * @author Paola_Cajilema
 */
public class ProyectosLN {

    public swCProyectoss loadListaProyectos() {
        ProyectossAD FAD = new ProyectossAD();
        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            if (accesoDatos.Connectar() == 2) {

                FAD.loadListaProyectos(accesoDatos);
                accesoDatos.Desconectar();
            }
        } catch (Exception e) {
            System.out.println("error" + e);
            //
        }
        return FAD;
    }

}
