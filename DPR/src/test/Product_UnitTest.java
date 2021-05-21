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
		// Arrange
		String s = null;
		
		// Act
		s = p.getProductName();
		
		// Assert
		assertEquals("Something", s);
	}
	
	@Test
	public void setProductNameTest() {
		// Arrange
		String newName = "Some new text";
		
		// Act
		p.setProductName(newName);
		
		// Assert
		assertEquals(newName, p.getProductName());
	}
	
	@Test
	public void getBarcodeTest() {
		// Arrange
		String s = null;
		
		// Act
		s = p.getBarcode();
		
		// Assert
		assertEquals("123456789", s);
	}
		
	@Test
	public void getPriceTest() {
		// Arrange
		double price = -1;
		
		// Act
		price = p.getPrice();
		
		// Assert
		assertEquals(100.0, price, 0);
	}
	
	@Test
	public void setPriceTest() {
		// Arrange
		double newPrice = 59.9;
		
		// Act
		p.setPrice(newPrice);
		
		// Assert
		assertEquals(newPrice, p.getPrice(), 0);
	}
	
	@Test
	public void getProductWarningPeriodTest() {
		// Arrange
		int warn = -1;
		
		// Act
		warn = p.getProductWarningPeriod();
		
		// Assert
		assertEquals(5, warn);
	}
	
	@Test
	public void setProductWarningPeriodTest() {
		// Arrange
		int warn = 20;
		
		// Act
		p.setProductWarningPeriod(warn);
		
		// Assert
		assertEquals(warn, p.getProductWarningPeriod());
	}

}
