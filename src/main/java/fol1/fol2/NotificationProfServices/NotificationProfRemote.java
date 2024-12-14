package fol1.fol2.NotificationProfServices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import fol1.fol2.entities.Notification;
import fol1.fol2.entities.NotificationProf;

@Remote
public interface NotificationProfRemote {
	NotificationProf addNotificationProf(NotificationProf noti);
    List<NotificationProf> afficheNotificationProf();
    void removeNotificationProfs();
    void removeNotificationProf(int id);
}