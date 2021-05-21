package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableRowSorter;

import controller.GenerateListController;
import model.Batch;
import javax.swing.JProgressBar;

public class Homepage extends JFrame {
	private static final long serialVersionUID = 1L;

	private static Homepage frame;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboBox;

	private GenerateListController glc;
	private BatchTableModel btm;
	private TableRowSorter<BatchTableModel> sorter;
	private JLabel lblTimeOfEdit;
	private JLabel lblStatus;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Homepage();
					frame.setVisible(true);
					frame.setMinimumSize(new Dimension(1000, 500));
					frame.setPreferredSize(new Dimension(1000, 600));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				frame.notifyGenerateListUpdate();
			}
		}).start();
	}

	/**
	 * Create the frame.
	 */
	public Homepage() {
		setTitle("Hovedmenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 30, 10, 30));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 25, 0, 0 };
		gbl_panel.rowHeights = new int[] { 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblMenu = new JLabel("Menu:");
		GridBagConstraints gbc_lblMenu = new GridBagConstraints();
		gbc_lblMenu.anchor = GridBagConstraints.WEST;
		gbc_lblMenu.insets = new Insets(0, 0, 5, 5);
		gbc_lblMenu.gridx = 1;
		gbc_lblMenu.gridy = 0;
		panel.add(lblMenu, gbc_lblMenu);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_6 = new GridBagConstraints();
		gbc_verticalStrut_6.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_6.gridx = 1;
		gbc_verticalStrut_6.gridy = 1;
		panel.add(verticalStrut_6, gbc_verticalStrut_6);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(10, 0));
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 2;
		panel.add(horizontalStrut_1, gbc_horizontalStrut_1);

		JButton btnProduct = new JButton("Produkt");		

		GridBagConstraints gbc_btnProduct = new GridBagConstraints();
		gbc_btnProduct.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProduct.insets = new Insets(0, 0, 5, 5);
		gbc_btnProduct.anchor = GridBagConstraints.NORTH;
		gbc_btnProduct.gridx = 1;
		gbc_btnProduct.gridy = 2;
		panel.add(btnProduct, gbc_btnProduct);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(10, 0));
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 2;
		gbc_horizontalStrut.gridy = 2;
		panel.add(horizontalStrut, gbc_horizontalStrut);

		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 3;
		panel.add(verticalStrut, gbc_verticalStrut);

		JButton btnNotification = new JButton("Notifikation");
		GridBagConstraints gbc_btnNotification = new GridBagConstraints();
		gbc_btnNotification.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNotification.insets = new Insets(0, 0, 5, 5);
		gbc_btnNotification.gridx = 1;
		gbc_btnNotification.gridy = 4;
		panel.add(btnNotification, gbc_btnNotification);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 5;
		panel.add(verticalStrut_1, gbc_verticalStrut_1);

		JButton btnMap = new JButton("Kort");
		GridBagConstraints gbc_btnMap = new GridBagConstraints();
		gbc_btnMap.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMap.insets = new Insets(0, 0, 5, 5);
		gbc_btnMap.gridx = 1;
		gbc_btnMap.gridy = 6;
		panel.add(btnMap, gbc_btnMap);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 7;
		panel.add(verticalStrut_2, gbc_verticalStrut_2);

		JButton btnUserAdmin = new JButton("Bruger Admin");
		GridBagConstraints gbc_btnUserAdmin = new GridBagConstraints();
		gbc_btnUserAdmin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUserAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_btnUserAdmin.gridx = 1;
		gbc_btnUserAdmin.gridy = 8;
		panel.add(btnUserAdmin, gbc_btnUserAdmin);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 9;
		panel.add(verticalStrut_3, gbc_verticalStrut_3);

		JButton btnStatistic = new JButton("Statistik");
		GridBagConstraints gbc_btnStatistic = new GridBagConstraints();
		gbc_btnStatistic.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnStatistic.insets = new Insets(0, 0, 5, 5);
		gbc_btnStatistic.gridx = 1;
		gbc_btnStatistic.gridy = 10;
		panel.add(btnStatistic, gbc_btnStatistic);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_4 = new GridBagConstraints();
		gbc_verticalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_4.gridx = 1;
		gbc_verticalStrut_4.gridy = 11;
		panel.add(verticalStrut_4, gbc_verticalStrut_4);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_5, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(35, 0));
		panel_1.add(horizontalStrut_2, BorderLayout.WEST);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 97, 82, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 13, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblFiltrerEfterStatus = new JLabel("Filtrer efter status:");
		GridBagConstraints gbc_lblFiltrerEfterStatus = new GridBagConstraints();
		gbc_lblFiltrerEfterStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrerEfterStatus.gridx = 0;
		gbc_lblFiltrerEfterStatus.gridy = 0;
		panel_3.add(lblFiltrerEfterStatus, gbc_lblFiltrerEfterStatus);

		comboBox = new JComboBox<String>();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					rowSorting();
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Samlet liste", "Rabat", "Udløbet", "Advarsels Periode" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_3.add(comboBox, gbc_comboBox);

		JLabel lblActiveUser = new JLabel("Logget ind som:");
		GridBagConstraints gbc_lblActiveUser = new GridBagConstraints();
		gbc_lblActiveUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblActiveUser.gridx = 4;
		gbc_lblActiveUser.gridy = 0;
		panel_3.add(lblActiveUser, gbc_lblActiveUser);

		JLabel lblCurrUser = new JLabel("{Default}");
		GridBagConstraints gbc_lblCurrUser = new GridBagConstraints();
		gbc_lblCurrUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrUser.gridx = 5;
		gbc_lblCurrUser.gridy = 0;
		panel_3.add(lblCurrUser, gbc_lblCurrUser);

		JButton btnLogOut = new JButton("Log ud");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogOut.gridx = 6;
		gbc_btnLogOut.gridy = 0;
		panel_3.add(btnLogOut, gbc_btnLogOut);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_7 = new GridBagConstraints();
		gbc_verticalStrut_7.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut_7.gridx = 0;
		gbc_verticalStrut_7.gridy = 1;
		panel_3.add(verticalStrut_7, gbc_verticalStrut_7);

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_8 = new GridBagConstraints();
		gbc_verticalStrut_8.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_8.gridx = 0;
		gbc_verticalStrut_8.gridy = 0;
		panel_4.add(verticalStrut_8, gbc_verticalStrut_8);

		JButton btnGenerate = new JButton("Generere Liste");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BackgroundWorker(progressBar, frame).execute();;
			}
		});
		GridBagConstraints gbc_btnGenerate = new GridBagConstraints();
		gbc_btnGenerate.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenerate.gridx = 0;
		gbc_btnGenerate.gridy = 1;
		panel_4.add(btnGenerate, gbc_btnGenerate);
		
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.gridwidth = 3;
		gbc_progressBar.insets = new Insets(0, 0, 0, 5);
		gbc_progressBar.gridx = 1;
		gbc_progressBar.gridy = 1;
		panel_4.add(progressBar, gbc_progressBar);

		JButton btnArchive = new JButton("Arkivere");
		GridBagConstraints gbc_btnArchive = new GridBagConstraints();
		gbc_btnArchive.insets = new Insets(0, 0, 0, 5);
		gbc_btnArchive.gridx = 12;
		gbc_btnArchive.gridy = 1;
		panel_4.add(btnArchive, gbc_btnArchive);

		JButton btnDiscount = new JButton("S\u00E6t discount");
		GridBagConstraints gbc_btnDiscount = new GridBagConstraints();
		gbc_btnDiscount.insets = new Insets(0, 0, 0, 5);
		gbc_btnDiscount.gridx = 13;
		gbc_btnDiscount.gridy = 1;
		panel_4.add(btnDiscount, gbc_btnDiscount);

		JButton btnPrint = new JButton("Udskriv");
		GridBagConstraints gbc_btnPrint = new GridBagConstraints();
		gbc_btnPrint.gridx = 14;
		gbc_btnPrint.gridy = 1;
		panel_4.add(btnPrint, gbc_btnPrint);

		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.NORTH);

		Component verticalStrut_9 = Box.createVerticalStrut(20);
		panel_6.add(verticalStrut_9);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_5.add(panel_7, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 45, 0, 0, 0, 0, 0 };
		gbl_panel_7.rowHeights = new int[] { 13, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		JLabel lblOnline = new JLabel("Online:");
		GridBagConstraints gbc_lblOnline = new GridBagConstraints();
		gbc_lblOnline.insets = new Insets(0, 0, 0, 5);
		gbc_lblOnline.gridx = 0;
		gbc_lblOnline.gridy = 0;
		panel_7.add(lblOnline, gbc_lblOnline);

		lblStatus = new JLabel("");
		GridBagConstraints gbc_lblStatus = new GridBagConstraints();
		gbc_lblStatus.insets = new Insets(0, 0, 0, 5);
		gbc_lblStatus.gridx = 1;
		gbc_lblStatus.gridy = 0;
		panel_7.add(lblStatus, gbc_lblStatus);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_4 = new GridBagConstraints();
		gbc_horizontalStrut_4.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalStrut_4.gridx = 2;
		gbc_horizontalStrut_4.gridy = 0;
		panel_7.add(horizontalStrut_4, gbc_horizontalStrut_4);

		JLabel lblUpdate = new JLabel("Sidste DB opdatering:");
		GridBagConstraints gbc_lblUpdate = new GridBagConstraints();
		gbc_lblUpdate.insets = new Insets(0, 0, 0, 5);
		gbc_lblUpdate.gridx = 3;
		gbc_lblUpdate.gridy = 0;
		panel_7.add(lblUpdate, gbc_lblUpdate);

		lblTimeOfEdit = new JLabel("");
		GridBagConstraints gbc_lblTimeOfEdit = new GridBagConstraints();
		gbc_lblTimeOfEdit.gridx = 4;
		gbc_lblTimeOfEdit.gridy = 0;
		panel_7.add(lblTimeOfEdit, gbc_lblTimeOfEdit);

		init();
	}

	private void init() {
		try {
			try {
				this.glc = new GenerateListController();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			btm = new BatchTableModel();
			sorter = new TableRowSorter<>(btm);
			sorter.setSortsOnUpdates(true);
			table.setModel(btm);
			table.setRowSorter(sorter);
			table.setDefaultRenderer(String.class, new BatchTableCellRenderer());
			table.getTableHeader().setReorderingAllowed(false);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Problem finding lists " + e.getMessage());
		}

	}

	protected void generateLists() {

		try {
			glc.generateList();
			List<Batch> nl = glc.getBatchCopyList();
			btm.setData(nl);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Batch list could not be generated");
		}

	}

	private void rowSorting() {
		String res = "";
		switch ((String) comboBox.getSelectedItem()) {
		case "Rabat":
			res = "DISCOUNT";
			break;
		case "Udløbet":
			res = "EXPIRED";
			break;
		case "Advarsels Periode":
			res = "PENDING";
			break;
		default:
			break;
		}

		RowFilter<BatchTableModel, Object> rf = RowFilter.regexFilter(res, 2);
		sorter.setRowFilter(rf);
	}

	private void notifyGenerateListUpdate() {

		try {
			String time = glc.getLastGenerateListUpdateTime();
			
			SwingUtilities.invokeLater(() -> {
				lblStatus.setText("sandt");
				if (time != null) {
					lblTimeOfEdit.setText(time);
				} else {
					lblTimeOfEdit.setText("ingen");
				}
			});
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SwingUtilities.invokeLater(() -> {
				lblStatus.setText("falsk");
			});
		}

	}

}
