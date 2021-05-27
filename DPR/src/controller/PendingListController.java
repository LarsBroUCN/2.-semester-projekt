package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DataAccessException;
import model.Batch;

public class PendingListController {

	private List<Batch> batchListPendingNotifications = new ArrayList<Batch>();
	private BatchController bc;

	public PendingListController() throws SQLException, DataAccessException {
		bc = new BatchController();
	}

	public List<Batch> generatePendingList() throws Exception {
		batchListPendingNotifications = bc.generatePendingList();
		return batchListPendingNotifications;
	}

}
