package az.muharram.shodaqoh.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import az.muharram.shodaqoh.service.ShodaqohService;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class SetupDBDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9026142595691563273L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private ShodaqohService service;
	private JTextField txtServer;
	private JTextField txtDatabase;

	/**
	 * Create the dialog.
	 */
	
	public SetupDBDialog(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Entri Shodaqoh - DB Setting");
		
		setBounds(100, 100, 286, 211);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setIcon(new ImageIcon(SetupDBDialog.class.getResource("/az/muharram/shodaqoh/ui/images/ok.png")));
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
				cancelButton.setIcon(new ImageIcon(SetupDBDialog.class.getResource("/az/muharram/shodaqoh/ui/images/undo.png")));
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
				gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
				{
					JLabel lblServer = new JLabel("Server");
					GridBagConstraints gbc_lblServer = new GridBagConstraints();
					gbc_lblServer.anchor = GridBagConstraints.WEST;
					gbc_lblServer.insets = new Insets(0, 0, 5, 5);
					gbc_lblServer.gridx = 0;
					gbc_lblServer.gridy = 0;
					panel_1.add(lblServer, gbc_lblServer);
				}
				{
					txtServer = new JTextField();
					GridBagConstraints gbc_txtServer = new GridBagConstraints();
					gbc_txtServer.insets = new Insets(0, 0, 5, 0);
					gbc_txtServer.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtServer.gridx = 2;
					gbc_txtServer.gridy = 0;
					panel_1.add(txtServer, gbc_txtServer);
					txtServer.setColumns(10);
				}
				{
					JLabel lblDatabase = new JLabel("Database");
					GridBagConstraints gbc_lblDatabase = new GridBagConstraints();
					gbc_lblDatabase.anchor = GridBagConstraints.WEST;
					gbc_lblDatabase.insets = new Insets(0, 0, 5, 5);
					gbc_lblDatabase.gridx = 0;
					gbc_lblDatabase.gridy = 1;
					panel_1.add(lblDatabase, gbc_lblDatabase);
				}
				{
					txtDatabase = new JTextField();
					txtDatabase.setText((String) null);
					txtDatabase.setColumns(10);
					GridBagConstraints gbc_txtDatabase = new GridBagConstraints();
					gbc_txtDatabase.insets = new Insets(0, 0, 5, 0);
					gbc_txtDatabase.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtDatabase.gridx = 2;
					gbc_txtDatabase.gridy = 1;
					panel_1.add(txtDatabase, gbc_txtDatabase);
				}
				{
					JLabel label = new JLabel("Username");
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 5, 5);
					gbc_label.gridx = 0;
					gbc_label.gridy = 2;
					panel_1.add(label, gbc_label);
				}
				{
					txtUsername = new JTextField();
					txtUsername.setColumns(10);
					GridBagConstraints gbc_txtUsername = new GridBagConstraints();
					gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
					gbc_txtUsername.gridx = 2;
					gbc_txtUsername.gridy = 2;
					panel_1.add(txtUsername, gbc_txtUsername);
				}
				{
					JLabel label = new JLabel("Password");
					GridBagConstraints gbc_label = new GridBagConstraints();
					gbc_label.insets = new Insets(0, 0, 0, 5);
					gbc_label.gridx = 0;
					gbc_label.gridy = 3;
					panel_1.add(label, gbc_label);
				}
				{
					txtPassword = new JPasswordField();
					GridBagConstraints gbc_txtPassword = new GridBagConstraints();
					gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtPassword.gridx = 2;
					gbc_txtPassword.gridy = 3;
					panel_1.add(txtPassword, gbc_txtPassword);
				}
			}
		}
		service = new ShodaqohService();
		Map<String, String> connectionSetting = service.loadConnectionSetting();
		txtServer.setText(connectionSetting.get("server"));
		txtUsername.setText(connectionSetting.get("username"));
		txtPassword.setText(connectionSetting.get("password"));
		txtDatabase.setText(connectionSetting.get("database"));
	}

	

	protected void closeDialog() {
		this.dispose();
	}

	protected void btnOkActionPerformed() {
		String username = txtUsername.getText();
		String password = String.valueOf(txtPassword.getPassword());
		String server = txtServer.getText();
		
		Map<String, String> values = new HashMap<String, String>();
		values.put("server", server);
		values.put("username", username);
		values.put("password", password);
		values.put("database", txtDatabase.getText());
		
		service.setConnectionSetting(values);
		
		JOptionPane.showMessageDialog(null, "Connection setting saved.\nYou need to restart application to get affect", "INFO", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	public void setService(ShodaqohService service) {
		this.service = service;
	}
	
	/*public void setParent(Main parent) {
		this.parent = parent;
	}*/
}
