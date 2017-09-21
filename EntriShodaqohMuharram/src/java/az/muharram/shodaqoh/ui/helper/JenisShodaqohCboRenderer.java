/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package az.muharram.shodaqoh.ui.helper;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import az.muharram.shodaqoh.entities.JenisShodaqoh;


/**
 *
 * @author THOHA
 */
public class JenisShodaqohCboRenderer extends DefaultListCellRenderer{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8239306092521298949L;

	@Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(value instanceof JenisShodaqoh){
            JenisShodaqoh jenisShodaqoh = (JenisShodaqoh)value;
            setText(jenisShodaqoh.getJenis()+" - "+jenisShodaqoh.getSatuan());
        }
        return this;

    }


}
