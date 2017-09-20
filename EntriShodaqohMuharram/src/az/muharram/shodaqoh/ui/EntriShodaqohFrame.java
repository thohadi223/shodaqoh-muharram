package az.muharram.shodaqoh.ui;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.swing.JTextField;

import az.muharram.shodaqoh.entities.JenisShodaqoh;
import az.muharram.shodaqoh.entities.Penyumbang;
import az.muharram.shodaqoh.entities.Shodaqoh;
import az.muharram.shodaqoh.service.ShodaqohService;
import az.muharram.shodaqoh.ui.helper.EntriTableCellRenderer;
import az.muharram.shodaqoh.ui.helper.JenisShodaqohCboRenderer;
import az.muharram.shodaqoh.ui.helper.ShodaqohTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EntriShodaqohFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -710267278469704905L;
	private JTable table;
	private JTextField txtNoTransaksi;
	private JTextField txtNilaiShodaqoh;
	private JTextField txtPenyumbang;
	private JTextField txtAsal;

	private ShodaqohService service;
	private JComboBox<JenisShodaqoh> cboJenisShodaqoh;
	private JButton btnSimpan;
	private JButton btnNew;
	private JButton btnEdit;
	private Shodaqoh shodaqohToEdit;
	
	private DecimalFormat numberFormatter;
	/**
	 * Create the frame.
	 */
	public EntriShodaqohFrame(ShodaqohService service) {
		setMaximizable(true);
		this.service = service;
		setClosable(true);
		setTitle("Form Entri Shodaqoh");
		setBounds(100, 100, 641, 563);
		
		numberFormatter = (DecimalFormat) NumberFormat.getInstance(new Locale("in"));
		numberFormatter.setMinimumFractionDigits(0);
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 220));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(400, 150));
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{115, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNomorTransaksi = new JLabel("Nomor Transaksi");
		GridBagConstraints gbc_lblNomorTransaksi = new GridBagConstraints();
		gbc_lblNomorTransaksi.anchor = GridBagConstraints.WEST;
		gbc_lblNomorTransaksi.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomorTransaksi.gridx = 0;
		gbc_lblNomorTransaksi.gridy = 0;
		panel_1.add(lblNomorTransaksi, gbc_lblNomorTransaksi);
		
		txtNoTransaksi = new JTextField();
		txtNoTransaksi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboJenisShodaqoh.requestFocusInWindow();
			}
		});
		txtNoTransaksi.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_txtNoTransaksi = new GridBagConstraints();
		gbc_txtNoTransaksi.insets = new Insets(0, 0, 5, 0);
		gbc_txtNoTransaksi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNoTransaksi.gridx = 2;
		gbc_txtNoTransaksi.gridy = 0;
		panel_1.add(txtNoTransaksi, gbc_txtNoTransaksi);
		txtNoTransaksi.setColumns(10);
		
		JLabel lblJenisShodaqoh = new JLabel("Jenis Shodaqoh");
		GridBagConstraints gbc_lblJenisShodaqoh = new GridBagConstraints();
		gbc_lblJenisShodaqoh.anchor = GridBagConstraints.WEST;
		gbc_lblJenisShodaqoh.insets = new Insets(0, 0, 5, 5);
		gbc_lblJenisShodaqoh.gridx = 0;
		gbc_lblJenisShodaqoh.gridy = 1;
		panel_1.add(lblJenisShodaqoh, gbc_lblJenisShodaqoh);
		
		cboJenisShodaqoh = new JComboBox<JenisShodaqoh>();
		cboJenisShodaqoh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
					txtNilaiShodaqoh.requestFocusInWindow();
				}
			}
		});
		GridBagConstraints gbc_cboJenisShodaqoh = new GridBagConstraints();
		gbc_cboJenisShodaqoh.insets = new Insets(0, 0, 5, 0);
		gbc_cboJenisShodaqoh.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboJenisShodaqoh.gridx = 2;
		gbc_cboJenisShodaqoh.gridy = 1;
		panel_1.add(cboJenisShodaqoh, gbc_cboJenisShodaqoh);
		
		cboJenisShodaqoh.setRenderer(new JenisShodaqohCboRenderer());
		
		
		JLabel lblNilaiShodaqoh = new JLabel("Nilai Shodaqoh");
		GridBagConstraints gbc_lblNilaiShodaqoh = new GridBagConstraints();
		gbc_lblNilaiShodaqoh.anchor = GridBagConstraints.WEST;
		gbc_lblNilaiShodaqoh.insets = new Insets(0, 0, 5, 5);
		gbc_lblNilaiShodaqoh.gridx = 0;
		gbc_lblNilaiShodaqoh.gridy = 2;
		panel_1.add(lblNilaiShodaqoh, gbc_lblNilaiShodaqoh);
		
		txtNilaiShodaqoh = new JTextField();
		txtNilaiShodaqoh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPenyumbang.requestFocusInWindow();
			}
		});
		txtNilaiShodaqoh.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNilaiShodaqoh.selectAll();
			}
		});
		txtNilaiShodaqoh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNilaiShodaqoh.setText("0");
		txtNilaiShodaqoh.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_txtNilaiShodaqoh = new GridBagConstraints();
		gbc_txtNilaiShodaqoh.insets = new Insets(0, 0, 5, 0);
		gbc_txtNilaiShodaqoh.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNilaiShodaqoh.gridx = 2;
		gbc_txtNilaiShodaqoh.gridy = 2;
		panel_1.add(txtNilaiShodaqoh, gbc_txtNilaiShodaqoh);
		txtNilaiShodaqoh.setColumns(10);
		
		JLabel lblPenyumbang = new JLabel("Penyumbang");
		GridBagConstraints gbc_lblPenyumbang = new GridBagConstraints();
		gbc_lblPenyumbang.anchor = GridBagConstraints.WEST;
		gbc_lblPenyumbang.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenyumbang.gridx = 0;
		gbc_lblPenyumbang.gridy = 3;
		panel_1.add(lblPenyumbang, gbc_lblPenyumbang);
		
		txtPenyumbang = new JTextField();
		txtPenyumbang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAsal.requestFocusInWindow();
			}
		});
		GridBagConstraints gbc_txtPenyumbang = new GridBagConstraints();
		gbc_txtPenyumbang.insets = new Insets(0, 0, 5, 0);
		gbc_txtPenyumbang.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPenyumbang.gridx = 2;
		gbc_txtPenyumbang.gridy = 3;
		panel_1.add(txtPenyumbang, gbc_txtPenyumbang);
		txtPenyumbang.setColumns(10);
		
		JLabel lblAsal = new JLabel("Asal");
		GridBagConstraints gbc_lblAsal = new GridBagConstraints();
		gbc_lblAsal.anchor = GridBagConstraints.WEST;
		gbc_lblAsal.insets = new Insets(0, 0, 0, 5);
		gbc_lblAsal.gridx = 0;
		gbc_lblAsal.gridy = 4;
		panel_1.add(lblAsal, gbc_lblAsal);
		
		txtAsal = new JTextField();
		txtAsal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSimpan.requestFocusInWindow();
			}
		});
		GridBagConstraints gbc_txtAsal = new GridBagConstraints();
		gbc_txtAsal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAsal.gridx = 2;
		gbc_txtAsal.gridy = 4;
		panel_1.add(txtAsal, gbc_txtAsal);
		txtAsal.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		btnSimpan = new JButton("Save");
		btnSimpan.setPreferredSize(new Dimension(80, 24));
		btnSimpan.setMnemonic('s');
		btnSimpan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				addShodaqoh();
			}
		});
		btnSimpan.setIcon(new ImageIcon(EntriShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/save-alt.png")));
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addShodaqoh();
			}
		});
		
		btnNew = new JButton("New");
		btnNew.setPreferredSize(new Dimension(80, 24));
		btnNew.setMnemonic('n');
		btnNew.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					newState();
			}
		});
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newState();
			}
		});
		btnNew.setIcon(new ImageIcon(EntriShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/addd.png")));
		panel_2.add(btnNew);
		
		btnEdit = new JButton("Edit");
		btnEdit.setPreferredSize(new Dimension(80, 24));
		btnEdit.setMnemonic('e');
		btnEdit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
					editState();
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editState();
			}
		});
		btnEdit.setIcon(new ImageIcon(EntriShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/edit.png")));
		panel_2.add(btnEdit);
		panel_2.add(btnSimpan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(80, 24));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inactiveState();
			}
		});
		btnCancel.setIcon(new ImageIcon(EntriShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/undo.png")));
		panel_2.add(btnCancel);
		
		//getRootPane().setDefaultButton(btnSimpan);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowHeight(22);
		
		DefaultTableCellRenderer renderer = new EntriTableCellRenderer();
		table.setDefaultRenderer(Object.class, renderer);
		//table.setDefaultRenderer(Integer.class, renderer);
		
		ListSelectionModel listShodaqohSelectionModel = table.getSelectionModel();
		listShodaqohSelectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel selectionModel = (ListSelectionModel) e.getSource();
				if(selectionModel.isSelectionEmpty()){
					inactiveState();
				}else{
					ShodaqohTableModel tableModel = (ShodaqohTableModel) table.getModel();
					int selectedIndex = selectionModel.getMinSelectionIndex();
					shodaqohToEdit = tableModel.getDataItem(selectedIndex);
					
					txtNoTransaksi.setText(shodaqohToEdit.getNoTransaksi());
					cboJenisShodaqoh.setSelectedItem(shodaqohToEdit.getJenisShodaqoh());
					txtNilaiShodaqoh.setText(numberFormatter.format(shodaqohToEdit.getJumlah()));
					txtPenyumbang.setText(shodaqohToEdit.getPenyumbang().getNama());
					txtAsal.setText(shodaqohToEdit.getPenyumbang().getAlamat());
					
					txtNoTransaksi.setEnabled(false);
					cboJenisShodaqoh.setEnabled(false);
					txtNilaiShodaqoh.setEnabled(false);
					txtPenyumbang.setEnabled(false);
					txtAsal.setEnabled(false);
					
					btnEdit.setEnabled(true);
					btnNew.setEnabled(true);
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		try {
			
			List<JenisShodaqoh> daftarJenis = service.findAllJenis();
			
			DefaultComboBoxModel<JenisShodaqoh> model = new DefaultComboBoxModel<JenisShodaqoh>();
			
			for (JenisShodaqoh jenisShodaqoh : daftarJenis) {
				model.addElement(jenisShodaqoh);
			}
			
			cboJenisShodaqoh.setModel(model);
			
			List<Shodaqoh> dataShodaqoh = service.findByOperator(Main.tahunAktif, Main.user);
			table.setModel(new ShodaqohTableModel(dataShodaqoh));
			
			JPanel panel_3 = new JPanel();
			panel_3.setPreferredSize(new Dimension(10, 50));
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			flowLayout.setHgap(10);
			flowLayout.setVgap(15);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			getContentPane().add(panel_3, BorderLayout.SOUTH);
			
			JButton btnClose = new JButton("Close");
			btnClose.setPreferredSize(new Dimension(80, 24));
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			panel_3.add(btnClose);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			
		}
		inactiveState();
	}
	protected void addShodaqoh() {
		try {
			
			Shodaqoh s = null;
			
			if(shodaqohToEdit!=null)
				s = shodaqohToEdit;
			else
				s= new Shodaqoh();
			
			Penyumbang p = null;
			
			if(!txtPenyumbang.getText().isEmpty()){
				p = new Penyumbang();
				p.setNama(txtPenyumbang.getText());
				p.setAlamat(txtAsal.getText());
				
			}
			
			s.setNoTransaksi(txtNoTransaksi.getText());
			s.setJenisShodaqoh((JenisShodaqoh)cboJenisShodaqoh.getSelectedItem());
			s.setJumlah(numberFormatter.parse(txtNilaiShodaqoh.getText()).doubleValue());
			s.setPenyumbang(p);
			s.setOperator(Main.user);
			s.setTahun(Main.tahunAktif);
			
			service.save(s);
			ShodaqohTableModel model = (ShodaqohTableModel) table.getModel();
			List<Shodaqoh> newData = service.findByOperator(Main.tahunAktif, Main.user);
			model.setDataItems(newData);
			
			txtAsal.setText("");
			txtNilaiShodaqoh.setText("0");
			txtPenyumbang.setText("");
			
			txtNoTransaksi.requestFocus();
			txtNoTransaksi.selectAll();
			
			shodaqohToEdit = null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}

	public void inactiveState(){
		txtNoTransaksi.setText("");
		txtNoTransaksi.setEnabled(false);
		cboJenisShodaqoh.setEnabled(false);
		cboJenisShodaqoh.setSelectedIndex(0);
		txtNilaiShodaqoh.setEnabled(false);
		txtNilaiShodaqoh.setText("");
		txtPenyumbang.setEnabled(false);
		txtPenyumbang.setText("");
		txtAsal.setEnabled(false);
		txtAsal.setText("");
		
		btnSimpan.setEnabled(false);
		btnNew.setEnabled(true);
		btnEdit.setEnabled(false);
	}
	
	public void newState(){
		txtNoTransaksi.setText("");
		cboJenisShodaqoh.setSelectedIndex(0);
		txtNilaiShodaqoh.setText("0");
		txtPenyumbang.setText("");
		txtAsal.setText("");
		
		txtNoTransaksi.setEnabled(true);
		cboJenisShodaqoh.setEnabled(true);
		txtNilaiShodaqoh.setEnabled(true);
		txtPenyumbang.setEnabled(true);
		txtAsal.setEnabled(true);
		
		btnSimpan.setEnabled(true);
		btnNew.setEnabled(false);
		
		txtNoTransaksi.requestFocus();
	}
	
	public void editState(){
		txtNoTransaksi.setEnabled(false);
		cboJenisShodaqoh.setEnabled(true);
		txtNilaiShodaqoh.setEnabled(true);
		txtPenyumbang.setEnabled(true);
		txtAsal.setEnabled(true);
		
		btnEdit.setEnabled(false);
		btnSimpan.setEnabled(true);
		cboJenisShodaqoh.requestFocus();
	}
}
