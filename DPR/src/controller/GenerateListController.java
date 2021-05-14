package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DataAccessException;
import model.Batch;
import model.Notification;
import model.Status;

public class GenerateListController {

	
	private ArrayList<Batch> batchList = new ArrayList<Batch>();
	//private ArrayList<Notification> notificationList = new ArrayList<Notification>();
	private ExpiredListController Ectrl;
	private PendingListController Pctrl;
	private DiscountListController Dctrl;
	

	public GenerateListController() throws DataAccessException, SQLException {
		Ectrl = new ExpiredListController();
		Pctrl = new PendingListController();
		Dctrl = new DiscountListController();
	}
	
	public void generateList() throws Exception {		
		ArrayList<Batch> pendingList = new ArrayList<Batch> (Pctrl.generatePendingList());
		ArrayList<Batch> discountList = new ArrayList<Batch> (Dctrl.generateDiscountList());
		ArrayList<Batch> expiredList = new ArrayList<Batch> (Ectrl.generateExpiredList());

		
		//join batchLists
		
		addToBatchList(pendingList);
		addToBatchList(discountList);
		addToBatchList(expiredList);
	}
		private void addToBatchList(ArrayList<Batch> batches) {
			for(Batch batch : batches) {
				batchList.add(batch);
			}
		}
		
		public ArrayList<Batch> getBatchCopyList(){
			ArrayList<Batch> batchListcopy = new ArrayList<Batch>(batchList); // create copy of list batchList
			
			return batchListcopy; //return copy of list
		}		
	//	createNotificationListFromBatchList(batchList); //Find notifications from batchList and transfer to notificationList	
	}
	
//	private void createNotificationListFromBatchList(ArrayList<Batch> batches){
//		for(Batch batch : batches) {
//			notificationList.add(batch.getNotification());
//		}
//	}
//	
	
	
//	public ArrayList<Notification> getNotifikationCopyList(){
//		ArrayList<Notification> notificationListcopy = new ArrayList<Notification>(notificationList); // create copy of list notificationList
//		
//		return notificationListcopy; //return copy of list
//	}
	
	
	


