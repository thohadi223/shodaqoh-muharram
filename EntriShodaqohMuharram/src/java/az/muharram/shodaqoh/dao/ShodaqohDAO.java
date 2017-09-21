package az.muharram.shodaqoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.muharram.shodaqoh.entities.JenisShodaqoh;
import az.muharram.shodaqoh.entities.Penyumbang;
import az.muharram.shodaqoh.entities.Shodaqoh;
import az.muharram.shodaqoh.entities.User;

public class ShodaqohDAO {
	private Connection connection;
	
	private final String INSERT = "INSERT INTO tr_shodaqoh (nomor_transaksi,tahun,operator,penyumbang,shodaqoh,jumlah) " +
			"VALUES (?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE tr_shodaqoh SET operator=?,penyumbang=?,shodaqoh=?,jumlah=?" +
			" WHERE id_transaksi = ?";
	private final String FIND_THN_AKTIF = "SELECT tahun FROM tahun_aktif WHERE status = true";
	private final String FIND_ALL = "SELECT id_transaksi,nomor_transaksi,operator,penyumbang,nama," +
			"alamat,shodaqoh,jumlah,jenis,satuan FROM tr_shodaqoh A LEFT JOIN penyumbang B " +
			"ON A.penyumbang = B.id_penyumbang LEFT JOIN ms_shodaqoh C ON A.shodaqoh = C.id_shodaqoh WHERE tahun=?";
	private final String FIND_PER_OPR = "SELECT id_transaksi,nomor_transaksi,operator,penyumbang,nama," +
			"alamat,shodaqoh,jumlah,jenis,satuan FROM tr_shodaqoh A LEFT JOIN penyumbang B " +
			"ON A.penyumbang = B.id_penyumbang LEFT JOIN ms_shodaqoh C ON A.shodaqoh = C.id_shodaqoh " +
			"WHERE tahun=? AND operator=? ORDER BY nomor_transaksi DESC";
	
	private PreparedStatement insert;
	private PreparedStatement findThnAktif;
	private PreparedStatement update;
	private PreparedStatement findAll;
	private PreparedStatement findPerOperator;
	
	public ShodaqohDAO(Connection connection) throws SQLException {
		this.connection = connection;
		findThnAktif = this.connection.prepareStatement(FIND_THN_AKTIF);
		insert = this.connection.prepareStatement(INSERT);
		update = this.connection.prepareStatement(UPDATE);
		findAll = this.connection.prepareStatement(FIND_ALL);
		findPerOperator = this.connection.prepareStatement(FIND_PER_OPR);
	}
	public List<Shodaqoh> findByOperator(int tahun,User o) throws SQLException{
		findPerOperator.setString(1, String.valueOf(tahun));
		findPerOperator.setString(2, o.getUsername());
		
		ResultSet rs = findPerOperator.executeQuery();
		List<Shodaqoh> list = new ArrayList<Shodaqoh>();
		
		while(rs.next()){
			Shodaqoh s = new Shodaqoh();
			s.setIdTransaksi(rs.getInt("id_transaksi"));
			s.setNoTransaksi(rs.getString("nomor_transaksi"));
			s.setPenyumbang(new Penyumbang(rs.getInt("penyumbang")));
			s.getPenyumbang().setNama(rs.getString("nama"));
			s.getPenyumbang().setAlamat(rs.getString("alamat"));
			s.setJenisShodaqoh(new JenisShodaqoh(rs.getInt("shodaqoh")));
			s.setJumlah(rs.getDouble("jumlah"));
			s.getJenisShodaqoh().setJenis(rs.getString("jenis"));
			s.getJenisShodaqoh().setSatuan(rs.getString("satuan"));
			s.setTahun(tahun);
			s.setOperator(o);
			list.add(s);
		}
		
		return list;
	}
	public List<Shodaqoh> findAll(int tahun) throws SQLException{
		findAll.setString(1, String.valueOf(tahun));
		ResultSet rs = findAll.executeQuery();
		List<Shodaqoh> list = new ArrayList<Shodaqoh>();
		
		while(rs.next()){
			Shodaqoh s = new Shodaqoh();
			s.setIdTransaksi(rs.getInt("id_transaksi"));
			s.setNoTransaksi(rs.getString("nomor_transaksi"));
			s.setOperator(new User(rs.getString("operator")));
			s.setPenyumbang(new Penyumbang(rs.getInt("penyumbang")));
			s.getPenyumbang().setNama(rs.getString("nama"));
			s.getPenyumbang().setAlamat(rs.getString("alamat"));
			s.setJenisShodaqoh(new JenisShodaqoh(rs.getInt("shodaqoh")));
			s.setJumlah(rs.getDouble("jumlah"));
			s.getJenisShodaqoh().setJenis(rs.getString("jenis"));
			s.getJenisShodaqoh().setSatuan(rs.getString("satuan"));
			s.setTahun(tahun);
			list.add(s);
		}
		
		return list;
	}
	public int findThnAktif() throws SQLException{
		ResultSet rs = findThnAktif.executeQuery();
		int tahun = 0;
		
		if(rs.next()){
			tahun =  rs.getInt("tahun");
		}
		
		return tahun;
	}
	
	public void insert(Shodaqoh s) throws SQLException{
		insert.setString(1, s.getNoTransaksi());
		insert.setString(2, String.valueOf(s.getTahun()));
		insert.setString(3, s.getOperator().getUsername());
		insert.setInt(5, s.getJenisShodaqoh().getIdJenis());
		insert.setDouble(6, s.getJumlah());
		
		if(s.getPenyumbang()!=null){
			insert.setInt(4, s.getPenyumbang().getIdPenyumbang());
		}else{
			insert.setObject(4, null);
		}
		insert.executeUpdate();
	}
	
	public void update(Shodaqoh s) throws SQLException{
		update.setString(1, s.getOperator().getUsername());
		update.setInt(3, s.getJenisShodaqoh().getIdJenis());
		update.setDouble(4, s.getJumlah());
		update.setInt(5, s.getIdTransaksi());
		
		if(s.getPenyumbang()!=null)
			update.setInt(2, s.getPenyumbang().getIdPenyumbang());
		else
			update.setObject(2, null);
		update.executeUpdate();
	}
}
