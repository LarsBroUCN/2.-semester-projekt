package db;

import model.Product;

public interface ProductDBIF {	
	public Product findByBarcodeFK(String barcode) throws DataAccessException;	
}
