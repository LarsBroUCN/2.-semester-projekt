package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import model.Batch;

public class Batch_UnitTest {

	private Batch b;

	@Before
	public void setUp() {
		b = new Batch(-1, null, 10, null, null, null);
	}
	
	
	@Test
	public void getWarningPeriodTest() {
		// Arrange
		int i = -1;
		
		// Act
		i = b.getWarningPeriod();
		
		// Assert
		assertEquals(10, i);
	}
	
	@Test
	public void setWarningPeriodTest() {
		// Arrange
		int i = 1;
		
		// Act
		b.setWarningPeriod(i);
		
		// Assert
		assertEquals(i, b.getWarningPeriod());
	}

}
