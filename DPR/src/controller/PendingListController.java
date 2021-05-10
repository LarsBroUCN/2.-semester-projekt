package controller;

import java.util.ArrayList;
import java.util.List;

import model.Batch;

public class PendingListController {

	private static ArrayList<Batch> batchListPendingNotifications = new ArrayList<Batch>();
	
	public static List<Batch> generatePendingList() {
		batchListPendingNotifications = BatchController.generatePendingList();
		return batchListPendingNotifications;
	}

}
