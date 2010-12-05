/**
 * 
 */
package com.dabis.trimsalon.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * 
 * @author Tom
 *
 */
public class QueryTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private Vector<String[]> cache = new Vector<String[]>();
	private String[] headers;
	private boolean[] columnsVisible;
	private String[] varNames;
	
	/**
	 * Constructors
	 * @param <T>
	 */
	public <T> QueryTableModel(String[] columnNames, List<T> data) {
		setHeaders(columnNames);
		setVarNames(getHeaders());
		setCache(data);
	}
	
	public <T> QueryTableModel(String[] columnNames, String[] attributeNames, List<T> data) {
		setHeaders(columnNames);
		setVarNames(attributeNames);
		setCache(data);
	}
	
    /**
	 * @return the headers
	 */
	public String[] getHeaders() {
		return headers;
	}
	
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String[] headers) {
		this.headers = new String[headers.length];
		columnsVisible = new boolean[headers.length];
		// Determine the column names. If given name starts with "!" the column must be hidden
		for(int i=0; i<headers.length; i++){
			if( headers[i].startsWith("!") ) {
				this.headers[i]  = headers[i].substring(1);
				columnsVisible[i] = false;
			} else {
				this.headers[i]  = headers[i];
				columnsVisible[i] = true;
			}
		}
	}
	
	/**
	 * @return the varNames
	 */
	public String[] getVarNames() {
		return varNames;
	}
	
	/**
	 * @param varNames the varNames to set
	 */
	public void setVarNames(String[] varNames) {
		this.varNames = varNames;
	}
	
	public String[] getRow(int row) {
		return cache.elementAt(row);
	}
	
	/**
	 * @param cache the cache to set
	 */
	public void setCache(Vector<String[]> cache) {
		this.cache = cache;
	}
	
	public <T> void setCache(List<T> data) {
		// Fill the data cache.
		// columns contains the getter methods for each column
		Method[] columns = new Method[varNames.length];
		// have to get the class of T
		Class<?> cls = data.get(0).getClass();
		try {
			// determine the getter methods
			for(int i=0; i<varNames.length; i++) {
				columns[i] = cls.getMethod("get"+varNames[i], (Class<?>[]) null);
			}
			// go through the list of objects
			for (T t : data) {
				String[] row = new String[varNames.length];
				// for each column invoke its get-method to retrieve the value
				// and convert the returned object to a String
				for(int i=0; i<varNames.length; i++) {
					row[i] = columns[i].invoke(t, (Object[]) null).toString();
				}
				// add the row to the cache
				cache.addElement(row);
			}
			// notify everyone that we have a new table.
			fireTableChanged(null);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
     * This function converts a column number in the table
     * to the right number of the data column.
     */
    protected int getNumber (int col) {
        int n = col;    // right number to return
        int i = 0;
        do {
            if (!(columnsVisible[i])) n++;
            i++;
        } while (i < n);
        // If we are on an invisible column, 
        // we have to go one step further
        while (!(columnsVisible[n])) n++;
        return n;
    }

	@Override
	public int getColumnCount() {
        int n = 0;
        for (int i = 0; i < headers.length; i++)
            if (columnsVisible[i]) n++;
        return n;
	}
	@Override
	public int getRowCount() { return cache.size(); }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] array = (Object[])(cache.elementAt(rowIndex));
        return array[getNumber(columnIndex)];
	}
	public String getColumnName(int i) {
		return headers[getNumber(i)];
	}

}
