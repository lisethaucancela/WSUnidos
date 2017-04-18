package pa.clases;

public class ClaseLNPADatosGenerales {

    String asignatura, escuela;
    ClasePADatosGenerales datosGenerales = null;

    public ClaseLNPADatosGenerales(String escuela, String asignatura) {
        this.asignatura = asignatura;
        this.escuela = escuela;
        
        datosGenerales = new ClasePADatosGenerales(escuela, asignatura);
    }

    private void matchDatosGenerales() {
        //ClasePADatosGenerales datosGenerales = new ClasePADatosGenerales(escuela, asignatura); 
        Thread hilo1 = new ClaseLNPADatosGeneralesCarrera(datosGenerales);
        Thread hilo2 = new ClaseLNPADatosGeneralesAsignatura(datosGenerales);
       
        hilo1.start();
        hilo2.start();
        
        while (hilo1.isAlive() || hilo2.isAlive()) {};        
    }

    public ClasePADatosGenerales getDatosGenerales() {
        try {
            matchDatosGenerales();
        } catch (Exception e) {
        }
        return datosGenerales;
    }
}
