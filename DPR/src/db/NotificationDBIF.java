package db;

import java.util.List;

import model.Notification;
import model.Status;

public interface NotificationDBIF {
	
	public List<Notification> getstate() throws DataAccessException;	
	public Notification setStateExpired(Notification notification) throws DataAccessException;
	public Notification findByBatchFK(int batchID) throws DataAccessException;

}
