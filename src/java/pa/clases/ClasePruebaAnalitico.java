package pa.clases;
public class ClasePruebaAnalitico {
    public static void main(String[] args) {
        //ClaseProgramaAnalitico programaAnalitico = new ClaseProgramaAnalitico("EIETR","IT09EO3");
        ClaseProgramaAnalitico programaAnalitico = new ClaseProgramaAnalitico("EIS","IS15152");
        //ClaseProgramaAnalitico programaAnalitico = new ClaseProgramaAnalitico("EIS","IS13133");
        //ClaseProgramaAnalitico programaAnalitico = new ClaseProgramaAnalitico("EIS","IS13132");
        
        
        System.out.println("FACULTAD: " + programaAnalitico.datosGenerales.getFacultad());
        System.out.println("ESCUELA: " + programaAnalitico.datosGenerales.getEscuela());
        System.out.println("CARRERA: " + programaAnalitico.datosGenerales.getCarrera());
        System.out.println("SEDE: " + programaAnalitico.datosGenerales.getSede());
        System.out.println("MODALIAD: " + programaAnalitico.datosGenerales.getModalidad());
        System.out.println("ASIGNATURA: " + programaAnalitico.datosGenerales.getAsignatura());
        System.out.println("NIVEL: " + programaAnalitico.datosGenerales.getNivel());
        System.out.println("CAMPO FORMACION: " + programaAnalitico.datosGenerales.getCampoFormacion());
        System.out.println("CÓDIGO: " + programaAnalitico.datosGenerales.getCodigoMateria());
        System.out.println("CRÉDITOS: " + programaAnalitico.datosGenerales.getnCreditos());
        System.out.println("HORAS SEMANALES: " + programaAnalitico.datosGenerales.getnHorasSemanal());
        System.out.println("PRERREQUISITOS: ");
        if(programaAnalitico.datosGenerales.getPrerequisitos().size()>0){
            for(int i=0; i<programaAnalitico.datosGenerales.getPrerequisitos().size();i++){
                System.out.println(programaAnalitico.datosGenerales.getPrerequisitos().get(i));
            }
        }
        System.out.println("CORREQUISITOS: ");
        if(programaAnalitico.datosGenerales.getCorrequisitos().size()>0){
            for(int i=0; i<programaAnalitico.datosGenerales.getCorrequisitos().size();i++){
                System.out.println(programaAnalitico.datosGenerales.getCorrequisitos().get(i));
            }
        }
    }
}
