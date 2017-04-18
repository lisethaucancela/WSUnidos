/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Liseth
 */
public class CEmpresa {

    private int IdEmpresa;
    private String Ruc;
    private CTipoEmpresa ObjTipoEmpresa;
    private CSectorEconomico ObjSectorEconomico;
    private CDpa ObjDpa;
    private String RazonSocial;
    private String Direccion;
    private String Telefono;
    private String DireccionWeb;
    private String Email;
    private String Actividades;
    private List<Convenio> ListConvenios;

    public CEmpresa() {
    }

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getRuc() {
        return Ruc;
    }

    public void setRuc(String Ruc) {
        this.Ruc = Ruc;
    }

    public CTipoEmpresa getObjTipoEmpresa() {
        return ObjTipoEmpresa;
    }

    public void setObjTipoEmpresa(CTipoEmpresa ObjTipoEmpresa) {
        this.ObjTipoEmpresa = ObjTipoEmpresa;
    }

    public CSectorEconomico getObjSectorEconomico() {
        return ObjSectorEconomico;
    }

    public void setObjSectorEconomico(CSectorEconomico ObjSectorEconomico) {
        this.ObjSectorEconomico = ObjSectorEconomico;
    }

    public CDpa getObjDpa() {
        return ObjDpa;
    }

    public void setObjDpa(CDpa ObjDpa) {
        this.ObjDpa = ObjDpa;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccionWeb() {
        return DireccionWeb;
    }

    public void setDireccionWeb(String DireccionWeb) {
        this.DireccionWeb = DireccionWeb;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getActividades() {
        return Actividades;
    }

    public void setActividades(String Actividades) {
        this.Actividades = Actividades;
    }

    public List<Convenio> getListConvenios() {
        return ListConvenios;
    }

    public void setListConvenios(List<Convenio> ListConvenios) {
        this.ListConvenios = ListConvenios;
    }

    public void addConvenios(Convenio OP) {
        try {
            if (this.ListConvenios == null) {
                this.ListConvenios = new ArrayList<>();
            }
            this.ListConvenios.add(OP);
        } catch (Exception e) {
            Logger.getLogger("CConvenio").severe(e.getMessage());
        }
    }
}
