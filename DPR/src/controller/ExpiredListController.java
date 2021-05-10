package controller;

import java.util.ArrayList;
import java.util.List;

import model.Batch;

public class ExpiredListController {

	private static ArrayList<Batch> batchListExpiredNotifications = new ArrayList<Batch>();
	
	public static List<Batch> generateExpiredList() {
		batchListExpiredNotifications = BatchController.generateExpiredList();
		return batchListExpiredNotifications;
	}
	
}
