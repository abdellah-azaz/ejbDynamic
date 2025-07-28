package fol1.fol2.api;

import java.io.IOException;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fol1.fol2.FiliereService.FiliereLocale;
import fol1.fol2.NotificationProfServices.NotificationProfLocale;
import fol1.fol2.NotificationServices.NotificationLocale;
import fol1.fol2.ReservationServices.ReservationLocale;
import fol1.fol2.UserService.UserLocale;
import fol1.fol2.categorieServices.CategorieLocale;
import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Filiere;
import fol1.fol2.entities.Matiere;
import fol1.fol2.entities.Notification;
import fol1.fol2.entities.NotificationProf;
import fol1.fol2.entities.Reservation;
import fol1.fol2.entities.Salle;
import fol1.fol2.entities.User;
import fol1.fol2.matiereServices.MatiereLocale;
import fol1.fol2.services.SalleLocale;
import fol1.fol2.services.SalleService;

@Path("/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class ReservationApi {

    @Inject
    private ReservationLocale ReservationService;
    @Inject
    private SalleLocale SalleService;
    //filiereservice
    @Inject
    private FiliereLocale FiliereService;
    @Inject
    private NotificationLocale NotificationService;
    @Inject 
    private NotificationProfLocale NotificationProfService;
    
    @Inject
    private UserLocale UserService;
   
    @Inject 
    private CategorieLocale categorieService;
    //(Filiere filiere, Categorie categorie, User user, Salle salle)
    @POST
    @Path("/addReservation/{filiere_code}/{user_code}/{salle_code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReservation(
            @PathParam("filiere_code") int filiere_code,
            @PathParam("user_code") int user_code,
            @PathParam("salle_code") int salle_code) {
        try {
            // Récupérer les entités nécessaires
            Filiere filiere = FiliereService.getFiliere(filiere_code);
            
            User user = UserService.getUser(user_code);
            Salle salle = SalleService.getSalle(salle_code);

            // Créer la réservation
            Reservation reserv = new Reservation(filiere, user, salle);
            ReservationService.addReservation(reserv);
            String S="reservation effectue user : "+user.getNom()+" au salle : "+salle.getLibelle()+ " ";
            Notification noti=new Notification(reserv,S);
            NotificationService.addNotification(noti);
            if("indisponible".equals(reserv.getSalle().getStatut())) {
            	NotificationProf notiprof=new NotificationProf("la salle "+reserv.getSalle().getLibelle()+ " que vous tentez de reserver est indisponible consulter les salles disponibles correspondantes a votre categorie et filiere. ");
                NotificationProfService.addNotificationProf(notiprof);
            }
            return Response.status(Response.Status.CREATED).entity(reserv).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la création de la réservation.")
                    .build();
        }
    }


    @POST
    @Path("/modifierReservation/{id}/{filiere_code}/{user_code}/{salle_code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateReservation(@PathParam("id")int id,@PathParam("filiere_code")int filiere_code,@PathParam("user_code")int user_code,@PathParam("salle_code")int salle_code ) {
    	Filiere filiere=FiliereService.getFiliere(filiere_code);
    	
    	User user=UserService.getUser(user_code);
    	Salle salle=SalleService.getSalle(salle_code);
        Reservation reserv=new Reservation(filiere,user,salle);
        reserv.setId(id);
        System.out.print(reserv.getId());
        ReservationService.updateReservation(reserv);
        String S="...reservation libere par user : "+user.getNom()+"  salle :"+salle.getLibelle()+" ";
        Notification noti=new Notification(reserv,S);
        NotificationService.addNotification(noti);
        return Response.status(Response.Status.CREATED).entity(reserv).build();
    	
    	
    	
    	
    }

    @GET
    @Path("/{id}")
    public Response getReservation(@PathParam("id") int id) {
        Reservation reserv = ReservationService.getReservation(id);
        if (reserv != null) {
            return Response.ok(reserv).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    

    @GET
    @Path("/afficherReservations")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Reservation> listReservation() {
        return ReservationService.afficheReservations();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteReservation(@PathParam("id") int id) {
    	Reservation reserv=ReservationService.getReservation(id);
    	
    	
    	 
        ReservationService.removeReservation(id);
       
        return Response.noContent().build();
    }
}