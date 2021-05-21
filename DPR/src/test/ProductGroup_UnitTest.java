package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.ProductGroup;

public class ProductGroup_UnitTest {

	ProductGroup pg;

	@Before
	public void setUp() {
		pg = new ProductGroup("some name", 10);
	}

	@Test
	public void getProductGroupNameTest() {
		// Arrange
		String name = null;
		
		// Act
		name = pg.getGroupName();
		
		// Assert
		assertEquals("some name", name);
	}

	@Test
	public void getGroupWarningPeriod() {
		// Arrange
		int i = -1;
		
		// Act
		i = pg.getGroupWarningPeriod();
		
		// Assert
		assertEquals(10, i);
	}

	@Test
	public void setGroupWarningPeriod() {
		// Arrange
		int newInt = 1;
		
		// Act
		pg.setGroupWarningPeriod(newInt);
		
		// Assert
		assertEquals(newInt, pg.getGroupWarningPeriod());
	}

}
