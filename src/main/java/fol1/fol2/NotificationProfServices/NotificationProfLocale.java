package fol1.fol2.NotificationProfServices;

import java.util.List;

import javax.ejb.Local;

import fol1.fol2.entities.Notification;
import fol1.fol2.entities.NotificationProf;

@Local
public interface NotificationProfLocale {
	NotificationProf addNotificationProf(NotificationProf noti);
    List<NotificationProf> afficheNotificationProf();
    void removeNotificationProfs();
    void removeNotificationProf(int id);
}