package inventory_pos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

public class InvTable extends JFrame {
	
	ImageIcon Logo = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	

	String[] Row = new String [] {
		"Item Code",
		"Item Name",
		"Item Description",
		"Price (₱)",
		"Size",
		"Stocks",
		"Re-Order Point",
		"Remarks",
	};
	

	String[][] Column = new String [][] {
		{"00001", "Lucky Me!", "Instant Pancit Canton", "25.50", "80g", "200", "50", "High Stock"},
		{"00002", "Head & Shoulders", "Anti-Dandruff Shampoo", "150.75", "400mL", "80", "70", "Low Stock"},
		{"00003", "Milk Magic", "Evaporated Milk", "40.00", "370mL", "100", "30", "High Stock"},
		{"00004", "Laptop", "15.6'' Gaming Laptop", "55000.00", "2.5Kg", "20", "10", "Low Stock"},
		{"00005", "Toblerone", "Milk Chocolate", "80.25", "400g", "300", "80", "High Stock"},
		{"00006", "Gatorade", "Sports drinks", "30.15", "350mL", "18", "80", "Low Stock"},
		{"00007", "Sprite", "Carbonated Drink", "40.00", "1.5L", "48", "60", "Low Stock"},
		{"00008", "M&M's", "Chocolate Candies", "15.50", "50g", "700", "200", "High Stock"},
		{"00009", "Piattos", "Cheese-flavored Potato Chips", "25.00", "85g", "200", "50", "High Stock"},
		{"00010", "Beef", "Ground Beef", "250.00", "1Kg", "30", "10", "Low Stock"}
	};
	

	DefaultTableModel Model = new DefaultTableModel(Column, Row){
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	
	//PANEL
	JTable Table = new JTable(Model);
	JScrollPane Scroll = new JScrollPane(Table);
	JPanel Panel = new JPanel(new BorderLayout());
	Vector<String> s = new Vector<String>();
	TableRowSorter<TableModel> sort = new TableRowSorter<>(Table.getModel());
	
	JTextField Search_TxtField;
	JButton[] Buttons = new JButton[2];
	String[] Buttons_Text = {
		"Add",
		"Cancel"
	};
	private POS main;
	
	public InvTable(POS main) {
        this.main = main;
    }
	
	public void Inv_Table() {
		setSize(900, 340);
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#FFD05B"));
		setIconImage(Logo.getImage());
		setResizable(false);
		setUndecorated(true);
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		    	Search_TxtField.setText("");
                main.Qty_Field.setText("");
		        main.setEnabled(true);
		    }
		});
		
		JLabel Label1 = new JLabel();
		Label1.setOpaque(true);
		Label1.setBackground(Color.decode("#FFD05B"));
		Label1.setBounds(0, 0, 896, 51);
		
		JLabel Holder = new JLabel();
		Holder.setOpaque(true);
		Holder.setBackground(Color.decode("#FFD05B"));
		Holder.setBounds(4, 4, 892, 332);
		
		JLabel Search_Label = new JLabel("SEARCH: ");
		Search_Label.setBounds(15, 15, 200, 30);
		Search_Label.setFont(new Font("Saira Condensed", Font.BOLD, 16));
		Search_Label.setForeground(Color.black);
		
		Search_TxtField = new JTextField();
		Search_TxtField.setBounds(145, 15, 430, 25);
		Search_TxtField.setFont(new Font("Saira Condensed", Font.PLAIN, 14));
		Search_TxtField.setForeground(Color.black);
		Search_TxtField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
	
		
		Table.getTableHeader().setEnabled(false); 
		
		//CENTER DATA
		DefaultTableCellRenderer Center = new DefaultTableCellRenderer(); 
		Center.setHorizontalAlignment(JLabel.CENTER); 
		
		for (int i = 0; i < Row.length; i++) {
		    Table.getColumnModel().getColumn(i).setCellRenderer(Center);
		}
		
		int x = 595;
		for (int i = 0; i < Buttons.length; i++) {
			int index = i;
			Buttons[i] = new JButton(Buttons_Text[i]);
			Buttons[i].setBounds(x, 13, 130, 30);
			Buttons[i].setFocusable(false);
			Buttons[i].setBorder(null);
			Buttons[i].setBackground(Color.WHITE);
			Buttons[i].setFont(new Font("Saira Condensed", Font.BOLD, 14));
			Buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			if (index == 0) {
				Buttons[i].addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		            	Buttons[index].setBackground(Color.decode("#b2d683"));

		            }
		            public void mouseExited(java.awt.event.MouseEvent evt) {
		            	Buttons[index].setBackground(Color.WHITE);

	
		            }
				});
			} else {
				Buttons[i].addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		            	Buttons[index].setBackground(Color.decode("#d68383"));
		
		            }
		            public void mouseExited(java.awt.event.MouseEvent evt) {
		            	Buttons[index].setBackground(Color.WHITE);

		            
		            }
				});
			}
			
			x += 140;
			Label1.add(Buttons[i]);
		}
		
		Buttons[0].addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        int selectedRow = Table.getSelectedRow();

		        if (selectedRow >= 0) {
		            int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to add " + main.Qty_Field.getText() + " " + Table.getValueAt(selectedRow, 1), "Add item", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		            if (Conf == JOptionPane.YES_OPTION) {
		                String ID = (String) Table.getValueAt(selectedRow, 0);
		                String Name = (String) Table.getValueAt(selectedRow, 1);
		                String Price = (String) Table.getValueAt(selectedRow, 3);
		                String Size = (String) Table.getValueAt(selectedRow, 4);
		                int Quantity = Integer.parseInt(main.Qty_Field.getText());

		                // Check if the item already exists in the POS table
		                int currentStock = Integer.parseInt((String) Table.getValueAt(selectedRow, 5));
		                int newStock = currentStock - Quantity;
		                
		                DefaultTableModel model = (DefaultTableModel) main.Table.getModel();
		                for (int i = 0; i < model.getRowCount(); i++) {
		                    if (ID.equals(model.getValueAt(i, 0))) {
		                        if (newStock < 0) {
				                    JOptionPane.showMessageDialog(null, "Stock is lower than requested amount", "Invalid Amount of Stock", JOptionPane.WARNING_MESSAGE);
				                    return;
		                        } else {
				                	// Update the quantity and price of the existing row
			                        int newQuantity = Integer.parseInt((String) model.getValueAt(i, 4)) + Quantity;
			                        double newTotal = Double.parseDouble(Price) * newQuantity;
			                        model.setValueAt(Integer.toString(newQuantity), i, 4);
			                        model.setValueAt(String.format("%.2f", newTotal), i, 5);
			                        
				                	Table.setValueAt(Integer.toString(newStock), selectedRow, 5);
				                    if (newStock > Long.parseLong((String) Table.getValueAt(selectedRow, 6))) {
				                        Table.setValueAt("High Stock", selectedRow, 7);
				                    } else {
				                        Table.setValueAt("Low Stock", selectedRow, 7);
				                    }
				                    
				                    Search_TxtField.setText("");
				                    main.Qty_Field.setText("");
				                    main.updateTotal();
				                    main.setEnabled(true);
				                    setVisible(false);
			                        return;
				                }    
		                    }
		                }
		                
		                if (newStock < 0) {
		                    JOptionPane.showMessageDialog(null, "Stock is lower than requested amount", "Invalid Amount of Stock", JOptionPane.WARNING_MESSAGE);
		                } else {
		                    Table.setValueAt(Integer.toString(newStock), selectedRow, 5);
		                    if (newStock > Long.parseLong((String) Table.getValueAt(selectedRow, 6))) {
		                        Table.setValueAt("High Stock", selectedRow, 7);
		                    } else {
		                        Table.setValueAt("Low Stock", selectedRow, 7);
		                    }

		                    double Total = Double.parseDouble(Price) * Quantity;
		                    Search_TxtField.setText("");
		                    main.Qty_Field.setText("");
		                    model.addRow(new Object[]{ID, Name, Size, Price, Integer.toString(Quantity), String.format("%.2f", Total)});
			                main.updateTotal();
		                    main.setEnabled(true);
		                    setVisible(false);
		                }
		            } 
		        } else {
	                JOptionPane.showMessageDialog(null, "Select an item first", "No Item Selected", JOptionPane.WARNING_MESSAGE);
	            }
		    }
		});
		
		Buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Conf = JOptionPane.showConfirmDialog(null, "Cancel?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(Conf == JOptionPane.YES_OPTION) {
                	Search_TxtField.setText("");
                    main.Qty_Field.setText("");
                    main.setEnabled(true);
                    setVisible(false);
                }
            }
        });
		
		Search_TxtField.getDocument().addDocumentListener(new DocumentListener(){
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				String str = Search_TxtField.getText();
				if (str.trim().length() == 0) {
					sort.setRowFilter(null);
				} else {
					sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
				}
			}
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				String str = Search_TxtField.getText();
				if (str.trim().length() == 0) {
					sort.setRowFilter(null);
				} else {
					sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {}
			});
			
			Search_TxtField.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			    	Search_TxtField.setText("");
			    }
			});
		Table.setRowHeight(22); 
		

		TableColumnModel Colm = Table.getColumnModel();
		int[] Wid = {
			70, 150, 220, 80, 110, 70, 100, 90 
		};
		
		for (int i = 0; i < Wid.length; i++) {
			Colm.getColumn(i).setPreferredWidth(Wid[i]);
		}

		Panel.setBounds(17, 60, 850, 255);
		Panel.add(Scroll);
		Table.setRowSorter(sort);
		add(Holder);
		Holder.add(Label1);
		Holder.add(Panel);
		Label1.add(Search_Label);
		Label1.add(Search_TxtField);
		setLayout(null);
		setVisible(true);
	}
}
