/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.CerdoEnfermedad;


/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class CerdoEnfermedadDAO extends AbstractDAO <CerdoEnfermedad>{

    
     public CerdoEnfermedadDAO() {
        super(CerdoEnfermedad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<CerdoEnfermedad> getAll (){
        Query query = em.createNamedQuery("Cerdo_enfermedad.all");
	List <CerdoEnfermedad> cerdosEnfermedad = query.getResultList(); 
        return cerdosEnfermedad;
    
       }
    
}