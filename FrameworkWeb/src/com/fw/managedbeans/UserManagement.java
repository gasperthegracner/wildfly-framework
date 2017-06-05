package com.fw.managedbeans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean
public class UserManagement {
	
	
	private static ExternalContext getContext(){
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public static boolean isLoggedIn(){
		if(getContext().getUserPrincipal()!= null){
			return true;
		}
		
		return false;
	}
	
	public static String getUser(){
		return getContext().getRemoteUser();
	}
	
	public static void logout(){
		ExternalContext externalContext = getContext();
		
		externalContext.invalidateSession();
			
		try {
			externalContext.redirect("/FrameworkWeb/index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
