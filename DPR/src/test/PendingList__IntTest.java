package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PendingListController;
import db.DataAccessException;
import model.Batch;
import model.Status;

class PendingList__IntTest {
	PendingListController plc;

	@BeforeEach
	public void setup() throws DataAccessException, SQLException {
		plc = new PendingListController();
	}

	@Test
	void generateDiscountListTest() throws Exception {
		//Arrange
		List<Batch> nl = new ArrayList<>();
		//Act
		nl = plc.generatePendingList();
		//Assert
		assertTrue("Should contain objects", nl.size() > 0);;
	}
	
	@Test
	void checkIfStatusIsPending() throws Exception {
		List<Batch> nl = new ArrayList<>();
		//Act
		nl = plc.generatePendingList();
		
		assertTrue(nl.get(0).getNotification().getStatus() == Status.PENDING);
	}
}
