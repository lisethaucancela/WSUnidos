package pa.clases;

import ec.edu.espoch.academico.ArrayOfMateriaPensum;
import ec.edu.espoch.academico.EscuelaEntidad;
import ec.edu.espoch.academico.MateriaPensum;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Holder;
import static pa.ServiciosWeb.institucionales.serviciosEspoch.getMallaCurricularPensumVigente;
import static pa.ServiciosWeb.institucionales.serviciosEspoch.getEscuelaEntidad;

public final class ClaseProgramaAnalitico {

    ClasePADatosGenerales datosGenerales;
    String codigoMateria;
    String codigoEscuela;

    public String getCodigoMateria() {
        return codigoMateria;
    }

    public String getCodigoEscuela() {
        return codigoEscuela;
    }

    public ClaseProgramaAnalitico(String codigoEscuela, String codigoMateria) {
        this.datosGenerales = new ClasePADatosGenerales(codigoMateria, codigoEscuela);
        if (comprobarMateriaEscuela(codigoEscuela, codigoMateria)) {
            this.codigoMateria = codigoMateria;
            this.codigoEscuela = codigoEscuela;
            Holder<String> p = new Holder<>();    //Pensum
            Holder<ArrayOfMateriaPensum> m = new Holder<>();      //Malla
            getMallaCurricularPensumVigente(codigoEscuela, p, m);
            llenarDatosGenerales();
        } else {
            this.codigoMateria = null;
            this.codigoEscuela = null;
        }
    }

    public String getCodigo() {
        return codigoMateria;
    }

    public String getEscuela() {
        return codigoEscuela;
    }

    public ClasePADatosGenerales getDatosGenerales() {
        return datosGenerales;
    }

    private Boolean comprobarMateriaEscuela(String codigoEscuela, String codigoMateria) {
        Holder<String> p = new Holder<>();    //Pensum
        Holder<ArrayOfMateriaPensum> m = new Holder<>();      //Malla

        getMallaCurricularPensumVigente(codigoEscuela, p, m);
        Integer nMaterias = m.value.getMateriaPensum().size();
        Boolean existe = false;
        Integer contador = 0;
        while (existe == false && contador <= nMaterias) {
            String codMat = m.value.getMateriaPensum().get(contador).getCodMateria();
            MateriaPensum mat = m.value.getMateriaPensum().get(contador);
            if (codMat.equals(codigoMateria)) {
                existe = true;

                //Llenar datos
                datosGenerales.setNivel(mat.getNivel());
                datosGenerales.setnCreditos(mat.getCreditos());
                datosGenerales.setnHorasSemanal(mat.getHorasPracticas() + mat.getHorasTeoricas());
                datosGenerales.setAsignatura(mat.getMateria());
                datosGenerales.setCampoFormacion(mat.getArea());
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

                System.out.println();
            }
            contador++;
        }
        return existe;
    }

    private void llenarDatosGenerales() {
        Integer nEscuelas = getEscuelaEntidad().getEscuelaEntidad().size();
        Integer contador = 0;
        String facultad = null;

        while (facultad == null && contador < nEscuelas) {
            if (getEscuelaEntidad().getEscuelaEntidad().get(contador).getCodEscuela().equals(codigoEscuela)) {
                EscuelaEntidad escu = getEscuelaEntidad().getEscuelaEntidad().get(contador);
                datosGenerales.setFacultad(escu.getFacultad());
                datosGenerales.setEscuela(escu.getEscuela());
                datosGenerales.setCarrera(escu.getCarrera());
                datosGenerales.setSede("MATRIZ ESPOCH");    //CREAR UN SERVICIO WEB QUE DEVUELVA LA SEDE DESDE NUESTRA BD
                datosGenerales.setModalidad("PRESENCIAL");    //CREAR UN SERVICIO WEB QUE DEVUELVA LA SEDE DESDE NUESTRA BD
            }
            contador++;
        }
    }
}
