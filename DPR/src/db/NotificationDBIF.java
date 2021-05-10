package db;

import model.Status;

public interface NotificationDBIF {
	
	public Status getstate() throws DataAccessException;
	
	public void setStateExpired(int notificationID) throws DataAccessException;

}
