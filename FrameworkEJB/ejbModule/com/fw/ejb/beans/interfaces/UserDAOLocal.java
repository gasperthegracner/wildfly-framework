package com.fw.ejb.beans.interfaces;

import java.util.List;

import com.fw.jpa.entity.Post;
import com.fw.jpa.entity.User;

import javax.ejb.Local;

@Local
public interface UserDAOLocal {
	public User create(User user);
	public User update(User user);
	public void remove(String id);
	public User getUser(String id);
	public User getUserByName(String name);
	public List<Post> getUsersPosts(String id);
	public List<User> getAllUsers();
}
