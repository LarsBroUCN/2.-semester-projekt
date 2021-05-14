package test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PendingListController;
import db.DataAccessException;
import model.Batch;

class PendingList__UnitTest {
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
		assertNotNull("Should not be equal to null", nl);
	}
}
