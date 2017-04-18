package pa.clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseConexion {
    private Connection conex;

    public ClaseConexion(){
        conex = null;        
    }
    
    public Connection conectar(){        
        //vi /var/lib/pgsql/data/pg_hba.conf
        String cadena = "jdbc:postgresql://192.168.253.131:5432/BDAnalitico";
        String user = "postgres";
        String pass = "espoch";
        
        try {
            Class.forName("org.postgresql.Driver");
            conex = DriverManager.getConnection(cadena,user,pass);            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger("ClaseConexion").log(Level.SEVERE, "Error al intentar conectarse a la BD", ex);
        }
        return conex;
    }
    
    //EJECUTAR CONSULTAS
    public ResultSet execSQL(String instruccionSQL) {
        ResultSet result = null;
        try {
            Statement stt = conex.createStatement();
            result = stt.executeQuery(instruccionSQL);
        } catch (SQLException ex) {
            Logger.getLogger("ClaseConexion").log(Level.SEVERE, "Error al ejecutar la consultaSQL", ex);
        }
        return result;
    }

    //EJECUTAR INSTRUCCIONES UPDATE
    public Integer execUPD(String instruccionSQL) {
        Integer result = null;
        try {
            Statement stt = conex.createStatement();
            result = stt.executeUpdate(instruccionSQL);
        } catch (SQLException ex) {
            Logger.getLogger("ClaseConexion").log(Level.SEVERE, "Error al ejecutar el updateSQL", ex);
        }
        return result;
    }    
}
