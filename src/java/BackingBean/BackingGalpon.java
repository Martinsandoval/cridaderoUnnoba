/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.CerdoDAO;
import Daos.GalponCerdoDAO;
import Daos.GalponDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cerdo;
import modelo.Galpon;
import modelo.GalponCerdo;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@SessionScoped
public class BackingGalpon {

    private Galpon galponGral;
    private GalponCerdo galpon;
    private Cerdo cerdo;
    @EJB
    private GalponDAO galponDAO;
    @EJB
    private CerdoDAO cerdoDAO;
    @EJB
    private GalponCerdoDAO galponCerdoDAO;

    public BackingGalpon() {
        this.galpon = new GalponCerdo();
        this.galponGral = new Galpon();

    }

    public Galpon getGalponGral() {
        return galponGral;
    }

    public void setGalponGral(Galpon galponGral) {
        this.galponGral = galponGral;
    }

    public GalponCerdo getGalpon() {
        return galpon;
    }

    public void setGalpon(GalponCerdo galpon) {
        this.galpon = galpon;
    }

    public Cerdo getCerdo() {
        return cerdo;
    }

    public void setCerdo(Cerdo cerdo) {
        this.cerdo = cerdo;
    }

    public List getGalpones() {
        return galponDAO.getAll();
    }

    public List getCerdosGalpon(int idGalpon) {
        galpon = galponCerdoDAO.buscar(idGalpon);
        return galpon.getCerdo();
    }
    public String getNombreGalpon(int idGalpon) {
        Galpon galpon1 = galponDAO.buscar(idGalpon);
        return galpon1.getNombre();
    }

    public String eliminarCerdo(int id) {
        try {
            cerdo = cerdoDAO.buscar(id);
            galpon.getCerdo().remove(cerdo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El cerdo fué eliminado exitosamente"));
            return ""; //retorna al listado de cerdos del galp{on 
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar el cerdo"));
            return ""; //retorna al listado de cerdos del galpon
        }
    }

    public String agregarGalponGral() {
        try {
            galponDAO.create(galponGral);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El galpon fué creado exitosamente"));
            return "../../Galpon/index.xhtml"; //retorna al listado de galpones
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear el galpon"));
            return "/admin/newGalpon.xhtml"; //retorna al form de creacion del galpon
        }


    }

    public String agregarGalpon() {
        try {
            galponCerdoDAO.create(galpon);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("El galpon fué creado exitosamente"));
            return "/admin/newGalpon.xhtml"; //retorna al listado de galpones
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear el galpon"));
            return ""; //retorna al form de creacion del galpon
        }

    }
        
      
}
