package inventory_pos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Payment extends JFrame {
	
	
	ImageIcon Logo = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	JButton[] Buttons = new JButton[2]; 
	JTextField Payment = new JTextField();
	String[] ButtonText = {
			"Cancel",
			"Buy"
	};
	
	private POS main;
	
	public Payment(POS main) {
        this.main = main;
    }
	
	private Discount discount;
	
	public void Payment_Main() {
		setSize(500, 230);
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.black);
		setIconImage(Logo.getImage());
		setResizable(false);
		setUndecorated(true);
		
		
		addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        main.setEnabled(true);
		    }
		});
		
		
		JLabel label1 = new JLabel();
		label1.setOpaque(true);
		label1.setBackground(Color.decode("#FFD05B"));
		label1.setBounds(0, 0, 496, 51);
		
		JLabel label2 = new JLabel();
		label2.setOpaque(true);
		label2.setBackground(Color.decode("#FFD05B"));
		label2.setBounds(4, 4, 492, 222);
		
		JLabel Payment_Text = new JLabel("PAYMENT");
		Payment_Text.setFont(new Font("Saira Condensed", Font.BOLD, 30));
		Payment_Text.setForeground(Color.black);
		Payment_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Payment_Text.setOpaque(false);
		Payment_Text.setBackground(null);
		Payment_Text.setBounds(4, 0, 470, 53);
		
		JLabel Payment_Label = new JLabel("Enter Payment: ");
		Payment_Label.setFont(new Font("Saira Condensed", Font.BOLD, 20));
		Payment_Label.setForeground(Color.black);
		Payment_Label.setOpaque(false);
		Payment_Label.setBackground(null);
		Payment_Label.setBounds(17, 70, 470, 53);
		
		Payment.setFont(new Font("Saira Condensed", Font.BOLD, 20));
		Payment.setForeground(Color.black);
		Payment.setHorizontalAlignment(SwingConstants.LEFT);
		Payment.setCaretColor(Color.black);
		Payment.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
		Payment.setOpaque(false);
		Payment.setBackground(null);
		Payment.setBounds(172, 82, 300, 30);
		
		int x = 20;
		for (int i = 0; i < Buttons.length; i++) {
			int index = i;
			Buttons[i] = new JButton(ButtonText[i]);
			Buttons[i].setBounds(x, 150, 200, 50);
			Buttons[i].setFocusable(false);
			Buttons[i].setBackground(Color.WHITE);
			Buttons[i].setForeground(Color.BLACK);
			Buttons[i].setFont(new Font("Saira Condensed", Font.BOLD, 20));
			Buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			Buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			label2.add(Buttons[i]);
			x += 250;
			
		}
		
		Buttons[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int Conf = JOptionPane.showConfirmDialog(null, "Cancel Payment and go back to the POS?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (Conf == JOptionPane.YES_OPTION) {
					Payment.setText("");
					main.setEnabled(true);
	            	setVisible(false);
				}
			}
		});
		
		Buttons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (Payment.getText().matches("^(0|[1-9]\\d*)$")) {
					int Conf = JOptionPane.showConfirmDialog(null, "Are you sure?", "Cancel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
					if (Conf == JOptionPane.YES_OPTION) {
						double Calcu = Double.parseDouble(Payment.getText()) - Double.parseDouble(main.Total.getText());
						if (Calcu >= 0) {
							JDialog Receipt = new JDialog();
							JPanel Receipt_Panel = new JPanel();
							JButton Okay_Btn = new JButton();

							JLabel Title = new JLabel(), HR = new JLabel(), Address_Title = new JLabel(), OCR = new JLabel(), HR2 = new JLabel(), HR3 = new JLabel();

							JLabel[] Head = new JLabel[5];
							String[] label1 = {"Name", "Size", "Qty", "Price", "Total"};
							String[] CostTotal = {"Total", "Cash", "Discount", "Change"};

							// Add the panel to the JScrollPane
							JScrollPane Scroll = new JScrollPane(Receipt_Panel);
							JScrollBar ScrollBar = Scroll.getVerticalScrollBar();
			    			
			    			Receipt.setSize(350, 500);
			    			Receipt.setLocationRelativeTo(null);
			    			Receipt.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
			    			Receipt.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 1));
			    			Receipt.setUndecorated(true);
			    			Receipt.setResizable(false);
			    			
			    			Title.setBounds(100, 10, 300, 30);
			    			Title.setText("Food Haven");
			    			Title.setFont(new Font("Saira Condensed", Font.BOLD, 28));
			    			Title.setOpaque(false);
			    			
			    			Address_Title.setBounds(120, 35, 300, 30);
			    			Address_Title.setText("SM City Tarlac");
			    			Address_Title.setFont(new Font("Saira Condensed", Font.BOLD, 14));
			    			Address_Title.setOpaque(false);
			    			
			    			OCR.setBounds(95, 70, 300, 30);
			    			OCR.setText("OFFICIAL RECEIPT");
			    			OCR.setFont(new Font("Saira Condensed", Font.BOLD, 18));
			    			OCR.setOpaque(false);
			    			
			    			HR.setBounds(30, 95, 300, 30);
			    			HR.setText("_____________________");
			    			HR.setFont(new Font("Georgia", Font.BOLD, 20));
			    			HR.setOpaque(false);
			    			
			    			int x = 10;
			    			for (int i = 0; i < label1.length; i++) {
			    				Head[i] = new JLabel(label1[i]);
			    				Head[i].setFont(new Font("Saira Condensed", Font.BOLD, 14));
			    				Head[i].setForeground(Color.black);
			    				Head[i].setOpaque(false);
			    				Head[i].setBackground(null);
			    				if (i == 0) {
			    					Head[i].setBounds(x, 105, 470, 53);
			    				} else if (i == 1) {
			    					Head[i].setBounds(x + 25, 105, 470, 53);
			    				} else if (i == 2){
			    					Head[i].setBounds(x + 20, 105, 470, 53);
			    				} else if (i == 3){
			    					Head[i].setBounds(x + 10, 105, 470, 53);
			    				} else if (i == 4){
			    					Head[i].setBounds(x + 15, 105, 470, 53);
			    				}
			    				
			    				x += 65;
			    				Receipt_Panel.add(Head[i]);
			    			}
			    			
			    			int RowPOS = main.Table.getRowCount();
			    			int y = 140;
			    			JLabel[] Name = new JLabel[RowPOS];
			    			JLabel[] Size = new JLabel[RowPOS];
			    			JLabel[] Qty = new JLabel[RowPOS];
			    			JLabel[] Price = new JLabel[RowPOS];
			    			JLabel[] Total = new JLabel[RowPOS];
			    			for (int i = 0; i < RowPOS; i++) {
			    				String RecName = (String) main.Table.getValueAt(i, 1);
			    				Name[i] = new JLabel(RecName);
			    				Name[i].setFont(new Font("Saira Condensed", Font.BOLD, 12));
			    				Name[i].setForeground(Color.black);
			    				Name[i].setOpaque(false);
			    				Name[i].setBackground(null);
			    				Name[i].setBounds(10, y, 470, 53);
			    				
			    				String RecSize = (String) main.Table.getValueAt(i, 2);
			    				Size[i] = new JLabel(RecSize);
			    				Size[i].setFont(new Font("Saira Condensed", Font.BOLD, 12));
			    				Size[i].setForeground(Color.black);
			    				Size[i].setOpaque(false);
			    				Size[i].setBackground(null);
			    				Size[i].setBounds(100, y, 470, 53);
			    				
			    				String RecQty = (String) main.Table.getValueAt(i, 4);
			    				Qty[i] = new JLabel(RecQty);
			    				Qty[i].setFont(new Font("Saira Condensed", Font.BOLD, 12));
			    				Qty[i].setForeground(Color.black);
			    				Qty[i].setOpaque(false);
			    				Qty[i].setBackground(null);
			    				Qty[i].setBounds(165, y, 470, 53);
			    				
			    				String RecPrice = (String) main.Table.getValueAt(i, 3);
			    				Price[i] = new JLabel(RecPrice);
			    				Price[i].setFont(new Font("Saira Condensed", Font.BOLD, 12));
			    				Price[i].setForeground(Color.black);
			    				Price[i].setOpaque(false);
			    				Price[i].setBackground(null);
			    				Price[i].setBounds(210, y, 470, 53);
			    				
			    				String RecTotal = (String) main.Table.getValueAt(i, 5);
			    				Total[i] = new JLabel(RecTotal);
			    				Total[i].setFont(new Font("Saira Condensed", Font.BOLD, 12));
			    				Total[i].setForeground(Color.black);
			    				Total[i].setHorizontalAlignment(SwingConstants.RIGHT);
			    				Total[i].setOpaque(false);
			    				Total[i].setBackground(null);
			    				Total[i].setBounds(120, y, 200, 53);
			    				
			    				y += 25;
			    				Receipt_Panel.add(Name[i]);
			    				Receipt_Panel.add(Size[i]);
			    				Receipt_Panel.add(Qty[i]);
			    				Receipt_Panel.add(Price[i]);
			    				Receipt_Panel.add(Total[i]);
			    			}
			    			
			    			HR2.setBounds(30, y+15, 300, 30);
			    			HR2.setText("_________________________________");
			    			HR2.setFont(new Font("Georgia", Font.BOLD, 20));
			    			HR2.setOpaque(false);
			    			
			    			y += 40;
			    			
	    					JLabel[] LabelTotal = new JLabel[CostTotal.length];
			    			JLabel[] Price2 = new JLabel[CostTotal.length];
			    			String[] StrPrice = {
			    					main.Total.getText(),
			    					String.format("%.2f", Double.parseDouble(Payment.getText())),
			    					String.format("%.2f", main.discounted),
			    					String.format("%.2f", (Double.parseDouble(Payment.getText()) - (Double.parseDouble(main.Total.getText()))))
			    			};
			    			
			    			JLabel[] Dots2 = new JLabel[CostTotal.length];
			    			for (int i = 0; i < CostTotal.length; i++) {
			    				LabelTotal[i] = new JLabel(CostTotal[i]);
			    				if (i == 0) {
			    					LabelTotal[i].setBounds(10, y-3, 150, 30);
			    					LabelTotal[i].setFont(new Font("Saira Condensed", Font.BOLD, 16));
			    				} else {
				    			    LabelTotal[i].setBounds(35, y-3, 150, 30);
				    			    LabelTotal[i].setFont(new Font("Saira Condensed", Font.BOLD, 14));
			    				}
			    			    LabelTotal[i].setOpaque(false);
			    			    Receipt_Panel.add(LabelTotal[i]);
			    			    
			    			    Price2[i] = new JLabel();
			    			    Price2[i].setHorizontalAlignment(SwingConstants.RIGHT);
			    			    Price2[i].setText(StrPrice[i]);
			    			    Price2[i].setBounds(240, y, 80, 30);
			    			    Price2[i].setOpaque(false);
			    			    Price2[i].setFont(new Font("Arial", Font.BOLD, 14));
			    			    Receipt_Panel.add(Price2[i]);
			    			    
			    				Dots2[i] = new JLabel("···························· P ");
				    			Dots2[i].setBounds(120, y, 150, 30);
				    			Dots2[i].setOpaque(false);
				    			Dots2[i].setFont(new Font("Saira Condensed", Font.BOLD, 12));
				    			Receipt_Panel.add(Dots2[i]);
				    			
				    			y += 30;
			    			}
			    			
			    			y+=5;
			    			HR3.setBounds(30, y, 300, 30);
			    			HR3.setText("__________________________________");
			    			HR3.setFont(new Font("Georgia", Font.BOLD, 20));
			    			HR3.setOpaque(false);
			    			
			    			y+=35;
			    			JLabel SubTitle2 = new JLabel();
			    			SubTitle2.setBounds(70, y, 300, 30);
			    			SubTitle2.setText("Thank you for purchasing!");
			    			SubTitle2.setFont(new Font("Saira Condensed", Font.BOLD, 14));
			    			SubTitle2.setOpaque(false);
			    			
			    			Receipt_Panel.setBackground(Color.white);
							Receipt_Panel.setLayout(null);
	
							y+=40;
			    			Okay_Btn.setText("OK");
			    			Okay_Btn.setBounds(120, y, 100, 30);
			    			Okay_Btn.setFont(new Font("Saira Condensed", Font.BOLD, 20));
			    			Okay_Btn.setForeground(Color.black);
			    			Okay_Btn.setBackground(Color.white);
			    			Okay_Btn.setOpaque(true);
			    			Okay_Btn.setBorder(null);
			    			Okay_Btn.setFocusable(false);
			    			Okay_Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			    			Okay_Btn.addActionListener(new ActionListener(){
			    			    @Override 
			    			    public void actionPerformed(ActionEvent e) {
			    			    	main.POS_Model.setRowCount(0);
					            	main.Total.setText("0.00");
					            	main.Invoice_Ctr += 1;
					            	main.InvoiceNum.setText(Integer.toString(main.Invoice_Ctr));
			    			    	main.setEnabled(true);
			    			    	setVisible(false);
			    			    	Receipt.dispose();
			    			    }
			    			});
			    			
			    			Receipt_Panel.setPreferredSize(new Dimension(320, y+50));
			    			

			    			// Set the preferred size of the JScrollPane
			    			Scroll.setPreferredSize(new Dimension(350, 350));
			    			Scroll.setViewportView(Receipt_Panel);
			    			Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			    			Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			    			ScrollBar.setUnitIncrement(20);
			    			ScrollBar.setBlockIncrement(100);

			    			Receipt_Panel.add(Okay_Btn);
			    			Receipt_Panel.add(Title);
			    			Receipt_Panel.add(Address_Title);
			    			Receipt_Panel.add(OCR);
			    			Receipt_Panel.add(HR);
			    			Receipt_Panel.add(HR2);
			    			Receipt_Panel.add(HR3);
			    			Receipt_Panel.add(Okay_Btn);
			    			Receipt_Panel.add(SubTitle2);
			    			Receipt.add(Scroll);

			    			Receipt.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Insufficient Payment", "Insufficient Money", JOptionPane.WARNING_MESSAGE); 
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please enter a valid payment", "Invalid Input", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		add(label2);
		label2.add(label1);
		label2.add(Payment);
		label2.add(Payment_Label);
		label1.add(Payment_Text);
		setLayout(null);
		setVisible(true);
	}
}
