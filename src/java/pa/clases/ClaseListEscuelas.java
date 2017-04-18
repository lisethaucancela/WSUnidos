package pa.clases;
import ec.edu.espoch.academico.ArrayOfEscuela;
import java.util.ArrayList;
import java.util.List;

public class ClaseListEscuelas {
    public List<ClaseEscuela> getEscuelas(String facultad){
        List<ClaseEscuela> listaEscuelas=null;
        try{
            listaEscuelas = new ArrayList<>();
            for(int i=0;i<getTodasEscuelas().getEscuela().size();i++){
                if((getTodasEscuelas().getEscuela().get(i).getCodFacultad()).equals(facultad)){
                    ClaseEscuela objEscuela = new ClaseEscuela();
                    objEscuela.setCodEscuela(getTodasEscuelas().getEscuela().get(i).getCodigo());
                    objEscuela.setNombre(getTodasEscuelas().getEscuela().get(i).getNombre());
                    listaEscuelas.add(objEscuela);
                }
            }
        }
        catch(Exception e){
        }
        return listaEscuelas;
    }

    private static ArrayOfEscuela getTodasEscuelas() {
        misserviciosinfogeneral.WsInfoGeneral_Service service = new misserviciosinfogeneral.WsInfoGeneral_Service();
        misserviciosinfogeneral.WsInfoGeneral port = service.getWsInfoGeneralPort();
        return port.getTodasEscuelas();
    }
}
