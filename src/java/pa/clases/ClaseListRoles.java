package pa.clases;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClaseListRoles {
    //MÉTODO QUE DEVUELVE LOS ROLES DE UN USUARIO
    public List<ClaseRol> devolverRolesUsuario(String cedula) throws ClassNotFoundException, SQLException {
        List<ClaseRol> objListaRoles = null;
        ClaseConexion c = new ClaseConexion();
        
        if (c.conectar() != null) {
            objListaRoles = new ArrayList<>();            
            String strConsultaSQL = "SELECT cedula FROM rolesusuario where ('CodEntidad'='FIE') and (idrol=2);";
            ResultSet rsEstudiantes = c.execSQL(strConsultaSQL);
            
            while (rsEstudiantes.next()) {
                ClaseRol objRol = new ClaseRol();
                objRol.setNombreRol(rsEstudiantes.getString("nombrerol"));
                objRol.setDescripcionRol("");
                
                objListaRoles.add(objRol);
            }
        }
        else{
            System.out.println("Error al devolver roles");
        }
        return objListaRoles;
    }
}
