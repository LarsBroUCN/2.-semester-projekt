package model;

public class ProductGroup {
	private String groupName;
	private int groupWarningPeriod;

	public ProductGroup(String groupName, int groupWarningPeriod) {
		super();
		this.groupName = groupName;
		this.groupWarningPeriod = groupWarningPeriod;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupWarningPeriod() {
		return groupWarningPeriod;
	}

	public void setGroupWarningPeriod(int groupWarningPeriod) {
		this.groupWarningPeriod = groupWarningPeriod;
	}

}
