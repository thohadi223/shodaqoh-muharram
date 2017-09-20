package az.muharram.shodaqoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import az.muharram.shodaqoh.entities.Penyumbang;

public class PenyumbangDAO {
	private Connection connection;
	
	private final String INSERT = "INSERT INTO penyumbang VALUES (null,?,?)";
	private final String UPDATE = "UPDATE penyumbang SET nama=?,alamat=? WHERE id_penyumbang = ?";
	private final String FIND_LAST_ID = "SELECT LAST_INSERT_ID()";
	
	private PreparedStatement insert;
	private PreparedStatement findLastID;
	private PreparedStatement update;
	
	public PenyumbangDAO(Connection connection) throws SQLException {
		this.connection = connection;
		insert = this.connection.prepareStatement(INSERT);
		findLastID = this.connection.prepareStatement(FIND_LAST_ID);
		update = this.connection.prepareStatement(UPDATE);
	}
	public void update(Penyumbang p) throws SQLException{
		update.setString(1, p.getNama());
		update.setString(2, p.getAlamat());
		update.setInt(3, p.getIdPenyumbang());
		
		update.executeUpdate();
	}
	public void insert(Penyumbang p) throws SQLException{
		insert.setString(1, p.getNama());
		insert.setString(2, p.getAlamat());
		
		insert.executeUpdate();
		
		ResultSet rs = findLastID.executeQuery();
		rs.next();
		p.setIdPenyumbang(rs.getInt(1)); //set id penyumbang
	}
}
