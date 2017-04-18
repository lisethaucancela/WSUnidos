package pa.clases;

import java.util.List;

public class ClaseTema {
    String id,desc;
    List<ClaseSubtema> subtemas;

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

    public List<ClaseSubtema> getSubtemas() {
        return subtemas;
    }

    public void setSubtemas(List<ClaseSubtema> subtemas) {
        this.subtemas = subtemas;
    }

    public ClaseTema() {
    }
    
}
