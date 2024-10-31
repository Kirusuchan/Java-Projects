package inventory_pos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class POS extends JFrame{
	
	public void updateTotal() {
	    double TotalAdd = 0, Discount = 0;
	    for (int i = 0; i < Table.getRowCount(); i++) {
	        double Add = Double.parseDouble((String) Table.getValueAt(i, 5));
	        TotalAdd += Add;
	    }    
	    JRadioButton selectedButton = null;

	    for (int i = 0; i < discount.Radio_Buttons.length; i++) {
	        if (discount.Radio_Buttons[i].isSelected()) {
	            selectedButton = discount.Radio_Buttons[i];
	            break;
	        }
	    }

	    double discountPercentage = 0.0;
	    if (selectedButton == discount.Radio_Buttons[1]) {
	        discountPercentage = 0.03;
	    } else if (selectedButton == discount.Radio_Buttons[2]) {
	        discountPercentage = 0.25;
	    } else if (selectedButton == discount.Radio_Buttons[3]) {
	        discountPercentage = 0.2;
	    } else if (selectedButton == discount.Radio_Buttons[4]) {
	        discountPercentage = 0.15;
	    }

	    discounted = TotalAdd * discountPercentage;
	    double discountedTotal = TotalAdd - (TotalAdd * discountPercentage);
	    Total.setText(String.format("%.2f", discountedTotal));
	}
	
	ImageIcon Logo = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	
	//HEADER NAMES
	String[] Row = new String [] {
		"Item Code",
		"Item Name",
		"Size",
		"Price (₱)",
		"Quantity",
		"Total"
	};
	

	String[][] Column = new String [][] {};
	

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
		
	JButton[] Buttons = new JButton[4];
	String[] ButtText = {
			"Remove Item",
			"Discount",
			"Payment",
			"Cancel"
	};
	JTextField Qty_Field;
	JLabel InvoiceNum, Total;
	private InvTable Inv;
	private Discount discount;
	private Payment payment;
	double discounted = 0.00;
	DefaultTableModel POS_Model = (DefaultTableModel) Table.getModel();
	
	int Invoice_Ctr = 1000000;
	public POS(){
		setSize(1200, 800);
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#424242"));
		setResizable(false);
		setTitle("Point-Of-Sale");
		setIconImage(Logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon backgroundImage = new ImageIcon("PosBg.png");
        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
		
	
	
		JLabel Invoice = new JLabel("Invoice number: ");
		Invoice.setFont(new Font("Saira Condensed", Font.PLAIN, 18));
		Invoice.setForeground(Color.black);
		Invoice.setOpaque(false);
		Invoice.setBackground(null);
		Invoice.setBounds(930, 100, 270, 53);
		
		InvoiceNum = new JLabel(Integer.toString(Invoice_Ctr));
		InvoiceNum.setFont(new Font("Saira Condensed", Font.BOLD, 18));
		InvoiceNum.setOpaque(false);
		InvoiceNum.setBackground(null);
		InvoiceNum.setBounds(1060, 100, 270, 53);
		
		
		
		JLabel TotalTxT = new JLabel("TOTAL");
		TotalTxT.setFont(new Font("Saira Condensed", Font.BOLD, 30));
		Invoice.setForeground(Color.black);
		TotalTxT.setHorizontalAlignment(SwingConstants.CENTER);
		TotalTxT.setOpaque(false);
		TotalTxT.setBackground(null);
		TotalTxT.setBounds(0, 350, 260, 53);
		
		Total = new JLabel("0.00");
		Total.setFont(new Font("Saira Condensed", Font.BOLD, 35));
		Total.setHorizontalAlignment(SwingConstants.CENTER);
		Invoice.setForeground(Color.black);
		Total.setOpaque(false);
		Total.setBackground(null);
		Total.setBounds(0, 400, 260, 50);
		
		JButton EXIT_BTN = new JButton("EXIT");
	    EXIT_BTN.setBounds(getWidth() - 160, 10, 130, 30);
	    EXIT_BTN.setFont(new Font("Saira Condensed", Font.BOLD, 16));
	    EXIT_BTN.setBackground(Color.WHITE);
	    EXIT_BTN.setForeground(Color.BLACK);
	    EXIT_BTN.setFocusable(false);
	    EXIT_BTN.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    EXIT_BTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    add(EXIT_BTN);
	    
	    JButton SEARCH = new JButton("SEARCH");
	    SEARCH.setBounds(getWidth() - 430, 90, 100, 30);
	    SEARCH.setFont(new Font("Saira Condensed", Font.BOLD, 16));
	    SEARCH.setBackground(Color.WHITE);
	    SEARCH.setForeground(Color.BLACK);
	    SEARCH.setFocusable(false);
	    SEARCH.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    SEARCH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    add(SEARCH);
			  
	    

		JLabel QuantiSearch = new JLabel("QUANTITY: ");
		QuantiSearch.setBounds(250, 90, 200, 30);
		QuantiSearch.setFont(new Font("Saira Condensed", Font.BOLD, 16));
		QuantiSearch.setForeground(Color.black);
		
		Qty_Field = new JTextField();
		Qty_Field.setBounds(350, 90, 400, 32);
		Qty_Field.setFont(new Font("Saira Condensed", Font.BOLD, 16));
		Qty_Field.setForeground(Color.black);
		Qty_Field.setOpaque(false);
		Qty_Field.setBackground(null);
		Qty_Field.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		Qty_Field.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		Qty_Field.setCaretColor(Color.black);
		
		
		Inv = new InvTable(this);
        Inv.Inv_Table();
        Inv.setVisible(false);
        
        
        SEARCH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	if(Double.parseDouble(Total.getText()) == 0.00) {
            		discount.Radio_Buttons[0].setSelected(true);
            	}
            	
            	if(Qty_Field.getText().isEmpty()) {
            	    JOptionPane.showMessageDialog(null, "Input a quantity first", "No quantity inputted", JOptionPane.WARNING_MESSAGE);
            	} else if (Qty_Field.getText().matches("^(0|[1-9]\\d*)$")) {
            	    Inv.setVisible(true);
            	    setEnabled(false);
            	} else {
            	    JOptionPane.showMessageDialog(null, "You can only use numbers equal or more than 0", "Invalid Quantity", JOptionPane.WARNING_MESSAGE);
            	}
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

		
		

		JLabel Date = new JLabel();
		Date.setBounds(60, 620, 500, 45);
		Date.setFont(new Font("Saira Condensed", Font.PLAIN, 14));
		Date.setForeground(Color.black);
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Time = new JLabel();
        Time.setBounds(790, 620, 500, 45);
        Time.setFont(new Font("Saira Condensed", Font.PLAIN, 14));
        Time.setForeground(Color.black);
        
        Timer timer = new Timer(1000, e -> {
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();

            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
            timeFormat.setDateFormatSymbols(new DateFormatSymbols(Locale.US) {
                @Override
                public String[] getAmPmStrings() {
                    return new String[] {"AM", "PM"};
                }
            });
            String time = timeFormat.format(now);
            Time.setText(time);

            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM dd, yyyy");
            dateFormat.setDateFormatSymbols(new DateFormatSymbols(Locale.US) {
                @Override
                public String[] getMonths() {
                    return new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
                }

                @Override
                public String[] getShortWeekdays() {
                    return new String[] {"", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
                }
            });
            String date = dateFormat.format(now);
            Date.setText(date);
        });
        timer.start();
        
     
		int y = 150;
		for (int i = 0; i < Buttons.length; i++) {
		
			Buttons[i] = new JButton(ButtText[i]);
			Buttons[i].setBounds(930, y, 200, 50);
			Buttons[i].setFocusable(false);
			Buttons[i].setBorder(null);
			Buttons[i].setBackground(Color.white);
			Buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			Buttons[i].setFont(new Font("Saira Condensed", Font.BOLD, 20));
			Buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			y += 70;
			add(Buttons[i]);
		}
		
		 Buttons[0].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Get the selected row in the POS table
	                int selectedRow = Table.getSelectedRow();
	                if (selectedRow >= 0) {
		            	int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + Table.getValueAt(selectedRow, 1), "Delete Item", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		            	if (Conf == JOptionPane.YES_OPTION) {
		            		// Get the ID of the item in the selected row
		                    String ID = (String) Table.getValueAt(selectedRow, 0);
		                    
		                    // Add back the deducted stock to the Inv table
		                    DefaultTableModel invModel = (DefaultTableModel) Inv.Table.getModel();
		                    int invRowIndex = -1;
		                    for (int i = 0; i < invModel.getRowCount(); i++) {
		                        if (invModel.getValueAt(i, 0).equals(ID)) {
		                            invRowIndex = i;
		                            break;
		                        }
		                    }
	                        
		                    if (invRowIndex >= 0) {
			                    int deductedStock = Integer.parseInt((String) Table.getValueAt(selectedRow, 4));
			                    int currentStock = Integer.parseInt(invModel.getValueAt(invRowIndex, 5).toString());
		                        invModel.setValueAt(Integer.toString(currentStock + deductedStock), invRowIndex, 5);
		                        
		                        if (Long.parseLong(invModel.getValueAt(invRowIndex, 5).toString()) > Long.parseLong(invModel.getValueAt(invRowIndex, 6).toString())) {
		                            invModel.setValueAt("High Stock", invRowIndex, 7);
		                        } else {
		                            invModel.setValueAt("Low Stock", invRowIndex, 7);
		                        }
		                        
		                    }
		                    
		                    // Remove the selected row from the POS table
		                    DefaultTableModel POS_Model = (DefaultTableModel) Table.getModel();
		                    POS_Model.removeRow(selectedRow);
		            	}
	                } else {
	                	JOptionPane.showMessageDialog(null, "Choose an item first", "Choose Item", JOptionPane.WARNING_MESSAGE);
	                }
	                updateTotal();
	            }
	        });
		 
		 discount = new Discount(this);
		 discount.Discount_Design();
		 discount.setVisible(false);
		 
		 Buttons[1].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(Double.parseDouble(Total.getText()) == 0.00) {
	            		discount.Radio_Buttons[0].setSelected(true);
	            	}
	            	
	            	discount.setVisible(true);
            	    setEnabled(false);
	            }
	        });
		 
		 payment = new Payment(this);
		 payment.Payment_Main();
		 payment.setVisible(false);
		 
		 Buttons[2].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(Double.parseDouble(Total.getText()) == 0.00) {
	            		discount.Radio_Buttons[0].setSelected(true);
	            	}
	            	
	            	if (Table.getRowCount() > 0) {
	            		payment.setVisible(true);
		            	setEnabled(false);
	            	} else {
	            		JOptionPane.showMessageDialog(null, "Add an Item first", "No Items", JOptionPane.WARNING_MESSAGE);
	            	}
	            }
	        });
		 
		 Buttons[3].addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int Conf = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel and clear the list?", "Cancel Order", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (Conf == JOptionPane.YES_OPTION) {
		            	// Loop through all rows in POS table
		            	for (int i = 0; i < POS_Model.getRowCount(); i++) {
		            	    // Get the ID of the item in the selected row
		            	    String ID = (String) POS_Model.getValueAt(i, 0);
		            	    
		            	    // Add back the deducted stock to the Inv table
		            	    DefaultTableModel invModel = (DefaultTableModel) Inv.Table.getModel();
		            	    int invRowIndex = -1;
		            	    for (int j = 0; j < invModel.getRowCount(); j++) {
		            	        if (invModel.getValueAt(j, 0).equals(ID)) {
		            	            invRowIndex = j;
		            	            break;
		            	        }
		            	    }
	
		            	    if (invRowIndex >= 0) {
		            	        int deductedStock = Integer.parseInt((String) POS_Model.getValueAt(i, 4));
		            	        int currentStock = Integer.parseInt(invModel.getValueAt(invRowIndex, 5).toString());
		            	        invModel.setValueAt(Integer.toString(currentStock + deductedStock), invRowIndex, 5);
	
		            	        if (Long.parseLong(invModel.getValueAt(invRowIndex, 5).toString()) > Long.parseLong(invModel.getValueAt(invRowIndex, 6).toString())) {
		            	            invModel.setValueAt("High Stock", invRowIndex, 7);
		            	        } else {
		            	            invModel.setValueAt("Low Stock", invRowIndex, 7);
		            	        }
	
		            	    }
	
		            	}
	

		            	POS_Model.setRowCount(0);
		            	Total.setText("0.00");
		            	discount.Radio_Buttons[0].setSelected(true);
					}
	            }
	        });
        
		Table.getTableHeader().setEnabled(false); 
		DefaultTableCellRenderer Center = new DefaultTableCellRenderer(); 
		Center.setHorizontalAlignment(JLabel.CENTER);
		
		for (int i = 0; i < Row.length; i++) {
		    Table.getColumnModel().getColumn(i).setCellRenderer(Center);
		}
		Table.setRowHeight(22);
		
		TableColumnModel Colm = Table.getColumnModel();
		int[] Wid = {
			70, 150, 80, 90, 70, 100 //ONLY EDIT THIS 
		};
		
		for (int i = 0; i < Wid.length; i++) {
			Colm.getColumn(i).setPreferredWidth(Wid[i]);
		}
		

		Panel.setBounds(250, 130, 630, 500);
		Panel.add(Scroll);
		Table.setRowSorter(sort);
		
		add(Panel);
		add(QuantiSearch);
		add(Qty_Field);
		add(TotalTxT);
		add(Total);
		add(Invoice);
		add(InvoiceNum);
		add(Time);
		add(Date);
		setLayout(null);
		setVisible(true);
		
	}
}

