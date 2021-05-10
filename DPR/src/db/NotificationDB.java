package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Notification;
import model.Status;

public class NotificationDB implements NotificationDBIF {
	private static final String FINDSTATEQ = "select * from notifications where status = 'pending'";
	private static final String UPDATEQ = "update notifications set discount =?, note =?, status=? where batchID_fk =?  ";
	private PreparedStatement findState, update;
	
	public NotificationDB() throws DataAccessException {
		try {
			findState = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATEQ);
			update = DBConnection.getInstance().getConnection().prepareStatement(UPDATEQ);
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

	//update
	@Override
	public Notification setStateExpired(Notification notification) throws DataAccessException {
		try {
			update.setDouble(1, notification.getDiscount());
			update.setString(2, notification.getNote());
			update.setObject(3, (notification.getStatus()));
			update.executeUpdate();
		} catch (Exception e) {
			throw new DataAccessException(null, "Kunne ikke opdatere status");
		}
		return notification;		
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