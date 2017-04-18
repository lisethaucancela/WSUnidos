package pa.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaseLNPAContenidos {

    ClaseContenidos objContenidos = new ClaseContenidos();

    public ClaseLNPAContenidos(String codPrograma) throws SQLException {
//MOSTRAR INFORMACIÓN DE CONTENIDOS DADO UN CÓDIGO DE  PROGRAMA ANALÍTICO
//SELECT * FROM contenido where codprogramaanalitico=3;

//MOSTRAR INFORMACIÓN DE UNIDADES DADO UN CÓDIGO DE CONTENIDO
//SELECT unidades.codunidad, unidades.nombreunidad FROM contenido LEFT JOIN unidades on (unidades.codcontenido = contenido.codcontenido) where (contenido.codcontenido=1);
//MOSTRAR INFORMACIÓN DE TEMAS DADO UN CÓDIGO DE CONTENIDO Y UN CÓDIGO DE UNIDAD
//SELECT temas.codtema, temas.tema FROM contenido LEFT JOIN unidades on (unidades.codcontenido = contenido.codcontenido) LEFT JOIN temas on (unidades.codunidad = temas.codunidad)  where ((contenido.codcontenido=1)and(unidades.codunidad=2));
//MOSTRAR INFORMACIÓN DE SUBTEMAS DADDO UN CÓDIGO DE CONTENIDO, UN CÓDIGO DE UNIDAD Y UN CÓDIGO DE TEMA
//SELECT subtemas.codsubtema, subtemas.subtema FROM contenido LEFT JOIN unidades on (unidades.codcontenido = contenido.codcontenido) LEFT JOIN temas on (unidades.codunidad = temas.codunidad) LEFT JOIN subtemas on (subtemas.codtema = temas.codtema) where ((contenido.codcontenido=1)and(unidades.codunidad=2)and(temas.codtema=1));
        ClaseConexion objc = new ClaseConexion();
        if (objc.conectar() != null) {
            String strInfoContenido = "SELECT * FROM contenido where codprogramaanalitico=" + codPrograma + ";";
            ResultSet rsInfoContenido = objc.execSQL(strInfoContenido);
            rsInfoContenido.next();

            String detalleContenido = rsInfoContenido.getString("detalle");
            String codContenido = rsInfoContenido.getString("codcontenido");
            objContenidos.setDesc(detalleContenido);
            objContenidos.setId(codContenido);

            String strUnidades = "SELECT unidades.codunidad, unidades.nombreunidad FROM contenido LEFT JOIN unidades on (unidades.codcontenido = contenido.codcontenido) where (contenido.codcontenido=" + codContenido + ");";
            ResultSet rsUnidades = objc.execSQL(strUnidades);
            
            List<ClaseUnidad> listaUnidades = new ArrayList<ClaseUnidad>();
            List<ClaseTema> listaTemas = new ArrayList<ClaseTema>();
            //List<ClaseSubtema> listaSubtemas = new ArrayList<ClaseSubtema>();

            while (rsUnidades.next()) {
                String codUnidad = rsUnidades.getString("codunidad");
                String strTemas = "SELECT temas.codtema, temas.tema FROM contenido LEFT JOIN unidades on (unidades.codcontenido = contenido.codcontenido) LEFT JOIN temas on (unidades.codunidad = temas.codunidad)  where ((contenido.codcontenido=" + codContenido + ")and(unidades.codunidad=" + codUnidad + "));";
                ResultSet rsTemas = objc.execSQL(strTemas);

                ClaseUnidad objUnidad = new ClaseUnidad();
                
                objUnidad.setId(rsUnidades.getString("codunidad"));
                objUnidad.setDesc(rsUnidades.getString("nombreunidad"));
                
                listaTemas.clear();
                while (rsTemas.next()) {
                    //String codTema = rsTemas.getString("codtema");
                    //String strSubtemas = "SELECT subtemas.codsubtema, subtemas.subtema FROM contenido LEFT JOIN unidades on (unidades.codcontenido = contenido.codcontenido) LEFT JOIN temas on (unidades.codunidad = temas.codunidad) LEFT JOIN subtemas on (subtemas.codtema = temas.codtema) where ((contenido.codcontenido=" + codContenido + ")and(unidades.codunidad=" + codUnidad + ")and(temas.codtema=" + codTema + "));";
                    //ResultSet rsSubtemas = objc.execSQL(strSubtemas);

                    ClaseTema objTema = new ClaseTema();
                    
                    objTema.setId(rsTemas.getString("codtema"));
                    objTema.setDesc(rsTemas.getString("tema"));
                    
                    listaTemas.add(objTema);

                    //while (rsSubtemas.next()) {
                    //    ClaseSubtema objSubtema = new ClaseSubtema();
                    //}                     
                }
                objUnidad.setTemas(listaTemas);
                listaUnidades.add(objUnidad);
                
            }
            objContenidos.setUnidades(listaUnidades);
        }
    }

    public ClaseContenidos getObjContenidos() {
        return objContenidos;
    }
}