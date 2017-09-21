package az.muharram.shodaqoh.ui.helper;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;

public class EntriTableCellRenderer extends MyTableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3146637164257906824L;
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		
		Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
				row, column);
		if(value instanceof Integer || column==3) 
        	this.setHorizontalAlignment(JLabel.RIGHT);
        else 
        	this.setHorizontalAlignment(JLabel.LEFT);
		
		return component;
	}
}
