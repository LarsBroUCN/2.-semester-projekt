package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DataAccessException;
import model.Batch;

public class DiscountListController {
	private BatchController bc;

	public DiscountListController() throws DataAccessException, SQLException {
		bc = new BatchController();
	}

	private List<Batch> batchListDiscountNotifications = new ArrayList<Batch>();

	public List<Batch> generateDiscountList() throws DataAccessException {

		batchListDiscountNotifications = bc.generateDiscountList();
		return batchListDiscountNotifications;
	}

}
