package db;

import java.util.List;

import model.Notification;
import model.Status;

public interface NotificationDBIF {
	
	public List<Notification> getstate() throws DataAccessException;	
	public Notification findByBatchFK(int batchID) throws DataAccessException;
	public Notification updateNotification(Notification notification, int batchID) throws DataAccessException;
	public Notification insertNotification(Notification notification, int batchID) throws DataAccessException;

}
