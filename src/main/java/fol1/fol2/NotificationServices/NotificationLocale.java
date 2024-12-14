package fol1.fol2.NotificationServices;

import java.util.List;

import javax.ejb.Local;

import fol1.fol2.entities.Notification;

@Local
public interface NotificationLocale {
	Notification addNotification(Notification noti);
    List<Notification> afficheNotifications();
    void removeNotifications();
    void removeNotification(int id);
}





