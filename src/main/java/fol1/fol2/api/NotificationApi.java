package fol1.fol2.api;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fol1.fol2.NotificationServices.NotificationLocale;
import fol1.fol2.entities.Notification;
import fol1.fol2.entities.Reservation;
<<<<<<< HEAD
//1 ere commentaire
=======
>>>>>>> 421983fba5e8941957aef789f430cb281e35c120

@Path("/notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class NotificationApi {
	@Inject
	private NotificationLocale NotificationService;
	
	
	
	
	
	
	   @GET
	    @Path("/getnotifications")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<Notification> listNoti() {
	        return NotificationService.afficheNotifications();
	    }
	   
	   @DELETE
	    @Path("/{id}")
	    public Response deleteNotification(@PathParam("id") int id) {
	        NotificationService.removeNotification(id);
	        return Response.noContent().build();
	    }
}
