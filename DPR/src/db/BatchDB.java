package db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Batch;
import model.Status;

public class BatchDB implements BatchDBIF {
	private static final String  FINDSTATUSQ = "    select notifications.batchid_fk, notifications.status from notifications\r\n"
			+ " inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = ?";
	private PreparedStatement findstatus;
	
	public BatchDB() throws SQLException {
		findstatus = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATUSQ);
	}
	
	
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
