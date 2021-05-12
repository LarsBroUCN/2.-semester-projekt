package db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Batch;
import model.Notification;
import model.Product;
import model.Status;

public class BatchDB implements BatchDBIF {
	private static final String  FINDSTATUSQ = "select notifications.batchid_fk, notifications.status from notifications\r\n"
			+ " inner join Batches on batches.batchid = Notifications.batchID_fk where notifications.status = ?";
	private static final String SEARCH_BATCH_Q = "select * from batches where BatchID = ?";
	private static final String UPDATE_BATCH_Q = "update batches set arrivaldate =?, expirationdate=?, warningperiod=?, barcode_fk=? where batchID=? ";
	private static final String FIND_ALL_NOT_NOTIFICATION = "select * from batches where batches.batchID not in (select Notifications.batchID_fk from notifications)";
	private PreparedStatement findAllByStatus, searchBatch, updateBatch, findAllNotNotification;
	private NotificationDB ndb;

	public BatchDB() throws SQLException, DataAccessException {
		findAllByStatus = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATUSQ);
		searchBatch = DBConnection.getInstance().getConnection().prepareStatement(SEARCH_BATCH_Q);
		updateBatch = DBConnection.getInstance().getConnection().prepareStatement(UPDATE_BATCH_Q);
		findAllNotNotification = DBConnection.getInstance().getConnection().prepareStatement(FIND_ALL_NOT_NOTIFICATION);
		ndb = new NotificationDB();
	}

	@Override
	public Batch searchBatch(int batchID) throws DataAccessException {
		try {
			searchBatch.setInt(1, batchID);
			ResultSet rs = searchBatch.executeQuery();
			Batch b = null;
			if (rs.next()) {
				b = buildObject(rs);
			}
			return b;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Kunne ikke finde data");
		}
	}
	
	@Override
	public List<Batch> findAllByStatus(Status status) throws DataAccessException {
        try {
            findAllByStatus.setString(1, status.toString());
            ResultSet rs = findAllByStatus.executeQuery();
            List<Batch> res = buildObjects(rs);
            return res;
        } catch (Exception e) {
            throw new DataAccessException(null, "Kunne ikke finde nogle batches.");
        }
	}
	
	@Override
	public List<Batch> findAllNotNotification() throws DataAccessException {
        try {            
            ResultSet rs = findAllNotNotification.executeQuery();
            List<Batch> res = buildObjects(rs);
            return res;
        } catch (Exception e) {
            throw new DataAccessException(null, "Kunne ikke finde nogle batches.");
        }
	}
	   
	   
	@Override
	public void updateBatch(Batch batch) throws DataAccessException {
		try {
			updateBatch.setDate(1, Date.valueOf(batch.getArrivalDate()));
			updateBatch.setDate(2, Date.valueOf(batch.getExpirationDate()));
			updateBatch.setInt(3, batch.getWarningPeriod());
			updateBatch.setString(4, batch.getProduct().getBarcode());
			updateBatch.execute();
			Notification notification = batch.getNotification();
			if(notification != null) {
				ndb.updateNotification(notification);
			}
		} catch (Exception e) {
			throw new DataAccessException(e, "Kunne ikke opdatere batchen");
		}
	}
	
	
	private List<Batch> buildObjects(ResultSet rs) throws SQLException, DataAccessException {	
		List<Batch> res = new ArrayList<>();	
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}

	private Batch buildObject(ResultSet rs) throws SQLException, DataAccessException {
		Batch b = new Batch(rs.getInt("batchID"), rs.getDate("arrivaldate").toLocalDate(), rs.getInt("warningperiod"),
				rs.getDate("expirationdate").toLocalDate(), new Product(null, rs.getString("barcode_fk"), 0, 0, null),
				null);
		Notification n = ndb.findByBatchFK(rs.getInt("batchID"));
		b.setNotification(n);
		return b;

	}


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
