/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

import com.google.gson.Gson;
import cvcc.practicas.ad.conexion.AccesoDatos;
import java.util.List;

/**
 *
 * @author Liseth
 */
public class EntidadLN {

    public Entidad loadConvenios(int idEntidad) {
        EntidadAD entidadAD = new EntidadAD();
        try {
            AccesoDatos accesoDatos = new AccesoDatos();
            if (accesoDatos.Connectar() == 2) {

                entidadAD.setIdEntidad(idEntidad);
                entidadAD.obtenerListaConvenios(accesoDatos);
                Gson gson = new Gson();
               // String result = gson.toJson(entidadAD);
               
            }

        } catch (Exception exConec) {
            System.err.println("e: " + exConec.getMessage());
        }
        return entidadAD;
    }

}
