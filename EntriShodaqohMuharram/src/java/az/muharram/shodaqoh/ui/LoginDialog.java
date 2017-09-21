package az.muharram.shodaqoh.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import az.muharram.shodaqoh.entities.User;
import az.muharram.shodaqoh.service.ShodaqohService;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class LoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9026142595691563273L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private ShodaqohService service;
	private Main parent;

	/**
	 * Create the dialog.
	 */
	
	public LoginDialog(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		this.parent = (Main)parent;
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Entri Shodaqoh - Login");
		
		setBounds(100, 100, 273, 159);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(LoginDialog.class.getResource("/az/muharram/shodaqoh/ui/images/ok.png")));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnOkActionPerformed();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						closeDialog();
					}
				});
				cancelButton.setIcon(new ImageIcon(LoginDialog.class.getResource("/az/muharram/shodaqoh/ui/images/undo.png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(0, 0, 0, 0));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setVgap(15);
			getContentPane().add(panel, BorderLayout.CENTER);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
				panel.add(panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel label = new JLabel("Username");
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 5, 5);
					gbc_label.gridx = 0;
					gbc_label.gridy = 0;
					panel_1.add(label, gbc_label);
				}
				{
					txtUsername = new JTextField();
					txtUsername.setColumns(10);
					GridBagConstraints gbc_txtUsername = new GridBagConstraints();
					gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
					gbc_txtUsername.gridx = 2;
					gbc_txtUsername.gridy = 0;
					panel_1.add(txtUsername, gbc_txtUsername);
				}
				{
					JLabel label = new JLabel("Password");
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 0, 5);
					gbc_label.gridx = 0;
					gbc_label.gridy = 1;
					panel_1.add(label, gbc_label);
				}
				{
					txtPassword = new JPasswordField();
					GridBagConstraints gbc_txtPassword = new GridBagConstraints();
					gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtPassword.gridx = 2;
					gbc_txtPassword.gridy = 1;
					panel_1.add(txtPassword, gbc_txtPassword);
				}
			}
		}
	}

	

	protected void closeDialog() {
		this.dispose();
	}



	protected void btnOkActionPerformed() {
		String username = txtUsername.getText();
		String password = String.valueOf(txtPassword.getPassword());
		try {
			User validUser = service.findUser(username);
			int thnAktif = service.findThnAktif();
			
			if(validUser!=null) {
				if(!password.isEmpty())
					password = User.encrypt(password);
				
				if(validUser.getPassword().equals(password)){
					Main.user = validUser;
					Main.tahunAktif = thnAktif;
					
					parent.toLoggedInMode();
					this.dispose();
					
				}else{
					JOptionPane.showMessageDialog(null, "Username atau password salah",
							"PERINGATAN",JOptionPane.WARNING_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(null, "Username atau password salah",
						"PERINGATAN",JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void setService(ShodaqohService service) {
		this.service = service;
	}
	
	/*public void setParent(Main parent) {
		this.parent = parent;
	}*/
}
