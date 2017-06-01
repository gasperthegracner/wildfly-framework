package com.fw.ejb.beans;

import com.fw.ejb.beans.interfaces.PostDAOLocal;
import com.fw.ejb.beans.interfaces.PostDAORemote;
import com.fw.jpa.entity.Post;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class PostDAO
 */
@Stateless
public class PostDAO implements PostDAORemote, PostDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PostDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Post create(Post post) {
		em.persist(post);
		return post;
	}

	@Override
	public Post update(Post post) {
		em.merge(post);
		return post;
	}

	@Override
	public void remove(int id) {
		em.remove(getPost(id));
		
	}

	@Override
	public Post getPost(int id) {
		return em.find(Post.class, id);
	}

	@Override
	public List<Post> getAllPosts() {
		return em.createNamedQuery("Post.getAll",Post.class).getResultList();
	}

}
