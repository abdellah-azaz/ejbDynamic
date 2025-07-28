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

import fol1.fol2.UserService.UserLocale;
import fol1.fol2.categorieServices.CategorieLocale;
import fol1.fol2.entities.Categorie;
import fol1.fol2.entities.Matiere;
import fol1.fol2.entities.Salle;
import fol1.fol2.entities.User;
import fol1.fol2.matiereServices.MatiereLocale;
import fol1.fol2.services.SalleLocale;
import fol1.fol2.services.SalleService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Stateless
public class UserApi {

    @Inject
    private UserLocale UserService;
   

    
    @POST
    @Path("/verifyUser/{email}/{mot_de_passe}/{role}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response verifyUser(
            @PathParam("email") String email,
            @PathParam("mot_de_passe") String motDePasse,
            @PathParam("role") String role) {
        try {
            User user = UserService.verifyUser(motDePasse, email, role); // Appel du service
            if (user != null) {
                return Response.ok(user).build(); // Utilisateur trouvé, retour en JSON
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Utilisateur non trouvé ou informations incorrectes.")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la vérification de l'utilisateur.")
                    .build();
        }
    }
    
    
    @Path("/getUserById/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") int id) {
        try {
            User user = UserService.getUser(id); // Appel du service pour trouver l'utilisateur par ID
            if (user != null) {
                return Response.ok(user).build(); // Retourne l'utilisateur en JSON
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Utilisateur avec l'ID " + id + " non trouvé.")
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la recherche de l'utilisateur avec l'ID: " + id)
                    .build();
        }
    }

    
    
    
}

