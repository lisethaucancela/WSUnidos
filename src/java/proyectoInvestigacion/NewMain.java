/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoInvestigacion;

import java.util.List;

/**
 *
 * @author Paola_Cajilema
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProyectosLN obj = new ProyectosLN();
        // swCProyectoss strProyectos = obj.loadListaProyectos("FIE");
        List<swCInstitucionEjecutora> strProyectos = obj.loadListaInstitucionesEjecutorasPorProyecto(1);
//        System.out.println(strProyectos);

        // TODO code application logic here
    }

}
