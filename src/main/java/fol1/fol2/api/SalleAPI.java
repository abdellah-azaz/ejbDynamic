package fol1.fol2.api;

import java.io.IOException;
import java.util.List;



import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
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

import fol1.fol2.NotificationProfServices.NotificationProfLocale;
import fol1.fol2.categorieServices.CategorieLocale;
import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Matiere;
import fol1.fol2.entities.Notification;
import fol1.fol2.entities.NotificationProf;
import fol1.fol2.entities.Salle;
import fol1.fol2.matiereServices.MatiereLocale;
import fol1.fol2.services.SalleLocale;
import fol1.fol2.services.SalleService;







@Path("/salles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)  
@Stateless
public class SalleAPI {

    @Inject
    private SalleLocale salleService;
    @Inject
    private MatiereLocale matiereService;
    @Inject 
    private CategorieLocale categorieService;
    @Inject
    private NotificationProfLocale NotificationProfService;

    @POST
    @Path("/addSalle/{categorie_code}/{statut}/{libelle}/{nbr_places}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSalle(@PathParam("categorie_code")int categorie_code,@PathParam("statut")String statut,@PathParam("libelle")String libelle,@PathParam("nbr_places")int nbr_places ) {
    	
    	Categorie categorie=categorieService.getCategorie(categorie_code);
        Salle newSalle = new Salle(categorie,statut,libelle,nbr_places);
        salleService.addSalle(newSalle);
        String S="salle ajoute par le responsable des salle : "+newSalle.getLibelle()+"qui est une salle de : "+categorie.getLibelle()+" ";
        NotificationProf noti=new NotificationProf(S);
        NotificationProfService.addNotificationProf(noti);
        return Response.status(Response.Status.CREATED).entity(newSalle).build();
    }
    
    @POST
    @Path("/modifierSalle/{id}/{categorie_code}/{statut}/{libelle}/{nbr_places}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSalle(@PathParam("id")int id,@PathParam("categorie_code")int categorie_code,@PathParam("statut")String statut,@PathParam("libelle")String libelle,@PathParam("nbr_places")int nbr_places ) {
    	
    	Categorie categorie=categorieService.getCategorie(categorie_code);
        Salle newSalle = new Salle(categorie,statut,libelle,nbr_places);
        newSalle.setId(id);
        salleService.updateSalle(newSalle);
        String S="salle modifie par le responsable des salle : "+newSalle.getLibelle()+" qui est une salle de : "+categorie.getLibelle()+" ";
        NotificationProf noti=new NotificationProf(S);
        NotificationProfService.addNotificationProf(noti);
        return Response.status(Response.Status.CREATED).entity(newSalle).build();
    }
    
    @POST
    @Path("/traiter/{nom}/{id}/{categorie_code}/{statut}/{libelle}/{nbr_places}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response traiterSalle(@PathParam("nom")String nom,@PathParam("id")int id,@PathParam("categorie_code")int categorie_code,@PathParam("statut")String statut,@PathParam("libelle")String libelle,@PathParam("nbr_places")int nbr_places ) {
    	
    	Categorie categorie=categorieService.getCategorie(categorie_code);
        Salle newSalle = new Salle(categorie,statut,libelle,nbr_places);
        newSalle.setId(id);
        salleService.updateSalle(newSalle);
        if("indisponible".equals(newSalle.getStatut())) {
        	String S="monsieur "+nom+" votre demande a ete traite par le responsable des salle : "+newSalle.getLibelle()+" qui est une salle de : "+categorie.getLibelle()+" ";
            NotificationProf noti=new NotificationProf(S);
            NotificationProfService.addNotificationProf(noti);
        }
        
        return Response.status(Response.Status.CREATED).entity(newSalle).build();
    }

    @GET
    @Path("/{id}")
    public Response getSalle(@PathParam("id") int id) {
        Salle salle = salleService.getSalle(id);
        if (salle != null) {
            return Response.ok(salle).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    

    @GET
    @Path("/afficher")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Salle> listSalles() {
        return salleService.afficheSalles();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSalle(@PathParam("id") int id) {
    	Salle newSalle=salleService.getSalle(id);
        salleService.removeSalle(id);
        String S="salle supprime par le responsable des salle : "+newSalle.getLibelle()+"qui est une salle de : "+newSalle.getCategorie().getLibelle()+" ";
        NotificationProf noti=new NotificationProf(S);
        NotificationProfService.addNotificationProf(noti);
        return Response.noContent().build();
    }
}

