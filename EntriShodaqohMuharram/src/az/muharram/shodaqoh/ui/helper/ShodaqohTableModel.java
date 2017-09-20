package az.muharram.shodaqoh.ui.helper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

import az.muharram.shodaqoh.entities.JenisShodaqoh;
import az.muharram.shodaqoh.entities.Shodaqoh;

public class ShodaqohTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6931108430770210275L;
	
	private String[] columns = {"No.","No. Transaksi","Jenis","Jumlah", "Penyumbang", "Asal"};
	private List<Shodaqoh> data;
	private DecimalFormat df = (DecimalFormat) NumberFormat.getInstance(new Locale("in"));
	public ShodaqohTableModel(List<Shodaqoh> data) {
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
		Shodaqoh s = data.get(row);
		
		JenisShodaqoh jenis = s.getJenisShodaqoh();
		
		String namaPenyumbang = "";
		String alamatPenyumbang = "";
		
		if(s.getPenyumbang()!=null){
			namaPenyumbang = s.getPenyumbang().getNama();
			alamatPenyumbang = s.getPenyumbang().getAlamat();
		}
		switch(col){
			case 0: return new Integer(row+1);
			case 1: return s.getNoTransaksi();
			case 2: return jenis.getJenis()+" - "+jenis.getSatuan();
			case 3: return df.format(s.getJumlah());
			case 4: return namaPenyumbang;
			case 5: return alamatPenyumbang;
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
	
	public void addDataItem(Shodaqoh s){
		data.add(s);
		fireTableDataChanged();
	}
	
	public Shodaqoh getDataItem(int index){
		return this.data.get(index);
	}
	
	public void setDataItems(List<Shodaqoh> newData){
		this.data = newData;
		fireTableDataChanged();
	}
}
