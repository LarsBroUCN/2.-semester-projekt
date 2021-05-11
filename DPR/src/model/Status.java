package model;

public enum Status {
	pending("pending"), discount("discount"), expired("expired"), discard("discard"), complete("complete");
	
	private String value;

	Status(String string) {
		value = string;
	} 
	
	public String getValue() {
		return value;
	}
}
