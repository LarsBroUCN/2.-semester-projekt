package db;

import model.Batch;
import model.Status;

public class BatchDB implements BatchDBIF {

	@Override
	public boolean checkIfNotificationExist() throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkBatchDate() throws DataAccessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Status getNotificationState() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Batch getBatch() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
