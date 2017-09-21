package az.muharram.shodaqoh.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import az.muharram.shodaqoh.entities.User;
import az.muharram.shodaqoh.service.ShodaqohService;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePassDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4607118669592922388L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtPassword1;
	private JPasswordField txtPassword2;
	private ShodaqohService service;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ChangePassDialog(java.awt.Frame parent, boolean modal) {
		super(parent,modal);
		setTitle("Ubah Password");
		setBounds(100, 100, 320, 200);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		FlowLayout fl_contentPanel = new FlowLayout();
		fl_contentPanel.setVgap(15);
		contentPanel.setLayout(fl_contentPanel);
		contentPanel.setBorder(new TitledBorder(new LineBorder(new Color(164, 164, 164), 1, true), "Password Baru", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(90, 90, 90)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPanel.add(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 116, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel lblPassword = new JLabel("Password");
				GridBagConstraints gbc_lblPassword = new GridBagConstraints();
				gbc_lblPassword.anchor = GridBagConstraints.WEST;
				gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
				gbc_lblPassword.gridx = 0;
				gbc_lblPassword.gridy = 0;
				panel.add(lblPassword, gbc_lblPassword);
			}
			{
				txtPassword1 = new JPasswordField();
				GridBagConstraints gbc_txtPassword1 = new GridBagConstraints();
				gbc_txtPassword1.insets = new Insets(0, 0, 5, 0);
				gbc_txtPassword1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPassword1.gridx = 1;
				gbc_txtPassword1.gridy = 0;
				panel.add(txtPassword1, gbc_txtPassword1);
			}
			{
				JLabel lblKonfirmasiPassword = new JLabel("Konfirmasi Password");
				GridBagConstraints gbc_lblKonfirmasiPassword = new GridBagConstraints();
				gbc_lblKonfirmasiPassword.anchor = GridBagConstraints.EAST;
				gbc_lblKonfirmasiPassword.insets = new Insets(0, 0, 0, 5);
				gbc_lblKonfirmasiPassword.gridx = 0;
				gbc_lblKonfirmasiPassword.gridy = 1;
				panel.add(lblKonfirmasiPassword, gbc_lblKonfirmasiPassword);
			}
			{
				txtPassword2 = new JPasswordField();
				GridBagConstraints gbc_txtPassword2 = new GridBagConstraints();
				gbc_txtPassword2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtPassword2.gridx = 1;
				gbc_txtPassword2.gridy = 1;
				panel.add(txtPassword2, gbc_txtPassword2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSimpan = new JButton("Simpan");
				btnSimpan.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnSimpanActionPerformed();
					}
				});
				btnSimpan.setActionCommand("OK");
				buttonPane.add(btnSimpan);
				getRootPane().setDefaultButton(btnSimpan);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnCancelActionPerformed();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

	protected void btnCancelActionPerformed() {
		this.dispose();
		
	}

	protected void btnSimpanActionPerformed() {
		String password1,password2;
		try {
			password1=String.valueOf(txtPassword1.getPassword());
			password2=String.valueOf(txtPassword2.getPassword());
			if(password1.equals(password2)){
				service.updatePassword(Main.user.getUsername(),User.encrypt(password1));
				JOptionPane.showMessageDialog(null, 
						"Password berhasil dirubah.\nSilakan restart aplikasi untuk menggunakan password baru",
						"INFO",JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(null, "Password tidak sama, silakan coba lagi",
						"PERINGATAN",JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void setService(ShodaqohService service) {
		this.service = service;
	}
}
