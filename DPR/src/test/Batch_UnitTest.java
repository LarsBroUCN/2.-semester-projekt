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
	
	// Might remove this test
	@Test
	public void objectExistTest() {
		assertNotNull("Should not be equal to null", b);;
	}
	
	@Test
	public void getWarningPeriodTest() {
		int i = b.getWarningPeriod();
		assertEquals(10, i);
	}
	
	@Test
	public void setWarningPeriodTest() {
		b.setWarningPeriod(1);
		assertEquals(1, b.getWarningPeriod());
	}

}
