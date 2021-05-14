package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import controller.BatchController;
import db.DataAccessException;
import model.Batch;

class BatchCtrl_UnitTest {

	BatchController bc;

	public BatchCtrl_UnitTest() throws DataAccessException, SQLException {
		bc = new BatchController();
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
		pendingList = bc.generatePendingList();
		discountList = bc.generateDiscountList();
		pdList = bc.getPDList();
		res.addAll(pendingList);
		res.addAll(discountList);
		
		assertEquals(res, pdList);
		// Assert
	}
}
