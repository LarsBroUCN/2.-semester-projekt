package db;

import java.util.List;

import model.Notification;
import model.Status;

public interface NotificationDBIF {
	
	public List<Notification> getstate() throws DataAccessException;
	
	public void setStateExpired(int notificationID) throws DataAccessException;

}
