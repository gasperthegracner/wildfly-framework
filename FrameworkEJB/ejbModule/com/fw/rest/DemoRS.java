package com.fw.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.fw.ejb.beans.interfaces.PostDAOLocal;
import com.fw.jpa.entity.Post;


@Stateless
@Path("/demo")
public class DemoRS {
	@EJB
	private PostDAOLocal postDAOLocal;

	@GET
	@Produces("text/plain")
	public Response getStatusMessage(){
		return Response.ok("REST is working!").build();
	}
	
	@GET
	@Produces("application/json")
	@Path("listalldemo")
	public Response getAllPosts(){
		System.out.println(postDAOLocal);
		List<Post> posts = postDAOLocal.getAllPosts();	
		return Response.ok(posts).build();
						
	}
	
}
