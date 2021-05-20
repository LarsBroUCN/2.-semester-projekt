package controller;

import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import db.DataAccessException;
import model.Batch;

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
		batchList.clear();
		ArrayList<Batch> expiredList = new ArrayList<Batch> (Ectrl.generateExpiredList());
		ArrayList<Batch> pendingList = new ArrayList<Batch> (Pctrl.generatePendingList());
		ArrayList<Batch> discountList = new ArrayList<Batch> (Dctrl.generateDiscountList());

		
		//join batchLists
		addToBatchList(expiredList);
		addToBatchList(discountList);
		addToBatchList(pendingList);
		
		
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
		
		public String getLastGenerateListUpdateTime() throws Exception {
			// get new batchList
			List<Batch> resList = new ArrayList<>(); 
			
			ArrayList<Batch> expiredList = new ArrayList<Batch>(Ectrl.generateExpiredList());
			ArrayList<Batch> pendingList = new ArrayList<Batch>(Pctrl.generatePendingList());
			ArrayList<Batch> discountList = new ArrayList<Batch>(Dctrl.generateDiscountList());

			resList.addAll(expiredList);
			resList.addAll(discountList);
			resList.addAll(pendingList);
			
			boolean resBool = true; 
			
			
			// Compare the lists
			if(resList.size() == batchList.size()) {
				for (int i = 0; i < resList.size() && resBool == true; i++) {
					if(resList.get(i).getBatchID() != batchList.get(i).getBatchID()) {
						resBool = false;
					}
				}
			} else {
				resBool = false;
			}

			// If list is new then get the current time
			if(!resBool) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime now = LocalTime.now();
				return now.format(dtf);
			}
			
			return null;	
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
	
	
	


