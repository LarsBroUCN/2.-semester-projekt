package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataAccessException;
import model.Batch;

public class ExpiredListController {

	private BatchController bc;
	
	public ExpiredListController() throws SQLException, DataAccessException {
		bc = new BatchController();
	}
	
	private ArrayList<Batch> batchListExpiredNotifications = new ArrayList<Batch>();
	
	public List<Batch> generateExpiredList() throws DataAccessException {
		batchListExpiredNotifications = bc.generateExpiredList();
		return batchListExpiredNotifications;
	}
	
}
