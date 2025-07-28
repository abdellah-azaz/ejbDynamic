package fol1.fol2.UserService;



import fol1.fol2.entities.Reservation;
import fol1.fol2.entities.Salle;
import fol1.fol2.entities.User;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService implements UserLocale, UserRemote {
	  @PersistenceContext(unitName = "SalleEjb")
	    private EntityManager em;
    

    public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
    public User addUser(User user) {
        em.persist(user);
        return user;
    }

	  @Override
	  public User updateUser(User user) {
		  User oldUser=em.find(User.class, user.getCode());
		  if(oldUser != null) {
			  oldUser.setMot_de_passe(user.getMot_de_passe());
			  oldUser.setNom(user.getNom());
			  oldUser.setPrenom(user.getPrenom());
			  oldUser.setStatut(user.getStatut());
			  oldUser.setTelephon(user.getTelephon());
			  em.merge(oldUser);
			  return oldUser;
		  }
		  else {
			  throw new IllegalArgumentException("la user avec l code :"+user.getCode()+"nexiste pas");
		  }
	      
	  }

    @Override
    public User getUser(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> afficheUser() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void removeUser(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }
    @Override
    public User verifyUser(String mot_de_passe, String email, String role) {
        try {
            return em.createQuery(
                    "SELECT u FROM User u WHERE u.mot_de_passe = :motDePasse AND u.email = :email AND u.role = :role",
                    User.class)
                    .setParameter("motDePasse", mot_de_passe)
                    .setParameter("email", email)
                    .setParameter("role", role)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Aucun utilisateur trouvé
        }
    }
    @Override
    public User findUserByRole(String role) {
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class)
                    .setParameter("role", role)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Aucun utilisateur trouvé avec ce rôle
        }
    }

}
