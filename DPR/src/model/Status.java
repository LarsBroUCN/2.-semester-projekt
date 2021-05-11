package model;

public enum Status {
	PENDING("PENDING"), DISCOUNT("DISCOUNT"), EXPIRED("EXPIRED"), DISCARD("DISCARD"), COMPLETE("COMPLETE");
	
	private String value;

	Status(String string) {
		value = string;
	} 
	
	public String getValue() {
		return value;
	}
}
