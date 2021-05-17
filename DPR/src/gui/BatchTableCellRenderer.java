package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class BatchTableCellRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = 1L;
	
	@Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row, int col) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        String status = (String) table.getValueAt(row, 2);
        if ("DISCOUNT".equals(status)) {
            setBackground(Color.YELLOW);
            setForeground(Color.BLACK);

        } else if("EXPIRED".equals(status)) {
        	setBackground(Color.RED);
            setForeground(Color.WHITE);        	
        }else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }       
        return this;
    }  

}
