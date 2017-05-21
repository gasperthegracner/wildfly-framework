package com.fw.managedbeans;

import java.time.Instant;
import java.util.List;

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
	private String title;
	private String content;
	private String dateTime;
	private int author_Id;
	
	public void createPost(){
		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setCreation_Date(Long.toString(Instant.now().getEpochSecond()));
		post.setAuthor_ID(author_Id);
		postDAOLocal.create(post);
	}
	
	public void updatePost(){
		Post post = new Post();
		post.setID(id);
		post.setTitle(title);
		post.setContent(content);
		post.setAuthor_ID(author_Id);
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
		author_Id = p.getAuthor_ID();
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

	public int getAuthor_Id() {
		return author_Id;
	}

	public void setAuthor_Id(int author_Id) {
		this.author_Id = author_Id;
	}
	
	
}
