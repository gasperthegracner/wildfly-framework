package com.fw.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fw.ejb.beans.interfaces.UserDAOLocal;
import com.fw.jpa.entity.Post;
import com.fw.jpa.entity.User;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDAO implements UserDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserDAO() {
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}
	
	@Override
	public User update(User user) {
		em.merge(user);
		return user;
	}
	
	@Override
	public void remove(int id) {
		em.remove(getUser(id));
	}
	
	@Override
	public User getUser(int id) {
		return em.find(User.class, id);
	}
	
	@Override
	public List<User> getAllUsers() {
		return em.createNamedQuery("User.getAll",User.class).getResultList();
	}

}
