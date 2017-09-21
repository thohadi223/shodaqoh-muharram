package az.muharram.shodaqoh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import az.muharram.shodaqoh.entities.User;

public class UserDAO {
	private Connection connection;
	private final String FIND_BY_USERNAME = "SELECT password,privilege FROM users WHERE username=?";
	private final String UPDATE_PASSWORD = "UPDATE users SET password=? WHERE username=?";
	
	private PreparedStatement findByUsername;
	private PreparedStatement updatePassword;
	
	public UserDAO(Connection connection) throws SQLException {
		this.connection = connection;
		findByUsername = this.connection.prepareStatement(FIND_BY_USERNAME);
		updatePassword = this.connection.prepareStatement(UPDATE_PASSWORD);
	}
	
	public void updatePassword(String username,String newPassword) throws SQLException{
		updatePassword.setString(1, newPassword);
		updatePassword.setString(2, username);
		updatePassword.executeUpdate();
	}
	
	public User findUser(String username) throws SQLException{
		findByUsername.setString(1, username);
		ResultSet rs = findByUsername.executeQuery();
		User user = null;
		if(rs.next()){
			user = new User(username);
			user.setPassword(rs.getString(1).trim());
			user.setPrivilege(rs.getInt(2));
		}
		return user;
	}
}
