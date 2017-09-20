package az.muharram.shodaqoh.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import az.muharram.shodaqoh.entities.User;
import az.muharram.shodaqoh.service.ShodaqohService;

import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JPanel;

import java.awt.Dimension;

import javax.swing.JLabel;

import java.awt.Font;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7281974690127554461L;

	private JDesktopPane desktopPane;
	
	private ShodaqohService service;
	private MysqlDataSource datasource;
	private JMenuItem mntmLogin;
	private JMenuItem mntmLogout;
	private JMenuItem mntmUbahPassword;
	private JMenuItem mntmDataUser;
	private JMenuItem mntmKeluar;
	private JMenuItem mntmEntriShodaqoh;
	private JMenuItem mntmJenisShodaqoh;
	private JMenuItem mntmKursMataUang;
	public static User user;
	public static int tahunAktif;
	private JPanel panelStatus;
	private JPanel leftPanel;
	private JLabel lblUserLoggedIn;
	private JLabel lblTahun;
	private JLabel lblCreatedByMiftah;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
					Main window = new Main();
					window.setVisible(true);

					window.setExtendedState(window.getExtendedState() | JFrame.MAXIMIZED_BOTH);
					
					try {
						window.service = new ShodaqohService();
						Map<String, String> dbSetting = window.service.loadConnectionSetting();
						
						window.datasource = new MysqlDataSource();
						window.datasource.setServerName(dbSetting.get("server"));
						window.datasource.setUser(dbSetting.get("username"));
						window.datasource.setPassword(dbSetting.get("password"));
						window.datasource.setDatabaseName(dbSetting.get("database"));
						/*window.datasource.setServerName("localhost");
						window.datasource.setUser("root");
						window.datasource.setPassword("toor");
						window.datasource.setDatabaseName("muharram");*/
						window.service.setConnection(window.datasource.getConnection());
						window.openLoginDialog();
						
						
					} catch (SQLException e) {
						//JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						JOptionPane.showMessageDialog(null, "Error connecting to database ...", "ERROR", JOptionPane.ERROR_MESSAGE);
						SetupDBDialog setupDb = new SetupDBDialog(window, true);
						
						setupDb.setVisible(true);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 521, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Aplikasi Entri Shodaqoh Muharram - Al-Zaytun");
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(32, 62, 96));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		panelStatus = new JPanel();
		panelStatus.setPreferredSize(new Dimension(10, 25));
		getContentPane().add(panelStatus, BorderLayout.SOUTH);
		panelStatus.setLayout(new BorderLayout(0, 0));
		
		leftPanel = new JPanel();
		panelStatus.add(leftPanel, BorderLayout.WEST);
		
		lblUserLoggedIn = new JLabel("User logged in: -");
		lblUserLoggedIn.setFont(new Font("Dialog", Font.PLAIN, 11));
		leftPanel.add(lblUserLoggedIn);
		
		lblTahun = new JLabel("Tahun: ");
		lblTahun.setFont(new Font("Dialog", Font.PLAIN, 11));
		leftPanel.add(lblTahun);
		
		JPanel rightPanel = new JPanel();
		panelStatus.add(rightPanel, BorderLayout.EAST);
		
		lblCreatedByMiftah = new JLabel("<html>Created by: Miftah Thoha &copy; AGICT 2012</html>");
		lblCreatedByMiftah.setFont(new Font("Dialog", Font.PLAIN, 11));
		rightPanel.add(lblCreatedByMiftah);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUser = new JMenu("User");
		menuBar.add(mnUser);
		
		mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openLoginDialog();
			}
		});
		mnUser.add(mntmLogin);
		
		mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toLoggedOutMode();
			}
		});
		mntmLogout.setEnabled(false);
		mnUser.add(mntmLogout);
		
		mntmUbahPassword = new JMenuItem("Ubah Password");
		mntmUbahPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openChangePassDialog();
			}
		});
		mntmUbahPassword.setEnabled(false);
		mnUser.add(mntmUbahPassword);
		
		JSeparator separator = new JSeparator();
		mnUser.add(separator);
		
		mntmDataUser = new JMenuItem("Data User");
		mntmDataUser.setEnabled(false);
		mnUser.add(mntmDataUser);
		
		JSeparator separator_1 = new JSeparator();
		mnUser.add(separator_1);
		
		mntmKeluar = new JMenuItem("Keluar");
		mntmKeluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnUser.add(mntmKeluar);
		
		JMenu mnShodaqoh = new JMenu("Shodaqoh");
		menuBar.add(mnShodaqoh);
		
		mntmEntriShodaqoh = new JMenuItem("Entri Shodaqoh");
		mntmEntriShodaqoh.setEnabled(false);
		mntmEntriShodaqoh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				openEntriShodaqohForm();
			}
		});
		mnShodaqoh.add(mntmEntriShodaqoh);
		
		mntmJenisShodaqoh = new JMenuItem("Jenis Shodaqoh");
		mntmJenisShodaqoh.setEnabled(false);
		mntmJenisShodaqoh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openJenisShodaqohForm();
				
			}

		});
		mnShodaqoh.add(mntmJenisShodaqoh);
		
		mntmKursMataUang = new JMenuItem("Kurs & Mata Uang");
		mntmKursMataUang.setEnabled(false);
		mnShodaqoh.add(mntmKursMataUang);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
	}

	protected void openJenisShodaqohForm() {
		JenisShodaqohFrame frame = new JenisShodaqohFrame(service);
		desktopPane.add(frame);
		frame.setVisible(true);
	}
	protected void openChangePassDialog() {
		ChangePassDialog dialog = new ChangePassDialog(this, true);
		dialog.setService(service);
		dialog.setVisible(true);
	}

	protected void openLoginDialog() {
		LoginDialog login = new LoginDialog(this,true);
		login.setService(service);
		login.setVisible(true);
	}
	
	protected void openSetupDbDialog(){
		SetupDBDialog setupDb = new SetupDBDialog(this, true);
		setupDb.setService(service);
		setupDb.setVisible(true);
	}

	protected void openEntriShodaqohForm() {
		EntriShodaqohFrame entriShodaqohForm = new EntriShodaqohFrame(service);
		openFrame(entriShodaqohForm);
		
	}
	private void openFrame(JInternalFrame f){
		desktopPane.add(f);
		Dimension parentSize = desktopPane.getSize();
		Dimension childSize = f.getSize();

		//set center screen
		f.setLocation((parentSize.width - childSize.width)/2, (parentSize.height - childSize.height)/2);
		f.setVisible(true);
	}
	protected void toLoggedInMode(){
		
		mntmLogin.setEnabled(false);
		mntmLogout.setEnabled(true);
		mntmUbahPassword.setEnabled(true);
		mntmEntriShodaqoh.setEnabled(true);
		
		if(user.getPrivilege()==15){
			mntmDataUser.setEnabled(true);
			mntmJenisShodaqoh.setEnabled(true);
			mntmKursMataUang.setEnabled(true);
		}
		
		lblUserLoggedIn.setText("User logged in: "+user.getUsername());
		lblTahun.setText("Tahun: "+tahunAktif+" H");
	}
	
	private void toLoggedOutMode(){
		mntmLogin.setEnabled(true);
		mntmLogout.setEnabled(false);
		mntmUbahPassword.setEnabled(false);
		mntmEntriShodaqoh.setEnabled(false);
		mntmDataUser.setEnabled(false);
		mntmJenisShodaqoh.setEnabled(false);
		mntmKursMataUang.setEnabled(false);
	}
}
