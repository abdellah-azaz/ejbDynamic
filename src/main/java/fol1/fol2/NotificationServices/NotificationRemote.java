package fol1.fol2.NotificationServices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import fol1.fol2.entities.Notification;

@Remote
public interface NotificationRemote {
	Notification addNotification(Notification noti);
    List<Notification> afficheNotifications();
    void removeNotifications();
    void removeNotification(int id);
}
