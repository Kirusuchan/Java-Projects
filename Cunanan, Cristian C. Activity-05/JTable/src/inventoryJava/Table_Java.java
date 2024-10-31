package inventoryJava;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public class Table_Java extends JFrame {
	
	//this will create a new Panel with BorderLayout
	JPanel tblPanel = new JPanel(new BorderLayout());
	//this will create an array of JTextField with fixed size of 5
	JTextField [] txtFields = new JTextField[7];
	//this will create an array of JLabel with fixed size of 5
	JLabel [] lblFields = new JLabel[7];
	//this string array will be the text of the Jlabel
	String [] strLblFields = {"Item Code : ","Item Name:", "Item Description : ", "Price : ", "Size. : ", "Stocks : " , "Re-order Point : "};
	//this will create a JButton
	JButton AddButton = new JButton();
	JButton StockInButton = new JButton();
	JButton EditButton = new JButton();
	JButton DeleteButton = new JButton();
	JButton SaveButton = new JButton();
	JButton SaveButton1 = new JButton();
	JButton CancelButton = new JButton();
	JButton CancelButton1 = new JButton();
	
	//also serves as the number of columns
	String[] columnNames = {"Item Code", "Item Name","Item Description", "Price", "Size", "Stock" ,"Re-order Point", "Remarks"};

	// Create a DefaultTableModel with empty data and column names
	DefaultTableModel model = new DefaultTableModel(new Object[0][columnNames.length], columnNames);
	Object[][] data = {
		{"00001", "Spam", "Canned Goods", 50.0, "200g", 100, 50, "High Stock"},
		{"00002", "Corned Beef", "Canned Goods", 40.0, "150g", 75, 30, "High Stock"},
		{"00003", "Tuna Flakes", "Canned Goods", 25.0, "150g", 50, 20, "Low Stock"},
		{"00004", "Instant Noodles", "Noodles", 15.0, "55g", 200, 100, "High Stock"},
		{"00005", "Pancit Canton", "Noodles", 12.0, "80g", 150, 70, "High Stock"},
		{"00006", "Chips", "Snacks", 20.0, "100g", 50, 25, "Low Stock"},
		{"00007", "Soda", "Drinks", 25.0, "350ml", 100, 50, "High Stock"},
		{"00008", "Juice", "Drinks", 30.0, "1L", 75, 30, "High Stock"},
		{"00009", "Bottled Water", "Drinks", 10.0, "500ml", 200, 100, "High Stock"},
		{"00010", "Canned Juice", "Drinks", 20.0, "240ml", 50, 20, "Low Stock"}
	};

	// Create a JTable with the model
	JTable table = new JTable(model);
	TableColumnModel columnModel = table.getColumnModel();

	TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());
	JTextField txtSearch = new JTextField();
			
	int itemCodeCounter = 11;
	

	public Table_Java() {
		
		this.setTitle("INVENTORY");
		this.setSize(1100, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		int y = 50;
		
		//this loop will set the properties of JTextField , JLabel
		for(int i = 0; i <= lblFields.length -1 ; i++) {
		//properties of JTextField
		txtFields[i] = new JTextField();
		txtFields[i].setBounds(180, y, 150, 25);
		this.add(txtFields[i]);
		
		
		//properties of JLabel
		lblFields[i] = new JLabel();
		lblFields[i].setText(strLblFields[i]);
		lblFields[i].setBounds(50, y, 150, 25);
		this.add(lblFields[i]);
		y+=30;
		}
	
		// Add the table to the center of the tblPanel
		tblPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		AddButton.setBounds(150, 280, 100, 30);
		AddButton.setText("Add");
		AddButton.setFocusable(false);
		
		StockInButton.setBounds(30, 280, 100, 30);
		StockInButton.setText("Stock in");
		StockInButton.setFocusable(false);
		
		EditButton.setBounds(270, 280, 100, 30);
		EditButton.setText("Edit");
		EditButton.setFocusable(false);
		
		SaveButton.setBounds(150, 330, 100, 30);
		SaveButton.setText("Save");
		SaveButton.setFocusable(false);
		SaveButton.setEnabled(false);
		
		SaveButton1.setBounds(150, 330, 100, 30);
		SaveButton1.setText("Save");
		SaveButton1.setFocusable(false);
		SaveButton1.setEnabled(false);
		SaveButton1.setVisible(false);
		
		DeleteButton.setBounds(30, 330, 100, 30);
		DeleteButton.setText("Delete");
		DeleteButton.setFocusable(false);
		
		CancelButton.setBounds(270, 330, 100, 30);
		CancelButton.setText("Cancel");
		CancelButton.setFocusable(false);
		CancelButton.setEnabled(false);
		
		CancelButton1.setBounds(270, 330, 100, 30);
		CancelButton1.setText("Cancel");
		CancelButton1.setFocusable(false);
		CancelButton1.setEnabled(false);
		CancelButton1.setVisible(false);
		

		txtSearch.setBounds(430, 10, 600, 30);
		txtSearch.setVisible(true);
		
		tblPanel.setBounds(400, 50, 650, 370);
		tblPanel.setBackground(Color.white);
		
//		txtFields[0].setText("00010");

		
		
		for (int i = 0; i < txtFields.length; i++) {
		    txtFields[i].setEditable(false);
		}
		
		// Disable column resizing for all columns
		for (int i = 0; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setResizable(false);
		}

		table.setDefaultEditor(Object.class, null);
		
		table.getTableHeader().setReorderingAllowed(false);
		
		tblPanel.add(new JScrollPane(table), BorderLayout.CENTER);
	
		// Set the horizontal alignment of the cell renderers to CENTER
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < table.getColumnCount(); i++) {
		    table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		table.setRowSorter(sort);
		model.addRow(data[0]);
		model.addRow(data[1]);
		model.addRow(data[2]);
		model.addRow(data[3]);
		model.addRow(data[4]);
		model.addRow(data[5]);
		model.addRow(data[6]);
		model.addRow(data[7]);
		model.addRow(data[8]);
		model.addRow(data[9]);

		this.add(tblPanel);
		this.add(StockInButton);
		this.add(EditButton);
		this.add(DeleteButton);
		this.add(SaveButton);
		this.add(SaveButton1);
		this.add(CancelButton);
		this.add(CancelButton1);
		this.add(AddButton);
		this.add(txtSearch);
		
		this.setLayout(null);
		this.setVisible(true);
		

		txtSearch.getDocument().addDocumentListener(new DocumentListener()
		 {
		 @Override
			 public void insertUpdate(DocumentEvent e) {
			 String str = txtSearch.getText();
			 if (str.trim().length() == 0) {
			 sort.setRowFilter(null);
			 } else {
		 //(?i) means case insensitive search
			 sort.setRowFilter(RowFilter.regexFilter("(?i)" + 
			 str));
		 }
		 }
		 @Override
		 public void removeUpdate(DocumentEvent e) {
			 String str = txtSearch.getText();
			 if (str.trim().length() == 0) {
			 sort.setRowFilter(null);
			 } else {
			 sort.setRowFilter(RowFilter.regexFilter("(?i)" + 
			str));
		 }
		 }
		 @Override
		 public void changedUpdate(DocumentEvent e) {}
		 });


		EditButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		       
		        // Check if any row is selected
		        if (table.getSelectedRow() == -1) {
		            JOptionPane.showMessageDialog(null, "Please select at least one row to edit.");
		            return;
		        }
		     // Enable text fields for editing
		        for (int i = 1; i < txtFields.length; i++) {
		            txtFields[i].setEditable(true);
		            txtFields[i].setEnabled(true);
		            if (i == 0 || i == 5) {
		                txtFields[i].setEditable(false);
		                txtFields[i].setEnabled(false);
		            }
		        }

		        // Disable other buttons
		        StockInButton.setEnabled(false);
		        DeleteButton.setEnabled(false);
		        AddButton.setEnabled(false);
		        EditButton.setEnabled(false);
		        

		        // Enable save buttons
		        SaveButton.setVisible(false);
		        SaveButton1.setVisible(true);
		        SaveButton1.setEnabled(true);
		        CancelButton.setVisible(false);
		        CancelButton.setEnabled(false);
		        CancelButton1.setVisible(true);
		        CancelButton1.setEnabled(true);
		        
		     // Check if only one row is selected
		        int[] selectedRows = table.getSelectedRows();
		        if (selectedRows.length == 1) {
		            // Populate text fields with selected row data, starting from index 1
		            int selectedRowIndex = selectedRows[0];
		            for (int i = 0; i < txtFields.length; i++) {
		                txtFields[i].setText(table.getValueAt(selectedRowIndex, i).toString());
		            }
		        } else {
		            // Show message if multiple rows are selected
		            JOptionPane.showMessageDialog(null, "Please edit one row at a time.");
		        }

		    }
		    
		});
	
	
		StockInButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow == -1) { // If no row is selected
		            JOptionPane.showMessageDialog(null, "Please select a row to stock in.");
		            return;
		        }

		        // Show a confirmation dialog before stock in
		        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to stock in?", "Confirm Stock In", JOptionPane.YES_NO_OPTION);
		        if (result != JOptionPane.YES_OPTION) {
		            return; // User canceled the stock in
		        }

		        // Show input dialog to get the stock in quantity
		        String stockInStr = JOptionPane.showInputDialog(null, "Enter the stock in quantity:");
		        if (stockInStr == null) { // If the user clicked cancel
		            return;
		        }

		        // Parse the stock in quantity from the input dialog, and handle any errors
		        int stockIn = 0;
		        try {
		            stockIn = Integer.parseInt(stockInStr);
		            if (stockIn <= 0) {
		                JOptionPane.showMessageDialog(null, "Error: Invalid stock in quantity. Please enter a positive integer.");
		                return;
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error: Invalid numeric value entered.");
		            return;
		        }


		        // Update the stock value and remarks for the selected row
		        int currentStocks = (int) table.getValueAt(selectedRow, 5);
		        int newStocks = currentStocks + stockIn;
		        table.setValueAt(newStocks, selectedRow, 5);

		        int reorderPoint = (int) table.getValueAt(selectedRow, 6);
		        int size = (int) table.getValueAt(selectedRow, 6);
		        String remarks = (newStocks >  reorderPoint) ? "High Stock" : "Low Stock";
		        table.setValueAt(remarks, selectedRow, 7);
		        
		        // Display a success message
		        JOptionPane.showMessageDialog(null, "Stock in successful.");

		        // Clear the selected row
		        table.clearSelection();
		    }
		});
		

		AddButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	 // Format the current item code as a five-digit string
		        String formattedItemCode = String.format("%05d", itemCodeCounter);
		        
		        // Set the text of the Item Code text field to the formatted item code
		        txtFields[0].setText(formattedItemCode);
		        
		    	for (int i = 1; i < txtFields.length; i++) {
				    txtFields[i].setEditable(true);
				    txtFields[i].setEnabled(true);
				}
		    	CancelButton.setEnabled(true);
		    	SaveButton.setEnabled(true);
		    	SaveButton.setVisible(true);
		    	SaveButton1.setEnabled(false);
		    	SaveButton1.setVisible(false);
		    	StockInButton.setEnabled(false);
		    	EditButton.setEnabled(false);
		    	DeleteButton.setEnabled(false);
		    	AddButton.setEnabled(false);
		    
		    }
		});
		
		CancelButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?");
		            if (confirm == JOptionPane.YES_OPTION) {
			            // Clear the text fields
			            for (int i = 0; i < txtFields.length; i++) {
			                txtFields[i].setText("");
			                txtFields[i].setEnabled(false);
			            }
		            }else {
		            	return;
		            }
		            
		            // Enable the other buttons
		            StockInButton.setEnabled(true);
		            EditButton.setEnabled(true);
		            DeleteButton.setEnabled(true);
		            AddButton.setEnabled(true);
		            CancelButton.setEnabled(false);
		            SaveButton.setEnabled(false);
		            SaveButton1.setEnabled(false);
		            table.clearSelection();
		           
		           
		    }	
		});
		
		CancelButton1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?");
		            if (confirm == JOptionPane.YES_OPTION) {
			            // Clear the text fields
			            for (int i = 1; i < txtFields.length; i++) {
			                txtFields[i].setText("");
			                txtFields[i].setEditable(false);
			            }
		            }else {
		            	return;
		            }
		            
		            // Enable the other buttons
		            StockInButton.setEnabled(true);
		            EditButton.setEnabled(true);
		            DeleteButton.setEnabled(true);
		            AddButton.setEnabled(true);
		            CancelButton.setEnabled(true);
		            CancelButton.setVisible(true);
		            SaveButton.setEnabled(false);
		            SaveButton1.setEnabled(false);
		            table.clearSelection();
		            txtFields[4].setEditable(false);
              
		           
		    }	
		});



		SaveButton1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Check if any rows are selected
		        int[] selectedRows = table.getSelectedRows();
		        if (selectedRows.length == 0) {
		            JOptionPane.showMessageDialog(null, "Please select a row to update.");
		            return;
		        }
		        
		        // Validate input fields
		        String itemDesc = txtFields[2].getText();
		        String itemName = txtFields[2].getText();
		        String priceStr = txtFields[3].getText();
		        String stocksStr = txtFields[5].getText();
		        String reorderPointStr = txtFields[6].getText();
//		        if (!itemDesc.matches("[a-zA-Z ]+")) {
//		            JOptionPane.showMessageDialog(null, "Item description must only contain letters and spaces.");
//		            return;
//		        }
		        if (!priceStr.matches("\\d+(\\.\\d+)?")) {
		            JOptionPane.showMessageDialog(null, "Price must be a valid number.");
		            return;
		        }
		        if (!stocksStr.matches("\\d+")) {
		            JOptionPane.showMessageDialog(null, "Stocks must be a whole number.");
		            return;
		        }
		        if (!reorderPointStr.matches("\\d+")) {
		            JOptionPane.showMessageDialog(null, "Reorder point must be a whole number.");
		            return;
		        }
		        
		        // Confirm update operation
		        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the selected row?", "Confirm Update", JOptionPane.YES_NO_OPTION);
		        if (confirm != JOptionPane.YES_OPTION) {
		            return;
		        }
		        
		        // Update table cells with new values from text fields
		        for (int i = 0; i < txtFields.length; i++) {
		            int row = selectedRows[0];
		            table.setValueAt(txtFields[i].getText(), row, i);
		        }
		        
		        // Update remarks based on stock and reorder point
		        int stocks = Integer.parseInt(stocksStr);
		        int reorderPoint = Integer.parseInt(reorderPointStr);
		        String remarks = "";
		        if (stocks > reorderPoint) {
		            remarks = "High Stocks";
		        } else {
		            remarks = "Low Stocks";
		        }
		        table.setValueAt(remarks, selectedRows[0], 7);
		        
		        // Re-enable buttons
		        StockInButton.setEnabled(true);
		        AddButton.setEnabled(true);
		        EditButton.setEnabled(true);
		        DeleteButton.setEnabled(true);
		        SaveButton.setEnabled(false);
		        SaveButton1.setEnabled(false);
		        SaveButton1.setVisible(true);
		        CancelButton.setEnabled(false);
		        
		        // Clear the text fields and disable editing
		        for (int i = 1; i < txtFields.length; i++) {
		            txtFields[i].setText("");
		            txtFields[i].setEditable(false);
		        }

		        // Deselect all rows
		        table.clearSelection();
		        JOptionPane.showMessageDialog(null, "Item Succesfully updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
		    }
		});



		
		SaveButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Validate the input for the item description field
		        String itemDescription = txtFields[2].getText().trim();
		        String itemName = txtFields[1].getText().trim();// Remove leading/trailing whitespace

//		        if (!itemDescription.matches("^[a-zA-Z ]+$")) {
//		            JOptionPane.showMessageDialog(null, "Error: Invalid item description. Please enter letters and spaces only.");
//		            return;
//		        }
		        
		        
				String formattedItemCode = String.format("%05d", itemCodeCounter);
				txtFields[0].setText(formattedItemCode);
				itemCodeCounter++;
				

		        // Parse the numeric values from the other fields, and handle any errors
		        double price = 0;
		        int stocks = 0;
		        int reorderPoint = 0;
		        int size = 0;
		        try {
		            price = Double.parseDouble(txtFields[3].getText());
		            stocks = Integer.parseInt(txtFields[5].getText());
		            reorderPoint = Integer.parseInt(txtFields[6].getText());		          
		            size = Integer.parseInt(txtFields[4].getText());
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Error: Invalid numeric value entered.");
		            return;
		        }

		        // Show confirmation dialog
		        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?");
		        if (confirm == JOptionPane.YES_OPTION) {
		        	 JOptionPane.showMessageDialog(null, "Item Succesfully saved.", "Success", JOptionPane.INFORMATION_MESSAGE);
		        

		            // Determine the remarks based on the size and reorder point
		            String remarks = "";
		            if (stocks >  reorderPoint) {
		                remarks = "High Stock";
		            } else {
		                remarks = "Low Stock";
		            }
		            
		           
		            // Clear the text fields (except for the first one)
		            for (int i = 1; i < txtFields.length; i++) {
		                txtFields[i].setText("");
		            }
		            for (int i = 1; i < txtFields.length; i++) {
		                txtFields[i].setEditable(false);
		            }
		           
		            //Add the values as a new row to the model
		            Object[] newRow = {formattedItemCode,itemName, itemDescription, price, stocks, reorderPoint, size, remarks};
		            model.addRow(newRow);
		            

		            StockInButton.setEnabled(true);
		            EditButton.setEnabled(true);
		            DeleteButton.setEnabled(true);
		            AddButton.setEnabled(true);
		            CancelButton.setEnabled(false);
		            SaveButton.setEnabled(false);
		        }
		        
		       
		    }
		    
		});
		
		DeleteButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int[] selectedRows = table.getSelectedRows();
		        if (selectedRows.length == 0) {
		            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        int result = JOptionPane.showConfirmDialog(null,
		                "Are you sure you want to delete the selected row(s)?",
		                "Confirm Delete", JOptionPane.YES_NO_OPTION);
		        if (result == JOptionPane.YES_OPTION) {
		            DefaultTableModel model = (DefaultTableModel) table.getModel();
		            for (int i = selectedRows.length - 1; i >= 0; i--) {
		                model.removeRow(selectedRows[i]);
		            }
		            JOptionPane.showMessageDialog(null, "Selected row(s) successfully deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);
		        }
		    }
		});


	}
	
}