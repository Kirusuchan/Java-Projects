package inventory_pos;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.stream.Stream;

public class Table extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	ImageIcon Logo = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

	
	Toolkit toolkit = getToolkit();
	Dimension Size = toolkit.getScreenSize();

	JLabel Info, SEARCH_LABEL;
	JTextField SEARCH_FIELD;
	JLabel[] Label = new JLabel[8]; 
	JTextField[] TField = new JTextField[8];
	JButton[] Edit_Buttons = new JButton[3], Edit_Buttons2 = new JButton[3]; 
	
	//BUTTON NAMES
	String[] Button_Text = {
			"Stock In",
			"Add",
			"Edit",
			"Delete",
			"Save",
			"Cancel"
	};

	String[] Row = new String [] {
		"Item ctr",
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
	Vector<String> r = new Vector<String>();
	TableRowSorter<TableModel> sort = new TableRowSorter<>(Table.getModel());

	int ctr = 11; 
	
	void Table_Inventory(){
		setSize(1200, 800);
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#FFD05B"));
		setResizable(false);
		setTitle("Inventory");
		setIconImage(Logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon backgroundImage = new ImageIcon("InvBg.png");
        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
        
        JButton EXIT_BTN = new JButton("EXIT");
        EXIT_BTN.setBounds(getWidth() - 160, 10, 130, 30);
        EXIT_BTN.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        EXIT_BTN.setBackground(Color.WHITE);
        EXIT_BTN.setForeground(Color.BLACK);
        EXIT_BTN.setFocusable(false);
        EXIT_BTN.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        EXIT_BTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(EXIT_BTN);
        
		SEARCH_LABEL = new JLabel("Search: ");
		SEARCH_LABEL.setBounds(270, 300, 200, 30);
		SEARCH_LABEL.setFont(new Font("Saira Condensed", Font.BOLD, 20));
		SEARCH_LABEL.setForeground(Color.black);
		
		SEARCH_FIELD = new JTextField();
		SEARCH_FIELD.setBounds(370, 305, 722, 25);
		SEARCH_FIELD.setFont(new Font("Saira Condensed", Font.PLAIN, 14));
		SEARCH_FIELD.setForeground(Color.black);
		SEARCH_FIELD.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		SEARCH_FIELD.getDocument().addDocumentListener(new DocumentListener(){
			
		@Override
		public void insertUpdate(DocumentEvent e) {
			String str = SEARCH_FIELD.getText();
			if (str.trim().length() == 0) {
				sort.setRowFilter(null);
			} else {
				sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
			}
		}
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			String str = SEARCH_FIELD.getText();
			if (str.trim().length() == 0) {
				sort.setRowFilter(null);
			} else {
				sort.setRowFilter(RowFilter.regexFilter("(?i)" + str));
			}
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {}
		});
		
		SEARCH_FIELD.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	SEARCH_FIELD.setText("");
		    }
		});
		
		EXIT_BTN.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	int Conf = JOptionPane.showConfirmDialog(null, "Go back home?", "Go back?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (Conf == JOptionPane.YES_OPTION) {
					Dashboard dashboard = new Dashboard();
					dashboard.Dashboard_Table();
					dispose();
				}
		    }
		});

		
		int y = 50; 
		for (int i = 0; i < Label.length; i++) {
			Label[i] = new JLabel(Row[i] + ":");
			Label[i].setBounds(340, y-4, 200, 30);
			Label[i].setFont(new Font("Saira Condensed", Font.BOLD, 16));
			Label[i].setForeground(Color.black);
			add(Label[i]);
			
			TField[i] = new JTextField();
			TField[i].setBounds(500, y, 500, 25);
			TField[i].setFont(new Font("Saira Condensed", Font.PLAIN, 14));
			TField[i].setForeground(Color.black);
			TField[i].setEditable(false);
			int index = i;
		    TField[i].addKeyListener(new java.awt.event.KeyAdapter() {
		        public void keyPressed(java.awt.event.KeyEvent e) {
		            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		                if (index < TField.length - 2) {
		                    TField[index+1].requestFocus();
		                }
		            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		                if (index < TField.length - 2) {
		                    TField[index+1].requestFocus();
		                }
		            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
		                if (index > 1) {
		                    TField[index-1].requestFocus();
		                }
		            }
		        }
		    });
			add(TField[i]);
			
			y += 30;
		}
		
		TField[6].addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            Edit_Buttons2[1].doClick();
		        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		            Edit_Buttons2[2].doClick();
		        }
		    }
		});
		
		   EXIT_BTN.setBounds(getWidth() - 160, 10, 130, 30);
	        EXIT_BTN.setFont(new Font("Saira Condensed", Font.BOLD, 16));
	        EXIT_BTN.setBackground(Color.WHITE);
	        EXIT_BTN.setForeground(Color.BLACK);
	        EXIT_BTN.setFocusable(false);
	        EXIT_BTN.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	        EXIT_BTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        
		int y1 = 410; 
		for (int i = 0; i < Edit_Buttons.length; i++) {
			Edit_Buttons[i] = new JButton(Button_Text[i]);
			Edit_Buttons2[i] = new JButton(Button_Text[i+3]);
			Edit_Buttons[i].setBounds(20, y1, 100, 50);
			Edit_Buttons2[i].setBounds(150, y1, 100, 50);
			Edit_Buttons[i].setFont(new Font("Saira Condensed", Font.PLAIN, 14));
			Edit_Buttons[i].setForeground(Color.black);
			Edit_Buttons2[i].setFont(new Font("Saira Condensed", Font.PLAIN, 14));
			Edit_Buttons2[i].setForeground(Color.black);
			Edit_Buttons[i].setFocusable(false);
			Edit_Buttons2[i].setFocusable(false);
			Edit_Buttons[i].setBackground(Color.white);
			Edit_Buttons2[i].setBackground(Color.white);
			Edit_Buttons[i].setEnabled(true);
			Edit_Buttons2[i].setEnabled(true);
			Edit_Buttons2[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Edit_Buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			Edit_Buttons2[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			Edit_Buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));		
			y1 += 80;
			add(Edit_Buttons[i]);
			add(Edit_Buttons2[i]);
		}
		
		
	
		
	
		Table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (Edit_Buttons2[1].isEnabled() == false && Edit_Buttons2[2].isEnabled() == false) {
		            int selectedRow = Table.getSelectedRow();
		            if (selectedRow >= 0) {
		                for (int i = 0; i < Model.getColumnCount(); i++) {
		                    TField[i].setText((String) Table.getValueAt(selectedRow, i));
		                }
		            }
		        }
		    }
		});
		
		Edit_Buttons[0].addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				int selectedRow = Table.getSelectedRow(); 
				if (selectedRow >= 0) { 
					
					//INPUT MESSAGE
					String Conf = JOptionPane.showInputDialog(null, "Enter new stock to be added.", "Stock Count", JOptionPane.INFORMATION_MESSAGE);
					
					if (Conf == null || Conf == "") {}
					else if (Conf.matches("[0-9]+")) {
						int Conf2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to add " + Conf + " stocks to " + TField[1].getText() + "?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (Conf2 == JOptionPane.YES_OPTION) {
							Long Added = Long.parseLong(Conf) + Long.parseLong((String) Table.getValueAt(selectedRow, 5));
							Table.setValueAt(String.valueOf(Added), selectedRow, 5); 
							
							if (Added > Long.parseLong((String) Table.getValueAt(selectedRow, 6))) {
								Table.setValueAt("High Stock", selectedRow, 7);
							} else {
								Table.setValueAt("Low Stock", selectedRow, 7);
							}
							
							for (int i = 0; i < Model.getColumnCount(); i++) { 
				               TField[i].setText((String) Table.getValueAt(selectedRow, i));
				            }  
						}	   
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Input", "Invalid", JOptionPane.WARNING_MESSAGE);
					}
				} else { 
					JOptionPane.showMessageDialog(null, "Select an Item first", "No Item selected", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
				
		Edit_Buttons[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				Edit_Buttons[0].setEnabled(false);
				Edit_Buttons[1].setEnabled(false);
				Edit_Buttons[2].setEnabled(false);
				Edit_Buttons2[0].setEnabled(false);
				Edit_Buttons2[1].setEnabled(true);
				Edit_Buttons2[2].setEnabled(true);
	
			
				TField[0].setText(String.format("%05d", ctr));
				
				for (int i = 0; i < TField.length; i++) {
				    if (i == 0 || i == 7) {
				        TField[i].setEditable(false);
				    } else {
				    	TField[i].setText("");
				        TField[i].setEditable(true);
				    }
				}
				
				TField[7].setText("");
				TField[1].requestFocus();
				
				Edit_Buttons2[1].addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
					if (Stream.of(TField).limit(7).filter(tf -> !tf.equals(TField[7])).anyMatch(tf -> tf.getText().isBlank())) {
						JOptionPane.showMessageDialog(null, "Please fill in the missing information.", "Missing Information", JOptionPane.WARNING_MESSAGE);
					} else if (Stream.of(TField[3]).anyMatch(tf -> !tf.getText().matches("^\\d*\\.?\\d+$")) || Stream.of(TField[5], TField[6]).anyMatch(tf -> !tf.getText().matches("^\\d+$"))) {
					    JOptionPane.showMessageDialog(null, "Price, Stocks, and Re-order Point can only be numbers.", "Incorrect Information", JOptionPane.WARNING_MESSAGE); 
					} else {
						int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this item?", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (Conf == JOptionPane.YES_OPTION) {
							
								for (int i = 0; i < TField.length - 1; i++) {
								    if (i == 0) {
								        r.add(String.format("%05d", ctr));
								        ctr += 1;
								    } else if (i == 3) {
								        String price = TField[3].getText();
								        if (!price.contains(".")) {
								            price += ".00";
								        }
								        r.add(price);
								    } else {
								        r.add(TField[i].getText());
								    }
								}
								
							    if (Long.parseLong(TField[5].getText()) > Long.parseLong(TField[6].getText())) {
							        r.add("High Stock");
							    } else {
							        r.add("Low Stock");
							    }
		
						
							    Model.addRow(r);
							    r = new Vector<String>();
		
							
							    for (int i = 0; i < TField.length; i++) {
							        TField[i].setEditable(false);
							        TField[i].setText("");
							    }
		
							    
							    Edit_Buttons[0].setEnabled(true);
							    Edit_Buttons[1].setEnabled(true);
							    Edit_Buttons[2].setEnabled(true);
							    Edit_Buttons2[0].setEnabled(true);
							    Edit_Buttons2[1].setEnabled(false);
							    Edit_Buttons2[2].setEnabled(false);
							    Edit_Buttons2[1].removeActionListener(Edit_Buttons2[1].getActionListeners()[0]);
							    Edit_Buttons2[2].removeActionListener(Edit_Buttons2[2].getActionListeners()[0]);
							}
						}
					}
				});
				
				//CANCEL
				Edit_Buttons2[2].addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						
						int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
						if (Conf == JOptionPane.YES_OPTION) {
							int selectedRow = Table.getSelectedRow();
							if (selectedRow >= 0) {
								for (int i = 0; i < Model.getColumnCount(); i++) {
					                TField[i].setText((String) Table.getValueAt(selectedRow, i));
					                TField[i].setEditable(false);
					            }
							} else {
								for (int i =0; i < TField.length-1; i++) {
									TField[i].setEditable(false);
									TField[i].setText("");
								}
							}
							
						
							Edit_Buttons[0].setEnabled(true);
							Edit_Buttons[1].setEnabled(true);
							Edit_Buttons[2].setEnabled(true);
							Edit_Buttons2[0].setEnabled(true);
							Edit_Buttons2[1].setEnabled(false);
							Edit_Buttons2[2].setEnabled(false);
							Edit_Buttons2[1].removeActionListener(Edit_Buttons2[1].getActionListeners()[0]);
							Edit_Buttons2[2].removeActionListener(Edit_Buttons2[2].getActionListeners()[0]);
						}
					}
				});
			}
		});
		

		Edit_Buttons[2].addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) {
		        
		    	
		    	int selectedRow = Table.getSelectedRow();
		        if (selectedRow >= 0) { 
		        	int Conf = JOptionPane.showConfirmDialog(null, "Edit " + Table.getValueAt(selectedRow, 1) + "?", "Edit Item?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		            if (Conf == JOptionPane.YES_OPTION) {
		            	for (int i = 0; i < Model.getColumnCount(); i++) {
			                TField[i].setText((String) Table.getValueAt(selectedRow, i));
			            }
			            
			            //Enables Text fields
			            for (int i = 0; i < TField.length; i++) {
			                if (i == 0 || i == 5 || i == 7) {
			                    TField[i].setEditable(false);
			                    TField[i].removeKeyListener(null);
			                } else {
			                    TField[i].setEditable(true);
			                    TField[i].removeKeyListener(null);
			                }
			            }
			            

						TField[1].requestFocus();
						
			            for (int i = 0; i < TField.length; i++) {
			                int index = i;
			                TField[i].addKeyListener(new java.awt.event.KeyAdapter() {
			                    public void keyPressed(java.awt.event.KeyEvent e) {
			                        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			                            if (index < TField.length - 2 && index != 4) {
			                                TField[index+1].requestFocus();
			                            } else if (index == 4) {
			                                TField[index+2].requestFocus();
			                            }
			                        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			                            if (index < TField.length - 2 && index != 4) {
			                                TField[index+1].requestFocus();
			                            } else if (index == 4) {
			                                TField[index+2].requestFocus();
			                            }
			                        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
			                            if (index > 1 && index != 6) {
			                                TField[index-1].requestFocus();
			                            } else if (index == 6) {
			                                TField[index-2].requestFocus();
			                            }
			                        }
			                    }
			                });
			            }
				        Edit_Buttons[0].setEnabled(false);
						Edit_Buttons[1].setEnabled(false);
						Edit_Buttons[2].setEnabled(false);
						Edit_Buttons2[0].setEnabled(false);
						Edit_Buttons2[1].setEnabled(true);
						Edit_Buttons2[2].setEnabled(true);
						
							//SAVE BUTTON
							Edit_Buttons2[1].addActionListener(new ActionListener() { 
								public void actionPerformed(ActionEvent e) {				
							
									if (Stream.of(TField).anyMatch(tf -> tf.getText().isBlank())) {
										JOptionPane.showMessageDialog(null, "Please fill in the missing information.", "Missing Information", JOptionPane.WARNING_MESSAGE);
									} else if (Stream.of(TField[3]).anyMatch(tf -> !tf.getText().matches("^\\d*\\.?\\d+$")) || Stream.of(TField[5], TField[6]).anyMatch(tf -> !tf.getText().matches("^\\d+$"))) {
									    JOptionPane.showMessageDialog(null, "Price, and Re-order Point can only be numbers.", "Incorrect Information", JOptionPane.WARNING_MESSAGE); 
									} else {
										int Conf = JOptionPane.showConfirmDialog(null, "Save changes?", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
										if (Conf == JOptionPane.YES_OPTION) {
											Table.setValueAt(TField[1].getText(), selectedRow, 1);
											Table.setValueAt(TField[2].getText(), selectedRow, 2);
											String price = TField[3].getText();
											if (!price.contains(".")) {
											    price += ".00";
											}
											Table.setValueAt(price, selectedRow, 3);
											Table.setValueAt(TField[4].getText(), selectedRow, 4);
											Table.setValueAt(TField[6].getText(), selectedRow, 6);
											
											if (Long.parseLong(TField[5].getText()) > Long.parseLong((String) Table.getValueAt(selectedRow, 6))) {
												Table.setValueAt("High Stock", selectedRow, 7);
											} else {
												Table.setValueAt("Low Stock", selectedRow, 7);
											}
											
											for (int i =0; i < TField.length; i++) {
												TField[i].setEditable(false);
											}
											
											for (int i = 0; i < Model.getColumnCount(); i++) {
								                TField[i].setText((String) Table.getValueAt(selectedRow, i));
								            }
											
											
											Edit_Buttons[0].setEnabled(true);
											Edit_Buttons[1].setEnabled(true);
											Edit_Buttons[2].setEnabled(true);
											Edit_Buttons2[0].setEnabled(true);
											Edit_Buttons2[1].setEnabled(false);
											Edit_Buttons2[2].setEnabled(false);
											Edit_Buttons2[1].removeActionListener(Edit_Buttons2[1].getActionListeners()[0]);
											Edit_Buttons2[2].removeActionListener(Edit_Buttons2[2].getActionListeners()[0]);
											
											for (int i = 0; i < TField.length; i++) {
												TField[i].removeKeyListener(null);
												
											    final int index = i;
											    TField[i].addKeyListener(new java.awt.event.KeyAdapter() {
											        public void keyPressed(java.awt.event.KeyEvent e) {
											            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
											                if (index < TField.length - 2) {
											                    TField[index+1].requestFocus();
											                }
											            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
											                if (index < TField.length - 2) {
											                    TField[index+1].requestFocus();
											                }
											            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
											                if (index > 1) {
											                    TField[index-1].requestFocus();
											                }
											            }
											        }
											    });
											}

										}
									}
								}
							});
							
							 //CANCEL BUTTOn
							Edit_Buttons2[2].addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
									if (Conf == JOptionPane.YES_OPTION) {
							
										int selectedRow = Table.getSelectedRow();
								        if (selectedRow >= 0) { 
								            for (int i = 0; i < Model.getColumnCount(); i++) {
								                TField[i].setText((String) Table.getValueAt(selectedRow, i));
								            }
								        }
										
								      
								        for (int i =0; i < TField.length; i++) {
								        	TField[i].setEditable(false);
										}
								        
								     
										Edit_Buttons[0].setEnabled(true);
										Edit_Buttons[1].setEnabled(true);
										Edit_Buttons[2].setEnabled(true);
										Edit_Buttons2[0].setEnabled(true);
										Edit_Buttons2[1].setEnabled(false);
										Edit_Buttons2[2].setEnabled(false);
										Edit_Buttons2[1].removeActionListener(Edit_Buttons2[1].getActionListeners()[0]);
										Edit_Buttons2[2].removeActionListener(Edit_Buttons2[2].getActionListeners()[0]);
										
										for (int i = 0; i < TField.length; i++) {
											TField[i].removeKeyListener(null);
											
										    final int index = i;
										    TField[i].addKeyListener(new java.awt.event.KeyAdapter() {
										        public void keyPressed(java.awt.event.KeyEvent e) {
										            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
										                if (index < TField.length - 2) {
										                    TField[index+1].requestFocus();
										                }
										            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
										                if (index < TField.length - 2) {
										                    TField[index+1].requestFocus();
										                }
										            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
										                if (index > 1) {
										                    TField[index-1].requestFocus();
										                }
										            }
										        }
										    });
										}
										
									}
								}
							});
		            }
		        } else {
		        	JOptionPane.showMessageDialog(null, "Select an Item first", "No Item selected", JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});
		
		 //DELETE
		Edit_Buttons2[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int selectedRow = Table.getSelectedRow();
			    if (selectedRow >= 0) {
			    	int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Delete Item", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			        if (Conf == JOptionPane.YES_OPTION) {
			        	Model.removeRow(selectedRow); 
				        for (int i = 0; i < TField.length; i++) {
				            TField[i].setText("");
				        }
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "Select an Item first", "No Item selected", JOptionPane.WARNING_MESSAGE);
			    }
			}
		});
		
		Table.getTableHeader().setEnabled(false);
		
	
		DefaultTableCellRenderer Center = new DefaultTableCellRenderer(); 
		Center.setHorizontalAlignment(JLabel.CENTER); 
		
		for (int i = 0; i < Row.length; i++) {
		    Table.getColumnModel().getColumn(i).setCellRenderer(Center);
		}
		
		
		Table.setRowHeight(40); 

		TableColumnModel Colm = Table.getColumnModel();
		int[] Wid = {
			100, 160, 230, 90, 120, 80, 110, 100 
		};
		
		for (int i = 0; i < Wid.length; i++) {
			Colm.getColumn(i).setPreferredWidth(Wid[i]);
		}
		
		
		Panel.setBounds(270, 340, 850, 300);
		Panel.add(Scroll);
		Table.setRowSorter(sort);
		
		Edit_Buttons2[1].setEnabled(false);
		Edit_Buttons2[2].setEnabled(false);
		
		
		setLayout(null);
		setVisible(true);
		add(Panel);
		add(SEARCH_LABEL);
		add(SEARCH_FIELD);
	}
}
