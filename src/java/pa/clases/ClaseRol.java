package pa.clases;
public class ClaseRol {
    Integer idRol=-1;
    String nombreRol,descripcionRol;

    public Integer getIdRol() {
        return idRol;
    }
    public String getNombreRol() {
        return nombreRol;
    }
    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }
}
