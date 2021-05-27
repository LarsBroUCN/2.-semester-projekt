package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.ProductGroup;


public class ProductDB implements ProductDBIF{
	private static final String FINDBARCODEQ = "select * from products where barcode =?";
	private PreparedStatement findBarcode;	
	
	public ProductDB() throws SQLException {
		findBarcode = DBConnection.getInstance().getConnection().prepareStatement(FINDBARCODEQ);
	}

	@Override
	public Product findByBarcodeFK(String barcode) throws DataAccessException {
		try {
			findBarcode.setString(1, barcode);
			ResultSet rs = findBarcode.executeQuery();
			Product p = null;
			if(rs.next()){
				p = buildObject(rs);
			}
			return p;
		} catch (Exception e) {
		       throw new DataAccessException(null, "Kunne ikke finde nogle produkter.");
		}
	
	}

		
	
	private List<Product> buildObjects(ResultSet rs) throws SQLException {	
		List<Product> res = new ArrayList<>();	
		while(rs.next()) {
			res.add(buildObject(rs));
		}
		return res;
	}


	private Product buildObject(ResultSet rs) throws SQLException {	
		Product n = new Product(			
				rs.getString("productName"),
				rs.getString("barcode"),
				rs.getDouble( String.valueOf("price").toString()),
				rs.getInt("productWarningPeriod"),
			    new ProductGroup(null, 0)
				);
		return n;
	}
}
