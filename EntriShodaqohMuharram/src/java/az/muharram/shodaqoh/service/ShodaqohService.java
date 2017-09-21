package az.muharram.shodaqoh.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;


import az.muharram.shodaqoh.dao.JenisShodaqohDAO;
import az.muharram.shodaqoh.dao.PenyumbangDAO;
import az.muharram.shodaqoh.dao.ShodaqohDAO;
import az.muharram.shodaqoh.dao.UserDAO;
import az.muharram.shodaqoh.entities.JenisShodaqoh;
import az.muharram.shodaqoh.entities.Shodaqoh;
import az.muharram.shodaqoh.entities.User;

public class ShodaqohService {
	private Connection connection;
	private JenisShodaqohDAO jenisShodaqohDA0;
	private ShodaqohDAO shodaqohDAO;
	private PenyumbangDAO penyumbangDAO;
	private UserDAO userDAO;
	
	public ShodaqohService(){
		
	}
	
	public void setConnection(Connection connection) throws SQLException{
		this.connection = connection;
		shodaqohDAO = new ShodaqohDAO(connection);
		jenisShodaqohDA0 = new JenisShodaqohDAO(connection);
		penyumbangDAO = new PenyumbangDAO(connection);
		userDAO = new UserDAO(connection);
	}
	
	public List<JenisShodaqoh> findAllJenis() throws SQLException{
		return jenisShodaqohDA0.findAll();
	}

	public User findUser(String username) throws SQLException{
		return userDAO.findUser(username);
	}
	
	public int findThnAktif() throws SQLException{
		return shodaqohDAO.findThnAktif();
	}
	
	public void save(Shodaqoh s) throws SQLException{
		connection.setAutoCommit(false);
		
		if(s.getPenyumbang()!=null){
			if(s.getPenyumbang().getIdPenyumbang()==0)
				penyumbangDAO.insert(s.getPenyumbang());
			else
				penyumbangDAO.update(s.getPenyumbang());
		}
			
		if(s.getIdTransaksi()==0)
			shodaqohDAO.insert(s);
		else
			shodaqohDAO.update(s);
		
		connection.commit();
		connection.setAutoCommit(true);
	}
	public void save(JenisShodaqoh j) throws SQLException{
		connection.setAutoCommit(false);
		
		if(j.getIdJenis()==0)
			jenisShodaqohDA0.insert(j);
		else
			jenisShodaqohDA0.update(j);
		
		connection.commit();
		connection.setAutoCommit(true);
	}
	public List<Shodaqoh> findByOperator(int tahun,User user) throws SQLException{
		return shodaqohDAO.findByOperator(tahun, user);
	}
	public void updatePassword(String username,String newPassword) throws SQLException{
		connection.setAutoCommit(false);
		userDAO.updatePassword(username, newPassword);
		connection.commit();
		connection.setAutoCommit(true);
	}
	public Map<String, String> loadConnectionSetting(){
		Map<String, String> values = null;
		try {
			File file = new File("connection.conf");
			Properties p = new Properties();
			p.load(new FileInputStream(file));
			
			values = new HashMap<String, String>();
			
			values.put("server", p.getProperty("server"));
			values.put("username", p.getProperty("username"));
			values.put("password", p.getProperty("password"));
			values.put("database", p.getProperty("database"));
			
			//return values;
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return values;
	}
	
	public void setConnectionSetting(Map<String, String> values){
		try {
			File file = new File("connection.conf");
			
			Properties p = new Properties();
			p.load(new FileInputStream(file));
			
			p.setProperty("server", values.get("server"));
			p.setProperty("username", values.get("username"));
			p.setProperty("password", values.get("password"));
			p.setProperty("database", values.get("database"));
			p.store(new FileOutputStream(file), "");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}
