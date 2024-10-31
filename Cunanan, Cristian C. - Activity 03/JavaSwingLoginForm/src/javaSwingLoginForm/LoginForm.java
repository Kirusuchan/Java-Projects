package javaSwingLoginForm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.*;

public class LoginForm extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static void read(ArrayList<String> dataList, String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) { // if the file exists, read the data from it
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    dataList.add(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	ArrayList<String> saved_usernames, saved_passwords;
	ArrayList<String> saved_firstname, saved_lastname;
	
		public LoginForm() {
		saved_usernames = new ArrayList<String>();
		saved_passwords = new ArrayList<String>();
		saved_firstname = new ArrayList<String>();
		saved_lastname = new ArrayList<String>();
		
		read(saved_usernames, "Usernames.txt");
		read(saved_passwords, "Passwords.txt");
		read(saved_firstname, "Firstnames.txt");
		read(saved_lastname, "lastnames.txt");
		
		   
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
        ImageIcon backgroundImage = new ImageIcon("finalframelogin.png");
        ImageIcon resizedBackgroundImage = new 		ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), 		getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
        
        ImageIcon viewIcon = new ImageIcon("view.png");
        ImageIcon viewIconResized = new ImageIcon(viewIcon.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
        JLabel viewResized = new JLabel(viewIconResized);
        viewResized.setBounds(725, 245, 20, 20);
        add(viewResized);
        
        
        JButton exitButton = new JButton("X");
        exitButton.setBounds(getWidth()- 50, 2, 50, 25);
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBackground(Color.gray);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        
        
        JButton regButton = new JButton("<html><u>Create an account</u></html>");
        regButton.setBounds(getWidth()- 300, 380, 180, 30);
        regButton.setFont(new Font("Arial", Font.BOLD, 16));
        regButton.setBackground(Color.GRAY);
        regButton.setForeground(Color.WHITE);
        regButton.setFocusable(false);
        regButton.setBorderPainted(false);
        
        JButton LoginButton = new JButton("Login");
        LoginButton.setBounds(getWidth()- 260, 320, 90, 30);
        LoginButton.setFont(new Font("Arial", Font.BOLD, 16));
        LoginButton.setBackground(Color.GRAY);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setFocusable(false);
        LoginButton.setBorderPainted(false);
        
        JButton MinButton = new JButton("--");
        MinButton.setBounds(getWidth()- 105, 2, 50, 25);
        MinButton.setFont(new Font("Arial", Font.BOLD, 20));
        MinButton.setBackground(Color.gray);
        MinButton.setFocusable(false);
        MinButton.setBorderPainted(false);
   
        add(MinButton);
        add(LoginButton);
        add(regButton);
        add(exitButton);
       
        //MouseListener
     
        setupButton(LoginButton);
        setupButton(regButton);
        setupButton(exitButton);
        setupButton(MinButton);
        
     // Add an action listener to the button
        MinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 setState(ICONIFIED);
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
                }
              
            }
        });
        
     // Add an action listener to the button
        regButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegForm();
            }
        });
     

        JLabel User_Txt = new JLabel("USER NAME:");
        User_Txt.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 18));
        User_Txt.setBounds(460, 120, 200, 50);
        User_Txt.setSize(320, 30);
        User_Txt.setForeground(Color.black);
        User_Txt.setOpaque(false);
        add(User_Txt);
        
    	JTextField User_TxtField = new JTextField();
        User_TxtField.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 16));
        User_TxtField.setBounds(460, 160, 260, 30);       
        User_TxtField.setForeground(Color.black);
        User_TxtField.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        add(User_TxtField);
        
        JLabel User_PassTxt = new JLabel("PASSWORD:");
        User_PassTxt.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 18));
        User_PassTxt.setBounds(460, 200, 200, 50);
        User_PassTxt.setSize(320, 30);
        User_PassTxt.setForeground(Color.black);
        User_PassTxt.setOpaque(false);
        add(User_PassTxt);
        
        JPasswordField Pass_Field = new JPasswordField();
        Pass_Field.setBounds(460, 240, 260, 30);       
        Pass_Field.setForeground(Color.black);
        Pass_Field.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 16));
        Pass_Field.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        Pass_Field.setEchoChar('•');
        add(Pass_Field);
        
        JLabel Or_Txt = new JLabel("OR");
        Or_Txt.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 16));
        Or_Txt.setBounds(570, 350, 200, 50);
        Or_Txt.setSize(320, 30);
        Or_Txt.setForeground(Color.black);
        Or_Txt.setOpaque(false);
        add(Or_Txt);
        
        JLabel visitLabel = new JLabel("Visit Us");
        visitLabel.setForeground(Color.black); 
        visitLabel.setBounds(440,435,50,20);
        add(visitLabel);
        
        JLabel insLabel = new JLabel("");
        insLabel.setForeground(Color.GRAY); 
        insLabel.setBounds(460,270,250,20);
        add(insLabel);
        
        

        visitLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://web.facebook.com/KIRUSUCHAN30"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                visitLabel.setText("<html><u><font color='blue'>Visit Us</font></u></html>"); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                visitLabel.setText("Visit Us"); 
            }
        });

        
      
        
        setVisible(true);
        
     // Add a mouse listener to the view icon
        viewResized.addMouseListener(new MouseAdapter() {
            boolean isPasswordVisible = false;
            
            @Override
            public void mouseEntered(MouseEvent e) {               
                ImageIcon viewIconHighlighted = new ImageIcon("see.png");
                ImageIcon viewIconHighlightedResized = new ImageIcon(viewIconHighlighted.getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH));
                viewResized.setIcon(viewIconHighlightedResized);
            }

            @Override
            public void mouseExited(MouseEvent e) {
           
                viewResized.setIcon(viewIconResized);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible;
                Pass_Field.setEchoChar(isPasswordVisible ? '\0' : '•');
            }
        });
        
        
	
     // Add anz action listener to the button
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {            	
    			
            	int a = 0;
              
                
              // Get the values of the username and password fields
                 String username = User_TxtField.getText();
                 String password = new String(Pass_Field.getPassword());
             
                 
                 if (username.isEmpty() || (password.isEmpty())){               	               	
                	 insLabel.setText("User name and/or password missing. Please try again.");
                	 return;              	 
                 }
                 else if(!saved_usernames.contains(username) || !saved_passwords.contains(password)) {
                	 insLabel.setText("This account does not exist.");               	 
                 }
                 else if(saved_usernames.contains(username) && saved_passwords.contains(password)) {
                	for(a = 0; a < saved_usernames.size(); a++) {
 						if(saved_usernames.get(a).equals(username) && saved_passwords.get(a).equals(password)) {
 							break;
 						}
 					}
                	if(a < saved_usernames.size() && saved_usernames.get(a).equals(username) && saved_passwords.get(a).equals(password)) {
                		int selected_index = a;
						new DashBoard(selected_index, saved_firstname, saved_lastname);
						
						dispose();
 					} 
                	else {
                		 insLabel.setText("You have entered a wrong password");
                    	 return;              	 
					
					}
                	
                 }
                 
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
	
