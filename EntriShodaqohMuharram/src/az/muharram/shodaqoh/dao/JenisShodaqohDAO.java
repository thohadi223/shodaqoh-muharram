package az.muharram.shodaqoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.muharram.shodaqoh.entities.JenisShodaqoh;

public class JenisShodaqohDAO {
	private Connection connection;
	
	private final String FIND_ALL = "SELECT id_shodaqoh,jenis,satuan,keterangan FROM ms_shodaqoh";
	private final String INSERT = "INSERT INTO ms_shodaqoh VALUES(?,?,?,?)";
	private final String UPDATE = "UPDATE ms_shodaqoh SET jenis=?,satuan=?,keterangan=? WHERE id_shodaqoh=?";
	
	private PreparedStatement findAll;
	private PreparedStatement insert;
	private PreparedStatement update;
	
	public JenisShodaqohDAO(Connection connection) throws SQLException {
		this.connection = connection;
		findAll = this.connection.prepareStatement(FIND_ALL);
		insert = this.connection.prepareStatement(INSERT);
		update = this.connection.prepareStatement(UPDATE);
	}
	
	public List<JenisShodaqoh> findAll() throws SQLException{
		ResultSet rs = findAll.executeQuery();
		List<JenisShodaqoh> list = new ArrayList<JenisShodaqoh>();
		
		while(rs.next()){
			JenisShodaqoh jenis = new JenisShodaqoh();
			jenis.setIdJenis(rs.getInt("id_shodaqoh"));
			jenis.setJenis(rs.getString("jenis"));
			jenis.setSatuan(rs.getString("satuan"));
			jenis.setKeterangan(rs.getString("keterangan"));
			
			list.add(jenis);
		}
		return list;
	}
	public void insert(JenisShodaqoh j) throws SQLException{
		insert.setInt(1, j.getIdJenis());
		insert.setString(2, j.getJenis());
		insert.setString(3, j.getSatuan());
		insert.setString(4, j.getKeterangan());
		
		insert.executeUpdate();
	}
	public void update(JenisShodaqoh j) throws SQLException{
		update.setString(1, j.getJenis());
		update.setString(2, j.getSatuan());
		update.setString(3, j.getKeterangan());
		update.setInt(4, j.getIdJenis());
		
		update.executeUpdate();
	}
}
