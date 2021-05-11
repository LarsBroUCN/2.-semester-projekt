package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataAccessException;
import model.Batch;

public class PendingListController {

	private ArrayList<Batch> batchListPendingNotifications = new ArrayList<Batch>();
private BatchController bc;
	
	public PendingListController() throws DataAccessException, SQLException {
		bc = new BatchController();
	}
	public List<Batch> generatePendingList() throws DataAccessException {
		batchListPendingNotifications = bc.generatePendingList();
		return batchListPendingNotifications;
	}

}
