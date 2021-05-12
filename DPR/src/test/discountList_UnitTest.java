package test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.DiscountListController;
import db.DataAccessException;
import model.Batch;

class discountList_UnitTest {
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
		assertNotNull("Should not be equal to null", nl);
	}

}
