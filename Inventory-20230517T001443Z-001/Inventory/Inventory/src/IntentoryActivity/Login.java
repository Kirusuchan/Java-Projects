package IntentoryActivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener{

	//Global declaration
	
	//Frame
	JFrame frame = new JFrame();
	
	//Username TextField
	JTextField UsernameTXT = new JTextField();
	
	//Password TextField
	JPasswordField PasswordTXT = new JPasswordField();
	
	//Login Button
	JButton Login = new JButton ();

	String user = "admin";
	String pass = "1234";
		Login () {
			
			//JFrame settings
			this.setSize(500,550);
			//this.setUndecorated(true);
			this.setVisible(true);
			this.setTitle("Login");
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ImageIcon image = new ImageIcon("Vector.png");
			ImageIcon resized = new ImageIcon(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),java.awt.Image.SCALE_SMOOTH));
			JLabel BL = new JLabel(resized);
			BL.setSize(this.getWidth(),this.getHeight());
			this.setContentPane(BL);
			
			//Username Textfield settings;
			UsernameTXT.setBounds(135,220,230,30);
			UsernameTXT.setOpaque(false);
			UsernameTXT.setBackground(new Color(0xFFFFFF));
			UsernameTXT.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			
			this.add(UsernameTXT);
			
			//Password Textfield settings;
			PasswordTXT.setBounds(135,285,230,30);
			PasswordTXT.setOpaque(false);
			PasswordTXT.setBackground(new Color(0xFFFFFF));
			PasswordTXT.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			
			this.add(PasswordTXT);
		
			
			//Button settings;
			Login.setBounds(135,340,230,30);
			Login.setOpaque(false);
			Login.setBackground(new Color(0xFFFFFF));
			Login.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			
			this.add(Login);
		
			
			Login.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String User = UsernameTXT.getText();
					String userInputtedPassword = new String(PasswordTXT.getPassword());
					
					 if (User.equals(user) && userInputtedPassword.equals(pass)) {
				            JOptionPane.showMessageDialog(null, "Login successful!");
				            new Dashboard();
				           dispose();
				        } else {
				            JOptionPane.showMessageDialog(null, "Invalid username or password.");
				        }
				}
				
			});
	}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

}
