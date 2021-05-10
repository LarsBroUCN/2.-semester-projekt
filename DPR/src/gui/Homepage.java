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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Homepage extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLACK, 2));
		panel.setBounds(33, 123, 282, 504);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNotification = new JButton("Notifikation");
		btnNotification.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNotification.setBounds(59, 150, 170, 31);
		panel.add(btnNotification);
		
		JButton btnProduct = new JButton("Produkt");
		btnProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnProduct.setBounds(59, 70, 170, 31);
		panel.add(btnProduct);
		
		JButton btnMap = new JButton("Kort");
		btnMap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMap.setBounds(59, 230, 170, 31);
		panel.add(btnMap);
		
		JButton btnAdmin = new JButton("Bruger Admin");
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdmin.setBounds(59, 310, 170, 31);
		panel.add(btnAdmin);
		
		JButton btnStatistik = new JButton("Statistik");
		btnStatistik.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStatistik.setBounds(59, 390, 170, 31);
		panel.add(btnStatistik);
		
		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 0, 80, 24);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(390, 123, 1015, 637);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1015, 637);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Produkt", "Udl\u00F8bsdato", "Status", "Rabat", "Valgt"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Double.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
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
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrint.setBounds(1235, 45, 170, 31);
		contentPane.add(btnPrint);
		
		JButton btnDiscount = new JButton("S\u00E6t Rabat");
		btnDiscount.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiscount.setBounds(980, 45, 170, 31);
		contentPane.add(btnDiscount);
		
		JButton btnArkive = new JButton("Arkivere");
		btnArkive.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnArkive.setBounds(725, 45, 170, 31);
		contentPane.add(btnArkive);
		
		JButton btnGenerateList = new JButton("Generere liste");
		btnGenerateList.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGenerateList.setBounds(470, 45, 170, 31);
		contentPane.add(btnGenerateList);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rabat", "Udl\u00F8bet", "AdvarselsPeriode"}));
		comboBox.setBounds(215, 45, 170, 31);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Filtrer efter status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(33, 45, 182, 31);
		contentPane.add(lblNewLabel_1);
	}
}
