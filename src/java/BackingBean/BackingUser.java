/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean;

import Daos.UserDAO;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.User;

/**
 *
 * @author Sandoval
 */
@ManagedBean
@SessionScoped
public class BackingUser {
     private User user;
     


  
     @EJB
     private UserDAO userDAO;
     @ManagedProperty(value="#{backingNavegacion}")
     private BackingNavegacion backingNavegacion;

    public BackingNavegacion getBackingNavegacion() {
        return backingNavegacion;
    }

    public void setBackingNavegacion(BackingNavegacion backingNavegacion) {
        this.backingNavegacion = backingNavegacion;
    }
    
    public BackingUser() {
        user=new User();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
     public String login(){
       if(userDAO.login(user.getUsername(), user.getPassword())){
          //  FacesContext context = FacesContext.getCurrentInstance();
            FacesContext.getCurrentInstance().getAttributes().put("usuario", user);
          //  context.getExternalContext().getSessionMap().put("usuario", user);
          //  backingNavegacion.getPaginas().add("Login");
            return "newxhtml.xhtml"; //pagina bienvenida
            
        }else{
              FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario y/o contraseña Incorrecta", null));
            return "login.xhtml"; //retorna al login nuevamente
        }
        
    }
     
     public String crearUsuario() {
        try {
            userDAO.create(user);
            return "/admin/Usuarios/new.xhtml?faces-redirect=true";
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage();
            fm.setDetail("Error al registrar Usuario");
            return null;
        }

    }

    public String borrarUsuario(int id) {
        try {
            user = userDAO.buscar(id);
            userDAO.remove(user);
            return "admin/Usuarios/index.xhtml?faces-redirect=true";

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage();
            fm.setDetail("Error al eliminar el Usuario");
            return null;

        }
    }
    
    
    
}
