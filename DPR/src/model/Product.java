package model;

public class Product {
	private String productName;
	private String barcode;
	private double price;
	private int productWarningPeriod;
	private ProductGroup productGroup;

	public Product(String productName, String barcode, double price, int productWarningPeriod,
			ProductGroup productGroup) {
		super();
		this.productName = productName;
		this.barcode = barcode;
		this.price = price;
		this.productWarningPeriod = productWarningPeriod;
		this.productGroup = productGroup;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getProductWarningPeriod() {
		return productWarningPeriod;
	}

	public void setProductWarningPeriod(int productWarningPeriod) {
		this.productWarningPeriod = productWarningPeriod;
	}

	public ProductGroup getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(ProductGroup productGroup) {
		this.productGroup = productGroup;
	}

}
