package az.muharram.shodaqoh.ui.helper;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author THOHA
 */
public class MyTableCellRenderer extends DefaultTableCellRenderer{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7000306308889960450L;

	@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if(!isSelected){
    		if(row % 2 ==1)
                component.setBackground(new Color(240, 240, 240));
            else if (row % 2 ==0 )
                component.setBackground(Color.WHITE);
                
        }
        
        this.setBorder(new EmptyBorder(2,5,2,5));
        return component;
    }

    
}
