package controller;

import java.util.ArrayList;
import java.util.List;

import model.Batch;
import model.Notification;
import model.Status;

public class GenerateListController {

	private ArrayList<Batch> batchList = new ArrayList<Batch>();
	private ArrayList<Notification> notificationList = new ArrayList<Notification>();
	
	public ArrayList<Notification> generateList(Status status) {
		ArrayList<Batch> expiredList = (ArrayList<Batch>) ExpiredListController.generateExpiredList();
		ArrayList<Batch> pendingList = (ArrayList<Batch>) PendingListController.generatePendingList();
		ArrayList<Batch> discountList = (ArrayList<Batch>) DiscountListController.generateDiscountList();
		
		//join batchLists
		addToBatchList(expiredList);
		addToBatchList(pendingList);
		addToBatchList(discountList);
		
		createNotificationListFromBatchList(batchList); //Find notifications from batchList and transfer to notificationList
		
		ArrayList<Notification> notificationListcopy = new ArrayList<Notification>(notificationList); // create copy of list notificationList
		
		return notificationListcopy; //return copy of list
	}
	
	private void createNotificationListFromBatchList(ArrayList<Batch> batches){
		for(Batch batch : batches) {
			notificationList.add(batch.getNotification());
		}
	}
	
	private void addToBatchList(ArrayList<Batch> batches) {
		for(Batch batch : batches) {
			batchList.add(batch);
		}
	}
	
}
