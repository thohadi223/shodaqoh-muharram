package az.muharram.shodaqoh.entities;

public class Shodaqoh {
	private int idTransaksi;
	private String noTransaksi;
	private int tahun;
	private User operator;
	private Penyumbang penyumbang;
	private JenisShodaqoh jenisShodaqoh;
	private double jumlah;
	
	
	public int getIdTransaksi() {
		return idTransaksi;
	}
	public void setIdTransaksi(int idTransaksi) {
		this.idTransaksi = idTransaksi;
	}
	public String getNoTransaksi() {
		return noTransaksi;
	}
	public void setNoTransaksi(String noTransaksi) {
		this.noTransaksi = noTransaksi;
	}
	public int getTahun() {
		return tahun;
	}
	public void setTahun(int tahun) {
		this.tahun = tahun;
	}
	public User getOperator() {
		return operator;
	}
	public void setOperator(User operator) {
		this.operator = operator;
	}
	public Penyumbang getPenyumbang() {
		return penyumbang;
	}
	public void setPenyumbang(Penyumbang penyumbang) {
		this.penyumbang = penyumbang;
	}
	public JenisShodaqoh getJenisShodaqoh() {
		return jenisShodaqoh;
	}
	public void setJenisShodaqoh(JenisShodaqoh jenisShodaqoh) {
		this.jenisShodaqoh = jenisShodaqoh;
	}
	public double getJumlah() {
		return jumlah;
	}
	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}
	
	
}
