
package pa.clases;

public class ClaseCaracterizacion {
    Integer intCodCaracterizacion;
    Integer intCodPrograma;
    String strDetalle;
    
    public Integer getIntCodCaracterizacion(){
        return intCodCaracterizacion;
    }
    public void setIntCodCaracterizacion(Integer codC){
        this.intCodCaracterizacion = codC;
    }
    
    public Integer getIntCodPrograma(){
        return intCodPrograma;
    }
    public void setIntCodPrograma(Integer codP){
        this.intCodPrograma= codP;
    }
    
    public String getstrDetalle(){
        return strDetalle;
    }
    public void setstrDetalle(String texto){
        this.strDetalle= texto;
    }
}
