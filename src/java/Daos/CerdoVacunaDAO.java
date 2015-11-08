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
import modelo.CerdoVacuna;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class CerdoVacunaDAO extends AbstractDAO <CerdoVacuna>{

    
     public CerdoVacunaDAO() {
        super(CerdoVacuna.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
                return em;
    }
    

       public List<CerdoVacuna> getAll (){
        Query query = em.createNamedQuery("cerdo_vacuna.all");
	List <CerdoVacuna> cerdosvac = query.getResultList(); 
        return cerdosvac;
    
       }
       
       public List<CerdoVacuna>getCerdoVacunas(Cerdo idcerdo){
          Query query = em.createNamedQuery("CerdoVacuna.findByCerdo");
          query.setParameter("idcerdo", idcerdo);
          return query.getResultList(); 
          
       }
    
}