package db;

import java.util.List;
import model.Notification;

public interface NotificationDBIF {
	public List<Notification> getstate() throws DataAccessException;
	public Notification findByBatchFK(int batchID) throws DataAccessException;
	public void updateNotification(Notification notification, int batchID) throws DataAccessException;
	public void insertNotification(Notification notification, int batchID) throws DataAccessException;
}
