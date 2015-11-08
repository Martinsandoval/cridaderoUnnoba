/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.PartoDAO;
import Daos.TienePartoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.Parto;
import modelo.TienePartos;
import modelo.Vacuna;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Islas, Juan Pablo
 */
@ManagedBean
@SessionScoped
public class BackingParto {

    @EJB
    private PartoDAO partoDAO;
    @EJB
    private TienePartoDAO tienePartoDAO;
    private TienePartos tieneParto;
    private Parto parto;
    /*   Atributos de nuevo parto      */
    private int cantChanchos;
    private int cantMuertos;
    private Date fecha;
    private int numeroParto;
    private Cerdo cerdo;

    public BackingParto() {
        parto = new Parto();
    }

    public PartoDAO getPartoDAO() {
        return partoDAO;
    }

    public void setPartoDAO(PartoDAO partoDAO) {
        this.partoDAO = partoDAO;
    }

    public TienePartoDAO getTienePartoDAO() {
        return tienePartoDAO;
    }

    public void setTienePartoDAO(TienePartoDAO tienePartoDAO) {
        this.tienePartoDAO = tienePartoDAO;
    }

    public TienePartos getTieneParto() {
        return tieneParto;
    }

    public void setTieneParto(TienePartos tieneParto) {
        this.tieneParto = tieneParto;
    }

    public Parto getParto() {
        return parto;
    }

    public void setParto(Parto parto) {
        this.parto = parto;
    }

    public int getCantChanchos() {
        return cantChanchos;
    }

    public void setCantChanchos(int cantChanchos) {
        this.cantChanchos = cantChanchos;
    }

    public int getCantMuertos() {
        return cantMuertos;
    }

    public void setCantMuertos(int cantMuertos) {
        this.cantMuertos = cantMuertos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroParto() {
        return numeroParto;
    }

    public void setNumeroParto(int numeroParto) {
        this.numeroParto = numeroParto;
    }

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public List<Parto> getPartos() {
        return partoDAO.getAll();
    }

    public String crearParto() {
        try {
            /*     Inicialización de parto               */

            /*   Almacenar en base de datos         */
            partoDAO.create(parto);

            /*   Mensaje de exito         */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El parto fué creado exitosamente."));
            return "";
        } catch (Exception e) {
            /*   Mensaje de error        */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear el parto."));
            return "";
        }
    }

    public List<Parto> listarParto() {
        return partoDAO.getAll();
    }

    public int cantidadCerdosTotal() {
        int aux = 0;
        for (Parto i : this.listarParto()) {

            aux += i.getCantChancho();
        }
        return aux;
    }

    public String agregarCerdoParto(Parto parto, Cerdo madre) {
        try {
            /*    Inicializar tiene parto            */
            TienePartos tp = new TienePartos();
            tp.setCria(parto);
            tp.setFecha(parto.getFecha());
            tp.setProgenitor(madre);

            /*    Almacenar en base de datos                  */
            tienePartoDAO.create(tp);
            /*   Mensaje de exito         */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué agregado exitosamente."));
            return "";
        } catch (Exception e) {
            /*   Mensaje de error        */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al agregar el cerdo."));
            return "";

        }
    }

    public String removerParto(int idParto) {
        try {
            Parto p = partoDAO.buscar(idParto);
            partoDAO.remove(p);

            /*   Mensaje de exito         */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El parto fué eliminado exitosamente."));
            return "";
        } catch (Exception e) {
            /*   Mensaje de error         */
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el parto."));
            return "";
        }
    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha elegida", format.format(event.getObject())));
    }
}
