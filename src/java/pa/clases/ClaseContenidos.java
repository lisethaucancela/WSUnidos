package pa.clases;

import java.util.List;

public class ClaseContenidos {
    String id,desc;
    List<ClaseUnidad> unidades;

    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<ClaseUnidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<ClaseUnidad> unidades) {
        this.unidades = unidades;
    }

    public ClaseContenidos() {
    }  
    
}
