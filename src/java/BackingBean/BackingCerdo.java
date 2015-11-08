/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.CerdoVacunaDAO;
import Daos.GalponCerdoDAO;
import Daos.GalponDAO;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;

import modelo.Galpon;
import modelo.GalponCerdo;
import modelo.Vacuna;
//import modelo.Pesaje;
//import org.primefaces.model.chart.Axis;
//import org.primefaces.model.chart.AxisType;
//import org.primefaces.model.chart.CartesianChartModel;
//import org.primefaces.model.chart.ChartSeries;
//import org.primefaces.model.chart.LineChartModel;
//import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Islas, Juan Pablo
 */
@ManagedBean
@ApplicationScoped
public class BackingCerdo {

    @EJB
    private GalponDAO galponDAO;
    @EJB
    private CerdoDAO cerdoDAO;
    @EJB
    private GalponCerdoDAO galponCerdoDAO;
    @ManagedProperty(value = "#{backingPesaje}")
    private BackingPesaje backingPesaje;
  
    private Cerdo cerdo;
    private GalponCerdo galponCerdo;
    private Galpon galpon;
    private Character sexo;
    private Integer idgalpon;
    private Integer caravana;
    private String estado_corporal;
    private String nombreGalpon;
    private List<Cerdo> filteredCerdos;
   

 

    public List<Cerdo> getFilteredCerdos() {
        return filteredCerdos;
    }

    public void setFilteredCerdos(List<Cerdo> filteredCerdos) {
        this.filteredCerdos = filteredCerdos;
    }

    public String getNombreGalpon() {
        return nombreGalpon;
    }

    public void setNombreGalpon(String nombreGalpon) {
        this.nombreGalpon = nombreGalpon;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Integer getCaravana() {
        return caravana;
    }

    public void setCaravana(Integer caravana) {
        this.caravana = caravana;
    }

    public Galpon getGalpon() {
        return galpon;
    }

    public void setGalpon(Galpon galpon) {
        this.galpon = galpon;
    }

    public Integer getIdgalpon() {
        return idgalpon;
    }

    public void setIdgalpon(Integer idgalpon) {
        this.idgalpon = idgalpon;
    }

    public String getEstado_corporal() {
        return estado_corporal;
    }

    public void setEstado_corporal(String estado_corporal) {
        this.estado_corporal = estado_corporal;
    }

    public GalponCerdo getGalponCerdo() {
        return galponCerdo;
    }

    public void setGalponCerdo(GalponCerdo galponCerdo) {
        this.galponCerdo = galponCerdo;
    }

   
    

    public BackingCerdo() {
        cerdo = new Cerdo();
        galpon = new Galpon();
        galponCerdo = new GalponCerdo();

    }

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public List<Cerdo> getCerdos() {
        return cerdoDAO.getAll();
    }

    public void cargarCerdo() {

        cerdo.setGalpon(galponDAO.buscarPorNombre(nombreGalpon));
        cerdo.setEstadoCorporal(estado_corporal);
        cerdo.setNCaravana(caravana);
        cerdo.setSexo(sexo);

    }

    public String agregarCerdo() {
        try {
            this.cargarCerdo();
            cerdoDAO.create(cerdo);
            galpon = galponDAO.buscar(cerdo.getGalpon());
            galponCerdo.setIdcerdo(cerdo);
            galponCerdo.setIdgalpon(galpon);
            galponCerdo.setFIni(new Date());
            galponCerdo.setFIni(null);
            galponCerdoDAO.create(galponCerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué agregado exitosamente"));
            return "/admin/Cerdo/index.xhtml"; //retorna al listado de galpones
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al agregar el cerdo"));
            return "/admin/Cerdo/newcerdo.xhtml"; //retorna al form de creacion del galpon
        }
    }

    public Cerdo buscarCerdo(int id) {
        return cerdoDAO.buscar(id);
    }

    public String eliminarCerdo(int id) {
        try {
            cerdo = cerdoDAO.buscar(id);
            galponCerdo = galponCerdoDAO.buscarPorCerdo(cerdo);
            galponCerdoDAO.remove(galponCerdo);
            /*  El cerdo no debería ser eliminado    */
            cerdoDAO.remove(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué eliminado exitosamente"));
            return "";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el cerdo"));
            return "";
        }
    }

    public String irAPesaje(int id) throws Exception {
        backingPesaje.setCerdo(cerdoDAO.buscar(id));
        int carav = backingPesaje.getCerdo().getNCaravana();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cerdo:" + carav));
        return "/admin/Pesaje/pesajeCerdo.xhtml?id=" + id; //pagina del pesaje
    }

    public String irARegistrarPesaje(int id) throws Exception {
        backingPesaje.setCerdo(cerdoDAO.buscar(id));
        return "/admin/Pesaje/newPesaje.xhtml?id=" + id; //pagina del pesaje
    }

    public String irAEditar(int id) throws Exception {
        this.cerdo = (cerdoDAO.buscar(id));
        return "/admin/Cerdo/edit.xhtml?id=" + id; //pagina del pesaje
    }

    public String editarCerdo() {
        try {
            cerdoDAO.edit(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo se editó exitosamente"));
            return "/admin/Cerdo/index.xhtml";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al editar el cerdo"));
            return "";
        }
    }

    /**
     *
     *
     * @param idCerdo : Numero de id del cerdo a buscar. idGalpon : Numero de id
     * del galpón al cual es movido el cerdo.
     * @return String : Retorna mensaje de confirmación o de error del sistema.
     */
    public String moverCerdo(int idCerdo) {
        try {
            cerdo = cerdoDAO.buscar(idCerdo);
            galpon = galponDAO.buscar(cerdo.getGalpon() + 1);

            galponCerdo = galponCerdoDAO.buscarPorCerdo(cerdo);

            cerdo.setGalpon(cerdo.getGalpon() + 1);
            cerdoDAO.edit(cerdo);
            galponCerdo.setIdgalpon(galpon);
            galponCerdoDAO.edit(galponCerdo);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué cambiado de galpon exitosamente."));
            return "";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al mover el cerdo"
                    + e.getMessage()));
            return "";
        }

    }

    public BackingPesaje getBackingPesaje() {
        return backingPesaje;
    }

    public void setBackingPesaje(BackingPesaje backingPesaje) {
        this.backingPesaje = backingPesaje;
    }
    // Generar grafico para el pesaje del cerdo
    

}
