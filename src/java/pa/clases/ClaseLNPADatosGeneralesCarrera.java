package pa.clases;

import ec.edu.espoch.academico.EscuelaEntidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static pa.ServiciosWeb.institucionales.serviciosEspoch.getEscuelaEntidad;

public class ClaseLNPADatosGeneralesCarrera extends Thread {

    String asignatura, escuela;
    ClasePADatosGenerales datosGenerales;

    @Override
    public void run() {
        try {
            this.llenarDatosGeneralesCarrera();
        } catch (SQLException ex) {
            Logger.getLogger(ClaseLNPADatosGeneralesCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ClaseLNPADatosGeneralesCarrera(ClasePADatosGenerales datosGenerales2) {
        this.asignatura = datosGenerales2.getCodigoMateria();
        this.escuela = datosGenerales2.getCodigoEscuela();
        this.datosGenerales = datosGenerales2;
    }

    private void llenarDatosGeneralesCarrera() throws SQLException {
        Integer contador2 = 0;
        Boolean existe2 = false;

        List<EscuelaEntidad> listaEscuelas = getEscuelaEntidad().getEscuelaEntidad();
        Integer nEscuelas = listaEscuelas.size();
        while (existe2 == false && contador2 < nEscuelas) {
            EscuelaEntidad escu = listaEscuelas.get(contador2);
            if (escu.getCodEscuela().equals(escuela)) {
                datosGenerales.setFacultad(escu.getFacultad());
                datosGenerales.setEscuela(escu.getEscuela());
                datosGenerales.setCarrera(escu.getCarrera());
                try {
                    ClaseConexion c = new ClaseConexion();
                    if (c.conectar() != null) {
                        String strConsultaSQL = "SELECT * FROM (carrera inner join sede on carrera.codsede=sede.codsede and codescuela='" + escuela + "');";
                        ResultSet rsobjetivo = c.execSQL(strConsultaSQL);
                        while (rsobjetivo.next()) {
                            datosGenerales.setSede(rsobjetivo.getString("nombresede"));
                            datosGenerales.setModalidad(rsobjetivo.getString("modalidad"));
                        }
                    }
                } catch (Exception e) {
                    datosGenerales.setSede("");
                    datosGenerales.setModalidad("");
                }
                existe2 = true;
            }
            contador2++;
        }
    }

    public ClasePADatosGenerales getDatosGenerales() {
        try {
            llenarDatosGeneralesCarrera();
        } catch (Exception e) {
            datosGenerales = null;
        }
        return datosGenerales;
    }

}
