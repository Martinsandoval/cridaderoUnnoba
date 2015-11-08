/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.VacunaDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Vacuna;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@SessionScoped
public class BackingVacuna {

    private Vacuna vacuna;
    @EJB
    private VacunaDAO vacunaDAO;

    public BackingVacuna() {
        this.vacuna = new Vacuna();
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public List<Vacuna> getVacunas() {
        return vacunaDAO.getAll();
    }

    public int totalVacunas() {
        return this.getVacunas().size();
    }

    public String crearVacuna() {
        try {
            vacuna.setCerdoVacunaCollection(null);
            vacunaDAO.create(vacuna);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("La vacuna fué creada exitosamente"));
            return "/admin/Vacuna/index.xhtml"; //retorna al listado de vacunas
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear vacuna"));
            return ""; //retorna al form de creacion de vacuna
        }
    }

    public String eliminarVacuna(int id) {
        try {
            vacuna = vacunaDAO.buscar(id);
            /*  El cerdo no debería ser eliminado    */
            vacunaDAO.remove(vacuna);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("La vacuna fué eliminada exitosamente"));
            return "";
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar vacuna"));
            return "";
        }
    }

    public String NombreVacuna(Vacuna vacuna) {
        return vacuna.getNombre();
    }
}
