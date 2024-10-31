package javaSwingLoginForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RegForm extends JFrame {

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
	
	private static void write(ArrayList<String> dataList, String fileName) {
	    try {
	        File file = new File(fileName);
	        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // append data to end of file
	        for (String data : dataList) {
	            writer.write(data);
	            writer.newLine();
	        }
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	ArrayList<String> saved_usernames, saved_passwords;
	ArrayList<String> saved_firstname, saved_lastname;
	JPasswordField Pass_word =  new JPasswordField();
	JTextField User_NameTxtField =  new JTextField();
	JLabel ins1 = new JLabel("*Must be atleast 8 characters");
		 
		RegForm() {
		saved_usernames = new ArrayList<String>();
		saved_passwords = new ArrayList<String>();
		saved_firstname = new ArrayList<String>();
		saved_lastname = new ArrayList<String>();
		
		read(saved_usernames, "Usernames.txt");
		
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
        ImageIcon backgroundImage = new ImageIcon("regform.png");
        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(),getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(),getHeight());
        setContentPane(backgroundLabel);
        
        ImageIcon viewIcon = new ImageIcon("eyesee.png");
        ImageIcon viewIconResized = new ImageIcon(viewIcon.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        JLabel viewResized = new JLabel(viewIconResized);
        viewResized.setBounds(530, 320, 30, 30);
        add(viewResized);
              
        JButton exitButton = new JButton("X");
        exitButton.setBounds(getWidth()- 65, 2, 50, 25);
        exitButton.setFont(new Font("Arial", Font.BOLD, 20));
        exitButton.setBackground(Color.gray);
        exitButton.setFocusable(false);
        exitButton.setBorderPainted(false);
        
        JButton backButton = new JButton("<--");
        backButton.setBounds(getWidth()- 185, 2, 60, 25);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.setBackground(Color.gray);
        backButton.setFocusable(false);
        backButton.setBorderPainted(false);
        
        JButton MinButton = new JButton("--");
        MinButton.setBounds(getWidth()- 120, 2, 50, 25);
        MinButton.setFont(new Font("Arial", Font.BOLD, 20));
        MinButton.setBackground(Color.gray);
        MinButton.setFocusable(false);
        MinButton.setBorderPainted(false);
               
        JLabel Last_NameTxt = new JLabel("Last Name:");
        Last_NameTxt.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        Last_NameTxt.setBounds(360, 90, 200, 50);
        Last_NameTxt.setSize(320, 30);
        Last_NameTxt.setForeground(Color.white);
        Last_NameTxt.setOpaque(false);
        add(Last_NameTxt);
        
        JTextField LastName_TxtField =  new JTextField();
        LastName_TxtField.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        LastName_TxtField.setBounds(360, 120, 150, 30);       
        LastName_TxtField.setForeground(Color.black);
        add(LastName_TxtField);
        
        JLabel First_NameTxt = new JLabel("First Name:");
        First_NameTxt.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        First_NameTxt.setBounds(580, 90, 200, 50);
        First_NameTxt.setSize(320, 30);
        First_NameTxt.setForeground(Color.white);
        First_NameTxt.setOpaque(false);
        add(First_NameTxt);
        
        JTextField FirstName_TxtField =  new JTextField();
        FirstName_TxtField.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        FirstName_TxtField.setBounds(580, 120, 150, 30);       
        FirstName_TxtField.setForeground(Color.black);
        add(FirstName_TxtField);
        
        JLabel User_NameTxt = new JLabel("Create User Name:");
        User_NameTxt.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        User_NameTxt.setBounds(470, 200, 200, 50);
        User_NameTxt.setSize(320, 30);
        User_NameTxt.setForeground(Color.white);
        User_NameTxt.setOpaque(false);
        add(User_NameTxt);
        
        User_NameTxtField.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        User_NameTxtField.setBounds(470, 230, 150, 30);       
        User_NameTxtField.setForeground(Color.black);
        add(User_NameTxtField);
        
        JLabel Password_Txt = new JLabel("Create Password:");
        Password_Txt.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        Password_Txt.setBounds(360, 290, 200, 50);
        Password_Txt.setSize(320, 30);
        Password_Txt.setForeground(Color.white);
        Password_Txt.setOpaque(false);
        add(Password_Txt);             
        
        JLabel Password_Txt2 = new JLabel("Confirm Password:");
        Password_Txt2.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        Password_Txt2.setBounds(580, 290, 200, 50);
        Password_Txt2.setSize(320, 30);
        Password_Txt2.setForeground(Color.white);
        Password_Txt2.setOpaque(false);
        add(Password_Txt2);
        
        JPasswordField Password_Confirm =  new JPasswordField();
        Password_Confirm.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        Password_Confirm.setBounds(580, 320, 150, 30);       
        Password_Confirm.setForeground(Color.black);
        add(Password_Confirm);
        
        Pass_word.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        Pass_word.setBounds(360, 320, 150, 30);
        Pass_word.setForeground(Color.black);
        add(Pass_word);
               
        ins1.setFont(new Font("Saira Condensed", Font.BOLD, 10));
        ins1.setBounds(360, 340, 200, 50);
        ins1.setSize(320, 30);
        ins1.setForeground(Color.white);
        ins1.setOpaque(false);
        add(ins1);
     
        JButton CreateButton = new JButton("Create Account");
        CreateButton.setBounds(getWidth()- 360, 400, 220, 25);
        CreateButton.setFont(new Font("Arial", Font.BOLD, 20));
        CreateButton.setBackground(Color.GRAY);
        CreateButton.setForeground(Color.WHITE);
        CreateButton.setFocusable(false);
        CreateButton.setBorderPainted(false);
        
        JButton BacktoLoginButton = new JButton("Back to Login");
        BacktoLoginButton.setBounds(getWidth()- 360, 450, 220, 25);
        BacktoLoginButton.setFont(new Font("Arial", Font.BOLD, 20));
        BacktoLoginButton.setBackground(Color.GRAY);
        BacktoLoginButton.setForeground(Color.WHITE);
        BacktoLoginButton.setFocusable(false);
        BacktoLoginButton.setBorderPainted(false);
        
        add(BacktoLoginButton);
        add(CreateButton);
        add(MinButton);
        add(backButton);
        add(exitButton);
        
        //sets the button hover
        setupButton(CreateButton);
        setupButton(MinButton);
        setupButton(exitButton);
        setupButton(BacktoLoginButton);
        setupButton(backButton);
        
        
        setVisible(true);
        
        // Action listener for checking if password field meets 8 characters
        Pass_word.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPasswordLength();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPasswordLength();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPasswordLength();
            }

            private void checkPasswordLength() {
                if (Pass_word.getPassword().length >= 8) {
                    ins1.setForeground(Color.GREEN);
                } else {
                    ins1.setForeground(Color.WHITE);
                }
            }
        });
     // Add an action listener to the button
        MinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 setState(Frame.ICONIFIED);
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
        
        //Action listener for back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	dispose();
            	new LoginForm();
            }
        });

        // Add a mouse listener to the view icon
        viewResized.addMouseListener(new MouseAdapter() {
            boolean isPasswordVisible = false;
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the view icon to its highlighted color version
                ImageIcon viewIconHighlighted = new ImageIcon("eyesee.png");
                ImageIcon viewIconHighlightedResized = new ImageIcon(viewIconHighlighted.getImage().getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH));
                viewResized.setIcon(viewIconHighlightedResized);
            }

            @Override
            public void mouseExited(MouseEvent e) {            
                viewResized.setIcon(viewIconResized);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                isPasswordVisible = !isPasswordVisible; 
                Password_Confirm.setEchoChar(isPasswordVisible ? '\0' : '•');
                Pass_word.setEchoChar(isPasswordVisible ? '\0' : '•');
            }
        });
       
     //  action listener for back to login button
        BacktoLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         	
            	dispose();
            	new LoginForm();	
            }
        });
        
    
                           
        // Add an action listener to the button
        CreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	String username = User_NameTxtField.getText();
            	String password = new String(Pass_word.getPassword());
            	
            	String password2 = new String(Password_Confirm.getPassword());
            	
            	String firstName = FirstName_TxtField.getText();
            	String lastName = LastName_TxtField.getText();
            	
            	if (!password.equals(password2)) {
                    JOptionPane.showMessageDialog(null,"The passwords you entered do not match. Please try again", "ERROR!",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            	 
            	else if (username.isEmpty() || password.isEmpty() || password2.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            		 JOptionPane.showMessageDialog(null, "Please fill in all the fields to proceed.", "Missing Information", JOptionPane.WARNING_MESSAGE);
            		 return;
            	}
            	
            	else if (password.length() < 8 && password2.length() < 8) {
            	    JOptionPane.showMessageDialog(null, "The password must be at least 8 characters long.", "Invalid Password", JOptionPane.WARNING_MESSAGE);
            	    return;
            	}
            	
            	else if (firstName.matches(".*\\d.*") || lastName.matches(".*\\d.*")) {
                    JOptionPane.showMessageDialog(null, "First name and Last name cannot contain numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            	else if(saved_usernames.contains(username)) {
            		JOptionPane.showMessageDialog(null, "This account already exists.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            	}
            	
            	else if(!password.matches("^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*\\d+)[a-zA-Z0-9]{8,}$")) {
				JOptionPane.showMessageDialog(null, "The input password should contain at least digits, lowercase and uppercase letters.", "Error", JOptionPane.ERROR_MESSAGE);
            	}
            	
            	else if(password.equals(password2)) {
            		int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to create this account?","Confirmation",dialogButton);
                    if(dialogResult == JOptionPane.YES_OPTION){
                    	saved_usernames.clear();
                    	saved_passwords.clear();
                    	saved_firstname.clear();
                    	saved_lastname.clear();
                    	
                    	saved_usernames.add(username);
                    	saved_passwords.add(password);
                    	saved_firstname.add(firstName);
                    	saved_lastname.add(lastName);
                    	
                    	write(saved_usernames, "Usernames.txt");
                    	write(saved_passwords, "Passwords.txt");
                    	write(saved_firstname, "Firstnames.txt");
                    	write(saved_lastname, "lastnames.txt");
                    	
                        
                    	User_NameTxtField.setText("");
                    	Pass_word.setText("");
                    	Password_Confirm.setText("");
                    	FirstName_TxtField.setText("");
                    	LastName_TxtField.setText("");
                    	
                    	JOptionPane.showMessageDialog(null, "Your account is successfully created.", "Account Creation", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                    	
                    }
            	}
            	else {
            		
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

		
		

        	

