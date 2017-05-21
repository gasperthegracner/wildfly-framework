package com.fw.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.fw.jpa.entity.Post;

@Local
public interface PostDAOLocal {
	public Post create(Post post);
	public Post update(Post post);
	public void remove(int id);
	public Post getPost(int id);
	public List<Post> getAllPosts();
}
