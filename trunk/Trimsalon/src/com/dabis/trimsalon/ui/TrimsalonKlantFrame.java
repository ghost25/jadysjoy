package com.dabis.trimsalon.ui;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.dabis.trimsalon.beans.Klant;
import com.dabis.trimsalon.utils.HibernateUtil;
import com.dabis.trimsalon.utils.QueryTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TrimsalonKlantFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(TrimsalonKlantFrame.class);
	private javax.swing.JButton addButton = null;
	private JButton clearButton = null;
	private JButton exitButton = null;
	private JButton changeButton = null;
	private JPanel ivjJFrameContentPane = null;
	private JLabel ivjJLabel9 = null;
	private JLabel ivjJLabel1 = null;
	private JLabel ivjJLabel2 = null;
	private JLabel ivjJLabel3 = null;
	private JLabel ivjJLabel4 = null;
	private JLabel ivjJLabel5 = null;
	private JLabel ivjJLabel6 = null;
	private JLabel ivjJLabel7 = null;
	private JLabel ivjJLabel8 = null;
	private JLabel ivjJLabel11 = null;
	private JLabel ivjJLabel12 = null;
	private JLabel ivjJLabel13 = null;
	private JLabel ivjJLabel14 = null;
	private JTextField ivjJTextField = null;
	private JTextField ivjJTextField1 = null;
	private JTextField ivjJTextField2 = null;
	private JTextField ivjJTextField3 = null;
	private JTextField ivjJTextField4 = null;
	private JTextField ivjJTextField5 = null;
	private JTextField ivjJTextField6 = null;
	private JTextField ivjJTextField7 = null;
	private JTextField ivjJTextField8 = null;
	private JTextField ivjJTextField12 = null;
	private JTextField ivjJTextField13 = null;
	private JTextField ivjJTextField14 = null;
	private JScrollPane ivjJScrollPane = null;
	private JTable ivjJTable = null;
	private TableColumn ivjTableColumn = null;
	private TableColumn ivjTableColumn2 = null;
	private JTabbedPane ivjJTabbedPane = null;
	private JScrollPane ivjJScrollPane2 = null;
	private JList ivjJList = null;
	public Boolean sortAscending = new Boolean(true);
	public String sortBy = "naam";  //  @jve:decl-index=0:
	public TrimsalonKlantFrame() {
		super();
		initialize();
	}

	private void initialize() {
		setName("mainFrame");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(931, 539);
		this.setTitle("Klanten");
		this.setContentPane(getJFrameContentPane());
		fillIvjJTable(sortBy, sortAscending);
	}

	/**
	 * Return the JFrameContentPane property value.
	 * @return JPanel
	 */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(null);
			getJFrameContentPane().add(getJLabel1(), getJLabel1().getName());
			getJFrameContentPane().add(getJTextField1(),
					getJTextField1().getName());
			getJFrameContentPane().add(getJLabel11(), getJLabel11().getName());
			ivjJFrameContentPane.add(getIvjJTabbedPane(), getIvjJTabbedPane()
					.getName()); // JVE Generated
			ivjJFrameContentPane.add(getJLabel2(), null);
			ivjJFrameContentPane.add(getJLabel3(), null);
			ivjJFrameContentPane.add(getJLabel5(), null);
			ivjJFrameContentPane.add(getJLabel4(), null);
			ivjJFrameContentPane.add(getJLabel7(), null);
			ivjJFrameContentPane.add(getJLabel6(), null);
			ivjJFrameContentPane.add(getJLabel8(), null);
			ivjJFrameContentPane.add(getJLabel12(), null);
			ivjJFrameContentPane.add(getJLabel13(), null);
			ivjJFrameContentPane.add(getJLabel14(), null);
			ivjJFrameContentPane.add(getJTextField1(), null);
			ivjJFrameContentPane.add(getJTextField2(), null);
			ivjJFrameContentPane.add(getJTextField3(), null);
			ivjJFrameContentPane.add(getJTextField4(), null);
			ivjJFrameContentPane.add(getJTextField5(), null);
			ivjJFrameContentPane.add(getJTextField6(), null);
			ivjJFrameContentPane.add(getJTextField7(), null);
			ivjJFrameContentPane.add(getJTextField8(), null);
			ivjJFrameContentPane.add(getJTextField12(), null);
			ivjJFrameContentPane.add(getJTextField13(), null);
			ivjJFrameContentPane.add(getJTextField14(), null);
			ivjJFrameContentPane.add(getAddButton(), null);
			ivjJFrameContentPane.add(getClearButton(), null);
			ivjJFrameContentPane.add(getExitButton(), null);
			ivjJFrameContentPane.add(getChangeButton(), null);
			ivjJFrameContentPane.add(getJLabel9(), null);
			ivjJFrameContentPane.add(getJTextField(), null);
		}
		return ivjJFrameContentPane;
	}
	
	/**
	 * Return the addButton property value.
	 * @return JButton
	 */
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setText("Toevoegen");
			addButton.setBounds(new Rectangle(450, 450, 100, 25));
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					Klant c = new Klant();
					// If id is empty then its a new klant
					if(getJTextField().getText().equalsIgnoreCase("")) {
						// New klant
						c.setNaam(getJTextField1().getText());
						c.setAdres(getJTextField2().getText());
						c.setHuisnummer(getJTextField3().getText());
						c.setPostcode(getJTextField4().getText());
						c.setWoonplaats(getJTextField5().getText());
						c.setTelefoon(getJTextField6().getText());
						c.setMobiel(getJTextField7().getText());
						c.setEmail(getJTextField8().getText());
						/* c.setOphalen(getJTextField12().getText());*/
						c.setOpmerkingen(getJTextField13().getText());
						/*c.setInschrijfdatum(getJTextField14().getText());*/
										        
						Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				        session.beginTransaction();
				        session.save(c);
				        session.getTransaction().commit();
					} else {
						// Klant is modified
						long id = Long.parseLong(getJTextField().getText());
						Session session = HibernateUtil.getSessionFactory().getCurrentSession();
				        session.beginTransaction();
						c = (Klant) session.createQuery("from Klant where id="+id).list().get(0);
				        session.getTransaction().commit();

				    	c.setNaam(getJTextField1().getText());
						c.setAdres(getJTextField2().getText());
						c.setHuisnummer(getJTextField3().getText());
						c.setPostcode(getJTextField4().getText());
						c.setWoonplaats(getJTextField5().getText());
						c.setTelefoon(getJTextField6().getText());
						c.setMobiel(getJTextField7().getText());
						c.setEmail(getJTextField8().getText());
						/*c.setOphalen(getJTextField12().getText());*/
						c.setOpmerkingen(getJTextField13().getText());
						/*c.setInschrijfdatum(getJTextField14().getText());*/
												
				        session.beginTransaction();
				        session.save(c);
				        session.getTransaction().commit();

					}
					fillIvjJTable("Naam", true);
				}
			});
		}
		return addButton;
	}
	
	/**
	 * This method initializes changeButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getChangeButton() {
		if (changeButton == null) {
			changeButton = new JButton();
			changeButton.setBounds(new Rectangle(560, 450, 100, 25));
			changeButton.setText("Wijzigen");
			changeButton.setName("changeButton");
			changeButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearInvoer();
					//Return the focus to the typing area.
					ivjJTextField1.requestFocusInWindow();
					
				}
			});
		}
		return changeButton;
	}
	
	/**
	 * This method initializes clearButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton();
			clearButton.setBounds(new Rectangle(670, 450, 100, 25));
			clearButton.setText("Legen");
			clearButton.setName("clearButton");
			clearButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearInvoer();
					//Return the focus to the typing area.
					ivjJTextField1.requestFocusInWindow();
					
				}
			});
		}
		return clearButton;
	}
	
	/**
	 * This method initializes exitButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getExitButton() {
		if (exitButton == null) {
			exitButton = new JButton();
			exitButton.setBounds(new Rectangle(780, 450, 100, 25));
			exitButton.setText("Stoppen");
			exitButton.setName("exitButton");
			exitButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitButton;
	}
	
	private void clearInvoer() {
		getJTextField1().setText(null);
		getJTextField2().setText(null);
		getJTextField3().setText(null);
		getJTextField4().setText(null);
		getJTextField5().setText(null);
		getJTextField6().setText(null);
		getJTextField7().setText(null);
		getJTextField8().setText(null);
		getJTextField12().setText(null);
		getJTextField13().setText(null);
		getJTextField14().setText(null);
	}

	/**
	 * Return the JLabels property value.
	 * @return JLabel
	 */
	private JLabel getJLabel9() {
		if (ivjJLabel9 == null) {
			ivjJLabel9 = new JLabel();
			ivjJLabel9.setName("JLabel9");
			ivjJLabel9.setBounds(457, 80, 134, 15);
			ivjJLabel9.setText("Id");
		}
		return ivjJLabel9;
	}
	
	private JLabel getJLabel1() {
		if (ivjJLabel1 == null) {
			ivjJLabel1 = new JLabel();
			ivjJLabel1.setName("JLabel1");
			ivjJLabel1.setText("Naam");
			ivjJLabel1.setBounds(457, 110, 134, 15);
		}
		return ivjJLabel1;
	}
	
	private JLabel getJLabel2() {
		if (ivjJLabel2 == null) {
			ivjJLabel2 = new JLabel();
			ivjJLabel2.setName("JLabel2");
			ivjJLabel2.setBounds(new Rectangle(457, 140, 134, 15));
			ivjJLabel2.setText("Adres");
		}
		return ivjJLabel2;
	}
	
	private JLabel getJLabel3() {
		if (ivjJLabel3 == null) {
			ivjJLabel3 = new JLabel();
			ivjJLabel3.setName("JLabel3");
			ivjJLabel3.setBounds(new Rectangle(457, 170, 134, 15));
			ivjJLabel3.setText("Huisnummer");
		}
		return ivjJLabel3;
	}
	
	private JLabel getJLabel4() {
		if (ivjJLabel4 == null) {
			ivjJLabel4 = new JLabel();
			ivjJLabel4.setName("JLabel4");
			ivjJLabel4.setBounds(new Rectangle(457, 200, 134, 15));
			ivjJLabel4.setText("Postcode");
		}
		return ivjJLabel4;
	}
	
	private JLabel getJLabel5() {
		if (ivjJLabel5 == null) {
			ivjJLabel5 = new JLabel();
			ivjJLabel5.setName("JLabel5");
			ivjJLabel5.setBounds(new Rectangle(457, 230, 134, 15));
			ivjJLabel5.setText("Woonplaats");
		}
		return ivjJLabel5;
	}
	
	private JLabel getJLabel6() {
		if (ivjJLabel6 == null) {
			ivjJLabel6 = new JLabel();
			ivjJLabel6.setName("JLabel6");
			ivjJLabel6.setBounds(new Rectangle(457, 260, 134, 15));
			ivjJLabel6.setText("Telefoon");
		}
		return ivjJLabel6;
	}
	
	private JLabel getJLabel7() {
		if (ivjJLabel7 == null) {
			ivjJLabel7 = new JLabel();
			ivjJLabel7.setName("JLabel7");
			ivjJLabel7.setBounds(new Rectangle(457, 290, 134, 15));
			ivjJLabel7.setText("Mobiel");
		}
		return ivjJLabel7;
	}
	
	private JLabel getJLabel8() {
		if (ivjJLabel8 == null) {
			ivjJLabel8 = new JLabel();
			ivjJLabel8.setName("JLabel8");
			ivjJLabel8.setBounds(new Rectangle(457, 320, 134, 15));
			ivjJLabel8.setText("Email");
		}
		return ivjJLabel8;
	}
	
	private JLabel getJLabel12() {
		if (ivjJLabel12 == null) {
			ivjJLabel12 = new JLabel();
			ivjJLabel12.setName("JLabel12");
			ivjJLabel12.setBounds(new Rectangle(457, 350, 134, 15));
			ivjJLabel12.setText("Ophalen");
		}
		return ivjJLabel12;
	}
	private JLabel getJLabel13() {
		if (ivjJLabel13 == null) {
			ivjJLabel13 = new JLabel();
			ivjJLabel13.setName("JLabel13");
			ivjJLabel13.setBounds(new Rectangle(457, 380, 134, 15));
			ivjJLabel13.setText("Opmerkingen");
		}
		return ivjJLabel13;
	}
	private JLabel getJLabel14() {
		if (ivjJLabel14 == null) {
			ivjJLabel14 = new JLabel();
			ivjJLabel14.setName("JLabel14");
			ivjJLabel14.setBounds(new Rectangle(457, 410, 134, 15));
			ivjJLabel14.setText("Inschrijfdatum");
		}
		return ivjJLabel14;
	}

	/**
	 * Return the JLabel11 property value.
	 * @return JLabel
	 */
	private JLabel getJLabel11() {
		if (ivjJLabel11 == null) {
			ivjJLabel11 = new JLabel();
			ivjJLabel11.setName("JLabel11");
			ivjJLabel11.setText("Klant informatie");
			ivjJLabel11.setBounds(457, 39, 442, 34);
		}
		return ivjJLabel11;
	}

	/**
	 * Return the JTextFields property value.
	 * @return JTextField
	 */
	private JTextField getJTextField() {
		if (ivjJTextField == null) {
			ivjJTextField = new JTextField();
			ivjJTextField.setName("JTextField");
			ivjJTextField.setBounds(new Rectangle(600, 80, 300, 20));
		}
		return ivjJTextField;
	}
	
	private JTextField getJTextField1() {
		if (ivjJTextField1 == null) {
			ivjJTextField1 = new JTextField();
			ivjJTextField1.setName("JTextField1");
			ivjJTextField1.setBounds(new Rectangle(600, 110, 300, 20));
		}
		return ivjJTextField1;
	}
	
	private JTextField getJTextField2() {
		if (ivjJTextField2 == null) {
			ivjJTextField2 = new JTextField();
			ivjJTextField2.setName("JTextField2");
			ivjJTextField2.setBounds(new Rectangle(600, 140, 300, 20));
		}
		return ivjJTextField2;
	}
	
	private JTextField getJTextField3() {
		if (ivjJTextField3 == null) {
			ivjJTextField3 = new JTextField();
			ivjJTextField3.setName("JTextField3");
			ivjJTextField3.setBounds(new Rectangle(600, 170, 300, 20));
		}
		return ivjJTextField3;
	}
	
	private JTextField getJTextField4() {
		if (ivjJTextField4 == null) {
			ivjJTextField4 = new JTextField();
			ivjJTextField4.setName("JTextField4");
			ivjJTextField4.setBounds(new Rectangle(600, 200, 300, 20));
		}
		return ivjJTextField4;
	}
		
	private JTextField getJTextField5() {
		if (ivjJTextField5 == null) {
			ivjJTextField5 = new JTextField();
			ivjJTextField5.setName("JTextField5");
			ivjJTextField5.setBounds(new Rectangle(600, 230, 300, 20));
		}
		return ivjJTextField5;
	}
	
	private JTextField getJTextField6() {
		if (ivjJTextField6 == null) {
			ivjJTextField6 = new JTextField();
			ivjJTextField6.setName("JTextField6");
			ivjJTextField6.setBounds(new Rectangle(600, 260, 300, 20));
		}
		return ivjJTextField6;
	}
	
	private JTextField getJTextField7() {
		if (ivjJTextField7 == null) {
			ivjJTextField7 = new JTextField();
			ivjJTextField7.setName("JTextField7");
			ivjJTextField7.setBounds(new Rectangle(600, 290, 300, 20));
		}
		return ivjJTextField7;
	}	
	
	private JTextField getJTextField8() {
		if (ivjJTextField8 == null) {
			ivjJTextField8 = new JTextField();
			ivjJTextField8.setName("JTextField8");
			ivjJTextField8.setBounds(new Rectangle(600, 320, 300, 20));
		}
		return ivjJTextField8;
	}
	private JTextField getJTextField12() {
		if (ivjJTextField12 == null) {
			ivjJTextField12 = new JTextField();
			ivjJTextField12.setName("JTextField12");
			ivjJTextField12.setBounds(new Rectangle(600, 350, 300, 20));
		}
		return ivjJTextField12;
	}
	private JTextField getJTextField13() {
		if (ivjJTextField13 == null) {
			ivjJTextField13 = new JTextField();
			ivjJTextField13.setName("JTextField13");
			ivjJTextField13.setBounds(new Rectangle(600, 380, 300, 20));
		}
		return ivjJTextField13;
	}
	private JTextField getJTextField14() {
		if (ivjJTextField14 == null) {
			ivjJTextField14 = new JTextField();
			ivjJTextField14.setName("JTextField14");
			ivjJTextField14.setBounds(new Rectangle(600, 410, 300, 20));
		}
		return ivjJTextField14;
	}
	
	private class TableSelectionListener implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent e) {
	        //Ignore extra messages.
	        if (e.getValueIsAdjusting()) return;

	        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
	        if (lsm.isSelectionEmpty()) {
	            //no rows are selected
	        } else {
	            int selectedRow = lsm.getMinSelectionIndex();
	            //selectedRow is selected
	            String id = (String) ((QueryTableModel)getIvjJTable().getModel()).getRow(selectedRow)[0];
				Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		        session.beginTransaction();
				Klant c = (Klant) session.createQuery("from klant where id="+id).list().get(0);
		        session.getTransaction().commit();
		        getJTextField().setText(c.getId()+"");
		        getJTextField1().setText(c.getNaam());
		        getJTextField2().setText(c.getAdres());
		        getJTextField3().setText(c.getHuisnummer());
		        getJTextField4().setText(c.getPostcode()+"");
		        getJTextField5().setText(c.getWoonplaats()+"");
		        getJTextField6().setText(c.getTelefoon()+"");
		        getJTextField7().setText(c.getMobiel()+"");
		        getJTextField8().setText(c.getEmail()+"");
		        getJTextField12().setText(c.isOphalen()+"");
		        getJTextField13().setText(c.getOpmerkingen()+"");
		        getJTextField14().setText(c.getInschrijfdatum()+"");
	        }
	    }
	}
	
	private class TableSorter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            TableColumnModel columnModel = getIvjJTable().getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX()); 
            int column = getIvjJTable().convertColumnIndexToModel(viewColumn); 
            if(e.getClickCount() == 1 && column != -1) {
                sortAscending = new Boolean(!sortAscending.booleanValue());
				String v = ((QueryTableModel)getIvjJTable().getModel()).getVarNames()[column];
                sortBy = v.substring(0, 1).toLowerCase()+v.substring(1);
                fillIvjJTable(sortBy, sortAscending);
                clearInvoer();
            }
         }
	}

	/**
	 * This method initializes hondenScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getIvjJScrollPane() {
		if (ivjJScrollPane == null) {
			ivjJScrollPane = new JScrollPane();
			ivjJScrollPane.setViewportView(getIvjJTable());
		}
		return ivjJScrollPane;
	}

	/**
	 * This method initializes hondenTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getIvjJTable() {
		if (ivjJTable == null) {
			ivjJTable = new JTable();
			ivjJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			ivjJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			ivjJTable.setShowGrid(true);
// Ask to be notified of selection changes.
			ivjJTable.getSelectionModel().addListSelectionListener(new TableSelectionListener());
// Make column header click result in sorting ascending (shift-click is descending)
			ivjJTable.setColumnSelectionAllowed(false);
	        TableSorter listSorter = new TableSorter();
			JTableHeader th = ivjJTable.getTableHeader();
	        th.addMouseListener(listSorter); 
		}
		return ivjJTable;
	}
	
	@SuppressWarnings("unchecked")
	private void fillIvjJTable(String sortBy, Boolean ascending) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Klant.class);
        if(ascending) c.addOrder(Order.asc(sortBy));
        else c.addOrder(Order.desc(sortBy));
		List<Klant> list = c.list();
        session.getTransaction().commit();
        String[] cols = {"!Id","Naam","Adres","Postcode"};
        QueryTableModel m = new QueryTableModel(cols, list);
        getIvjJTable().setModel(m);
        
	}
	
	/**
	 * This method initializes ivjTableColumn
	 * 
	 * @return table.TableColumn
	 */
	@SuppressWarnings("unused")
	private TableColumn getIvjTableColumn() {
		if (ivjTableColumn == null) {
			ivjTableColumn = new TableColumn(); // Explicit Instance
			ivjTableColumn.setHeaderValue("Task");
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
	@SuppressWarnings("unused")
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
					.addTab("Klanten", null, getIvjJScrollPane2(), null); // JVE Generated
			ivjJTabbedPane.addTab("Details", null, getIvjJScrollPane(), null); // JVE Generated
			ivjJTabbedPane.setBounds(7, 28, 428, 476); // JVE Generated
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
			ivjJScrollPane2.setViewportView(getIvjJList());
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

}  //  @jve:decl-index=0:visual-constraint="-15,6"
