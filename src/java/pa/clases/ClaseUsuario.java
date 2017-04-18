package pa.clases;
import ec.edu.espoch.academico.ArrayOfRolCarrera;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ClaseUsuario {
    String cedula;
    String nombre;

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //MÉTODO QUE DEVUELVE SI EXISTE UN USUARIO O NO EN NUESTRA BASE DE DATOS
    public Boolean existeUsuarioLocal(String cedula) throws ClassNotFoundException, SQLException{
        Boolean existe=false;
        ClaseConexion objConexion = new ClaseConexion();
        Connection con = objConexion.conectar();
        java.sql.Statement st = con.createStatement();
        String sql =    "select count(*) as nRegistros from usuario where cedula='"+cedula+"';";       
        try (ResultSet result = st.executeQuery(sql)) {
            result.next();
            String n = result.getObject("nRegistros").toString();
            if(n.equals("1")) 
                existe=true;
        }
        return existe;
    }   
    
    //MÉTODO QUE VERIFICA EL USUARIO Y LA CONTRASEÑA EN EL OASIS
    public Boolean existeUsuarioOASIS(String cedula, String password){
        Boolean existe=false;
        try{
            //ArrayOfRolCarrera objAut = new ArrayOfRolCarrera();
            ArrayOfRolCarrera objAut = autenticarUsuarioCarrera(cedula,password);
            if(objAut!=null)
                existe=true;
        }
        catch(Exception e){
        }
        return existe;
    }
    
    public Integer devolverNRoles(String cedula){
        Integer nRoles=0;
        return nRoles;
    }

    //WS OASIS IMPORTADOS
    private static ArrayOfRolCarrera autenticarUsuarioCarrera(java.lang.String login, java.lang.String password) {
        misserviciosespochseguridad.WsEspochSeguridad_Service service = new misserviciosespochseguridad.WsEspochSeguridad_Service();
        misserviciosespochseguridad.WsEspochSeguridad port = service.getWsEspochSeguridadPort();
        return port.autenticarUsuarioCarrera(login, password);
    }
}
