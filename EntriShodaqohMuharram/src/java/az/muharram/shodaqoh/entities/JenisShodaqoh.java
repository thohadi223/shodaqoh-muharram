package az.muharram.shodaqoh.entities;

public class JenisShodaqoh {
	private int idJenis;
	private String jenis;
	private String satuan;
	private String keterangan;
	
	public JenisShodaqoh() {
	
	}
	
	public JenisShodaqoh(int idJenis){
		this.idJenis = idJenis;
	}
	
	public int getIdJenis() {
		return idJenis;
	}
	public void setIdJenis(int idJenis) {
		this.idJenis = idJenis;
	}
	public String getJenis() {
		return jenis;
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}
	public String getSatuan() {
		return satuan;
	}
	public void setSatuan(String satuan) {
		this.satuan = satuan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof JenisShodaqoh){
			JenisShodaqoh js = (JenisShodaqoh)obj;
			return js.getIdJenis() == this.idJenis;
		}else
			return false;
	}
	
	@Override
	public int hashCode() {
		return this.idJenis*223;
	}
}
