package az.muharram.shodaqoh.ui;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;


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
import java.util.List;
import java.util.Locale;

import javax.swing.JTextField;

import az.muharram.shodaqoh.entities.JenisShodaqoh;
import az.muharram.shodaqoh.service.ShodaqohService;
import az.muharram.shodaqoh.ui.helper.JenisShodaqohTableModel;
import az.muharram.shodaqoh.ui.helper.MyTableCellRenderer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JenisShodaqohFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -710267278469704905L;
	private JTable table;
	private JTextField txtSatuan;
	private JTextField txtKeterangan;

	private ShodaqohService service;
	private JComboBox cboJenisShodaqoh;
	private JButton btnSimpan;
	private JButton btnNew;
	private JButton btnEdit;
	private JenisShodaqoh shodaqohToEdit;
	
	private DecimalFormat numberFormatter;
	/**
	 * Create the frame.
	 */
	public JenisShodaqohFrame(ShodaqohService service) {
		this.service = service;
		setClosable(true);
		setTitle("Form Daftar Jenis Shodaqoh");
		setBounds(100, 100, 527, 436);
		
		numberFormatter = (DecimalFormat) NumberFormat.getInstance(new Locale("in"));
		numberFormatter.setMinimumFractionDigits(0);
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 180));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(400, 100));
		panel.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{115, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblJenisShodaqoh = new JLabel("Jenis Shodaqoh");
		GridBagConstraints gbc_lblJenisShodaqoh = new GridBagConstraints();
		gbc_lblJenisShodaqoh.anchor = GridBagConstraints.WEST;
		gbc_lblJenisShodaqoh.insets = new Insets(0, 0, 5, 5);
		gbc_lblJenisShodaqoh.gridx = 0;
		gbc_lblJenisShodaqoh.gridy = 0;
		panel_1.add(lblJenisShodaqoh, gbc_lblJenisShodaqoh);
		
		cboJenisShodaqoh = new JComboBox();
		cboJenisShodaqoh.setEditable(true);
		GridBagConstraints gbc_cboJenisShodaqoh = new GridBagConstraints();
		gbc_cboJenisShodaqoh.insets = new Insets(0, 0, 5, 0);
		gbc_cboJenisShodaqoh.fill = GridBagConstraints.HORIZONTAL;
		gbc_cboJenisShodaqoh.gridx = 2;
		gbc_cboJenisShodaqoh.gridy = 0;
		panel_1.add(cboJenisShodaqoh, gbc_cboJenisShodaqoh);
		
		//cboJenisShodaqoh.setRenderer(new JenisShodaqohCboRenderer());
		
		JLabel lblPenyumbang = new JLabel("Satuan");
		GridBagConstraints gbc_lblPenyumbang = new GridBagConstraints();
		gbc_lblPenyumbang.anchor = GridBagConstraints.WEST;
		gbc_lblPenyumbang.insets = new Insets(0, 0, 5, 5);
		gbc_lblPenyumbang.gridx = 0;
		gbc_lblPenyumbang.gridy = 1;
		panel_1.add(lblPenyumbang, gbc_lblPenyumbang);
		
		txtSatuan = new JTextField();
		GridBagConstraints gbc_txtSatuan = new GridBagConstraints();
		gbc_txtSatuan.insets = new Insets(0, 0, 5, 0);
		gbc_txtSatuan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSatuan.gridx = 2;
		gbc_txtSatuan.gridy = 1;
		panel_1.add(txtSatuan, gbc_txtSatuan);
		txtSatuan.setColumns(10);
		
		JLabel lblAsal = new JLabel("Keterangan");
		GridBagConstraints gbc_lblAsal = new GridBagConstraints();
		gbc_lblAsal.anchor = GridBagConstraints.WEST;
		gbc_lblAsal.insets = new Insets(0, 0, 0, 5);
		gbc_lblAsal.gridx = 0;
		gbc_lblAsal.gridy = 2;
		panel_1.add(lblAsal, gbc_lblAsal);
		
		txtKeterangan = new JTextField();
		GridBagConstraints gbc_txtKeterangan = new GridBagConstraints();
		gbc_txtKeterangan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeterangan.gridx = 2;
		gbc_txtKeterangan.gridy = 2;
		panel_1.add(txtKeterangan, gbc_txtKeterangan);
		txtKeterangan.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		btnSimpan = new JButton("Save");
		btnSimpan.setMnemonic('s');
		btnSimpan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				addShodaqoh();
			}
		});
		btnSimpan.setIcon(new ImageIcon(JenisShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/save-alt.png")));
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addShodaqoh();
			}
		});
		
		btnNew = new JButton("New");
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
		btnNew.setIcon(new ImageIcon(JenisShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/addd.png")));
		panel_2.add(btnNew);
		
		btnEdit = new JButton("Edit");
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
		btnEdit.setIcon(new ImageIcon(JenisShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/edit.png")));
		panel_2.add(btnEdit);
		panel_2.add(btnSimpan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inactiveState();
			}
		});
		btnCancel.setIcon(new ImageIcon(JenisShodaqohFrame.class.getResource("/az/muharram/shodaqoh/ui/images/undo.png")));
		panel_2.add(btnCancel);
		
		//getRootPane().setDefaultButton(btnSimpan);

		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowHeight(22);
		
		DefaultTableCellRenderer renderer = new MyTableCellRenderer();
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
					JenisShodaqohTableModel tableModel = (JenisShodaqohTableModel) table.getModel();
					int selectedIndex = selectionModel.getMinSelectionIndex();
					shodaqohToEdit = tableModel.getDataItem(selectedIndex);
					
					cboJenisShodaqoh.setSelectedItem(shodaqohToEdit.getJenis());
					txtSatuan.setText(shodaqohToEdit.getSatuan());
					txtKeterangan.setText(shodaqohToEdit.getKeterangan());
					
					cboJenisShodaqoh.setEnabled(false);
					txtSatuan.setEnabled(false);
					txtKeterangan.setEnabled(false);
					
					btnEdit.setEnabled(true);
					btnNew.setEnabled(true);
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		try {
			
			/*List<JenisShodaqoh> daftarJenis = service.findAllJenis();
			
			DefaultComboBoxModel model = new DefaultComboBoxModel();
			
			for (JenisShodaqoh jenisShodaqoh : daftarJenis) {
				model.addElement(jenisShodaqoh);
			}
			
			cboJenisShodaqoh.setModel(model);*/
			cboJenisShodaqoh.addItem("Uang");
			cboJenisShodaqoh.addItem("Alat Komunikasi");
			
			List<JenisShodaqoh> dataJenisShodaqoh = service.findAllJenis();
			table.setModel(new JenisShodaqohTableModel(dataJenisShodaqoh));
			
			JPanel panel_3 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			getContentPane().add(panel_3, BorderLayout.SOUTH);
			
			JButton btnClose = new JButton("Close");
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
			
			JenisShodaqoh s = null;
			
			if(shodaqohToEdit!=null)
				s = shodaqohToEdit;
			else
				s= new JenisShodaqoh();
			
			
			s.setJenis(cboJenisShodaqoh.getSelectedItem().toString());
			s.setSatuan(txtSatuan.getText());
			s.setKeterangan(txtKeterangan.getText());
			
			service.save(s);
			JenisShodaqohTableModel model = (JenisShodaqohTableModel) table.getModel();
			List<JenisShodaqoh> newData = service.findAllJenis();
			model.setDataItems(newData);
			
			txtKeterangan.setText("");
			txtSatuan.setText("");
			
			shodaqohToEdit = null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			
		} 
		
	}

	public void inactiveState(){
		cboJenisShodaqoh.setEnabled(false);
		cboJenisShodaqoh.setSelectedIndex(0);
		txtSatuan.setEnabled(false);
		txtSatuan.setText("");
		txtKeterangan.setEnabled(false);
		txtKeterangan.setText("");
		
		btnSimpan.setEnabled(false);
		btnNew.setEnabled(true);
		btnEdit.setEnabled(false);
	}
	
	public void newState(){
		cboJenisShodaqoh.setSelectedIndex(0);
		txtSatuan.setText("");
		txtKeterangan.setText("");
		
		cboJenisShodaqoh.setEnabled(true);
		txtSatuan.setEnabled(true);
		txtKeterangan.setEnabled(true);
		
		btnSimpan.setEnabled(true);
		btnNew.setEnabled(false);
		
	}
	
	public void editState(){
		cboJenisShodaqoh.setEnabled(true);
		txtSatuan.setEnabled(true);
		txtKeterangan.setEnabled(true);
		
		btnEdit.setEnabled(false);
		btnSimpan.setEnabled(true);
		cboJenisShodaqoh.requestFocus();
	}
}
