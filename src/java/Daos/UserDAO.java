/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.User;

/**
 *
 * @author Administrador
 */
@Stateless
@LocalBean
public class UserDAO extends AbstractDAO<User> {

    public UserDAO() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<User> getAll() {
        Query query = em.createNamedQuery("User.findAll");
        List<User> usuario = query.getResultList();
        return usuario;

    }

    public boolean login(String user, String pass) {
       // User usuario = new User();
       // usuario.setUsername(user);
       // usuario.setPassword(pass);
        Query query = em.createNamedQuery("usuario.exist");
        query.setParameter("username", user);
        query.setParameter("password", pass);
        List<User> usuarios = query.getResultList();
        return !usuarios.isEmpty();

    }
}
