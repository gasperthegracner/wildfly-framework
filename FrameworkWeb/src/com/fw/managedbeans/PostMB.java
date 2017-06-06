package com.fw.managedbeans;

import java.time.Instant;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;

import com.fw.ejb.beans.interfaces.PostDAOLocal;
import com.fw.ejb.beans.interfaces.UserDAOLocal;
import com.fw.jpa.entity.Post;
import com.fw.jpa.entity.User;

@ViewScoped
@ManagedBean
public class PostMB {

	@EJB
	private PostDAOLocal postDAOLocal;
	private UserDAOLocal userDaoLocal;
	
	private int id = 0;
	private String title;
	private String content;
	private String dateTime;
	private User author;
	
	public void createPost(User post_author){

		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setCreation_Date(Long.toString(Instant.now().getEpochSecond()));
		post.setAuthor(post_author);
		postDAOLocal.create(post);
	}
	
	public void updatePost(){
		Post post = new Post();
		post.setID(id);
		post.setTitle(title);
		post.setContent(content);
		post.setAuthor(author);
		postDAOLocal.update(post);
	}

	public void deletePost(int id){
		postDAOLocal.remove(id);
	}
	
	public void getPost(int id){
		Post p = postDAOLocal.getPost(id);
		this.id = p.getID();
		title = p.getTitle();
		content = p.getContent();
		dateTime = p.getCreation_Date();
		author = p.getAuthor();
	}
	
	public List<Post> getAllPosts(){
		return postDAOLocal.getAllPosts();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	
}
