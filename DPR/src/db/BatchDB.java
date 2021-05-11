package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Batch;
import model.Product;
import model.Status;

public class BatchDB implements BatchDBIF {
	
	private final String SEARCH_BATCH_Q = "select * from batch where BatchID = ?";
	private PreparedStatement searchBatch;
	
	public BatchDB() throws DataAccessException {
		try {
			searchBatch = db.DBConnection.getInstance().prepareStatement(SEARCH_BATCH_Q);
		} catch(SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
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
			if(rs.getString(columnIndex).equals)
		}
		return null;
	}
	
	
	@Override
	public boolean checkIfNotificationExist() throws DataAccessException {
		
		return false;
	}

	@Override
	public boolean checkBatchDate() throws DataAccessException {
		
		return false;
	}

	@Override
	public Status getNotificationState() throws DataAccessException {
		
		return null;
	}

	@Override
	public Batch getBatch() throws DataAccessException {
		
		return null;
	}

}
