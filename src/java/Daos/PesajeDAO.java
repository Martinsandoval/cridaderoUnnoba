/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelo.Cerdo;
import modelo.Pesaje;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class PesajeDAO extends AbstractDAO <Pesaje>{

    
     public PesajeDAO() {
        super(Pesaje.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

    public List<Pesaje> getAll (){
        Query query = em.createNamedQuery("Pesaje.findAll");	 
        return  query.getResultList();
    }
    

    /**
    * Devuelve la lista de pesajes del cerdo seleccionado.
    * 
    * @param cerdo : 
    * @return 
    * 
    */
    public List<Pesaje> historial (Cerdo cerdo){
        Query query = em.createNamedQuery("Pesaje.findByIdCerdo");     
	return query.getResultList(); 
        
    }
    
    
}