package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Product;

public class Product_UnitTest {

	Product p;

	@Before
	public void setUp() {
		p = new Product("Something", "123456789", 100.0, 5, null);
	}

	
	@Test
	public void getProductNameTest() {
		String s = p.getProductName();
		assertEquals("Something", s);
	}
	
	@Test
	public void setProductNameTest() {
		String newName = "Some new text";
		p.setProductName(newName);
		assertEquals(newName, p.getProductName());
	}
	
	@Test
	public void getBarcodeTest() {
		String s = p.getBarcode();
		assertEquals("123456789", s);
	}
		
	@Test
	public void getPriceTest() {
		double price = p.getPrice();
		assertEquals(100.0, price, 0);
	}
	
	@Test
	public void setPriceTest() {
		double newPrice = 59.9;
		p.setPrice(newPrice);
		assertEquals(newPrice, p.getPrice(), 0);
	}
	
	@Test
	public void getProductWarningPeriodTest() {
		int warn = p.getProductWarningPeriod();
		assertEquals(5, warn);
	}
	
	@Test
	public void setProductWarningPeriodTest() {
		int warn = 20;
		p.setProductWarningPeriod(warn);
		assertEquals(warn, p.getProductWarningPeriod());
	}

}
