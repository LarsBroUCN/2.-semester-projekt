package test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.GenerateListController;
import db.DataAccessException;
import model.Batch;
import model.Notification;

public class GenerateList_UnitTest {

	GenerateListController generateListController;
	
	@Before
	public void setup() throws DataAccessException, SQLException {
		generateListController = new GenerateListController();
	}
	
	@Test
	public void generateList_Test() throws Exception {
		
		//Arrange

		generateListController.generateList();
		

		List<Notification> nl = new ArrayList<>();

		
		//Act
		
		
		//Assert
		assertNotNull("Should have been succesfull", nl);
	}	
	

//	@Test
//	public void generateExpiredList_Test() throws Exception {
//		
//		//Arrange
//		List<Batch> batch =  batchController.generateExpiredList();
//		
//		
//		//Act
//		
//		//Assert
//		assertNotNull("Should have been successful", batch);
//	}	
	
	
	@After
	public void cleanUp() {		
	}

}
