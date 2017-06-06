package com.fw.managedbeans;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.fw.ejb.beans.interfaces.UserDAOLocal;
import com.fw.jpa.entity.User;

@ViewScoped
@ManagedBean
public class UserManagement {
	
	@EJB
	private UserDAOLocal userDAO;
	
	private static ExternalContext getContext(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public static boolean isLoggedIn(){
		if(getContext().getUserPrincipal()!= null){
			return true;
		}
		
		return false;
	}
	
	private User getUser(){
		if(getContext().getUserPrincipal()!= null){
			System.out.println(userDAO.getUser("dbd310de-46d7-11e7-a919-92ebcb67fe33").getId());
			return userDAO.getUser("dbd310de-46d7-11e7-a919-92ebcb67fe33");
		}
		return null;
		
	}
	
	public String getUsername(){
		getUser();
		return getContext().getRemoteUser();
	}
	
	public void logout(){
		ExternalContext externalContext = getContext();
		
		externalContext.invalidateSession();
			
		try {
			externalContext.redirect("/FrameworkWeb/index.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
