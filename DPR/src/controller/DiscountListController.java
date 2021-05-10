package controller;

import java.util.ArrayList;
import java.util.List;

import model.Batch;

public class DiscountListController {

	private static ArrayList<Batch> batchListDiscountNotifications = new ArrayList<Batch>();
	
	public static List<Batch> generateDiscountList() {
		batchListDiscountNotifications = BatchController.generateDiscountList();
		return batchListDiscountNotifications;
	}
	
}
