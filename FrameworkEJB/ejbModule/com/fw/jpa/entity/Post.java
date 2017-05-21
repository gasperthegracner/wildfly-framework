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
	private int ID;
	
	@NotNull
	@Length(max=255)
	private String Title;
	
	@NotNull
	@Lob
	private String Content;
	
	@NotNull
	private String Creation_Date;
	
	@NotNull
	private int Author_ID;
	
	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}   
	public int getID() {
		return this.ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}   
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}   
	public String getContent() {
		return this.Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}   
	public String getCreation_Date() {
		return this.Creation_Date;
	}

	public void setCreation_Date(String Creation_Date) {
		this.Creation_Date = Creation_Date;
	}   
	public int getAuthor_ID() {
		return this.Author_ID;
	}

	public void setAuthor_ID(int Author_ID) {
		this.Author_ID = Author_ID;
	}
   
}
