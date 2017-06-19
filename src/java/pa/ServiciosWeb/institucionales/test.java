/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.ServiciosWeb.institucionales;

import ec.edu.espoch.academico.ArrayOfFacultad;

/**
 *
 * @author Paola_Cajilema
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayOfFacultad objFacu = serviciosEspoch.getFacultadesTotales();
        for (int i = 0; i < objFacu.getFacultad().size(); i++) {
            System.out.println(objFacu.getFacultad().get(i).getNombre());
        }

    }
}
