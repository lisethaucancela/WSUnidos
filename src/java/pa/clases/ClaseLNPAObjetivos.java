
package pa.clases;

import java.sql.ResultSet;
import pa.clases.ClaseConexion;


public class ClaseLNPAObjetivos
{
   String  codigo;
    ClasePAObjetivos objLN = null; 

    public ClaseLNPAObjetivos(String codigopla) {
        this.codigo = codigopla;
    }

    public ClasePAObjetivos getObjetivo()
    {  
        ClasePAObjetivos objObjetivos = null;
        try
        { 
            objObjetivos = new ClasePAObjetivos(codigo);
            ClaseConexion c= new ClaseConexion();
            if(c.conectar() != null)
            {
                
                String strConsultaSQL="Select detalleobjetivo from objetivosprogramaanalitico as a inner join tipoobjetivos as b on  a.codtipoobjetivos= b.codtipoobjetivos and   a.codprogramaanalitico = " + codigo;
                ResultSet rsobjetivo=c.execSQL(strConsultaSQL);
               
                    while(rsobjetivo.next())
                    {
                        objObjetivos.setDescripcion(rsobjetivo.getString("detalleobjetivo"));
                    }
              
                
            }
         }
        catch(Exception e)
        {
        }
        return(objObjetivos); 
    }   
}
