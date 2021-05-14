package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.ExpiredListController;
import db.DataAccessException;
import model.Batch;
import model.Status;

class ExpiredList_UnitTest {

	ExpiredListController elc;
	
	@BeforeEach
	public void setup() throws DataAccessException, SQLException {
		elc = new ExpiredListController();
	}

	@Test
	void generateDiscountListTest() throws Exception {
		//Arrange
		List<Batch> nl = new ArrayList<>();
		//Act
		nl = elc.generateExpiredList();
		//Assert
		assertNotNull("Should not be equal to null", nl);
	}
	
	@Test
	void checkIfStatusIsExpired() throws Exception {
		List<Batch> nl = new ArrayList<>();
		//Act
		nl = elc.generateExpiredList();
		
		assertTrue(nl.get(0).getNotification().getStatus() == Status.EXPIRED);
	}

}
