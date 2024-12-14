package fol1.fol2.UserService;



import fol1.fol2.entities.Salle;
import fol1.fol2.entities.User;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserLocale {
    User addUser(User user);
    User updateUser(User user);
    User getUser(int id);
    List<User> afficheUser();
    void removeUser(int id);
    User verifyUser(String mot_de_passe,String email,String role);
    User findUserByRole(String role);
}