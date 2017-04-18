package pa.clases;

import ec.edu.espoch.academico.ArrayOfFacultad;
import java.util.ArrayList;
import java.util.List;

public class ClaseListFacultades {

    List<ClaseFacultad> objListaFacultades = null;

    public ClaseListFacultades() {
        objListaFacultades = new ArrayList<>();
    }

    public List<ClaseFacultad> getFacultades() {
        //AÑADIR TODAS LAS FACULTADES DE LA ESPOCH
        ArrayOfFacultad facultades = getFacultadesTotales();
        for (int i=0; i < facultades.getFacultad().size(); i++) {
            ClaseFacultad objFacultad = new ClaseFacultad();
            objFacultad.setCodFacultad(facultades.getFacultad().get(i).getCodigo());     
            objFacultad.setNombre(facultades.getFacultad().get(i).getNombre());
            objListaFacultades.add(objFacultad);
        }
        return objListaFacultades;
    }

    //WS OASIS INVOCADOS
    private static ArrayOfFacultad getFacultadesTotales() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getFacultadesTotales();
    }

}
