package pa.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import pa.clases.ClaseConexion;

/**
 *
 * @author Usuario
 */
public class ClaseLNPACaracterizacion {

    Integer intCodCaracterizacion;
    ClaseCaracterizacion objCaracterizacion = new ClaseCaracterizacion();

    public ClaseLNPACaracterizacion(String SrtCodCaracterizacion) {
        intCodCaracterizacion = Integer.valueOf(SrtCodCaracterizacion);
    }

    public ClaseCaracterizacion getObjcaracterizacion() throws SQLException {

        ClaseConexion objc = new ClaseConexion();
        if (objc.conectar() != null) {
            String strConsultaSQL = "SELECT * FROM caracterizacion WHERE codprogramaanalitico = 3";
            ResultSet rscaracterizacion = objc.execSQL(strConsultaSQL);
            //controlar el error si no es el codigo
            while (rscaracterizacion.next()) {
                objCaracterizacion.setIntCodCaracterizacion(Integer.parseInt(rscaracterizacion.getString("codcaracterizacion")));
                objCaracterizacion.setIntCodPrograma(Integer.parseInt(rscaracterizacion.getString("codprogramaanalitico")));
                objCaracterizacion.setstrDetalle(rscaracterizacion.getString("detalle"));
            }
        }
//        String d = objcaracterizacion.getstrDetalle();
//        Integer a = objcaracterizacion.getIntCodCaracterizacion();
//        Integer b = objcaracterizacion.getIntCodPrograma();
        return objCaracterizacion;
    }

}
