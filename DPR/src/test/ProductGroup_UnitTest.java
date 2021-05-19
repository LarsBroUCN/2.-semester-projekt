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
		String name = pg.getGroupName();
		assertEquals("some name", name);
	}

	@Test
	public void setProductGroupNameTest() {
		String name = "new name";
		pg.setGroupName(name);
		assertEquals(name, pg.getGroupName());
	}

	@Test
	public void getGroupWarningPeriod() {
		int i = pg.getGroupWarningPeriod();
		assertEquals(10, i);
	}

	@Test
	public void setGroupWarningPeriod() {
		int newInt = 1;
		pg.setGroupWarningPeriod(newInt);
		assertEquals(newInt, pg.getGroupWarningPeriod());
	}

}
