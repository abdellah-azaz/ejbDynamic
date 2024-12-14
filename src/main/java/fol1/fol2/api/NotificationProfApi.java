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

import fol1.fol2.NotificationProfServices.NotificationProfLocale;
import fol1.fol2.NotificationServices.NotificationLocale;
import fol1.fol2.entities.Notification;
import fol1.fol2.entities.NotificationProf;

@Path("/notificationprofs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class NotificationProfApi {
	@Inject
	private NotificationProfLocale NotificationProfService;
	
	
	
	
	
	
	   @GET
	    @Path("/getnotificationprofs")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public List<NotificationProf> listNoti() {
	        return NotificationProfService.afficheNotificationProf();
	    }
	   
	   @DELETE
	    @Path("/{id}")
	    public Response deleteNotificationProf(@PathParam("id") int id) {
	        NotificationProfService.removeNotificationProf(id);
	        return Response.noContent().build();
	    }
}
