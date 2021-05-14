package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import controller.GenerateListController;
import model.Batch;
import model.Notification;
import model.Status;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private GenerateListController generateListController;	
	private JComboBox comboBox;	
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Homepage() {
		setFont(new Font("Dialog", Font.BOLD, 18));
		setTitle("Hovedmenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1455, 828);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(10, 40));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(10, 10));
		panel.setBorder(new LineBorder(Color.BLACK, 2));
		panel.setLayout(null);
		
		JButton btnNotification = new JButton("Notifikation");
		btnNotification.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNotification.setBounds(59, 150, 170, 31);
		panel.add(btnNotification);
		
		JButton btnProduct = new JButton("Produkt");
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnProduct.setBounds(59, 70, 170, 31);
		panel.add(btnProduct);
		
		JButton btnMap = new JButton("Kort");
		btnMap.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMap.setBounds(59, 230, 170, 31);
		panel.add(btnMap);
		
		JButton btnAdmin = new JButton("Bruger Admin");
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdmin.setBounds(59, 310, 170, 31);
		panel.add(btnAdmin);
		
		JButton btnStatistik = new JButton("Statistik");
		btnStatistik.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStatistik.setBounds(59, 390, 170, 31);
		panel.add(btnStatistik);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 80, 24);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Produkt", "Udl\u00F8bsdato", "barcode", "Status", "Rabat", "Valgt "
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(176);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(4).setPreferredWidth(55);
		scrollPane.setViewportView(table);
		
		JButton btnPrint = new JButton("Udskriv");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnDiscount = new JButton("S\u00E6t Rabat");
		btnDiscount.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnArkive = new JButton("Arkivere");
		btnArkive.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnGenerateList = new JButton("Generere liste");
		btnGenerateList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int comboboxindex = comboBox.getSelectedIndex(); 
				if(comboboxindex == 1) {
					findAllLists();
				} else if(comboboxindex == 2) {
					try {
						findDiscount();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(comboboxindex == 3) {
					try {
						findExpired();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if (comboboxindex == 4) {
					try {
						findPending();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
				
//				RowFilter<GenerateListTableModel, Object> rf = RowFilter.regexFilter(comboBox.getSelectedItem().toString()	, 0);
//				sorter = new TableRowSorter<GenerateListTableModel>(generateListTableModel); 
//				sorter.setRowFilter(rf);
//			
//				table.setRowSorter(sorter);
//				//String value = String.valueOf(comboBox.getSelectedIndex());
//				
//				findList();
			}
		});
		btnGenerateList.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Samlet liste", "Rabat", "Udl\u00F8bet", "AdvarselsPeriode"}));
		
		JLabel lblNewLabel_1 = new JLabel("Filtrer efter status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBox, 0, 166, Short.MAX_VALUE)
							.addGap(95)
							.addComponent(btnGenerateList, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(85)
							.addComponent(btnArkive, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(85)
							.addComponent(btnDiscount, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
							.addGap(85)
							.addComponent(btnPrint, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
							.addGap(51)
							.addComponent(panel_1)))
					.addGap(29))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnGenerateList)
						.addComponent(btnArkive)
						.addComponent(btnDiscount)
						.addComponent(btnPrint))
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		
		init();
	}

	private void init() {
		try {
			this.generateListController = new GenerateListController();			
			model = (DefaultTableModel) table.getModel();
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null, "Problem finding lists " + e.getMessage());
		}
		//findList();
		
	}

	private void findAllLists() {
		
		try {
			
			model.setRowCount(0);
			generateListController.generateList();
			
			ArrayList<Batch> nl= generateListController.getBatchCopyList();		
				
			for(int i = 0 ; i< generateListController.getBatchCopyList().size(); i++) {				
				
				Object rowData[] = new Object[6];				
				rowData[0] = nl.get(i).getProduct().getProductName();
				rowData[1] = nl.get(i).getExpirationDate();
				rowData[2] = nl.get(i).getProduct().getBarcode();
				rowData[3] = nl.get(i).getNotification().getStatus();
				rowData[4] = nl.get(i).getNotification().getDiscount();	
				if(nl.get(i).getNotification().getStatus().equals(Status.PENDING)) {
				rowData[5] = Boolean.TRUE;
				model.addRow(rowData);
				
				}else {
					//If the status is not pending we dont mark the checkbox
				model.addRow(rowData);
			
				}					
			}	
		
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void findExpired() throws Exception {
		generateListController.generateList();
		ArrayList<Batch> nl= generateListController.getBatchCopyList();		
		for(int i = 0 ; i< nl.size(); i++) {
			if(nl.get(i).getNotification().getStatus().equals(Status.EXPIRED)) {
				try {
					model.setRowCount(0);
					Object rowData[] = new Object[6];
					rowData[0] = nl.get(i).getProduct().getProductName();
					rowData[1] = nl.get(i).getExpirationDate();
					rowData[2] = nl.get(i).getProduct().getBarcode();
					rowData[3] = nl.get(i).getNotification().getStatus();
					rowData[4] = nl.get(i).getNotification().getDiscount();	
					rowData[5] = Boolean.FALSE;
					model.addRow(rowData);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		
		}
	}
	
	private void findDiscount() throws Exception {
		generateListController.generateList();
		ArrayList<Batch> nl= generateListController.getBatchCopyList();		
		for(int i = 0 ; i< nl.size(); i++) {
			if(nl.get(i).getNotification().getStatus().equals(Status.DISCOUNT)) {
				try {
					model.setRowCount(0);
					Object rowData[] = new Object[6];
					rowData[0] = nl.get(i).getProduct().getProductName();
					rowData[1] = nl.get(i).getExpirationDate();
					rowData[2] = nl.get(i).getProduct().getBarcode();
					rowData[3] = nl.get(i).getNotification().getStatus();
					rowData[4] = nl.get(i).getNotification().getDiscount();	
					rowData[5] = Boolean.FALSE;
					model.addRow(rowData);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		}
	}
	
	private void findPending() throws Exception {
		generateListController.generateList();
		ArrayList<Batch> nl= generateListController.getBatchCopyList();		
		for(int i = 0 ; i< nl.size(); i++) {
			if(nl.get(i).getNotification().getStatus().equals(Status.PENDING)) {
				try {
					model.setRowCount(0);
					Object rowData[] = new Object[6];
					rowData[0] = nl.get(i).getProduct().getProductName();
					rowData[1] = nl.get(i).getExpirationDate();
					rowData[2] = nl.get(i).getProduct().getBarcode();
					rowData[3] = nl.get(i).getNotification().getStatus();
					rowData[4] = nl.get(i).getNotification().getDiscount();	
					rowData[5] = Boolean.TRUE;
					model.addRow(rowData);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
}





