package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.BatchController;
import controller.GenerateListController;
import db.DataAccessException;
import model.Batch;
import model.Notification;

public class generateList_UnitTest {

	GenerateListController generateListController;
	BatchController batchController;
	
	@Before
	public void setup() throws DataAccessException, SQLException {
		generateListController = new GenerateListController();
		batchController = new BatchController();
	}
	
//	@Test
//	public void generateList_Test() throws Exception {
//		
//		//Arrange
//		generateListController.generateList();
//		ArrayList<Notification> nl=	generateListController.getNotifikationCopyList();
//		
//		//Act
//		
//		//Assert
//		assertNotNull("Should have been succesfull", nl);
//	}	
//	
	
	@Test
	public void generateExpiredList_Test() throws Exception {
		
		//Arrange
		List<Batch> batch =  batchController.generateExpiredList();
		
		
		//Act
		
		//Assert
		assertNotNull("Should have been succesfull", batch);
	}	
	
	
	@After
	public void cleanUp() {		
	}

}
