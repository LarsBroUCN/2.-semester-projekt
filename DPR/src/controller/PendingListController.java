package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataAccessException;
import model.Batch;

public class PendingListController {

	private BatchController bc;
	
	public PendingListController() throws SQLException, DataAccessException {
		bc = new BatchController();
	}
	
	private ArrayList<Batch> batchListPendingNotifications = new ArrayList<Batch>();
	
	public List<Batch> generatePendingList() throws DataAccessException {
		batchListPendingNotifications = bc.generatePendingList();
		return batchListPendingNotifications;
	}

}
