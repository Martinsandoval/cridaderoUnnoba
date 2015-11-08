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
import modelo.Enfermedad;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class EnfermedadDAO extends AbstractDAO <Enfermedad>{

    
     public EnfermedadDAO() {
        super(Enfermedad.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<Enfermedad> getAll (){
        Query query = em.createNamedQuery("Enfermedad.findAll");
	List <Enfermedad> enf = query.getResultList(); 
        return enf;
    
       }
    
}