package com.fw.managedbeans;

import java.time.Instant;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fw.ejb.beans.interfaces.PostDAOLocal;
import com.fw.jpa.entity.Post;

@ViewScoped
@ManagedBean
public class PostMB {

	@EJB
	private PostDAOLocal postDAOLocal;
	
	private int id = 0;
	
	public PostMB() {
		
	}
	
	public void test() {
		Post post = new Post();
		post.setTitle("Testni vnos 1");
		post.setContent("To je prva testna vsebina");
		post.setCreation_Date(Long.toString(Instant.now().getEpochSecond()));
		postDAOLocal.create(post);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
