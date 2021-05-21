package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Batch;
import model.Notification;

public class Notification_UnitTest {

	Notification n;
	
	@Before
	public void setUp() {
		n = new Notification(-1, "some data", 14.0, null);
	}

	
	@Test
	public void getNoteStringTest() {
		// Arrange
		String s = null;
		
		// Act
		s = n.getNote();
		
		// Assert
		assertEquals("some data", s);
	}
	
	@Test
	public void setNoteStringTest() {
		// Arrange
		String newNote = "Some new text";
		
		// Act
		n.setNote(newNote);
		
		// Assert
		assertEquals(newNote, n.getNote());
	}
	
	@Test
	public void getDiscountTest() {
		// Arrange
		double d = -1;
		
		// Act
		d = n.getDiscount();
		
		// Assert
		assertEquals(14.0, d, 0);
	}
	
	@Test
	public void setDiscountTest() {
		// Arrange
		double newD = 13.0;
		
		// Act
		n.setDiscount(newD);
		
		// Assert
		assertEquals(newD, n.getDiscount(), 0);
	}
	
	

}
