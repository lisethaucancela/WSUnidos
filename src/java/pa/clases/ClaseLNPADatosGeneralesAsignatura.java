package pa.clases;

import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.MateriaPensum;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Holder;
import static pa.ServiciosWeb.institucionales.serviciosEspoch.getMallaCurricularPensumVigente;

public class ClaseLNPADatosGeneralesAsignatura extends Thread{
    String asignatura, escuela;
    ClasePADatosGenerales datosGenerales;    
    
    @Override
    public void run(){
        llenarDatosGeneralesAsignatura();
    }
    
    public ClaseLNPADatosGeneralesAsignatura(ClasePADatosGenerales datosGenerales2) {
        this.asignatura = datosGenerales2.getCodigoMateria();
        this.escuela = datosGenerales2.getCodigoEscuela();
        
        this.datosGenerales = datosGenerales2;
    }
     
    private void llenarDatosGeneralesAsignatura(){ 
            Holder<String> p = new Holder<>();    //Pensum
            Holder<ArrayOfMateriaPensum> m = new Holder<>();      //Malla
            getMallaCurricularPensumVigente(escuela, p, m);

            Integer nMaterias = m.value.getMateriaPensum().size();
            Boolean existe = false;
            Integer contador = 0;
            while (existe == false && contador < nMaterias) {
                MateriaPensum mat = m.value.getMateriaPensum().get(contador);
                String codMat = mat.getCodMateria();

                if (codMat.equals(asignatura)) {
                    existe = true;
                    datosGenerales.setNivel(mat.getNivel());
                    datosGenerales.setnCreditos(mat.getCreditos());
                    datosGenerales.setnHorasSemanal(mat.getHorasPracticas() + mat.getHorasTeoricas());
                    datosGenerales.setAsignatura(mat.getMateria());
                    datosGenerales.setCampoFormacion(mat.getArea());
                    datosGenerales.setCodigoMateria(mat.getCodMateria());

                    List<String> listaPrerreq;
                    List<String> listaCorreq;
                    try {
                        listaPrerreq = new ArrayList<>();
                        listaCorreq = new ArrayList<>();
                        for (int i = 0; i < mat.getRequisitos().getMateriaRequisito().size(); i++) {
                            if (mat.getRequisitos().getMateriaRequisito().get(i).getTipo().equals("PRERREQUISITO")) {
                                listaPrerreq.add(mat.getRequisitos().getMateriaRequisito().get(i).getCodMateria());
                            }
                            if (mat.getRequisitos().getMateriaRequisito().get(i).getTipo().equals("CORREQUISITO")) {
                                listaCorreq.add(mat.getRequisitos().getMateriaRequisito().get(i).getCodMateria());
                            }
                        }
                        datosGenerales.setPrerequisitos(listaPrerreq);
                        datosGenerales.setCorrequisitos(listaCorreq);
                    } catch (Exception e) {
                    }
                }
                contador++;
            }
    }
    
    public ClasePADatosGenerales getDatosGenerales() {
        try {
            llenarDatosGeneralesAsignatura();           
        } catch (Exception e) {
            datosGenerales = null;
        }
        return datosGenerales;
    }     
}
