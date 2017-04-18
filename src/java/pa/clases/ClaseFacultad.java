package pa.clases;
public class ClaseFacultad {
    String codFacultad,nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    ClaseListEscuelas escuelas = new ClaseListEscuelas();
    //Falta declarar el Logo

    public ClaseListEscuelas getEscuelas() {
        return escuelas;
    }

    public void setEscuelas(ClaseListEscuelas escuelas) {
        this.escuelas = escuelas;
    }

    public String getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(String codFacultad) {
        this.codFacultad = codFacultad;
    }    
}
