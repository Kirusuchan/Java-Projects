package javaSwingLoginForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class DashBoard extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel FirstLast_Txt = new JLabel();
	

	private ArrayList<String> firstNameList;

	private int selected_in;

	private ArrayList<String> lastNameList;
	
	
	DashBoard(int selected_ind, ArrayList<String> saved_firstname_list, ArrayList<String> saved_lastname_list){
		this.selected_in = selected_ind;
		this.firstNameList = saved_firstname_list;
		this.lastNameList = saved_lastname_list;
		
		setTitle("LOGIN");
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        // Load the logo image and set it as the icon of the JFrame
        ImageIcon logoImage = new ImageIcon("logo1.png");
        setIconImage(logoImage.getImage());

        // Create a new ImageIcon object with the same size as the JFrame
        ImageIcon backgroundImage = new ImageIcon("welcome.png");
        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
        
        ImageIcon Profile = new ImageIcon("Profie.png");
        ImageIcon resizedProfile = new ImageIcon(Profile.getImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundresizedProfile = new JLabel(resizedProfile);
        backgroundresizedProfile.setBounds(275, 95, 250, 250);
        add(backgroundresizedProfile);
        
        JButton exitButton = new JButton("X");
        exitButton.setBounds(getWidth()- 50, 2, 50, 25);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(Color.gray);
        exitButton.setFocusable(false);
       
        JButton MinButton = new JButton("--");
        MinButton.setBounds(getWidth()- 50, 32, 50, 25);
        MinButton.setFont(new Font("Arial", Font.BOLD, 20));
        MinButton.setBackground(Color.gray);
        MinButton.setFocusable(false);
        
        JButton Logout_Button = new JButton("LOGOUT");
        Logout_Button.setBounds(getWidth()- 135, 400, 130, 30);
        Logout_Button.setFont(new Font("Arial", Font.BOLD, 20));
        Logout_Button.setBackground(Color.gray);
        Logout_Button.setFocusable(false);
      
        FirstLast_Txt.setFont(new Font("Saira Condensed", Font.BOLD, 22));
        FirstLast_Txt.setText("Welcome, " + firstNameList.get(selected_in) + " " + lastNameList.get(selected_in) + "!");
        FirstLast_Txt.setBounds(160, 380, 550, 50);
        FirstLast_Txt.setSize(500, 30);
        FirstLast_Txt.setHorizontalAlignment(SwingConstants.CENTER);
        FirstLast_Txt.setForeground(Color.white);
        FirstLast_Txt.setBackground(Color.LIGHT_GRAY);
        FirstLast_Txt.setOpaque(false);
        add(FirstLast_Txt);
        
        add(MinButton);
        add(Logout_Button);
        add(exitButton);
        
        setupButton(Logout_Button);
        setupButton(exitButton);
        setupButton(MinButton);
        
        setVisible(true);
        
     // Add an action listener to the button
        Logout_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to Logout?","Confirmation",dialogButton);
                
                if(dialogResult == JOptionPane.YES_OPTION){
                	
            	dispose();
            	new LoginForm();
            	
                } else {
                	
                	return;
                }
            }
        });
        
	
       
     // Add an action listener to the button
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","Confirmation",dialogButton);
                
                if(dialogResult == JOptionPane.YES_OPTION){
                	
            	System.exit(0);            	
                } else {
                	
                	return;
                }            } 
        });
        
     // Add an action listener to the button
        MinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 setState(ICONIFIED);
            }
        });
        
	}

	 public void setupButton(JButton button) {
           button.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseEntered(MouseEvent e) {
                   button.setBackground(Color.LIGHT_GRAY); // Change the background color when the mouse enters
       }

       @Override
       public void mouseExited(MouseEvent e) {
           button.setBackground(Color.GRAY); // Change the background color back when the mouse exits
               }
           });
       }		
}
	
