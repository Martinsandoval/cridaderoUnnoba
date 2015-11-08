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
import modelo.TienePartos;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class TienePartoDAO extends AbstractDAO <TienePartos>{

    
     public TienePartoDAO() {
        super(TienePartos.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<TienePartos> getAll (){
        Query query = em.createNamedQuery("tiene_parto.all");
	List <TienePartos> tiene = query.getResultList(); 
        return tiene;
    
       }
    
}