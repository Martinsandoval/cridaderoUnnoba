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

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class CerdoDAO extends AbstractDAO<Cerdo> {

    public CerdoDAO() {
        super(Cerdo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List <Cerdo> getAll() {
        Query query = em.createNamedQuery("Cerdo.findAll");
        return query.getResultList();

    }
}