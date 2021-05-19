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
		String s = n.getNote();
		assertEquals("some data", s);
	}
	
	@Test
	public void setNoteStringTest() {
		String newNote = "Some new text";
		n.setNote(newNote);
		assertEquals(newNote, n.getNote());
	}
	
	@Test
	public void getDiscountTest() {
		double d = n.getDiscount();
		assertEquals(14.0, d, 0);
	}
	
	@Test
	public void setDiscountTest() {
		double newD = 13.0;
		n.setDiscount(newD);
		assertEquals(newD, n.getDiscount(), 0);
	}
	
	

}
