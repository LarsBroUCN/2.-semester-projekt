package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.BatchController;
import db.DataAccessException;
import model.Batch;

public class generateList_UnitTest {

	BatchController batchController;
	
	@Before
	public void setup() throws DataAccessException, SQLException {
		batchController = new BatchController();
	}
	
	@Test
	public void generateExpiredList_Test() throws Exception {
		
		//Arrange
		List<Batch> batch = batchController.generateExpiredList();
		
		//Act
		
		//Assert
		assertNotNull("Should have been succesfull", batch);
	}	
	
	
	
	@After
	public void cleanUp() {		
	}

}
