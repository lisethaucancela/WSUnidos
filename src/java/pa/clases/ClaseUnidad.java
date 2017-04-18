package pa.clases;

import java.util.List;

public class ClaseUnidad {
     String id,desc;
    List<ClaseTema> temas;

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

    public List<ClaseTema> getTemas() {
        return temas;
    }

    public void setTemas(List<ClaseTema> temas) {
        this.temas = temas;
    }

    public ClaseUnidad() {
    }
    
}
