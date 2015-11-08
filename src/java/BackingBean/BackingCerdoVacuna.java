/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.CerdoVacunaDAO;
import Daos.VacunaDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.CerdoVacuna;
import modelo.Vacuna;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@ApplicationScoped
public class BackingCerdoVacuna {

    private Vacuna vacuna;
    @EJB
    private CerdoVacunaDAO cerdoVacunaDAO;
    @EJB
    private VacunaDAO vacunaDAO;
    private CerdoVacuna cerdoVacuna;
    private String nombreVacuna;
    private Date fecha;
    private Float dosis;
    private Cerdo cerdo;
    private int idcerdo;
    @EJB
    private CerdoDAO cerdoDAO;

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public BackingCerdoVacuna() {
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getDosis() {
        return dosis;
    }

    public void setDosis(Float dosis) {
        this.dosis = dosis;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public CerdoVacuna getCerdoVacuna() {
        return cerdoVacuna;
    }

    public int getIdcerdo() {
        return idcerdo;
    }

    public void setIdcerdo(int idcerdo) {
        this.idcerdo = idcerdo;
    }

    public void setCerdoVacuna(CerdoVacuna cerdoVacuna) {
        this.cerdoVacuna = cerdoVacuna;
    }

    public String cargarVacuna() {
        this.cerdoVacuna = new CerdoVacuna();
        cerdoVacuna.setIdvacuna(vacunaDAO.buscarPorNombre(nombreVacuna));
        cerdoVacuna.setDosis(dosis);
        cerdoVacuna.setFecha(fecha);
        this.setCerdo(cerdoDAO.buscar(idcerdo));
        cerdoVacuna.setIdcerdo(cerdo);

        return "";
    }

    public String registrarVacuna() {
        try {
            this.cargarVacuna();
            cerdoVacunaDAO.create(cerdoVacuna);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("La vacuna fue registrada"));
            return "/admin/Vacuna/vacunasCerdo.xhtml"; //retorna al listado de galpones
        } catch (Exception E) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("No se registro la vacuna"));
            return "/admin/Cerdo/vacunar.xhtml"; //retorna al listado de galpones
        }
    }

    public String irAVacunar(int id) {
        cerdo = cerdoDAO.buscar(id);
        return "/admin/Cerdo/vacunar.xhtml?id=" + id;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public List<CerdoVacuna> getVacunasCerdo() {
        return cerdoVacunaDAO.getCerdoVacunas(cerdo);

    }

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha elegida", format.format(event.getObject())));
    }

    public String irAVerVacunas(int id) {
        cerdo = cerdoDAO.buscar(id);
        return "/admin/Vacuna/vacunasCerdo.xhtml";
    }
 
}
