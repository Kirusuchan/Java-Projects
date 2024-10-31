package foodOrderingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class FoodMenu extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	
	String[] Drinks = {"Express", "Cafe Latte", "Cappuccino", "Mocha", "Americano", "Macchiato", "Espresso Macchiato", "Flat White"};
    String[] SnacksAndSweets = {"Chocolate Chip Cookie", "Brownie", "Popcorn", "Trail Mix", "Gummy Bears", "Pretzels", "Chips", "Candy Bar"};
    String[] StarbucksDishes = {"Avocado Toast", "Breakfast Sandwich", "Feta Breakfast Wrap", "Egg White", "Chicken Caprese Sandwich", "Dill Havarti Sandwich", "Impossible™ Breakfast Sandwich", "Classic Whole-Grain Oatmeal"};
    
    double[] Prices_Drinks = {125, 150, 150, 175, 125, 150, 175, 175};
    double[] Prices_SnacksAndSweets = {50, 75, 25, 90, 40, 30, 50, 60};
    double[] Prices_StarbucksDishes = {276, 251, 262, 223, 373, 373, 251, 191};
    
    JLabel DrinkB = new JLabel("DRINKS");
    JLabel Sweet_SnacksB = new JLabel("SWEETS & SNACKS");
    JLabel DISHESB = new JLabel("DISHES");

    JLabel TotalLabel = new JLabel("");
    JLabel DiscountLabel = new JLabel("");
    JLabel ChangeLabel = new JLabel("");
    
    JTextField PaymentTxtField = new JTextField();
    
    JPanel panelDrinks = new JPanel();
    JPanel panelSandS = new JPanel();
    JPanel panelDishes = new JPanel();
    double totalPrice = 0.0;
    
    JPanel ORDER_DETAILS_Panel = new JPanel();
    JPanel RPANELBUTTON = new JPanel();
    
    JPanel DISCOUNT_DETAILS_Panel = new JPanel();
    JPanel DPANELBUTTON = new JPanel();

    JPanel radioPanel = new JPanel();
    JPanel radioPanel1 = new JPanel();
    JButton buyButton = new JButton("Buy");
    JButton cancelButton = new JButton("Cancel");
   
    JRadioButton takeOutButton = new JRadioButton("Take Out");
    ButtonGroup orderTypeGroup = new ButtonGroup();
    JRadioButton dineInButton = new JRadioButton("Dine In");
    JLabel orderTypeLabel = new JLabel("Order Type: ");
     
    JRadioButton StudentButton = new JRadioButton("Student(3%)");
    ButtonGroup DiscountTypeGroup = new ButtonGroup();
    ButtonGroup OrdertTypeGroup = new ButtonGroup();
    JRadioButton SeniorButton = new JRadioButton("Senior(10%)");
    JLabel DiscountTypeLabel = new JLabel("Discount: ");
    
	private static final long serialVersionUID = 1L;
	 Font font = new Font("Saira Condensed", Font.BOLD, 20);
	 Font font2 = new Font("Saira Condensed", Font.BOLD, 14);
	
	FoodMenu () {
		
		setTitle("Starbucks Coffee");
		setSize(1420, 950);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
        setLocationRelativeTo(null);
        
        // Load the logo image and set it as the icon of the JFrame
        ImageIcon logoImage = new ImageIcon("logo.png");
        setIconImage(logoImage.getImage());

        // Create a new ImageIcon object with the same size as the JFrame
        ImageIcon backgroundImage = new ImageIcon("OgImage.png");
        ImageIcon resizedBackgroundImage = new 		ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), 		getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
        

        DrinkB.setFont(new Font("Saira Condensed", Font.BOLD, 32));
        DrinkB.setBounds(120, 220, 100, 50);
        DrinkB.setSize(320, 30);
        DrinkB.setForeground(Color.white);
        DrinkB.setOpaque(false);
        DrinkB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        add(DrinkB);
        
        Sweet_SnacksB.setFont(new Font("Saira Condensed", Font.BOLD, 32));
        Sweet_SnacksB.setBounds(290, 220, 230, 50);
        Sweet_SnacksB.setSize(320, 30);
        Sweet_SnacksB.setForeground(Color.white);
        Sweet_SnacksB.setOpaque(false);
        Sweet_SnacksB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(Sweet_SnacksB);
        
      
        DISHESB.setFont(new Font("Saira Condensed", Font.BOLD, 32));
        DISHESB.setBounds(650, 220, 300, 50);
        DISHESB.setSize(320, 30);
        DISHESB.setForeground(Color.white);
        DISHESB.setOpaque(false);
        DISHESB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(DISHESB);
        
        TotalLabel.setFont(new Font("Saira Condensed", Font.PLAIN, 24));
        TotalLabel.setBounds(1100, 520, 300, 50);
        TotalLabel.setSize(320, 30);
        TotalLabel.setForeground(Color.black);
        TotalLabel.setOpaque(false);
        add(TotalLabel);
        
        DiscountLabel.setFont(new Font("Saira Condensed", Font.PLAIN, 24));
        DiscountLabel.setBounds(1100, 575, 300, 50);
        DiscountLabel.setSize(320, 30);
        DiscountLabel.setForeground(Color.black);
        DiscountLabel.setOpaque(false);
        add(DiscountLabel);
        
        ChangeLabel.setFont(new Font("Saira Condensed", Font.PLAIN, 24));
        ChangeLabel.setBounds(1100, 695, 300, 50);
        ChangeLabel.setSize(320, 30);
        ChangeLabel.setForeground(Color.black);
        ChangeLabel.setOpaque(false);
        add(ChangeLabel);
        
        PaymentTxtField.setFont(new Font("Saira Condensed", Font.PLAIN, 24));
        PaymentTxtField.setBounds(1100, 636, 80, 50);
        PaymentTxtField.setSize(260, 30);
        PaymentTxtField.setOpaque(false);
        PaymentTxtField.setBorder(null);
        add(PaymentTxtField);
        
        
        panelDrinks.setLayout(new BoxLayout(panelDrinks, BoxLayout.Y_AXIS));
        panelDrinks.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDrinks.setOpaque(false);
        panelDrinks.setBounds(120,270,650,400);
        getContentPane().add(panelDrinks);
        
        panelSandS.setLayout(new BoxLayout(panelSandS, BoxLayout.Y_AXIS));
        panelSandS.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSandS.setOpaque(false);
        panelSandS.setBounds(120,270,650,400);
        getContentPane().add(panelSandS);
        
        panelDishes.setLayout(new BoxLayout(panelDishes, BoxLayout.Y_AXIS));
        panelDishes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelDishes.setOpaque(false);
        panelDishes.setBounds(120,270,650,400);
        getContentPane().add(panelDishes);
                  
        ORDER_DETAILS_Panel.setLayout(new BoxLayout(ORDER_DETAILS_Panel, BoxLayout.Y_AXIS));
        ORDER_DETAILS_Panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ORDER_DETAILS_Panel.setBackground(Color.red);
        ORDER_DETAILS_Panel.setOpaque(false);
        ORDER_DETAILS_Panel.setBounds(900,175,450,220);
        getContentPane().add(ORDER_DETAILS_Panel);
        
        JScrollPane scrollPane = new JScrollPane(ORDER_DETAILS_Panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(450, 220));
        scrollPane.setBounds(900, 175, 450, 220);
        scrollPane.setOpaque(false);
        getContentPane().add(scrollPane);

        RPANELBUTTON.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        RPANELBUTTON.setOpaque(false);
        RPANELBUTTON.setBounds(145,30,600,100);
        getContentPane().add(RPANELBUTTON);
        
        radioPanel.setOpaque(false);
        radioPanel.setFocusable(false);
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
        radioPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Order Type"));
        radioPanel.setFont(font);
        RPANELBUTTON.add(radioPanel);
             
        orderTypeLabel.setFont(font);
        ORDER_DETAILS_Panel.add(orderTypeLabel);
      
        dineInButton.setFocusable(false);
        dineInButton.setOpaque(false);
        dineInButton.setFont(font);
        dineInButton.setForeground(Color.black);
       
        takeOutButton.setFocusable(false);
        takeOutButton.setOpaque(false);
        takeOutButton.setFont(font);
        takeOutButton.setForeground(Color.black);
        
        DPANELBUTTON.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        DPANELBUTTON.setOpaque(false);
        DPANELBUTTON.setBounds(830,410,600,100);
        getContentPane().add(DPANELBUTTON);
        
        radioPanel1.setOpaque(false);
        radioPanel1.setFocusable(false);
        radioPanel1.setLayout(new BoxLayout(radioPanel1, BoxLayout.X_AXIS));
        radioPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Discount"));
        radioPanel1.setFont(font);
        DPANELBUTTON.add(radioPanel1);
             
        DiscountTypeLabel.setFont(font);
        DISCOUNT_DETAILS_Panel.add(DiscountTypeLabel);
      
        StudentButton.setFocusable(false);
        StudentButton.setOpaque(false);
        StudentButton.setFont(font);
        StudentButton.setForeground(Color.black);
       
        SeniorButton.setFocusable(false);
        SeniorButton.setOpaque(false);
        SeniorButton.setFont(font);
        SeniorButton.setForeground(Color.black);
                    
                    
        radioPanel1.add(StudentButton);
        radioPanel1.add(Box.createHorizontalGlue());
        radioPanel1.add(SeniorButton);
        radioPanel.add(dineInButton);
        radioPanel.add(Box.createHorizontalGlue());
        radioPanel.add(takeOutButton);
        
        OrdertTypeGroup.add(dineInButton);
        OrdertTypeGroup.add(takeOutButton);
        DiscountTypeGroup.add(StudentButton);
        DiscountTypeGroup.add(SeniorButton);
        
        
        buyButton.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        buyButton.setBounds(1100, 760, 0, 0);
        buyButton.setSize(100,50);
        buyButton.setFocusable(false);
        buyButton.setForeground(Color.black);
        buyButton.setOpaque(false);
        buyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        cancelButton.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        cancelButton.setBounds(1265, 760, 0, 0);
        cancelButton.setSize(100,50);
        cancelButton.setFocusable(false);
        cancelButton.setForeground(Color.black);
        cancelButton.setOpaque(false);
        cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
       
      for (int i = 0; i < Drinks.length; i++) {
    	  int finalI = i;
        JPanel drinkPanel = new JPanel();
        drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.X_AXIS));
        drinkPanel.setOpaque(false);
        drinkPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JCheckBox CheckBox = new JCheckBox(Drinks[i]);
        CheckBox.setFont(font);
        CheckBox.setOpaque(false);
        CheckBox.setFocusable(false);
        CheckBox.setForeground(Color.white);

        JLabel priceLabel = new JLabel("................................................   ₱" + Prices_Drinks[i]);
        priceLabel.setFont(font);
        priceLabel.setOpaque(false);
        priceLabel.setFocusable(false);
        priceLabel.setForeground(Color.white);

        
        drinkPanel.add(CheckBox);
        drinkPanel.add(Box.createHorizontalGlue());
        drinkPanel.add(priceLabel);
        panelDrinks.add(drinkPanel);
        
      
        CheckBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (CheckBox.isSelected()) {
                	totalPrice += Prices_Drinks[finalI];
                    JLabel itemLabel = new JLabel(CheckBox.getText()+"(" + "₱" + Prices_Drinks[finalI] + ")");
                    itemLabel.setFont(font2);
                    itemLabel.setForeground(Color.black);
                    ORDER_DETAILS_Panel.add(itemLabel);
                } else {
                    totalPrice -= Prices_Drinks[finalI];
                    Component[] orderComponents = ORDER_DETAILS_Panel.getComponents();
                    for (int k = 0; k < orderComponents.length; k++) {
                        if (orderComponents[k] instanceof JLabel) {
                            JLabel itemLabel = (JLabel) orderComponents[k];
                            if (itemLabel.getText().startsWith(CheckBox.getText())) {
                                ORDER_DETAILS_Panel.remove(itemLabel);
                            }
                        }
                    }
                }
                ORDER_DETAILS_Panel.revalidate();
                ORDER_DETAILS_Panel.repaint();
                TotalLabel.setText("₱" + totalPrice);
            }
        });

      }
      
      for (int i = 0; i < Prices_SnacksAndSweets.length; i++) {
    	  int finalI = i;
          JPanel SandSPanel = new JPanel();
          SandSPanel.setLayout(new BoxLayout(SandSPanel, BoxLayout.X_AXIS));
          SandSPanel.setOpaque(false);
          SandSPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

          JCheckBox CheckBox1 = new JCheckBox(SnacksAndSweets[i]);
          CheckBox1.setFont(font);
          CheckBox1.setOpaque(false);
          CheckBox1.setFocusable(false);
          CheckBox1.setForeground(Color.white);

          JLabel priceLabel = new JLabel("......................................   ₱" + Prices_SnacksAndSweets[i]);
          priceLabel.setFont(font);
          priceLabel.setOpaque(false);
          priceLabel.setFocusable(false);
          priceLabel.setForeground(Color.white);

          SandSPanel.add(CheckBox1);
          SandSPanel.add(Box.createHorizontalGlue());
          SandSPanel.add(priceLabel);
          panelSandS.add(SandSPanel);
         
          CheckBox1.addItemListener(new ItemListener() {
        	    public void itemStateChanged(ItemEvent e) {
        	        if (CheckBox1.isSelected()) {
        	        	totalPrice += Prices_SnacksAndSweets[finalI];
        	            JLabel itemLabel = new JLabel(CheckBox1.getText()+"(" + "₱" + Prices_SnacksAndSweets[finalI] + ")");
        	            itemLabel.setFont(font2);
        	            itemLabel.setForeground(Color.black);
        	            ORDER_DETAILS_Panel.add(itemLabel);
        	        } else {
        	            totalPrice -= Prices_SnacksAndSweets[finalI];
        	            Component[] orderComponents = ORDER_DETAILS_Panel.getComponents();
        	            for (int k = 0; k < orderComponents.length; k++) {
        	                if (orderComponents[k] instanceof JLabel) {
        	                    JLabel itemLabel = (JLabel) orderComponents[k];
        	                    if (itemLabel.getText().startsWith(CheckBox1.getText())) {
        	                        ORDER_DETAILS_Panel.remove(itemLabel);
        	                    }
        	                }
        	            }
        	        }
        	        ORDER_DETAILS_Panel.revalidate();
        	        ORDER_DETAILS_Panel.repaint();
        	        TotalLabel.setText("₱" + totalPrice);
        	    }
        	});
          
          }
      
    for (int i = 0; i < StarbucksDishes.length; i++) {
    	int finalI = i;
      JPanel DishesPanel = new JPanel();
      DishesPanel.setLayout(new BoxLayout(DishesPanel, BoxLayout.X_AXIS));
      DishesPanel.setOpaque(false);
      DishesPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

      JCheckBox CheckBox2 = new JCheckBox(StarbucksDishes[i]);
      CheckBox2.setFont(font);
      CheckBox2.setOpaque(false);
      CheckBox2.setFocusable(false);
      CheckBox2.setForeground(Color.white);

      JLabel priceLabel = new JLabel(".............................  ₱" + Prices_StarbucksDishes[i]);
      priceLabel.setFont(font);
      priceLabel.setOpaque(false);
      priceLabel.setFocusable(false);
      priceLabel.setForeground(Color.white);

      DishesPanel.add(CheckBox2);
      DishesPanel.add(Box.createHorizontalGlue());
      DishesPanel.add(priceLabel);
      panelDishes.add(DishesPanel);
      

      CheckBox2.addItemListener(new ItemListener() {
  	    public void itemStateChanged(ItemEvent e) {
  	        if (CheckBox2.isSelected()) {
  	        	totalPrice += Prices_StarbucksDishes[finalI];
  	            JLabel itemLabel = new JLabel(CheckBox2.getText()+"(" + "₱" + Prices_StarbucksDishes[finalI] + ")");
  	            itemLabel.setFont(font2);
  	            itemLabel.setForeground(Color.black);
  	            ORDER_DETAILS_Panel.add(itemLabel);
  	        } else {
  	            totalPrice -= Prices_StarbucksDishes[finalI];
  	            Component[] orderComponents = ORDER_DETAILS_Panel.getComponents();
  	            for (int k = 0; k < orderComponents.length; k++) {
  	                if (orderComponents[k] instanceof JLabel) {
  	                    JLabel itemLabel = (JLabel) orderComponents[k];
  	                    if (itemLabel.getText().startsWith(CheckBox2.getText())) {
  	                        ORDER_DETAILS_Panel.remove(itemLabel);
  	                    }
  	                }
  	            }
  	        }
  	        ORDER_DETAILS_Panel.revalidate();
  	        ORDER_DETAILS_Panel.repaint();
  	        TotalLabel.setText("₱" + totalPrice);
  	    }
  	});

      
    }
        
    buyButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	
	    	//Check if any order type radio button is selected
	        if (!dineInButton.isSelected() && !takeOutButton.isSelected()) {
	            JOptionPane.showMessageDialog(null, "Please select an order type.");
	            return;
	        }
           
            int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to place this order?", "Confirm Order", JOptionPane.YES_NO_OPTION);
            if (confirmed != JOptionPane.YES_OPTION) {
                return;
            }
            
            String orderDetails = "";
            Component[] orderComponents = ORDER_DETAILS_Panel.getComponents();
            for (int k = 0; k < orderComponents.length; k++) {
                if (orderComponents[k] instanceof JLabel) {
                    JLabel itemLabel = (JLabel) orderComponents[k];
                    orderDetails += itemLabel.getText() + "\n";
                }
            }
            String totalPriceText = TotalLabel.getText();
            String totalPrice = totalPriceText.substring(totalPriceText.indexOf("₱") + 1);
            // Create and show the dialog
            JDialog dialog = new JDialog();
            dialog.setUndecorated(true);
            dialog.setTitle("Order Details");
            
            JLabel infoLabel = new JLabel("Starbucks Coffee    Tarlac, Tarlac");
            infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
            infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
 
            JLabel titleLabel = new JLabel("Order Details");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel topPanel = new JPanel(new BorderLayout()); 
            topPanel.add(titleLabel, BorderLayout.SOUTH);

            JPanel middlePanel = new JPanel();
            middlePanel.setBorder(BorderFactory.createDashedBorder(Color.black, 5, 5));
            middlePanel.setPreferredSize(new Dimension(400, 300));
            
            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setFont(font);
            textArea.setOpaque(false);          
            textArea.setSize(400,300);
           
            middlePanel.add(textArea);
    
            JLabel footerLabel = new JLabel("Thank you for purchasing!");
            footerLabel.setFont(new Font("Arial", Font.BOLD, 16));
            footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.add(new JSeparator(), BorderLayout.NORTH);
            bottomPanel.add(footerLabel, BorderLayout.CENTER);

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.add(topPanel, BorderLayout.NORTH);
            mainPanel.add(middlePanel, BorderLayout.CENTER);
            mainPanel.add(bottomPanel, BorderLayout.SOUTH);
            topPanel.add(infoLabel, BorderLayout.CENTER);
          
           
            // Calculate discount percentage based on selected radio button
            double discountPercentage = 0.0;
            if (StudentButton.isSelected()) {
                discountPercentage = 0.03; // 3% discount for students
            } else if (SeniorButton.isSelected()) {
                discountPercentage = 0.10; // 10% discount for seniors
            }

            // Get the payment amount from the text field
            String paymentText = PaymentTxtField.getText();
            if (!paymentText.matches("\\d+(\\.\\d+)?")) { // check if input is a valid number
                JOptionPane.showMessageDialog(null, "Please enter a valid payment amount.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            double paymentAmount = 0.0;
            if (!paymentText.isEmpty()) {
                paymentAmount = Double.parseDouble(paymentText);
            }
            
            // Check if payment amount is empty or less than the final price
            double finalPriceAmount = Double.parseDouble(totalPrice) * (1 - discountPercentage);
            if (paymentAmount == 0.0 || paymentAmount < finalPriceAmount) {
                JOptionPane.showMessageDialog(null, "Payment is empty or less than the final price.");
                return;
            }
          
            // Apply discount to total price
            double discountedPrice = Double.parseDouble(totalPrice) * (1 - discountPercentage);
            String finalPrice = String.format("%.2f", discountedPrice);


            // Calculate the change
            double changeAmount = paymentAmount - discountedPrice;
            String change = String.format("%.2f", changeAmount);
            
            // Update the Discount Label and Change Label
            DiscountLabel.setText("₱" + finalPrice);
            ChangeLabel.setText("₱" + change);

            // Add discount label and final price to the order details text
            orderDetails += "\n"+"........................................................................................"+ "\n" + "\n" +DiscountTypeLabel.getText() + String.format("%.0f%%", discountPercentage * 100) + "\n";
            orderDetails += "Total Price: ₱"+totalPrice+"\n"+"Discounted Price: ₱" + finalPrice ;
            DiscountLabel.setText(finalPrice);
          
            orderDetails += "\nPayment: ₱" + paymentText + "\nChange: ₱" + change;
            
            
            // Set the text of the JTextArea to the updated order details          
            textArea.setText("\n" + orderDetails);   
            dialog.add(mainPanel);
            dialog.pack();
            dialog.setSize(new Dimension(550, 1000));
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
    });
    
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
               dispose();
            }
        }
    });

      DrinkB.addMouseListener(new MouseAdapter() {
    	    @Override
    	    public void mouseClicked(MouseEvent e) {
    	    	
    	    	panelSandS.setVisible(false);
    	        panelDishes.setVisible(false);

    	        ImageIcon backgroundImage = new ImageIcon("Design.png");
      	        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
      	        backgroundLabel.setSize(getWidth(), getHeight());
      	        backgroundLabel.setIcon(resizedBackgroundImage);
      	        
    	     
    	        DrinkB.setForeground(Color.gray);
    	        panelDrinks.setVisible(true);
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			 DrinkB.setForeground(Color.gray);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			DrinkB.setForeground(Color.white);
		}
	});
      
      Sweet_SnacksB.addMouseListener(new MouseAdapter() {
  	    @Override
  	    public void mouseClicked(MouseEvent e) {

  	    	panelDrinks.setVisible(false);
  	    	panelDishes.setVisible(false);
  	    	
  	        ImageIcon backgroundImage = new ImageIcon("Design1.png");
  	        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
  	        backgroundLabel.setSize(getWidth(), getHeight());
  	        backgroundLabel.setIcon(resizedBackgroundImage);
  	        
  	    	panelSandS.setVisible(true);
  	    	Sweet_SnacksB.setForeground(Color.gray);
}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			Sweet_SnacksB.setForeground(Color.gray);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			Sweet_SnacksB.setForeground(Color.white);
  	    }
  	});
    
      DISHESB.addMouseListener(new MouseAdapter() {
  	    @Override
  	    public void mouseClicked(MouseEvent e) {
  	  
	  	    panelDrinks.setVisible(false);
	  	    panelSandS.setVisible(false);
	 
	    	ImageIcon backgroundImage = new ImageIcon("Design2.png");
	        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
	        backgroundLabel.setSize(getWidth(), getHeight());
	        backgroundLabel.setIcon(resizedBackgroundImage);     
	        
	
	  	    panelDishes.setVisible(true);
	  	    DISHESB.setForeground(Color.gray);
  	    }
		
		@Override
		public void mouseEntered(MouseEvent e) {
			DISHESB.setForeground(Color.gray);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			DISHESB.setForeground(Color.white);
  	    }
  	});    

    // Add a listener to the radio buttons
    dineInButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            orderTypeLabel.setText("Order Type: Dine In");
       
        }
    });

    takeOutButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            orderTypeLabel.setText("Order Type: Take Out");

        }
    });
    


      pack();
  	  panelDrinks.setVisible(true);
      panelSandS.setVisible(false);
      panelDishes.setVisible(false);
      add(buyButton);
      add(cancelButton);
      setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
        
