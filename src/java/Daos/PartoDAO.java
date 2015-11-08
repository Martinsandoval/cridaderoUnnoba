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
import modelo.Parto;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class PartoDAO extends AbstractDAO<Parto> {

    public PartoDAO() {
        super(Parto.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Parto> getAll() {
        Query query = em.createNamedQuery("Parto.findAll");
        return query.getResultList();


    }
}