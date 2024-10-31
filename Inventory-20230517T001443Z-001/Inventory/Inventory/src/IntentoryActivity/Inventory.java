package IntentoryActivity;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
public class Inventory extends JFrame implements ActionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//this will create a new Panel with BorderLayout
	
		JPanel tblPanel = new JPanel(new BorderLayout());
			//this will create an array of JTextField with fixed size of 5
		JTextField [] txt_Fields = new JTextField[8];
		
		
		//this will create an array of JLabel with fixed size of 5
		JLabel [] Label_Fields = new JLabel[8]
				;
		
		String [] header = new String [] {"Item Code","Item Name","Item Description", "Price","Size","Stocks",
				"Re-Order Point","Remarks"
				
		};
		
		//this string array will be the text of the Jlabel
		String [] columnNames = {"Item Code : ","Item Name", "Item Description : ", "Price : ", "Size. : ", "Stocks : ","Re-order Point","REMARKS"};
		
		
		
		//this will create a JButton
		JButton StockInButton = new JButton();
		JButton AddButton = new JButton();
		JButton EditButton = new JButton();
		JButton DeleteButton = new JButton();
		JButton Savebtn = new JButton();
		JButton CancelButton = new JButton();
		JButton SaveButton1 = new JButton();
		DefaultTableModel model = new DefaultTableModel(null, header);
		
		//table(JTable) gets he value of DefaultTableModel
		JTable table = new JTable(model);
		
		//JScrollPane gets the value of JTable
		JScrollPane ScrollPane_Table = new JScrollPane(table);
		//this will add a function to filter the items in a table
		TableRowSorter<TableModel> sort = new TableRowSorter<>(table.getModel());
		

		JPanel panelProducts = new JPanel(new BorderLayout());
		JLabel search = new JLabel();
		JTextField txtSearch = new JTextField();
		//Row Vector 
		Vector <String> r = new Vector<String>();
		//ctr for the ItemCode
		int ctr = 00001;
		
		// methods
		public static boolean isNumeric(String txt) {
			try
			{
				Integer.parseInt(txt);
				return true;
			}
			catch (NumberFormatException nfe)
			{
				return false;
			}
		}
		
		Inventory(){
			
			this.setTitle("Table");
			this.setSize(1050, 500);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			
			int y = 50;
			//this loop will set the properties of JTextField , JLabel
			for(int i = 0; i <= txt_Fields.length -1 ; i++) {
				//properties of JTextField
				txt_Fields[i] = new JTextField();
				txt_Fields[i].setBounds(180, y, 150, 25);
				this.add(txt_Fields[i]);
				
				//properties of JLabel
				Label_Fields[i] = new JLabel();
				Label_Fields[i].setText(columnNames[i]);
				Label_Fields[i].setBounds(50, y, 150, 25);
				this.add(Label_Fields[i]);
				y+=30;
			}
			this.add(txtSearch);
			this.add(search);
			
			search.setText("Search");
			search.setFont(new Font("ARIAL",Font.BOLD, 20));
			search.setBounds(450,20,200,25);
			txtSearch.setBounds(530,20,470,25);
			
			table.setRowSorter(sort);
			txtSearch.getDocument().addDocumentListener(new DocumentListener()
					    {
					            @Override
					            public void insertUpdate(DocumentEvent e) {
					                String str = txtSearch.getText();
					                if (str.trim().length() == 0) {
					                    sort.setRowFilter(null);
					                } else {
					                    //(?i) means case insensitive search
					                    sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
					                }
					            }
					            @Override
					            public void removeUpdate(DocumentEvent e) {
					                String str = txtSearch.getText();
					                if (str.trim().length() == 0) {
					                    sort.setRowFilter(null);
					                } else {
					                    sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
					                }
					            }
					            @Override
					            public void changedUpdate(DocumentEvent e) {}
					        });

			
			//Settings of lblTextfields
			Label_Fields[7].setBounds(50, 500, 150, 25);
			txt_Fields[7].setBounds(180, 500, 150, 25);
			txt_Fields[7].setText("");
			txt_Fields[7].setEnabled(false);
			
			txt_Fields[0].setEnabled(false);
			txt_Fields[0].setText("00001");
			
			for(int i = 1; i<=txt_Fields.length -1; i++) {
				txt_Fields[i].setEditable(false);
			}
			
			
		
			//Stock Button Settings
			StockInButton.setBounds(50, 300, 100, 30);
			StockInButton.setText("Stock in");
			StockInButton.setFocusable(false);
			StockInButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//Declaring integer to get the value of the table that selected by the user
					int selectedRow = table.getSelectedRow();
					//Test the selected row to get the value of Stocks
					if(selectedRow != -1) {
						// get the current value of the selected element
	                	String StocksNewValue = JOptionPane.showInputDialog("Enter Stocks to add:");
			            String Current_Value = (String) model.getValueAt(selectedRow, 5);
			            String Re_OrderPoint_Value = (String) model.getValueAt(selectedRow, 6);
			            
			            //Test the textfield if it is Numeric
			            if(isNumeric(Current_Value) && isNumeric(StocksNewValue) && isNumeric(Re_OrderPoint_Value) && (StocksNewValue != null && !StocksNewValue.isBlank())) {
			            	double txt5value = Double.parseDouble(Current_Value);
			            	double txt6value = Double.parseDouble(StocksNewValue);
			            	int txt7value = Integer.parseInt(Re_OrderPoint_Value);
			            	
			            	//Process for adding current Stocks and Stocks inputed by the user
			            	double sum = txt5value + txt6value;
			            	model.setValueAt(sum, selectedRow, 5);
				            table.clearSelection();
				            	if(sum <= txt7value) {
				            	model.setValueAt("Low Stocks", selectedRow, 7);
				            	}
				            	else if(sum > txt7value) {
				            	model.setValueAt("High Stocks", selectedRow, 7);
				            	}
				            	else {
				            	// Do Nothing
				            		}
				            	
			            		
			        	}else if(StocksNewValue == null) {
			            	// Do Nothing
			            }
			            else {
			            	JOptionPane.showMessageDialog(null, "Please make sure that your inputs is a number.");
			            }
			            
						}
						else {
						JOptionPane.showMessageDialog(null, "Please select a row to add Stocks.");
						}
//				
//	                    
				 }
				
			});
			//Defaultl
			String [] cvt = new String [8];
			txt_Fields[1].setText("Pancit Canton");
			txt_Fields[2].setText("Noodles");
			txt_Fields[3].setText("22.35");
			txt_Fields[4].setText("16 grams");
			txt_Fields[5].setText("100");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			String formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 2
			txt_Fields[1].setText("Samyang");
			txt_Fields[2].setText("Noodles");
			txt_Fields[3].setText("20.5");
			txt_Fields[4].setText("25 grams");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 3
			txt_Fields[1].setText("Loaded");
			txt_Fields[2].setText("Junk Food");
			txt_Fields[3].setText("7.53");
			txt_Fields[4].setText("7 grams");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 4
			txt_Fields[1].setText("Potate Fries");
			txt_Fields[2].setText("Junk Food");
			txt_Fields[3].setText("10.0");
			txt_Fields[4].setText("10 grams");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 5
			txt_Fields[1].setText("Moby");
			txt_Fields[2].setText("Junk Food");
			txt_Fields[3].setText("11.64");
			txt_Fields[4].setText("10 grams");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 6
			txt_Fields[1].setText("Hansel");
			txt_Fields[2].setText("Biscuit");
			txt_Fields[3].setText("53.64");
			txt_Fields[4].setText("18 grams");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 7
			txt_Fields[1].setText("Skyflakes");
			txt_Fields[2].setText("Biscuit");
			txt_Fields[3].setText("55.6");
			txt_Fields[4].setText("3.5 oz");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 8
			txt_Fields[1].setText("San Marino");
			txt_Fields[2].setText("Canned Goods");
			txt_Fields[3].setText("75.68");
			txt_Fields[4].setText("3.5 oz");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 9
			txt_Fields[1].setText("Corned Beef");
			txt_Fields[2].setText("Canned Goods");
			txt_Fields[3].setText("78.2");
			txt_Fields[4].setText("3.5 oz");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText(formatted);

			model.addRow(cvt);
			
			//Row 10
			txt_Fields[1].setText("Reno");
			txt_Fields[2].setText("Canned Goods");
			txt_Fields[3].setText("50.5");
			txt_Fields[4].setText("4.5 oz");
			txt_Fields[5].setText("50");
			txt_Fields[6].setText("10");
			txt_Fields[7].setText("High Stocks");
			for (int i = 0; i <=cvt.length-1;i++) {
				
				cvt[i]=txt_Fields[i].getText().toString();
						
			}
			
			for(int i =1; i<=txt_Fields.length-1; i++) {
				txt_Fields[i].setEditable(false);
				txt_Fields[i].setText("");

			
			}
			ctr++;
			formatted = String.format("%05d", ctr);
			
			txt_Fields[0].setText("");

			model.addRow(cvt);
			//Add button settings
			AddButton.setBounds(170, 300, 100, 30);
			AddButton.setText("Add");
			AddButton.setFocusable(false);
			AddButton.addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) {
					ctr++;
					ctr--;
					String formatted = String.format("%05d", ctr);
					
					txt_Fields[0].setText(formatted);
					//If Add button, some of the buttons will disabled and Savebutton and cancel button will enabled
					for(int i = 1; i<=txt_Fields.length -1; i++) {
						//txt_Fields[0].setText(formatted);
						txt_Fields[i].setEditable(true);
						StockInButton.setEnabled(false);
						AddButton.setEnabled(false);
						EditButton.setEnabled(false);
						DeleteButton.setEnabled(false);
						Savebtn.setEnabled(true);
						CancelButton.setEnabled(true);
						table.clearSelection();
					}
				}
			});
			
			//Savebutton 2 for Add button to avoid logical error
			SaveButton1.setEnabled(false);
			SaveButton1.setBounds(170, 340, 100, 30);
			SaveButton1.setText("Save");
			this.add(SaveButton1);
			SaveButton1.setVisible(false);
			SaveButton1.setFocusable(false);
			SaveButton1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int rowSelected = table.getSelectedRow();
					//Yes and No Option for the test of savebutton
					int res = JOptionPane.showConfirmDialog(null,"Sure you want to edit??", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
						/* if user pressed yes it gets 
						 * the text of textfields and process
						 * if its high Stocks and low Stocks
						 */
						if(res == JOptionPane.YES_OPTION){
						//Stocks convert to string
						String [] cvt = new String [8];
							for (int i = 0; i <=cvt.length-1;i++) {
						
						cvt[i]=txt_Fields[i].getText().toString();
						String Stocks = (txt_Fields[5].getText());
						double Stocks_Integer = Double.parseDouble(Stocks);
						
					String ReOrder_Point = (txt_Fields[6].getText());
					double ReOrder_PointINT = Double.parseDouble(ReOrder_Point);
					
						if(Stocks_Integer <= ReOrder_PointINT) {
							txt_Fields[7].setText("Low Stocks");
						}
						else if(Stocks_Integer > ReOrder_PointINT) {
							txt_Fields[7].setText("High Stocks");
						}
						else {
							
						}
					}
							
							for(int i =1; i<=txt_Fields.length-1; i++) {
								txt_Fields[i].setEditable(false);
								txt_Fields[i].setText("");
					}
							
					//Incrementation of the ctr of item code		
					ctr++;
					//Process to display zeros in item code
					String formatted = String.format("%05d", ctr);
					
					
					model.removeRow(rowSelected);
					model.addRow(cvt);
					
					
					SaveButton1.setVisible(false);
					Savebtn.setVisible(true);
					CancelButton.setEnabled(false);
					StockInButton.setEnabled(true);
					AddButton.setEnabled(true);
					EditButton.setEnabled(true);
					DeleteButton.setEnabled(true);
					table.clearSelection();
				}
					 
				}
			});
			//Edit button settings
			EditButton.setBounds(290, 300, 100, 30);
			EditButton.setText("Edit");
			EditButton.setFocusable(false);
			EditButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 int rowSelected = table.getSelectedRow();
					 if(rowSelected == -1) {
			                JOptionPane.showMessageDialog(null, "Please select a row to edit.");
			                return;
			            }
					 
					int selectedRow = table.getSelectedRow();
					
					txt_Fields[1].setEnabled(true);
					txt_Fields[1].setEditable(true);
					
					txt_Fields[2].setEnabled(true);
					txt_Fields[2].setEditable(true);
					
					txt_Fields[3].setEditable(true);
					txt_Fields[4].setEnabled(true);
					
					txt_Fields[6].setEnabled(true);
					txt_Fields[4].setEditable(true);
					
					txt_Fields[5].setEditable(false);
					txt_Fields[4].setEditable(true);
					txt_Fields[6].setEditable(true);
					
					for(int i = 0; i<=txt_Fields.length-1;i++) {
					model.getValueAt(selectedRow, i);
	
	                    String value = (String) model.getValueAt(selectedRow, i); // get the value of the first column of the selected row
	                    txt_Fields[i].setText(value); // set the value in the text field
	                    
					}
				
					ctr--;
					String formatted = String.format("%05d", ctr);
					
					txt_Fields[0].setText(formatted);
						
					StockInButton.setEnabled(false);
					AddButton.setEnabled(false);
					EditButton.setEnabled(false);	
					DeleteButton.setEnabled(false);
					//Savebtn.setEnabled(true);
					SaveButton1.setVisible(true);
					SaveButton1.setEnabled(true);
					CancelButton.setEnabled(true);
					Savebtn.setVisible(false);
					
					}
				
				
			});
		
			//Delete button settings
			DeleteButton.setBounds(50, 340, 100, 30);
			DeleteButton.setText("Delete");
			DeleteButton.setFocusable(false);
			DeleteButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 int selectedRow = table.getSelectedRow();
					 if(selectedRow == -1) {
			                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
			                return;
			            } 
					 
					 if(e.getSource().equals(DeleteButton)) {
					int res = JOptionPane.showConfirmDialog(null,"Sure? You want to Delete?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.WARNING_MESSAGE);
				            if(res == JOptionPane.YES_OPTION){
				            	model.removeRow(table.getSelectedRow());
				            }else if (res == JOptionPane.NO_OPTION){
				               
				            }else {
				            	
				            }
	
				            table.clearSelection();
				}
				
				}
			});
			TableColumnModel tmtable = table.getColumnModel();
			tmtable.getColumn(2).setPreferredWidth(135);
			tmtable.getColumn(0).setPreferredWidth(90);

			//Save button settings
			Savebtn.setEnabled(false);
			Savebtn.setBounds(170, 340, 100, 30);
			Savebtn.setText("Save");
			Savebtn.setFocusable(false);
			Savebtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					//Test if the user leaves blank space in textfields
					
					if (txt_Fields[1].getText().isEmpty()) {
			              JOptionPane.showMessageDialog(null, "Please fill all the blanks");
			              return;
			         }
					else if(txt_Fields[2].getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Please fill all the blanks");
			              return;
					}
					else if(txt_Fields[3].getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Please fill all the blanks");
			              return;
					}
					else if(txt_Fields[4].getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Please fill all the blanks");
			              return;
					}
					else if(txt_Fields[5].getText().isEmpty()) {
						 JOptionPane.showMessageDialog(null, "Please fill all the blanks");
			              return;
					}
				
					else if(txt_Fields[6].getText().isEmpty()) {
					 JOptionPane.showMessageDialog(null, "Please fill all the blanks");
		              return;
					}
					//Test if the user input a String into Stocks textfields
					try {
					    double value = Double.parseDouble(txt_Fields[5].getText());
					    // If control reaches here, the input is a valid integer
					} catch (NumberFormatException e1) {
						 JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
			              return;
					}
					
					//Test if the user input a String into Re-order Point textfields
						try {
							double value = Double.parseDouble(txt_Fields[6].getText());
					    // If control reaches here, the input is a valid integer
						} catch (NumberFormatException e1) {
						 JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
			              return;
						}
					
					//Test if the user input a String into Price textfields
						try {
							double value = Double.parseDouble(txt_Fields[3].getText());
					    // If control reaches here, the input is a valid integer
						} catch (NumberFormatException e1) {
						 JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
			              return;
						}
					
					
						String Stocks = (txt_Fields[5].getText());
						double Stocks_Integer = Double.parseDouble(Stocks);
					
						String ReOrder_Point = (txt_Fields[6].getText());
						double ReOrder_PointINT = Double.parseDouble(ReOrder_Point);
							if(Stocks_Integer <= ReOrder_PointINT) {
								txt_Fields[7].setText("Low Stocks");
							}
							else if(Stocks_Integer > ReOrder_PointINT) {
								txt_Fields[7].setText("High Stocks");
							}
							else {
						
								}
					 
				         
				     
					// TODO Auto-generated method stub
					int res = JOptionPane.showConfirmDialog(null,"Sure you want to edit??", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
					
					 if(res == JOptionPane.YES_OPTION){
						 
					//Stocks convert to string
					String [] cvt = new String [8];
					for (int i = 0; i <=cvt.length-1;i++) {
						
						cvt[i]=txt_Fields[i].getText().toString();
								
					}
					
					for(int i =1; i<=txt_Fields.length-1; i++) {
						txt_Fields[i].setEditable(false);
						txt_Fields[i].setText("");
		
					
					}
					ctr++;
					String formatted = String.format("%05d", ctr);
					
					txt_Fields[0].setText("");

					model.addRow(cvt);
   	
				 //If the Save button is pressed, it sets into disable with Cancel Btn
				 Savebtn.setEnabled(false);
				 CancelButton.setEnabled(false);
				 StockInButton.setEnabled(true);
				 AddButton.setEnabled(true);
				 EditButton.setEnabled(true);
				 DeleteButton.setEnabled(true);
				 JOptionPane.showMessageDialog(null, "Item Sucessfully save!");
				 table.clearSelection();
				 
				 }else if (res == JOptionPane.NO_OPTION){
					 
				 }else {
				            	
				 }
	
				 }
				
		
			});
			CancelButton.setEnabled(false);
			//Cancel button settings
			CancelButton.setBounds(290, 340, 100, 30);
			CancelButton.setText("Cancel");
			CancelButton.setFocusable(false);
			CancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int res = JOptionPane.showConfirmDialog(null,"Sure? You want to Cancel?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(res == JOptionPane.YES_OPTION){
				            
				            	
				            	
				            	//If the Cancel button is pressed, it sets into disable with Save Btn
				            	SaveButton1.setVisible(false);
				            	SaveButton1.setVisible(true);
				            	Savebtn.setEnabled(false);
				            	CancelButton.setEnabled(false);
				            	StockInButton.setEnabled(true);
				            	AddButton.setEnabled(true);
				            	EditButton.setEnabled(true);
				            	DeleteButton.setEnabled(true);
				            	
				            }else if (res == JOptionPane.NO_OPTION){
				               
				            }else {
				            	
				            }
				}
				
				
			});
			TableColumnModel tmtblProducts = table.getColumnModel();
			tmtblProducts.getColumn(7).setPreferredWidth(130);
			tmtblProducts.getColumn(1).setPreferredWidth(130);
			tmtblProducts.getColumn(4).setPreferredWidth(100);
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			for(int i = 0; i<=txt_Fields.length -1;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
			tblPanel.setBounds(450, 50, 550, 400);
			tblPanel.setBackground(Color.white);
			tblPanel.add(ScrollPane_Table);
			table.getTableHeader().setEnabled(false);
			this.add(CancelButton);
			this.add(Savebtn);
			this.add(DeleteButton);
			this.add(EditButton);
			this.add(AddButton);
			this.add(tblPanel);
			this.add(StockInButton);
			this.setLayout(null);
			this.setVisible(true);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	}

