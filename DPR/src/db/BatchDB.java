package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Batch;
import model.Status;

public class BatchDB implements BatchDBIF {
	private static final String  FINDSTATUSQ = "select notifications.batchid_fk, notifications.status from notifications\r\n"
			+ " inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = ?";
	private final String SEARCH_BATCH_Q = "select * from batch where BatchID = ?";
	private PreparedStatement findstatus, searchBatch;
	
	public BatchDB() throws SQLException {
		findstatus = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATUSQ);
        searchBatch = DBConnection.getInstance().getConnection().prepareStatement(SEARCH_BATCH_Q);
	}
	
	   public Batch searchBatch(int batchID) throws DataAccessException {
	        try {
	            searchBatch.setInt(1, batchID);
	            ResultSet rs = searchBatch.executeQuery();
	            Batch b = null;
	            if(rs.next()) {
	                b = buildObject(rs);
	            }
	            return b;
	        } catch (SQLException e) {
	            throw new DataAccessException(e, "Could not retrieve data");
	        }
	        }
	    private Batch buildObject(ResultSet rs) throws DataAccessException {
	   try {
	           Batch b = null;
	            if(rs.getString(columnIndex).equals) {
	        }
	        return null;

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
