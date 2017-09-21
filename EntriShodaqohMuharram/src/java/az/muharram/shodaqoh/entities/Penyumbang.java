package az.muharram.shodaqoh.entities;

public class Penyumbang {
	private int idPenyumbang;
	private String nama;
	private String alamat;
	
	public Penyumbang() {
		
	}
	
	public Penyumbang(int idPenyumbang){
		this.idPenyumbang = idPenyumbang;
	}
	
	public int getIdPenyumbang() {
		return idPenyumbang;
	}
	public void setIdPenyumbang(int idPenyumbang) {
		this.idPenyumbang = idPenyumbang;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	
	
}
