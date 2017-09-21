package az.muharram.shodaqoh.ui.helper;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import az.muharram.shodaqoh.entities.JenisShodaqoh;

public class JenisShodaqohTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6931108430770210275L;
	
	private String[] columns = {"No.","Jenis","Satuan", "Keterangan"};
	private List<JenisShodaqoh> data;
	public JenisShodaqohTableModel(List<JenisShodaqoh> data) {
		this.data = data;
	}
	
	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		JenisShodaqoh jenis = data.get(row);

		switch(col){
			case 0: return new Integer(row+1);
			case 1: return jenis.getJenis();
			case 2: return jenis.getSatuan();
			case 3: return jenis.getKeterangan();
			
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	
	@Override
    public Class<?> getColumnClass(int columnIndex) {
		Object o = getValueAt(0, columnIndex);
		if(o==null)
			return String.class;
		else
			return o.getClass();
		/*return getValueAt(0, columnIndex).getClass();*/
            
    }
	
	public void addDataItem(JenisShodaqoh s){
		data.add(s);
		fireTableDataChanged();
	}
	
	public JenisShodaqoh getDataItem(int index){
		return this.data.get(index);
	}
	
	public void setDataItems(List<JenisShodaqoh> newData){
		this.data = newData;
		fireTableDataChanged();
	}
}
