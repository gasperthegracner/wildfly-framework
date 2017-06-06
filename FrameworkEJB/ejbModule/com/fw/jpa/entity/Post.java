package com.fw.jpa.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.internal.NotNull;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity
@NamedQuery(name="Post.getAll", query="SELECT s FROM Post s")
public class Post implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Length(max=255)
	private String title;
	
	@NotNull
	@Lob
	private String content;
	
	@NotNull
	private String creation_date;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="author_id")
	private User author;
	

	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	} 
	
	public int getID() {
		return this.id;
	}

	public void setID(int ID) {
		this.id = ID;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}  
	
	public String getContent() {
		return this.content;
	}

	public void setContent(String Content) {
		this.content = Content;
	} 
	
	public String getCreation_Date() {
		return this.creation_date;
	}

	public void setCreation_Date(String Creation_Date) {
		this.creation_date = Creation_Date;
	}   
	
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
   
}
