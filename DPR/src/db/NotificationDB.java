package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Notification;
import model.Status;

public class NotificationDB implements NotificationDBIF {
	private static final String FINDSTATEQ = "select * from notifications where Status =?";
	private PreparedStatement findState;
	
	public NotificationDB() throws DataAccessException {
		try {
			findState = DBConnection.getInstance().getConnection().prepareStatement(FINDSTATEQ);
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
			throw new DataAccessException(null, "Kunne ikke finde nogle informationer, om værksteder osv.");
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
			 	rs.getDouble(""),
			 	Status.valueOf(rs.getString("status")) 
				);
		return n;
	}


	//update
	@Override
	public void setStateExpired(int notificationID) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
