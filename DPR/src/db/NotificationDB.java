package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Notification;
import model.Status;

public class NotificationDB implements NotificationDBIF {
	private static final String FINDSTATEQ = "select * from notifications where status =?";
	private static final String UPDATEQ = "update notifications set discount =?, note =?, status=? where batchID_fk =?";
	private static final String FINDBYBATCHFKQ = "select * from notifications where batchID_fk =?";
	private static final String insertQ = "insert into notifications (discount, note, status, batchID_fk) values (?, ?, ?, ?)";
	private PreparedStatement findState, update, findByBatchFK, insert;
	
	public NotificationDB() throws DataAccessException {
		try {
			findState = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATEQ);
			update = DBConnection.getInstance().getConnection().prepareStatement(UPDATEQ);
			findByBatchFK = DBConnection.getInstance().getConnection().prepareStatement(FINDBYBATCHFKQ);
			insert = DBConnection.getInstance().getConnection().prepareStatement(insertQ);
		} catch (SQLException e) {
			throw new DataAccessException(e, "could not prepare statement");
		}
	}
	
	
	//findall notifications
	@Override
	public List<Notification> getstate() throws DataAccessException {
		try {		
			ResultSet rs = findState.executeQuery();			
			List<Notification> res = buildObjects(rs);			
			return res;			
		} catch (Exception e) {
			throw new DataAccessException(null, "Kunne ikke finde nogle notifikationer.");
		}
	}
	
	@Override
	public Notification insertNotification(Notification notification, int batchID) throws DataAccessException{
		try {
			insert.setDouble(1, notification.getDiscount());
			insert.setString(2, notification.getNote());
			insert.setObject(3, (notification.getStatus().toString()));
			insert.setInt(4, batchID);
			insert.execute();
		} catch (Exception e) {
			throw new DataAccessException(null, "Kunne ikke indsætte en ny notifikation");
		}
		return notification;
	}
	
	
	//update
	@Override
	public Notification updateNotification(Notification notification, int batchID) throws DataAccessException {
		try {
			update.setDouble(1, notification.getDiscount());
			update.setString(2, notification.getNote());
			update.setObject(3, (notification.getStatus().toString()));
			update.setInt(4, batchID);
			update.execute();
			
		} catch (Exception e) {
			throw new DataAccessException(null, "Kunne ikke opdatere status");
		}
		return notification;		
	}
	
	public Notification findByBatchFK(int batchID) throws DataAccessException {
		try {
			findByBatchFK.setInt(1, batchID);
			ResultSet rs = findByBatchFK.executeQuery();
			Notification n = null;
			if(rs.next()) {
                n = buildObject(rs);
            }
			return n;
					
		} catch (Exception e) {
			throw new DataAccessException(e, "Kunne ikke generere en notifikation");
		}
	}
	
	
	private List<Notification> buildObjects(ResultSet rs) throws SQLException {	
		List<Notification> res = new ArrayList<>();	
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}


	private Notification buildObject(ResultSet rs) throws SQLException {
	
		Notification n = new Notification(			
				rs.getString("note"),
			 	rs.getDouble("discount"),
			 Status.valueOf(rs.getString("status"))			
				);
		return n;
	}

}