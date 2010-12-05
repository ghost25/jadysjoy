package com.dabis.trimsalon.ui;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Example of a ToDoList.  Use the Add button to add entries that will be displayed in the list and the table
 */
public class ClientEntry extends JFrame {
	private javax.swing.JButton ivjJButton1 = null;
	private JPanel ivjJFrameContentPane = null;
	private JLabel ivjJLabel1 = null;
	private JLabel ivjJLabel11 = null;
	private JTextField ivjJTextField1 = null;
	private JScrollPane ivjJScrollPane = null;
	private JTable ivjJTable = null;
	private TableColumn ivjTableColumn = null;
	private TableColumn ivjTableColumn2 = null;
	private int taskCount = 0;
	private JTabbedPane ivjJTabbedPane = null;
	private JScrollPane ivjJScrollPane2 = null;
	private JList ivjJList = null;
	private JLabel ivjJLabel111 = null;
	private JTextField ivjJTextField11 = null;
	private JTextField ivjJTextField111 = null;
	private JLabel ivjJLabel1111 = null;
	private JButton ivjJButton11 = null;
	private JButton ivjJButton111 = null;
	private JLabel ivjJLabel11111 = null;
	private JLabel ivjJLabel111111 = null;
	private JLabel ivjJLabel1111111 = null;
	private JTextField ivjJTextField1111 = null;
	private JTextField ivjJTextField1112 = null;
	private JTextField ivjJTextField1113 = null;
	public ClientEntry() {
		super();
		initialize();
	}

	/**
	 * Return the JButton1 property value.
	 * @return JButton
	 */
	private JButton getJButton1() {
		if (ivjJButton1 == null) {
			ivjJButton1 = new JButton();
			ivjJButton1.setName("JButton1");
			ivjJButton1.setText("Toevoegen");
			ivjJButton1.setBounds(15, 379, 106, 25);
			ivjJButton1.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					String newTask = getJTextField1().getText();
					if (!newTask.equals("")) {
						DefaultListModel listModel = (DefaultListModel) getIvjJList()
								.getModel();
						listModel.addElement(newTask);
						TableModel model = getIvjJTable().getModel();
						model.setValueAt(newTask, taskCount, 0);
						model.setValueAt(new GregorianCalendar().getTime()
								.toString(), taskCount, 1);
						getJTextField1().setText("");
						if (taskCount < model.getRowCount() - 1)
							taskCount++;
					}
				}
			});
		}
		return ivjJButton1;
	}

	/**
	 * Return the JFrameContentPane property value.
	 * @return JPanel
	 */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			ivjJLabel1111111 = new JLabel();
			ivjJLabel1111111.setBounds(new Rectangle(10, 250, 98, 15));
			ivjJLabel1111111.setText("Gewicht");
			ivjJLabel1111111.setName("JLabel11");
			ivjJLabel111111 = new JLabel();
			ivjJLabel111111.setBounds(new Rectangle(10, 220, 98, 15));
			ivjJLabel111111.setText("Leeftijd");
			ivjJLabel111111.setName("JLabel11");
			ivjJLabel11111 = new JLabel();
			ivjJLabel11111.setBounds(new Rectangle(10, 190, 98, 15));
			ivjJLabel11111.setText("Woonplaats");
			ivjJLabel11111.setName("JLabel11");
			ivjJLabel1111 = new JLabel();
			ivjJLabel1111.setBounds(new Rectangle(10, 160, 98, 15));
			ivjJLabel1111.setText("Naam");
			ivjJLabel1111.setName("JLabel11");
			ivjJLabel111 = new JLabel();
			ivjJLabel111.setBounds(new Rectangle(10, 130, 98, 15));
			ivjJLabel111.setText("Soort");
			ivjJLabel111.setName("JLabel11");
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(null);
			getJFrameContentPane().add(getJLabel1(), getJLabel1().getName());
			getJFrameContentPane().add(getJTextField1(),
					getJTextField1().getName());
			getJFrameContentPane().add(getJButton1(), getJButton1().getName());
			getJFrameContentPane().add(getJLabel11(), getJLabel11().getName());
			ivjJFrameContentPane.add(getIvjJTabbedPane(), getIvjJTabbedPane()
					.getName()); // JVE Generated
			ivjJFrameContentPane.add(ivjJLabel111, null);
			ivjJFrameContentPane.add(getIvjJTextField11(), null);
			ivjJFrameContentPane.add(getIvjJTextField111(), null);
			ivjJFrameContentPane.add(ivjJLabel1111, null);
			ivjJFrameContentPane.add(getIvjJButton11(), null);
			ivjJFrameContentPane.add(getIvjJButton111(), null);
			ivjJFrameContentPane.add(ivjJLabel11111, null);
			ivjJFrameContentPane.add(ivjJLabel111111, null);
			ivjJFrameContentPane.add(ivjJLabel1111111, null);
			ivjJFrameContentPane.add(getIvjJTextField1111(), null);
			ivjJFrameContentPane.add(getIvjJTextField1112(), null);
			ivjJFrameContentPane.add(getIvjJTextField1113(), null);
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the JLabel1 property value.
	 * @return JLabel
	 */
	private JLabel getJLabel1() {
		if (ivjJLabel1 == null) {
			ivjJLabel1 = new JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Honden Toevoegen");
			ivjJLabel1.setBounds(12, 12, 372, 47);
		}
		return ivjJLabel1;
	}

	/**
	 * Return the JLabel11 property value.
	 * @return JLabel
	 */
	private JLabel getJLabel11() {
		if (ivjJLabel11 == null) {
			ivjJLabel11 = new JLabel();
			ivjJLabel11.setName("JLabel11");
			ivjJLabel11.setText("ID");
			ivjJLabel11.setBounds(10, 100, 98, 15);
		}
		return ivjJLabel11;
	}

	/**
	 * Return the JTextField1 property value.
	 * @return JTextField
	 */
	private JTextField getJTextField1() {
		if (ivjJTextField1 == null) {
			ivjJTextField1 = new JTextField();
			ivjJTextField1.setName("JTextField1");
			ivjJTextField1.setBounds(120, 100, 263, 19);
			ivjJTextField1.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					String newTask = getJTextField1().getText();
					if (!newTask.equals("")) {
						DefaultListModel listModel = (DefaultListModel) getIvjJList()
								.getModel();
						listModel.addElement(newTask);
						TableModel model = getIvjJTable().getModel();
						model.setValueAt(newTask, taskCount, 0);
						model.setValueAt(new GregorianCalendar().getTime()
								.toString(), taskCount, 1);
						getJTextField1().setText("");
						if (taskCount < model.getRowCount() - 1)
							taskCount++;
					}
				}
			});
		}
		return ivjJTextField1;
	}

	/**
	 * Initialize the class.
	 */
	private void initialize() {
		setName("JFrame1");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(787, 454);
		setTitle("Hond toevoegen");
		setContentPane(getJFrameContentPane());

	}

	/**
	 * This method initializes ivjJScrollPane
	 * 
	 * @return JScrollPane
	 */
	private JScrollPane getIvjJScrollPane() {
		if (ivjJScrollPane == null) {
			ivjJScrollPane = new JScrollPane(); // Explicit Instance
			ivjJScrollPane.setViewportView(getIvjJTable()); // JVE Generated
			ivjJScrollPane.setBounds(10, 130, 329, 146); // JVE Generated
		}
		return ivjJScrollPane;
	}

	/**
	 * Static inner class for the table model
	 */
	public static class ToDoListModel extends AbstractTableModel {

		String[][] data = { { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" }, { "", "" }, { "", "" },
				{ "", "" }, { "", "" }, { "", "" } };

		public Object getValueAt(int rowIndex, int columnIndex) {
			return data[rowIndex][columnIndex];
		}

		public int getColumnCount() {
			return 0;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int c) {
			return ("");
		}

		public void setValueAt(Object arg0, int arg1, int arg2) {
			data[arg1][arg2] = (String) arg0;
			fireTableDataChanged();
		}
	}

	/**
	 * This method initializes ivjJTable
	 * 
	 * @return JTable
	 */
	private JTable getIvjJTable() {
		if (ivjJTable == null) {
			ivjJTable = new JTable(); // Explicit Instance
			ivjJTable.addColumn(getIvjTableColumn()); // JVE Generated
			ivjJTable.setAutoCreateColumnsFromModel(false); // JVE Generated
			ivjJTable.setModel(new ToDoListModel());
			ivjJTable.addColumn(getIvjTableColumn2());
		}
		return ivjJTable;
	}

	/**
	 * This method initializes ivjTableColumn
	 * 
	 * @return table.TableColumn
	 */
	private TableColumn getIvjTableColumn() {
		if (ivjTableColumn == null) {
			ivjTableColumn = new TableColumn(); // Explicit Instance
			ivjTableColumn.setHeaderValue("Hond");
			ivjTableColumn.setPreferredWidth(40); // JVE Generated
			ivjTableColumn.setResizable(false); // JVE Generated
			ivjTableColumn.setModelIndex(0); // JVE Generated
		}
		return ivjTableColumn;
	}

	/**
	 * This method initializes ivjTableColumn2
	 * 
	 * @return table.TableColumn
	 */
	private TableColumn getIvjTableColumn2() {
		if (ivjTableColumn2 == null) {
			ivjTableColumn2 = new TableColumn(); // Explicit Instance
			ivjTableColumn2.setHeaderValue("Time Added");
			ivjTableColumn2.setPreferredWidth(90); // JVE Generated
			ivjTableColumn2.setModelIndex(1); // JVE Generated
		}
		return ivjTableColumn2;
	}

	/**
	 * This method initializes ivjJTabbedPane
	 * 
	 * @return JTabbedPane
	 */
	private JTabbedPane getIvjJTabbedPane() {
		if (ivjJTabbedPane == null) {
			ivjJTabbedPane = new JTabbedPane(); // Explicit Instance
			ivjJTabbedPane
					.addTab("Honden", null, getIvjJScrollPane2(), null); // JVE Generated
			ivjJTabbedPane.addTab("Details", null, getIvjJScrollPane(), null); // JVE Generated
			ivjJTabbedPane.setBounds(414, 3, 356, 408); // JVE Generated
		}
		return ivjJTabbedPane;
	}

	/**
	 * This method initializes ivjJScrollPane2
	 * 
	 * @return JScrollPane
	 */
	private JScrollPane getIvjJScrollPane2() {
		if (ivjJScrollPane2 == null) {
			ivjJScrollPane2 = new JScrollPane(); // Explicit Instance
			ivjJScrollPane2.setViewportView(getIvjJList()); // JVE Generated
		}
		return ivjJScrollPane2;
	}

	/**
	 * This method initializes ivjJList
	 * 
	 * @return JList
	 */
	private JList getIvjJList() {
		if (ivjJList == null) {
			ivjJList = new JList(); // Explicit Instance
			ivjJList.setModel(new DefaultListModel());
		}
		return ivjJList;
	}

	/**
	 * This method initializes ivjJTextField11	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIvjJTextField11() {
		if (ivjJTextField11 == null) {
			ivjJTextField11 = new JTextField();
			ivjJTextField11.setBounds(new Rectangle(120, 130, 263, 19));
			ivjJTextField11.setName("JTextField1");
		}
		return ivjJTextField11;
	}

	/**
	 * This method initializes ivjJTextField111	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIvjJTextField111() {
		if (ivjJTextField111 == null) {
			ivjJTextField111 = new JTextField();
			ivjJTextField111.setBounds(new Rectangle(120, 160, 263, 19));
			ivjJTextField111.setName("JTextField1");
		}
		return ivjJTextField111;
	}

	/**
	 * This method initializes ivjJButton11	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getIvjJButton11() {
		if (ivjJButton11 == null) {
			ivjJButton11 = new JButton();
			ivjJButton11.setBounds(new Rectangle(136, 379, 106, 25));
			ivjJButton11.setText("Legen");
			ivjJButton11.setName("JButton1");
			ivjJButton11.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					 //Clear the text components.
					ivjJTextField1.setText("");
					ivjJTextField11.setText("");
					ivjJTextField111.setText("");
					ivjJTextField1111.setText("");
					ivjJTextField1112.setText("");
					ivjJTextField1113.setText("");
			        //Return the focus to the typing area.
					ivjJTextField1.requestFocusInWindow();
					
				}
			});
		}
		return ivjJButton11;
	}

	/**
	 * This method initializes ivjJButton111	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getIvjJButton111() {
		if (ivjJButton111 == null) {
			ivjJButton111 = new JButton();
			ivjJButton111.setBounds(new Rectangle(255, 379, 106, 25));
			ivjJButton111.setText("Stoppen");
			ivjJButton111.setName("JButton1");
			ivjJButton111.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()");
					System.exit(0);
					// TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return ivjJButton111;
	}

	/**
	 * This method initializes ivjJTextField1111	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIvjJTextField1111() {
		if (ivjJTextField1111 == null) {
			ivjJTextField1111 = new JTextField();
			ivjJTextField1111.setBounds(new Rectangle(120, 190, 263, 19));
			ivjJTextField1111.setName("JTextField1");
		}
		return ivjJTextField1111;
	}

	/**
	 * This method initializes ivjJTextField1112	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIvjJTextField1112() {
		if (ivjJTextField1112 == null) {
			ivjJTextField1112 = new JTextField();
			ivjJTextField1112.setBounds(new Rectangle(120, 220, 263, 19));
			ivjJTextField1112.setName("JTextField1");
		}
		return ivjJTextField1112;
	}

	/**
	 * This method initializes ivjJTextField1113	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIvjJTextField1113() {
		if (ivjJTextField1113 == null) {
			ivjJTextField1113 = new JTextField();
			ivjJTextField1113.setBounds(new Rectangle(120, 250, 263, 19));
		}
		return ivjJTextField1113;
	}
}  //  @jve:decl-index=0:visual-constraint="208,6"
