package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Batch;
import model.Notification;
import model.Product;

public class BatchDB implements BatchDBIF {
	private static final String  FINDSTATUSQ = "select notifications.batchid_fk, notifications.status from notifications\r\n"
			+ " inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = ?";
	private static final String SEARCH_BATCH_Q = "select * from batch where BatchID = ?";
	private PreparedStatement findstatus, searchBatch;
	private NotificationDB ndb;
	
	public BatchDB() throws SQLException, DataAccessException {
		findstatus = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATUSQ);
        searchBatch = DBConnection.getInstance().getConnection().prepareStatement(SEARCH_BATCH_Q);
        ndb = new NotificationDB();
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
	   
	   
	    private Batch buildObject(ResultSet rs) throws SQLException, DataAccessException {
	    		Batch b = new Batch(rs.getInt("batchID"), rs.getDate("arrivaldate").toLocalDate(), 
	    				rs.getInt("warningperiod"), rs.getDate("expirationdate").toLocalDate(), 
	    				new Product(null, rs.getString("barcode_fk"), 0, 0, null), null);
	    		Notification n = ndb.findByBatchFK(rs.getInt("batchID"));
	    		b.setNotification(n);
	    		return b;

	       }
	
//	@Override
//	public boolean checkIfNotificationExist() throws DataAccessException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean checkBatchDate() throws DataAccessException {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Status getNotificationState() throws DataAccessException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Batch getBatch() throws DataAccessException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
