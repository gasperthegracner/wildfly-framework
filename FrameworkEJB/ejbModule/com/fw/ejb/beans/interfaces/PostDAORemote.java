package com.fw.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.fw.jpa.entity.Post;

@Remote
public interface PostDAORemote {
	public Post create(Post post);
	public Post update(Post post);
	public void remove(int id);
	public Post getPost(int id);
	public List<Post> getAllPosts();
}
