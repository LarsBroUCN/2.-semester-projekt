package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Batch;

public class BatchTableModel extends DefaultTableModel {
	private static final long serialVersionUID = 1L;
	private List<Batch> data;
	private List<Boolean> selection;
	private static final String[] COL_NAMES = { "Produkt", "Stregkode", "Status", "Rabat", "Valgt" };

	public BatchTableModel() {
		data = new ArrayList<>();
		selection = new ArrayList<>();
	}

	public void setData(List<Batch> data) {
		this.data.clear();
		this.selection.clear();
		
		for(Batch b: data) {
			this.data.add(b);
			this.selection.add(Boolean.FALSE);
		}
		
		super.fireTableDataChanged();
	}
	
	public List<Integer> getSelectedIdentities() {
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0; i < selection.size(); i++) {
			if(selection.get(i)) {
				res.add(data.get(i).getBatchID());
			}
		}
		
		return res;
	}

	public Batch getDataAtIndex(int index) {
		Batch res = null;
		if (index >= 0 && index < data.size()) {
			res = data.get(index);
		}
		return res;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return col == 4;
	}

	@Override
	public int getRowCount() {
		int res = 0;
		if (data != null) {
			res = data.size();
		}
		return res;
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public String getColumnName(int column) {
		return COL_NAMES[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		Batch currBatch = data.get(row);
		Boolean selected = selection.get(row);
		
		String res = "UNDEFINED";
		switch (column) {
		case 0:
			res = "" + currBatch.getProduct().getProductName();
			break;
		case 1:
			res = "" + currBatch.getProduct().getBarcode();
			break;
		case 2:
			res = "" + currBatch.getNotification().getStatus();
			break;
		case 3:
			res = "" + currBatch.getNotification().getDiscount();
			break;
		case 4:
			return selected;
		default:
			res = "UNKOWN COL - CONTACt th... bzzt admIN!11!";
		}
		return res;
	}
	
	@Override
	public void setValueAt(Object value, int row, int column) {
		if (column == 4) {
			selection.set(row, (boolean) value);
			super.fireTableCellUpdated(row, column);
		};
	}

	@Override
	public Class<?> getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return Boolean.class;
		default:
			return String.class;
		}
	}

}
