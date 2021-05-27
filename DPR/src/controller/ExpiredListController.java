package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DataAccessException;
import model.Batch;

public class ExpiredListController {

	private List<Batch> batchListExpiredNotifications = new ArrayList<Batch>();
	private BatchController bc;

	public ExpiredListController() throws DataAccessException, SQLException {
		bc = new BatchController();
	}

	public List<Batch> generateExpiredList() throws Exception {

		batchListExpiredNotifications = bc.generateExpiredList();
		return batchListExpiredNotifications;
	}

}
