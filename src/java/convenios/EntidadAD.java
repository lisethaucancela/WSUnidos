/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convenios;

import cvcc.practicas.ad.conexion.AccesoDatos;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Liseth
 */
public class EntidadAD extends Entidad {

    public EntidadAD() {
    }

    public void obtenerListaConvenios(AccesoDatos accesoDatos) throws Exception {
        String sql = "SELECT con.id_convenio, con.descripcion, con.fecha_ini, con.fecha_fin, con.estado,  empresa.id_empresa, empresa.ruc,\n"
                + "          tipo_empresa.descripcion as tip_emp_descripcion, sector_economico.descripcion as sec_eco_descripcion,\n"
                + "          dpa.descripcion as dpa_descripcion, empresa.razon_social, empresa.direccion,\n"
                + "          empresa.telefono, empresa.direccion_web, empresa.email, empresa.actividades\n"
                + "  FROM practicas.convenio as con,\n"
                + "       practicas.empresa, practicas.tipo_empresa,\n"
                + "       practicas.sector_economico, practicas.dpa,\n"
                + "       practicas.entidad\n"
                + "  WHERE entidad.id_entidad = '" + this.getIdEntidad() + "' AND\n"
                + "        empresa.id_empresa = con.id_empresa AND\n"
                + "	   tipo_empresa.id_tipo_empresa = empresa.id_tipo_empresa AND\n"
                + "	   sector_economico.id_sector_economico = empresa.id_sector_economico AND\n"
                + "	   dpa.id_dpa = empresa.id_dpa AND\n"
                + "	   entidad.id_entidad = con.id_entidad;";
        try {
            if (accesoDatos.Connectar() == 2) {
                if (accesoDatos.EjecutarSQL(sql) == 1) {
                    ResultSet rsDatos = accesoDatos.getRs();
                    while (rsDatos.next()) {
                        Convenio objConvenio = new Convenio();
                        objConvenio.setIdConvenio(rsDatos.getInt("id_convenio"));
                        objConvenio.setDescripcion(rsDatos.getString("descripcion"));
                        objConvenio.setFechaInicio(rsDatos.getDate("fecha_ini"));
                        objConvenio.setFechaFin(rsDatos.getDate("fecha_fin"));
                        objConvenio.setEstado(rsDatos.getBoolean("estado"));

                        CEmpresa objEmpresa = new CEmpresa();
                        objEmpresa.setIdEmpresa(rsDatos.getInt("id_empresa"));
                        objEmpresa.setRuc(rsDatos.getString("ruc"));
                        objEmpresa.setRazonSocial(rsDatos.getString("razon_social"));
                        objEmpresa.setDireccion(rsDatos.getString("direccion"));
                        objEmpresa.setTelefono(rsDatos.getString("telefono"));
                        objEmpresa.setDireccionWeb(rsDatos.getString("direccion_web"));
                        objEmpresa.setEmail(rsDatos.getString("email"));
                        objEmpresa.setActividades(rsDatos.getString("actividades"));

                        CTipoEmpresa objTipoEmpresa = new CTipoEmpresa();
                        objTipoEmpresa.setDescripcion(rsDatos.getString("tip_emp_descripcion"));
                        objEmpresa.setObjTipoEmpresa(objTipoEmpresa);

                        CSectorEconomico objSectorEconomico = new CSectorEconomico();
                        objSectorEconomico.setDescripcion(rsDatos.getString("sec_eco_descripcion"));
                        objEmpresa.setObjSectorEconomico(objSectorEconomico);

                        CDpa objDpa = new CDpa();
                        objDpa.setDescripcion(rsDatos.getString("dpa_descripcion"));
                        objEmpresa.setObjDpa(objDpa);

                        objConvenio.setObjEmpresa(objEmpresa);

                        this.addConvenios(objConvenio);
                    }
                }
            }
        } catch (SQLException exConec) {
            System.err.println("e: " + exConec.getMessage());
            throw new Exception(exConec.getMessage());
        }
    }
}
