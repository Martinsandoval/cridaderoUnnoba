/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.EnfermedadDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Enfermedad;

/**
 *
 * @author Islas, Juan Pablo
 */
@ManagedBean
@SessionScoped
public class BackingEnfermedad {
    private Enfermedad enfermedad;
    @EJB
    private EnfermedadDAO enfermedadDAO;
    private String nombreCientifico;
    private String nombrePopular;

    public BackingEnfermedad() {
        enfermedad= new Enfermedad();
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public EnfermedadDAO getEnfermedadDAO() {
        return enfermedadDAO;
    }

    public void setEnfermedadDAO(EnfermedadDAO enfermedadDAO) {
        this.enfermedadDAO = enfermedadDAO;
    }
    
    /**
     * 
     * cientifico : Ingresa el nombre cientifico de la enfermedad
     * popular : Ingresa el nombre popular de la enfermedad
     * @return 
     */
    public String crearEnfermedad( ){
       
        try {
            enfermedadDAO.create(enfermedad);
        
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("La enfermedad fué creada exitosamente."));
            return ""; 
        } catch(Exception ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al crear la enfermedad."));
            return ""; 
        }
    }
    
    /**
     * 
     * @param idEnfermedad : Ingresa el numero identificador de la enfermedad
     *                       a eliminar 
     * @return 
     */
    public String removerEnfermedad(int idenfermedad){
        try {
            Enfermedad e = enfermedadDAO.buscar(idenfermedad);
            enfermedadDAO.remove(e);
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("La enfermedad fué eliminada exitosamente."));
            return ""; 
        } catch(Exception ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error al eliminar la enfermedad."));
            return ""; 
        }
    }
    
    public List<Enfermedad> getEnfermedades(){
        return enfermedadDAO.getAll();
    }
    
    public int totalEnfermedades(){
        return this.getEnfermedades().size();
    }
    
    
}
