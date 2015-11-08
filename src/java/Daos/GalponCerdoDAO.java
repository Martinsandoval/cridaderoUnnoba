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
import modelo.Cerdo;
import modelo.GalponCerdo;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class GalponCerdoDAO extends AbstractDAO <GalponCerdo>{

    
     public GalponCerdoDAO() {
        super(GalponCerdo.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

    public List<GalponCerdo> getAll (){
        Query query = em.createNamedQuery("galpn_cerdo.all");
	List <GalponCerdo> galponcerdos = query.getResultList(); 
        return galponcerdos;
    
    }
    
    public GalponCerdo buscarPorCerdo(Cerdo cerdo){
          Query query = em.createNamedQuery("GalponCerdo.findByCerdo");
          query.setParameter("cerdo", cerdo);
           List<GalponCerdo> galponcerdos = query.getResultList();
           return galponcerdos.get(0);
    }
    
    /**
     *
     * 
     * @param idCerdo : Numero de id del cerdo a buscar
     * @return GalponCerdo : Objeto que contiene la ubicación del cerdo,
     *                     fecha de ingreso y fecha de egreso.
     */
    public GalponCerdo galponActual(int idCerdo) throws Exception {
        
        Query query = em.createNamedQuery("galponcerdo.galponactual");
	query.setParameter("cerdo", idCerdo);
        List<GalponCerdo> galponcerdos = query.getResultList();
        
        /* Comprobar que haya galpones en la lista */  
        if (galponcerdos.isEmpty()){
            throw new Exception("No se ha encontrado galpon");
        } 
        
        /*  Devolver el primer galpon, que debería ser el único   */
        return galponcerdos.get(0);
        
        
        
        
        
    }
    
}