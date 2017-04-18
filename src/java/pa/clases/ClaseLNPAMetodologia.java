package pa.clases;
import java.sql.ResultSet;
import pa.clases.ClaseConexion;


public class ClaseLNPAMetodologia 
{    
    String codigo;
    ClasePAMetodologia objLN = null; 

    public ClaseLNPAMetodologia(String codigo) 
    {
        this.codigo = codigo;
    }

   
   public ClasePAMetodologia getMetodologia() 
   {
       ClasePAMetodologia objMetodologia = null;
       try
       {
           objMetodologia = new ClasePAMetodologia(codigo);
           ClaseConexion c= new ClaseConexion();
           if (c.conectar()!=null)
           {
           String strConsultaSQL="SELECT * FROM metodologia where codprogramaanalitico=3";
                ResultSet rsmetodologia=c.execSQL(strConsultaSQL);
                
                while(rsmetodologia.next())
                {
                    objMetodologia.setDescripcion(rsmetodologia.getString("descripcionmetodologia"));
                }
           }
       
        }
       
       catch (Exception e){}       
       return (objMetodologia);
   }
    
   
    
    
    
    
}
