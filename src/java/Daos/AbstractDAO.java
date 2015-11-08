/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author HP1140LA
 */
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Ger!
 */

 
public abstract class  AbstractDAO <T> {
   @PersistenceContext(name="PU") 
   protected  EntityManager em;
    final Class<T> entityClass;
 
    public AbstractDAO(Class classType) {
        this.entityClass = classType;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        
        em.persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T t) {
       em.remove( em.merge(t));
    }

    public T buscar(int id) {
        return em.find(entityClass, id);
    }
    
    

}

