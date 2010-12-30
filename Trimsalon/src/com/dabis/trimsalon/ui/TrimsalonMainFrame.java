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

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.dabis.trimsalon.beans.Hond;
import com.dabis.trimsalon.utils.HibernateUtil;
import com.dabis.trimsalon.utils.QueryTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Scherm om een Hond te toevoegen/wijzigen/verwijderen
 */
public class TrimsalonMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static Logger log = Logger.getLogger(TrimsalonMainFrame.class);
	private javax.swing.JButton addButton = null;
	private JPanel ivjJFrameContentPane = null;
	private JLabel headerLabel = null;
	private JLabel idLabel = null;
	private JTextField idTextField = null;
	private JTabbedPane ivjJTabbedPane = null;
	private JTextField naamTextField = null;
	private JTextField rasTextField = null;
	private JLabel rasLabel = null;
	private JButton clearButton = null;
	private JButton exitButton = null;
	private JLabel Label = null;
	private JLabel leeftijdLabel = null;
	private JLabel gewichtLabel = null;
	private JTextField woonplaatsTextField = null;
	private JTextField leeftijdTextField = null;
	private JTextField gewichtTextField = null;
	private JScrollPane hondenScrollPane = null;
	private JTable hondenTable = null;
	public Boolean sortAscending = new Boolean(true);
	public String sortBy = "naam";  //  @jve:decl-index=0:
	public TrimsalonMainFrame() {
		super();
		initialize();
	}

	/**
	 * Return the addButton property value.
	 * @return JButton
	 */
	private JButton getAddButton() {
		if (addButton == null) {
			addButton = new JButton();
			addButton.setBounds(new Rectangle(16, 379, 96, 26));
			addButton.setText("Toevoegen");
			addButton.addActionListener(new ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent arg0) {
					Client c = new Client();
					// If id is empty then its a new client
					if(getIdTextField().getText().equalsIgnoreCase("")) {
						// New client
						c.setNaam(getNaamTextField().getText());
						c.setRas(getRasTextField().getText());
						c.setRt(getRtTextField().getText());
						c.setKleur(getKleurTextField().getText());
						c.setGecas(getGecasTextField().getText());
						c.setGeboren(getGeborenTextField().getText());
						c.setMk(getMkTextField().getText());
						c.setGedrag(getGedragTextField().getText());
						c.setAdvies(getAdviesTextField().getText());
				        
						Session session = HibernateUtil.getSessionFactory("").getCurrentSession();
				        session.beginTransaction();
				        session.save(c);
				        session.getTransaction().commit();
					} else {
						// Client is modified
						long id = Long.parseLong(getIdTextField().getText());
						Session session = HibernateUtil.getSessionFactory("").getCurrentSession();
				        session.beginTransaction();
						c = (Client) session.createQuery("from Client where id="+id).list().get(0);
				        session.getTransaction().commit();

				        c.setNaam(getNaamTextField().getText());
						c.setRas(getRasTextField().getText());
						c.setRt(getRtTextField().getText());
						c.setKleur(getKleurTextField().getText());
						c.setGecas(getGecasTextField().getText());
						c.setGeboren(getGeborenTextField().getText());
						c.setMk(getMkTextField().getText());
						c.setGedrag(getGedragTextField().getText());
						c.setAdvies(getAdviesTextField().getText());
						
				        session.beginTransaction();
				        session.save(c);
				        session.getTransaction().commit();

					}
					fillHondenTable("Naam", true);
				}
			});
		}
		return addButton;
	}

	/**
	 * Return the JFrameContentPane property value.
	 * @return JPanel
	 */
	private JPanel getJFrameContentPane() {
		if (ivjJFrameContentPane == null) {
			gewichtLabel = new JLabel();
			gewichtLabel.setBounds(new Rectangle(10, 250, 98, 15));
			gewichtLabel.setText("Gewicht");
			leeftijdLabel = new JLabel();
			leeftijdLabel.setBounds(new Rectangle(10, 220, 98, 15));
			leeftijdLabel.setText("Leeftijd");
			woonplaatsLabel = new JLabel();
			woonplaatsLabel.setBounds(new Rectangle(10, 190, 98, 15));
			woonplaatsLabel.setText("Woonplaats");
			naamLabel = new JLabel();
			naamLabel.setBounds(new Rectangle(10, 160, 98, 15));
			naamLabel.setText("Naam");
			idLabel = new JLabel();
			idLabel.setBounds(new Rectangle(10, 130, 98, 15));
			idLabel.setText("Soort");
			ivjJFrameContentPane = new JPanel();
			ivjJFrameContentPane.setName("JFrameContentPane");
			ivjJFrameContentPane.setLayout(null);
			ivjJFrameContentPane.add(getHeaderLabel(), null);
			ivjJFrameContentPane.add(getIdTextField(), null);
			ivjJFrameContentPane.add(idLabel, null);
			ivjJFrameContentPane.add(getSoortTextField(), null);
			ivjJFrameContentPane.add(naamLabel, null);
			ivjJFrameContentPane.add(getNaamTextField(), null);
			ivjJFrameContentPane.add(woonplaatsLabel, null);
			ivjJFrameContentPane.add(getWoonplaatsTextField(), null);
			ivjJFrameContentPane.add(leeftijdLabel, null);
			ivjJFrameContentPane.add(getLeeftijdTextField(), null);
			ivjJFrameContentPane.add(gewichtLabel, null);
			ivjJFrameContentPane.add(getGewichtTextField(), null);
			ivjJFrameContentPane.add(getAddButton(), null);
			ivjJFrameContentPane.add(getClearButton(), null);
			ivjJFrameContentPane.add(getExitButton(), null);
			ivjJFrameContentPane.add(getIvjJTabbedPane(), getIvjJTabbedPane().getName());
		}
		return ivjJFrameContentPane;
	}

	/**
	 * Return the JLabel1 property value.
	 * @return JLabel
	 */
	private JLabel getHeaderLabel() {
		if (headerLabel == null) {
			headerLabel = new JLabel();
			headerLabel.setText("Honden Toevoegen");
			headerLabel.setBounds(new Rectangle(5, 5, 378, 42));
		}
		return headerLabel;
	}

	/**
	 * Return the JTextField1 property value.
	 * @return JTextField
	 */
	private JTextField getIdTextField() {
		if (idTextField == null) {
			idTextField = new JTextField();
			idTextField.setName("idTextField");
			idTextField.setBounds(new Rectangle(120, 100, 56, 20));
			idTextField.setEditable(false);
			idTextField.setVisible(false);
		}
		return idTextField;
	}

	/**
	 * Initialize the class.
	 */
	private void initialize() {
		setName("mainFrame");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(787, 454);
		setTitle("Honden");
		setContentPane(getJFrameContentPane());
		fillHondenTable(sortBy, sortAscending);
		
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
					.addTab("Honden", null, getHondenScrollPane(), null); // JVE Generated
			ivjJTabbedPane.setBounds(414, 3, 356, 408); // JVE Generated
		}
		return ivjJTabbedPane;
	}

	/**
	 * This method initializes soortTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getSoortTextField() {
		if (soortTextField == null) {
			soortTextField = new JTextField();
			soortTextField.setBounds(new Rectangle(120, 130, 263, 19));
			soortTextField.setName("soortTextField");
		}
		return soortTextField;
	}

	/**
	 * This method initializes naamTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNaamTextField() {
		if (naamTextField == null) {
			naamTextField = new JTextField();
			naamTextField.setBounds(new Rectangle(120, 160, 263, 19));
			naamTextField.setName("naamTextField");
		}
		return naamTextField;
	}

	/**
	 * This method initializes clearButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getClearButton() {
		if (clearButton == null) {
			clearButton = new JButton();
			clearButton.setBounds(new Rectangle(129, 379, 106, 25));
			clearButton.setText("Legen");
			clearButton.setName("clearButton");
			clearButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					clearInvoer();
					//Return the focus to the typing area.
					idTextField.requestFocusInWindow();
					
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
			exitButton.setBounds(new Rectangle(255, 379, 106, 25));
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

	/**
	 * This method initializes woonplaatsTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getWoonplaatsTextField() {
		if (woonplaatsTextField == null) {
			woonplaatsTextField = new JTextField();
			woonplaatsTextField.setBounds(new Rectangle(120, 190, 263, 19));
			woonplaatsTextField.setName("woonplaatsTextField");
		}
		return woonplaatsTextField;
	}

	/**
	 * This method initializes leeftijdTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLeeftijdTextField() {
		if (leeftijdTextField == null) {
			leeftijdTextField = new JTextField();
			leeftijdTextField.setBounds(new Rectangle(120, 220, 263, 19));
			leeftijdTextField.setName("leeftijdTextField");
		}
		return leeftijdTextField;
	}

	/**
	 * This method initializes gewichtTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getGewichtTextField() {
		if (gewichtTextField == null) {
			gewichtTextField = new JTextField();
			gewichtTextField.setBounds(new Rectangle(120, 250, 263, 19));
			gewichtTextField.setName("gewichtTextField");
		}
		return gewichtTextField;
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
	            String id = (String) ((QueryTableModel)getHondenTable().getModel()).getRow(selectedRow)[0];
				Session session = HibernateUtil.getSessionFactory("").getCurrentSession();
		        session.beginTransaction();
				Client c = (Client) session.createQuery("from Client where id="+id).list().get(0);
		        session.getTransaction().commit();
		        getIdTextField().setText(c.getId()+"");
		        getSoortTextField().setText(c.getSoort());
		        getNaamTextField().setText(c.getNaam());
		        getWoonplaatsTextField().setText(c.getWoonplaats());
		        getLeeftijdTextField().setText(c.getLeeftijd()+"");
		        getGewichtTextField().setText(c.getGewicht()+"");
	        }
	    }
	}
	
	private class TableSorter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            TableColumnModel columnModel = getHondenTable().getColumnModel();
            int viewColumn = columnModel.getColumnIndexAtX(e.getX()); 
            int column = getHondenTable().convertColumnIndexToModel(viewColumn); 
            if(e.getClickCount() == 1 && column != -1) {
                sortAscending = new Boolean(!sortAscending.booleanValue());
				String v = ((QueryTableModel)getHondenTable().getModel()).getVarNames()[column];
                sortBy = v.substring(0, 1).toLowerCase()+v.substring(1);
                fillHondenTable(sortBy, sortAscending);
                clearInvoer();
            }
         }
	}

	/**
	 * This method initializes hondenScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getHondenScrollPane() {
		if (hondenScrollPane == null) {
			hondenScrollPane = new JScrollPane();
			hondenScrollPane.setViewportView(getHondenTable());
		}
		return hondenScrollPane;
	}

	/**
	 * This method initializes hondenTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getHondenTable() {
		if (hondenTable == null) {
			hondenTable = new JTable();
			hondenTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
			hondenTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			hondenTable.setShowGrid(true);
// Ask to be notified of selection changes.
			hondenTable.getSelectionModel().addListSelectionListener(new TableSelectionListener());
// Make column header click result in sorting ascending (shift-click is descending)
			hondenTable.setColumnSelectionAllowed(false);
	        TableSorter listSorter = new TableSorter();
			JTableHeader th = hondenTable.getTableHeader();
	        th.addMouseListener(listSorter); 
		}
		return hondenTable;
	}
	
	@SuppressWarnings("unchecked")
	private void fillHondenTable(String sortBy, Boolean ascending) {
		Session session = HibernateUtil.getSessionFactory("").getCurrentSession();
        session.beginTransaction();
        Criteria c = session.createCriteria(Client.class);
        if(ascending) c.addOrder(Order.asc(sortBy));
        else c.addOrder(Order.desc(sortBy));
		List<Client> list = c.list();
        session.getTransaction().commit();
        String[] cols = {"!Id","Soort","Naam","Woonplaats"};
        QueryTableModel m = new QueryTableModel(cols, list);
        getHondenTable().setModel(m);
        
	}
	
	private void clearInvoer() {
		getIdTextField().setText(null);
		getSoortTextField().setText(null);
		getNaamTextField().setText(null);
		getWoonplaatsTextField().setText(null);
		getLeeftijdTextField().setText(null);
		getGewichtTextField().setText(null);
	}
}  //  @jve:decl-index=0:visual-constraint="13,-12"
