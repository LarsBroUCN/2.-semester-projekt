package controller;

import java.util.List;

import model.Batch;
import model.Status;


public class GenerateListController {

	public List<Batch> generateList(Status status) {
		PendingListController.generatePendingList();
		return null;
	}
	
	
}
