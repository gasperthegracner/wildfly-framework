package com.fw.ejb.beans.interfaces;

import java.util.List;
import com.fw.jpa.entity.User;

import javax.ejb.Local;

@Local
public interface UserDAOLocal {
	public User create(User user);
	public User update(User user);
	public void remove(int id);
	public User getUser(int id);
	public List<User> getAllUsers();
}
