package IntentoryActivity;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.HashMap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.Date;
public class PointOfSale extends JFrame {
	
	//Global declaration
			//Frame
			JFrame frame = new JFrame();
			JFrame items = new JFrame();
			//Buttons
			JButton NewTransaction = new JButton();
			JButton RemoveItems = new JButton();
			JButton Discount = new JButton();
			JButton Payment = new JButton();
			JButton Cancel = new JButton();
			
		JLabel dateLabel= new JLabel();
			
		JButton X = new JButton ();
		JButton Minimize = new JButton();
		
		JTextField Quantity = new JTextField();
		JButton Searchbtn = new JButton();
		double discountedValue ;
		String [] header1 = new String [] {"Item Code","Item Name","Size", "Price","Quantity","Total"
				
				
				
		};
		
		JPanel MainFramePanel = new JPanel(new BorderLayout());
		DefaultTableModel MainTableModel = new DefaultTableModel(null, header1);
		
		//table(JTable) gets he value of DefaultTableModel
		JTable Maintable = new JTable(MainTableModel);
		
		//JScrollPane gets the value of JTable
		JScrollPane ScrollPane = new JScrollPane(Maintable);
				//this will add a function to filter the items in a table
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(Maintable.getModel());
		
		JLabel Counter = new JLabel();
		
		JLabel TotalPayment = new JLabel();
		JLabel PaymentTotal = new JLabel();
		int counter = 100000;
	PointOfSale() {
		//JFrame settings
		
		this.setSize(1500,800);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setTitle("Point Of Sale");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setLayout(null);
		
		ImageIcon image = new ImageIcon("POS.png");
		ImageIcon resized = new ImageIcon(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),java.awt.Image.SCALE_SMOOTH));
		JLabel BL = new JLabel(resized);
		BL.setSize(this.getWidth(),this.getHeight());
		this.setContentPane(BL);
		
		Border border = BorderFactory.createLineBorder(Color.black);
		Border border1 = BorderFactory.createLineBorder(Color.WHITE);
		String format = String.format("%05d", counter);
		
		
		this.add(Searchbtn);
		
		Searchbtn.setFont(new Font("ARIAL", Font.BOLD,24));
		Searchbtn.setBounds(550,290,200,50);
		Searchbtn.setOpaque(false);
		Searchbtn.setBorder(border);
		Searchbtn.setBackground(Color.black);
		// Add a mouse listener to the button
		Searchbtn.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        // Change the background color when the mouse enters the button
			    	Searchbtn.setBorder(border1);
			    }
			    @Override
			    public void mouseExited(MouseEvent e) {
			        // Change the background color back to the default when the mouse exits the button
			    	Searchbtn.setBorder(border);
			    }
		});
		
		
		this.add(Quantity);
		this.add(X);
		this.add(MainFramePanel);
		this.add(Minimize);
		this.add(Counter);
		this.add(TotalPayment);
		this.add(PaymentTotal);
		
		Counter.setFont(new Font("ARIAL", Font.BOLD,40));
		Counter.setBounds(890,290,200,50);
		Counter.setOpaque(false);
		Counter.setBackground(Color.black);
		Counter.setText(format);
		
		TotalPayment.setFont(new Font("ARIAL", Font.BOLD,30));
		TotalPayment.setBounds(1150,150,250,50);
		TotalPayment.setOpaque(false);
		TotalPayment.setBackground(Color.black);
		TotalPayment.setText("Total Payment:");
		
		PaymentTotal.setFont(new Font("ARIAL", Font.BOLD,30));
		PaymentTotal.setBounds(1150,200,250,50);
		PaymentTotal.setOpaque(false);
		PaymentTotal.setBackground(Color.black);
		PaymentTotal.setText("");
		
		Quantity.setFont(new Font("ARIAL", Font.BOLD,24));
		Quantity.setBounds(75,290,370,50);
		Quantity.setOpaque(false);
		Quantity.setBorder(border);
		Quantity.setBackground(Color.black);
		
		MainFramePanel.setBounds(100, 400, 800, 400);
		MainFramePanel.setBackground(Color.white);
		MainFramePanel.add(ScrollPane);
		MainFramePanel.setBackground(new Color(0xd6d6d6));
		Maintable.getTableHeader().setEnabled(false);
		
		
		
		X.setBounds(1440,0,60,30);
		X.setFont(new Font("Arial", Font.BOLD,18));
		X.setText("X");
		X.setBackground(new Color(0xd6d6d6));
		X.setFocusable(false);
		
		
		X.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
			
		});
		
		Minimize.setBounds(1375,0,60,30);
		Minimize.setFont(new Font("Arial", Font.BOLD,25));
		Minimize.setText("-");
		Minimize.setBackground(new Color(0xd6d6d6));
		Minimize.setFocusable(false);
		
		
		Minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setState(JFrame.ICONIFIED);
				
			}
			
			
		});
		
		// Create a new JLabel with a default text
		JLabel label = new JLabel("Time: ");
		label.setFont(new Font("SansSerif", Font.PLAIN, 40));
		this.add(label);
		//this.setLayout(new FlowLayout());
		label.setBounds(760,125,400,80);
		// Create a SimpleDateFormat object to format the time
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		label.setPreferredSize(new Dimension(300, 40));
		
		dateLabel.setBounds(50,125,650,80);
		this.add(dateLabel);
		
		
		
		// Create a Timer that fires every second
		Timer timer = new Timer(1000, new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Update the label text with the current time
		        label.setText("Time:      " + dateFormat.format(new Date()));
		        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy");
                Date now = new Date();
                
                dateLabel.setFont(new Font("Arial", Font.BOLD, 40));
                dateLabel.setText("Date:           "+dateFormat.format(now));
		    }
		    
		});
		timer.start();
		
		
		
		
		//Border and backgrounds Settings in button
	
		RemoveItems.setBorder(border);
		RemoveItems.setBackground(Color.black);
		Discount.setBorder(border);
		Discount.setBackground(Color.black);
		Payment.setBorder(border);
		Payment.setBackground(Color.black);
		Cancel.setBorder(border);
		Cancel.setBackground(Color.black);
		//------------------------------------------
		this.add(NewTransaction);
		this.add(RemoveItems);
		this.add(Discount);	
		this.add(Payment);
		this.add(Cancel);
		
		
		
		//Remove Items button settings;
		RemoveItems.setBounds(1110,455,370,50);
		RemoveItems.setOpaque(false);
		
		
		// Add a mouse listener to the button
					RemoveItems.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				        // Change the background color when the mouse enters the button
				    	RemoveItems.setBorder(border1);
				    }
				    @Override
				    public void mouseExited(MouseEvent e) {
				        // Change the background color back to the default when the mouse exits the button
				    	RemoveItems.setBorder(border);
				    }
			});
					
		Discount.setBounds(1110,535,370,50);
		Discount.setOpaque(false);
				
					
		// Add a mouse listener to the button
		Discount.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Change the background color when the mouse enters the button
	    	Discount.setBorder(border1);
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Change the background color back to the default when the mouse exits the button
	    	Discount.setBorder(border);
	    }
});
		
		Payment.setBounds(1110,615,370,50);
		Payment.setOpaque(false);
				
					
		// Add a mouse listener to the button
		Payment.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Change the background color when the mouse enters the button
	    	Payment.setBorder(border1);
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Change the background color back to the default when the mouse exits the button
	    	Payment.setBorder(border);
	    }
});
		Cancel.setBounds(1110,695,370,50);
		Cancel.setOpaque(false);
				
					
		// Add a mouse listener to the button
		Cancel.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
	        // Change the background color when the mouse enters the button
	    	Cancel.setBorder(border1);
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
	        // Change the background color back to the default when the mouse exits the button
	    	Cancel.setBorder(border);
	    }
});
		
		//Cancel Button
		
		Cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel??", "Confirmation", JOptionPane.YES_NO_OPTION);
			        
			        if (option == JOptionPane.YES_OPTION) {
			            // user clicked "Yes"
			           dispose();
			        } else {
			           
			        }
			}
			
			
		});
		
		
		//this will create a new Panel with BorderLayout
		
			JPanel tblPanel = new JPanel(new BorderLayout());
				//this will create an array of JTextField with fixed size of 5
			JTextField [] txt_Fields = new JTextField[8];
			
			
				
			
			String [] header = new String [] {"Item Code","Item Name","Item Description", "Price","Size","Stocks",
					"Re-Order Point","Remarks"
					
			};
			
			
			
			
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
			JButton AddItembtn = new JButton();
			JButton X = new JButton();
			JButton Minimize = new JButton();
			
		
				
				items.setTitle("Table");
				items.setSize(800, 400);
				items.setLocationRelativeTo(null);
				items.setUndecorated(true);
				this.setResizable(false);
				
				int y = 50;
				//this loop will set the properties of JTextField , JLabel
				for(int i = 0; i <= txt_Fields.length -1 ; i++) {
					//properties of JTextField
					txt_Fields[i] = new JTextField();
					txt_Fields[i].setBounds(180, y, 150, 25);
					this.add(txt_Fields[i]);
					
					
				}
				items.add(txtSearch);
				items.add(search);
				items.add(AddItembtn);
				items.add(X);
				items.add(Minimize);
				
				X.setBounds(750,0,50,25);
				X.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				X.setText("X");
				X.setFocusable(false);
				
				X.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						items.dispose();
					}
					
				}); 
				
				search.setText("Search");
				search.setFont(new Font("ARIAL",Font.BOLD, 20));
				search.setBounds(5,40,200,25);
				txtSearch.setBounds(85,40,550,25);
				AddItembtn.setBounds(675,40,100,25);
				AddItembtn.setText("Add Item");
				
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

				
				
				txt_Fields[7].setBounds(180, 500, 150, 25);
				txt_Fields[7].setText("");
				txt_Fields[7].setEnabled(false);
				
				txt_Fields[0].setEnabled(false);
				txt_Fields[0].setText("00001");
				txt_Fields[0].setVisible(false);
				
				for(int i = 1; i<=txt_Fields.length -1; i++) {
					txt_Fields[i].setEditable(false);
				}
				
				
			
				
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
					txt_Fields[i].setVisible(false);
				
				}
				ctr++;
				formatted = String.format("%05d", ctr);
				
				txt_Fields[0].setText("");
				
				model.addRow(cvt);
				
				TableColumnModel tmtblProducts = table.getColumnModel();
				tmtblProducts.getColumn(7).setPreferredWidth(130);
				tmtblProducts.getColumn(1).setPreferredWidth(130);
				tmtblProducts.getColumn(4).setPreferredWidth(100);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				for(int i = 0; i<=txt_Fields.length -1;i++) {
				table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			}
				tblPanel.setBounds(1, 70, 785, 400);
				tblPanel.setBackground(Color.white);
				tblPanel.add(ScrollPane_Table);
				table.getTableHeader().setEnabled(false);
			
				items.add(tblPanel);
			
				items.setLayout(null);
				items.setVisible(false);
				
				
			
				
			Searchbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if (Quantity.getText().isEmpty()) {
			             JOptionPane.showMessageDialog(null, "Please Enter Quantity!", "Invalid", JOptionPane.WARNING_MESSAGE);
			              return;
			         }
					else {
					//Test if the user input a String into Stocks textfields
					try {
					    double value = Double.parseDouble(Quantity.getText());
					    // If control reaches here, the input is a valid integer
					} catch (NumberFormatException e1) {
						 JOptionPane.showMessageDialog(null, "Please enter a valid integer value.");
			              return;
					}
						
						
					}
					for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
						int value = Integer.parseInt(model.getValueAt(rowIndex, 5).toString());
						int value6 = Integer.parseInt(model.getValueAt(rowIndex, 6).toString());

					    // Perform your test on the value here
					    if (value <value6) {
					        // Convert the value to the appropriate data type if needed
					    model.setValueAt("Low Stocks", rowIndex, 7);
					   
				
					        
					    }
					  else {
				    	 model.setValueAt("High Stocks", rowIndex, 7);
				    }

} 
				items.setVisible(true);
				
				}
							
				
				
			});
			
			PaymentTotal.setText("₱0.0");
			
			
			AddItembtn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        int rowSelected = table.getSelectedRow();
			        if (rowSelected == -1) {
			            JOptionPane.showMessageDialog(null, "Please select a row to add.");
			            return;
			        }

			        int res = JOptionPane.showConfirmDialog(null, "Sure you want to add this item??", "Swing Tester",
			                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			        
			        
			        
			        if (res == JOptionPane.YES_OPTION) {
			            int selectedRow = table.getSelectedRow();
			            
			          

			            
			            String[] row = new String[6];
			            JTextField compute = new JTextField();
			            items.add(compute);
			            
			            
			            for (int i = 0; i <= txt_Fields.length - 1; i++) {
			                model.getValueAt(selectedRow, i);
			                
			                Object value = model.getValueAt(selectedRow, i);

			                txt_Fields[i].setText(value.toString());
			            }
			           
			            
			            
			            // Item Code
			            row[0] = txt_Fields[0].getText();
			            // Item name
			            row[1] = txt_Fields[1].getText();
			            // Size
			            row[2] = txt_Fields[4].getText();
			            // Price
			            row[3] = txt_Fields[3].getText();
			            // Quantity
			            row[4] = Quantity.getText();

			            String PriceStr = txt_Fields[3].getText();
			            String QuantityStr = Quantity.getText();
			            double x = Double.parseDouble(PriceStr);
			            double y = Double.parseDouble(QuantityStr);
			            double sum = x * y;
			            String f = String.valueOf(sum);
			            compute.setText(f);
			            row[5] = compute.getText();
			            
			            
			          
			           
						 
						 
			            
			            Object current_value = model.getValueAt(selectedRow, 5);
			            double CValue = 0;
			            if (current_value instanceof String) {
			                CValue = Double.parseDouble((String) current_value);
			            } else if (current_value instanceof Integer) {
			                CValue = ((Integer) current_value).doubleValue();
			            }
			            
			            // Check if the item is already in the table
			            boolean itemExists = false;
			            int rowCount = Maintable.getRowCount();
			            for (int row1 = 0; row1 < rowCount; row1++) {
			                Object value = Maintable.getValueAt(row1, 0);
			                if (value != null && value.toString().equals(row[0])) {
			                    itemExists = true;
			                    break;
			                }
			            }

			            if (itemExists) {
			                JOptionPane.showMessageDialog(null, "Item already exists in the table.", "Duplicate Item",
			                        JOptionPane.WARNING_MESSAGE);
			                return; // Exit the method if the item already exists
			            }

			            double sum1 = CValue - y;
			            int SumInt = (int) sum1;
			            if (sum1 < 0) {
			                JOptionPane.showMessageDialog(null, "Not enough stocks");
			                model.setValueAt(current_value, selectedRow, 5);
			            } else {
			                model.setValueAt(SumInt, selectedRow, 5);
			                int Stocks = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
				            int ReOrder = Integer.parseInt(model.getValueAt(selectedRow, 6).toString());

			                if(Stocks<ReOrder) {
			                	model.setValueAt("Low Stocks", selectedRow, 7);
			                }
			                else {
			                	model.setValueAt("High Stocks", selectedRow, 7);
			                }
			                MainTableModel.addRow(row);
			                table.clearSelection();
			                items.dispose();
			            }
			        }
			       
			        // Calculate the sum of the column values
			        double sum = 0.0;
			        for (int i = 0; i < Maintable.getRowCount(); i++) {
			            Object value = Maintable.getValueAt(i, 5);
			            if (value instanceof String) {
			            	sum += Double.parseDouble((String) value);
			            } else if (value instanceof Integer) {
			            sum += ((Integer) value).doubleValue();
			            }
			            }
			        PaymentTotal.setText("₱" + String.format("%.2f", sum));
			        
			       
			        
			        
			    }
			    
			    
			    });


			
			RemoveItems.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					
					 int selectedRow = Maintable.getSelectedRow();

					 if(selectedRow == -1) {
			                JOptionPane.showMessageDialog(null, "Please select a row to delete.");
			                return;
			            } 
					 
					 
					 //Value of table to compute index 0
					 String index0 = table.getValueAt(0, 0).toString();
					 //Value of table to compute index 1
					 String index1 = table.getValueAt(1, 0).toString();
					 //Value of table to compute index 2
					 String index2 = table.getValueAt(2, 0).toString();
					 //Value of table to compute index 3
					 String index3 = table.getValueAt(3, 0).toString();
					 //Value of table to compute index 4
					 String index4 = table.getValueAt(4, 0).toString();
					 
					 //Value of table to compute index 5
					 String index5 = table.getValueAt(5, 0).toString();
					 
					 //Value of table to compute index 6
					 String index6 = table.getValueAt(6, 0).toString();
					 
					 //Value of table to compute index 7
					 String index7 = table.getValueAt(7, 0).toString();
					
					 //Value of table to compute index 8
					 String index8 = table.getValueAt(8, 0).toString();
					 
					 //Value of table to compute index 9
					 String index9 = table.getValueAt(9, 0).toString();
					 
					 int Intindex0 = Integer.parseInt(table.getValueAt(0, 5).toString());
					 
					 int Intindex1 = Integer.parseInt(table.getValueAt(1, 5).toString());
					 
					 int Intindex2 = Integer.parseInt(table.getValueAt(2, 5).toString());
					 
					 int Intindex3 = Integer.parseInt(table.getValueAt(3, 5).toString());
					 
					 int Intindex4 = Integer.parseInt(table.getValueAt(4, 5).toString());
					 
					 int Intindex5 = Integer.parseInt(table.getValueAt(5, 5).toString());
					 
					 int Intindex6 = Integer.parseInt(table.getValueAt(6, 5).toString());
					 
					 int Intindex7 = Integer.parseInt(table.getValueAt(7, 5).toString());
					 
					 int Intindex8 = Integer.parseInt(table.getValueAt(8, 5).toString());
					 
					 int Intindex9 = Integer.parseInt(table.getValueAt(9, 5).toString());
					 
					String columnValue0 = Maintable.getValueAt(selectedRow, 0).toString();
					int intValue0 = Integer.parseInt(Maintable.getValueAt(selectedRow, 4).toString());
	
					
					 
					 if(e.getSource().equals(RemoveItems)) {
					int res = JOptionPane.showConfirmDialog(null,"Sure? You want to Delete?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.WARNING_MESSAGE);
					if (res == JOptionPane.YES_OPTION) {
						PaymentTotal.setText("₱0.00");
						 
						if(index0.equals(columnValue0)) {
							int	sum1 = Intindex0 + intValue0;
						table.setValueAt(sum1, 0, 5);		

						int Stocks = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
			            int ReOrder = Integer.parseInt(model.getValueAt(selectedRow, 6).toString());

		                if(Stocks<ReOrder) {
		                	model.setValueAt("Low Stocks", selectedRow, 7);
		                }
		                else {
		                	model.setValueAt("High Stocks", selectedRow, 7);
		                }   
									
				            	MainTableModel.removeRow(Maintable.getSelectedRow());
				            	
				            	 // Recalculate the total payment
				                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
				                for (int i = 0; i < Maintable.getRowCount(); i++) {
				                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
				                }

				                // To get the sum of the column values
				                double sum = Arrays.stream(columnValues).sum();

				                PaymentTotal.setText("₱"+Double.toString(sum));
				              
								}else if (index1.equals(columnValue0)) {
									int	sum1 = Intindex1 + intValue0;
									table.setValueAt(sum1, 1, 5);		
									
								
									 
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               

								            	
													
								                PaymentTotal.setText("₱"+Double.toString(sum));
								                
							                }
								}else if (index2.equals(columnValue0)) {
									int	sum1 = Intindex2 + intValue0;
									table.setValueAt(sum1, 2, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               
								               
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                }    
								}else if (index3.equals(columnValue0)) {
									int	sum1 = Intindex3 + intValue0;
									table.setValueAt(sum1, 3, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               
								               
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                } 
								}else if (index4.equals(columnValue0)) {
									int	sum1 = Intindex4 + intValue0;
									table.setValueAt(sum1, 4, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               
								                PaymentTotal.setText("₱"+Double.toString(sum));  
							                }   
								}else if (index5.equals(columnValue0)) {
									int	sum1 = Intindex5 + intValue0;
									table.setValueAt(sum1, 5, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                }              
								}else if (index6.equals(columnValue0)) {
									int	sum1 = Intindex6 + intValue0;
									table.setValueAt(sum1, 6, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								              
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                }              
								}else if (index7.equals(columnValue0)) {
									int	sum1 = Intindex7 + intValue0;
									table.setValueAt(sum1, 7, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                }              
								}else if (index8.equals(columnValue0)) {
									int	sum1 = Intindex8 + intValue0;
									table.setValueAt(sum1, 8, 5);		
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    // To get the sum of the column values
								                double sum = Arrays.stream(columnValues).sum();
								               
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                }              
								}else if (index9.equals(columnValue0)) {
									int	sum1 = Intindex9 + intValue0;
									table.setValueAt(sum1, 9, 5);		
									
									
							            	MainTableModel.removeRow(Maintable.getSelectedRow());
							            	 // Recalculate the total payment
							                double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has double values
							                for (int i = 0; i < Maintable.getRowCount(); i++) {
							                    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							                    double sum = Arrays.stream(columnValues).sum();
							                   
								                PaymentTotal.setText("₱"+Double.toString(sum));
							                }              
							            	
				                }
				                	
				                
						
			                    
				                   
							
				              
					 
				            }else if (res == JOptionPane.NO_OPTION){
				               
				            }else {
				            	
				            }
	
				            Maintable.clearSelection();
				            
				}
				
				}
			});
			JRadioButton Student = new JRadioButton();
			JRadioButton Senior = new JRadioButton();
			JRadioButton RegularCustomer = new JRadioButton();
			JRadioButton Employee = new JRadioButton();
			ButtonGroup group = new ButtonGroup();
			JLabel dc = new JLabel();
			JButton Ok = new JButton();
			JFrame Dcframe = new JFrame();
			JButton close = new JButton ();
			JButton minim = new JButton();
			//JFrame settings
			Dcframe.setSize(400,250);
			//this.setUndecorated(true);
			Dcframe.setVisible(false);
			Dcframe.setTitle("DISCOUNT");
			Dcframe.setUndecorated(true);
			Dcframe.setLocationRelativeTo(null);
			Dcframe.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			Dcframe.setResizable(false);
			Dcframe.setLayout(null);
			Dcframe.add(Student);
			Dcframe.add(Senior);
			Dcframe.add(RegularCustomer);
			Dcframe.add(Employee);
			Dcframe.add(dc);
			Dcframe.add(Ok);
			group.add(Student);
			group.add(Senior);
			group.add(RegularCustomer);
			group.add(Employee);
			Dcframe.add(close);
			Dcframe.add(minim);
			
			close.setBounds(355,0,45,30);
			close.setText("X");
			close.setFont(new Font("ARIAL", Font.BOLD, 17));
			close.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Dcframe.setVisible(false);
				}
				
			});
			dc.setBounds(100,10,200,50);
			dc.setText("SELECT DISCOUNT");
			dc.setFont(new Font("ARIAL", Font.BOLD, 20));
			
			
			//Student
			Student.setBounds(25,60,130,30);
			Student.setText("Student 3%");
			Student.setFont(new Font("ARIAL", Font.BOLD, 15));
			
			//SENIOR
			Senior.setBounds(25,120,150,30);
			Senior.setText("Senior/ PWD 20%");
			Senior.setFont(new Font("ARIAL", Font.BOLD, 15));
			
			//Regular Customer
			RegularCustomer.setBounds(180,60,200,30);
			RegularCustomer.setText("Regular Customer 25%");
			RegularCustomer.setFont(new Font("ARIAL", Font.BOLD, 15));
			
			//Employee Customer
			Employee.setBounds(180,120,200,30);
			Employee.setText("Employee 15%");
			Employee.setFont(new Font("ARIAL", Font.BOLD, 15));
			
			//OK button
			Ok.setBounds(135,160,100,30);
			Ok.setText("OK");
			
			Discount.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 int selectedRow = Maintable.getSelectedRow();
					 if(selectedRow == -1) {
			                JOptionPane.showMessageDialog(null, "Please select order first!", "Warning", JOptionPane.WARNING_MESSAGE);
			                return;
			            } 
					
				Dcframe.setVisible(true);
				
				Ok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(Student.isSelected()) {
							
							
							//
							double value = Double.parseDouble(Maintable.getValueAt(selectedRow, 5).toString());
							discountedValue = (value * .3);
							value = value - discountedValue;
							Maintable.setValueAt(String.format("%.2f", value), selectedRow, 5);
							double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has integer values
						    
							for (int i = 0; i < Maintable.getRowCount(); i++) {
							    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							}

							// To get the sum of the column values
							double sum = Arrays.stream(columnValues).sum();

							PaymentTotal.setText("₱"+Double.toString(sum));

							Dcframe.dispose();
							group.clearSelection();
							Maintable.clearSelection();
							
						}
						else if(Senior.isSelected()) {
							double value = Double.parseDouble(Maintable.getValueAt(selectedRow, 5).toString());
							 discountedValue = (value * .20) ;
							value = value - discountedValue;
							Maintable.setValueAt(String.format("%.2f", value), selectedRow, 5);
							double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has integer values
						    
							for (int i = 0; i < Maintable.getRowCount(); i++) {
							    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							}

							// To get the sum of the column values
							double sum = Arrays.stream(columnValues).sum();

							PaymentTotal.setText("₱"+Double.toString(sum));

							Dcframe.dispose();
							group.clearSelection();
							Maintable.clearSelection();
						}
						else if(RegularCustomer.isSelected()) {
							double value = Double.parseDouble(Maintable.getValueAt(selectedRow, 5).toString());
							 discountedValue = (value * .25) ;
							value = value - discountedValue;
							Maintable.setValueAt(String.format("%.2f", value), selectedRow, 5);
							double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has integer values
						    
							for (int i = 0; i < Maintable.getRowCount(); i++) {
							    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							}

							// To get the sum of the column values
							double sum = Arrays.stream(columnValues).sum();

							PaymentTotal.setText("₱"+Double.toString(sum));

							Dcframe.dispose();
							group.clearSelection();
							Maintable.clearSelection();
						}
						else if(Employee.isSelected()) {
							double value = Double.parseDouble(Maintable.getValueAt(selectedRow, 5).toString());
							 discountedValue = (value * .15) ;
							value = value - discountedValue;
							Maintable.setValueAt(String.format("%.2f", value), selectedRow, 5);
							double[] columnValues = new double[Maintable.getRowCount()]; // Assuming the column has integer values
						    
							for (int i = 0; i < Maintable.getRowCount(); i++) {
							    columnValues[i] = Double.parseDouble(Maintable.getValueAt(i, 5).toString());
							}

							// To get the sum of the column values
							double sum = Arrays.stream(columnValues).sum();

							PaymentTotal.setText("₱"+Double.toString(sum));

							Dcframe.dispose();
							group.clearSelection();
							Maintable.clearSelection();
						}
						else {
							
						}
					}
					
				});
				}
				
			});
			
		/*JFrame PaymentFrame = new JFrame();
		JLabel EnterPayment = new JLabel();
		JTextField PaymentTxt = new JTextField();
		JButton OK = new JButton();
		JButton Cancel = new JButton();
			
		PaymentFrame.setVisible(false);
		PaymentFrame.add(EnterPayment);
		PaymentFrame.add(PaymentTxt);
		PaymentFrame.add(OK);
		PaymentFrame.add(Cancel);
		*/
		Payment.addActionListener(new ActionListener() {

			@Override
			 public void actionPerformed(ActionEvent e) {
		        String stocksNewValue = JOptionPane.showInputDialog("Enter Payment:");
		        if (stocksNewValue != null) {
		            double pay = 0;
		            try {
		                pay = Double.parseDouble(stocksNewValue);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
		                return;
		            }

		            double total = 0;
		            String paymentTotalText = PaymentTotal.getText();
		            String numericValue = paymentTotalText.replaceAll("[^\\d.]+", "");
		            try {
		                total = Double.parseDouble(numericValue);
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Invalid payment total! Please check the payment total value.", "Invalid Payment Total", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            
		            if (pay < total) {
		                JOptionPane.showMessageDialog(null, "Insufficient Amount!", "Insufficient Amount", JOptionPane.WARNING_MESSAGE);
		            } else {
		                JDialog dialog = new JDialog();
		                dialog.setTitle("Receipt");
		                dialog.setUndecorated(true);
		                dialog.setPreferredSize(new Dimension(400, 420));
		                dialog.setLayout(null);

		              
		                
		                // Rest of your code for configuring the dialog and adding components
		                // ...
		                
		                dialog.pack();
		                dialog.setVisible(true);
		                dialog.setLocationRelativeTo(null);
		                
		                JLabel shopName = new JLabel();
				        shopName.setText("7 Evelyn");
				        shopName.setBounds(150, 20, 200, 30);
				        shopName.setFont(new Font("Arial", Font.BOLD, 20));
				        dialog.setLayout(null);

				        JLabel location = new JLabel();
				        location.setText("No where, Concepcion, Tarlac");
				        location.setBounds(110, 50, 250, 30);
				        location.setFont(new Font("Arial", Font.PLAIN, 13));

				        JLabel receipt = new JLabel();
				        receipt.setText("ORDER RECEIPT");
				        receipt.setBounds(115, 100, 250, 30);
				        receipt.setFont(new Font("Arial", Font.BOLD, 20));
				        
				        JLabel Dash = new JLabel();
				        
				        Border B = BorderFactory.createLineBorder(Color.RED, 1);

				       
				       
				        Dash.setText("---------------------------------------------------");
				        
				        Dash.setBounds(10, 120, 365, 30);
				        Dash.setFont(new Font("Arial", Font.BOLD, 20));
				        
				        int x = 50;
				     
				        JLabel Name = new JLabel();
				        JLabel Size = new JLabel();
				        JLabel Qty = new JLabel();;
				        JLabel Price = new JLabel();
				        JLabel Total = new JLabel();
				        
				        Name.setText("Name");
				        Size.setText("Size");
				        Qty.setText("Qty");
				        Price.setText("Price");
				        Total.setText("Total");
				        
				        Name.setFont(new Font("Arial", Font.BOLD,15));
				        Size.setFont(new Font("Arial", Font.BOLD,15));
				        Qty.setFont(new Font("Arial", Font.BOLD,15));
				        Price.setFont(new Font("Arial", Font.BOLD,15));
				        Total.setFont(new Font("Arial", Font.BOLD,15));
				        
				        Name.setBounds(10,140,40,30);
				        Size.setBounds(100,140,40,30);
				        Qty.setBounds(170,140,40,30);
				        Price.setBounds(250,140,40,30);
				        Total.setBounds(330,140,40,30);
				        JLabel dash2 = new JLabel();
				        
				        dash2.setText("---------------------------------------------------");
				        
				      
				        dash2.setFont(new Font("Arial", Font.BOLD, 20));
				        JLabel FinalTotal = new JLabel();
				        FinalTotal.setText("Price:");
				       
				        
				        JLabel Cash = new JLabel();
				        JLabel Discount = new JLabel();
				        JLabel Change = new JLabel();
				        
				        Cash.setText("Cash:");
				        
				        Discount.setText("Discount:");
				       
				        Change.setText("Change:");
				        
				        
				        
				        
				        JLabel dashes[] = new JLabel[4];
				        
				        
				      
				        JLabel PTotal = new JLabel();
				       
				        JLabel PCash = new JLabel();
				       
				        
				        
				        JLabel PDC = new JLabel();
				       
				        
				        JLabel PChange = new JLabel();
				       
				        
				        JLabel endingDash = new JLabel();
				        endingDash.setText("---------------------------------------------------");
				        
				       
				        endingDash.setFont(new Font("Arial", Font.BOLD, 20));
				        
				        JLabel Thankyou = new JLabel();
				        Thankyou.setText("Thank you for purchasing!!!");
				       
				        Thankyou.setFont(new Font("Arial", Font.PLAIN, 13));
				        
				        
				        JLabel ok = new JLabel();
				        ok.setText("OK");
				      
				        ok.setFont(new Font("Arial", Font.PLAIN, 13));
				        
				        int y = 90;
				        int z = 160;
				       int a = 180;
				        int rowHeight = 25; // Height of each row
				        int totalHeight = a + Maintable.getRowCount() * rowHeight; // Calculate the total height required

				        StringBuilder rowData = new StringBuilder();
				        JLabel r1[] = new JLabel[Maintable.getRowCount()];
				        JLabel r2[] = new JLabel[Maintable.getRowCount()];
				        JLabel qty[] = new JLabel[Maintable.getRowCount()];
				        JLabel prc[] = new JLabel[Maintable.getRowCount()];
				        JLabel ttl[] = new JLabel[Maintable.getRowCount()];

				        for (int row = 0; row < Maintable.getRowCount(); row++) {
				            r1[row] = new JLabel();
				            r2[row] = new JLabel();
				            qty[row] = new JLabel();
				            prc[row] = new JLabel();
				            ttl[row] = new JLabel();

				            String r1str = (String) Maintable.getValueAt(row, 1);
				            String r2str = (String) Maintable.getValueAt(row, 2);
				            String r4str = (String) Maintable.getValueAt(row, 4);
				            String r5str = (String) Maintable.getValueAt(row, 3);
				            String totalI = (String) Maintable.getValueAt(row, 5);

				            r1[row].setText(r1str);
				            r1[row].setBounds(10, z, 100, 30);

				            r2[row].setText(r2str);
				            r2[row].setBounds(95, z, 100, 30);

				            qty[row].setText(r4str);
				            qty[row].setBounds(180, z, 100, 30);

				            prc[row].setText(r5str);
				            prc[row].setBounds(250, z, 100, 30);

				            ttl[row].setText(totalI);
				            ttl[row].setBounds(335, z, 100, 30);

				            dialog.add(ttl[row]);
				            dialog.add(prc[row]);
				            dialog.add(qty[row]);
				            dialog.add(r1[row]);
				            dialog.add(r2[row]);

				           
					        	
					        z += rowHeight;
				            y += 80;
				            
				            
				            
				        
				        }
				        
				       int h = 0;
				       h +=totalHeight;
				       dash2.setBounds(10, h, 365, 30);
				       h+=20;
				       
				       FinalTotal.setBounds(10,h,40,30);
				       PTotal.setBounds(330, h, 225, 30);;
				       h+=20;
				       
				       Cash.setBounds(25,h,60,30);
				       PCash.setBounds(330, h, 225, 30);;
				       h+=20;
				       
				       Discount.setBounds(25,h,60,30);
				       PDC.setBounds(330, h, 225, 30);;
				       h+=20;
				       
				       Change.setBounds(25,h,60,30);
				       PChange.setBounds(330, h, 225, 30);;
				       h+=20;

				       
				        endingDash.setBounds(10, h, 365, 30);
				        h+=20;
				        Thankyou.setBounds(110, h, 250, 30);
				        h+=20;
				        ok.setBounds(180, h, 250, 30);
				        
				        totalHeight +=h;

				        for (int row = 0; row < Maintable.getRowCount(); row++) {
				        String totalStr = (String) Maintable.getValueAt(row, 5);
			             
			             // Convert the value to a double and add it to the total
			             double rowTotal = Double.parseDouble(totalStr);
			             total += rowTotal;
			         
			         // Display the total or perform any desired actions with it
			        PTotal.setText(String.valueOf(total));
			        PCash.setText(stocksNewValue);
			        PDC.setText(String.valueOf(discountedValue));
			        double Pay = Double.parseDouble(stocksNewValue);
			        double S =   total-pay;
			        PChange.setText(String.valueOf(String.format("%.2f", S)));
			            ok.addMouseListener(new MouseAdapter() {
			                @Override
			                public void mouseClicked(MouseEvent e) {
			                    // Handle the click event here
			                	counter++;
			                	String format = String.format("%05d", counter);
			                	Counter.setText(format);
								Maintable.clearSelection();
								MainTableModel.setRowCount(0);
								PaymentTotal.setText("₱0.00");
								Quantity.setText("");
								dialog.dispose();
			                }
			            });
				        }
				        JTextArea textArea = new JTextArea();
				        textArea.setText(rowData.toString());
				        textArea.setEditable(false);

				        dialog.setSize(400, totalHeight-120); // Set the size of the dialog
				        
				        dialog.add(PTotal);
					      dialog.add(PCash);
					        dialog.add(PDC);
					         dialog.add(PChange);
				        dialog.add(ok);
				        dialog.add(Thankyou);
				        dialog.add(endingDash);
				        dialog.add(Discount);
				        dialog.add(Change);
				        dialog.add(Cash);
				        dialog.add(FinalTotal);
				        dialog.add(dash2);
				        dialog.add(Name);
				        dialog.add(Size);
				        dialog.add(Total);
				        dialog.add(Qty);
				        dialog.add(Price);
				        dialog.add(Dash);
				        dialog.add(receipt);
				        dialog.add(location);
				        dialog.add(shopName);
				        
				        

		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "No input provided!", "No Input", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});

				       
			    }
			
				  
				
				
				
		    
		
		
	}


