package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.DiscountListController;
import db.DataAccessException;
import model.Batch;
import model.Status;

class DiscountList_UnitTest {
	DiscountListController dlc;

	@BeforeEach
	public void setup() throws DataAccessException, SQLException {
		dlc = new DiscountListController();
	}

	@Test
	void generateDiscountListTest() throws DataAccessException {
		//Arrange
		List<Batch> nl = new ArrayList<>();
		//Act
		nl = dlc.generateDiscountList();
		//Assert
		assertTrue("Should contain objects", nl.size() > 0);
	}
	
	@Test
	void checkIfStatusIsDiscount() throws DataAccessException {
		List<Batch> nl = new ArrayList<>();
		//Act
		nl = dlc.generateDiscountList();
		
		assertTrue(nl.get(0).getNotification().getStatus() == Status.DISCOUNT);
	}

}
