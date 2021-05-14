package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.BatchController;
import db.BatchDB;
import db.BatchDBIF;
import db.DataAccessException;
import model.Batch;
import model.Status;

class BatchCtrl_UnitTest {

	BatchController bc;
	BatchDBIF bdb;

	public BatchCtrl_UnitTest() throws DataAccessException, SQLException {
		bc = new BatchController();
		bdb = new BatchDB();
	}

	@Test
	public void generateExpiredListTest() throws Exception {
		// Arrange
		List<Batch> bl = new ArrayList<>();

		// Act
		bl = bc.generateExpiredList();
		// Assert
		assertNotNull("Should not be equal to null", bl);
	}

	@Test
	public void generateDiscountListTest() throws Exception {

		// Arrange
		List<Batch> bl = new ArrayList<>();

		// Act
		bl = bc.generateDiscountList();
		// Assert
		assertNotNull("Should not be equal to null", bl);
	}
	
	@Test
	public void generatePendingListTest() throws Exception {

		// Arrange
		List<Batch> bl = new ArrayList<>();

		// Act
		bl = bc.generatePendingList();
		// Assert
		assertNotNull("Should not be equal to null", bl);
	}
	
	// PDList should be equal to the combination of the pendingList and discountList
	@Test
	public void getPDListTest() throws Exception {
		// Arrange
		List<Batch> res = new ArrayList<>();
		List<Batch> pendingList = new ArrayList<>();
		List<Batch> discountList = new ArrayList<>();
		List<Batch> pdList = new ArrayList<>();
		
		// Act
		pendingList = bdb.findAllByStatus(Status.PENDING);
		discountList = bdb.findAllByStatus(Status.DISCOUNT);
		pdList = bc.getPDList();
		res.addAll(pendingList);
		res.addAll(discountList);
		
		boolean resBool = true;
		
		if(pdList.size() == res.size()) {
			for (int i = 0; i < res.size(); i++) {
				if(pdList.get(i).getBatchID() != res.get(i).getBatchID()) {
					resBool = false;
				}
			}
		}
		
		// Assert
		assertTrue(resBool);
	}
}
