package inventoryJava;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame  {

	String UserName = "admin";
	String PassWord = "admin";
	
	Table_Java myTable = new Table_Java();

	
	public LoginForm() {
		
		setTitle("LOGIN");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
        setLocationRelativeTo(null);
        setUndecorated(false);
        
        // Load the logo image and set it as the icon of the JFrame
        ImageIcon logoImage = new ImageIcon("logo1.png");
        setIconImage(logoImage.getImage());

        // Create a new ImageIcon object with the same size as the JFrame
        ImageIcon backgroundImage = new ImageIcon("finalframelogin.png");
        ImageIcon resizedBackgroundImage = new 		ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), 		getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
        
        
        JButton LoginButton = new JButton("Login");
        LoginButton.setBounds(getWidth()- 300, 320, 90, 30);
        LoginButton.setFont(new Font("Arial", Font.BOLD, 16));
        LoginButton.setBackground(Color.GRAY);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setFocusable(false);
        LoginButton.setBorderPainted(false);
        
        JLabel User_Txt = new JLabel("USER NAME:");
        User_Txt.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 18));
        User_Txt.setBounds(120, 120, 200, 50);
        User_Txt.setSize(320, 30);
        User_Txt.setForeground(Color.black);
        User_Txt.setOpaque(false);
        add(User_Txt);
        
    	JTextField User_TxtField = new JTextField();
        User_TxtField.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 16));
        User_TxtField.setBounds(120, 160, 260, 30);       
        User_TxtField.setForeground(Color.black);
        User_TxtField.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        add(User_TxtField);
        
        JLabel User_PassTxt = new JLabel("PASSWORD:");
        User_PassTxt.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 18));
        User_PassTxt.setBounds(120, 200, 200, 50);
        User_PassTxt.setSize(320, 30);
        User_PassTxt.setForeground(Color.black);
        User_PassTxt.setOpaque(false);
        add(User_PassTxt);
        
        JPasswordField Pass_Field = new JPasswordField();
        Pass_Field.setBounds(120, 240, 260, 30);       
        Pass_Field.setForeground(Color.black);
        Pass_Field.setFont(new Font("Saira Condensed", Font.TRUETYPE_FONT, 16));
        Pass_Field.setBorder(BorderFactory.createLineBorder(Color.gray,2));
        Pass_Field.setEchoChar('•');
        add(Pass_Field);
        
        
        JLabel insLabel = new JLabel("");
        insLabel.setForeground(Color.GRAY); 
        insLabel.setBounds(120,270,250,20);
        add(insLabel);
        
        add(LoginButton);
        this.setVisible(true);
       
        //MouseListener
     
        setupButton(LoginButton);
        
        LoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 // Get the values of the username and password fields
                String username = User_TxtField.getText();
                String password = new String(Pass_Field.getPassword());
                
                if (username.isEmpty() || (password.isEmpty())){               	               	
               	 insLabel.setText("User name and/or password missing. Please try again.");
               	 return;              	 
                }
                
             // Check if the values of the username and password match
                if (UserName.equals(username) && PassWord.equals(password)) {
                    
               	 JOptionPane.showMessageDialog(LoginForm.this, "Login successful!");
               	 
               	 new Table_Java();
               	 dispose();
                    
                } else {
               	 insLabel.setText("Incorrect username or password.");                	
                    return;
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
