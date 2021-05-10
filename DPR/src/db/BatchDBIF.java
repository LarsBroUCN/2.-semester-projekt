package db;

import model.Batch;
import model.Status;

public interface BatchDBIF {
	
	public boolean checkIfNotificationExist() throws DataAccessException;
	
	public boolean checkBatchDate() throws DataAccessException;
	
	public Status getNotificationState() throws DataAccessException;
	
	public Batch getBatch() throws DataAccessException;

}
