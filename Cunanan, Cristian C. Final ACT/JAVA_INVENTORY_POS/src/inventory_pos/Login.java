package inventory_pos;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class Login extends JFrame implements ActionListener{
	
	String FinalUser_Name = "admin", Password_String = "admin";
	
	JTextField User_Name = new JTextField();
	JPasswordField User_Pass = new JPasswordField();
	JButton Login = new JButton();
	
	ImageIcon LogoImage = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	Toolkit toolkit = getToolkit();
	Dimension SizeDimension = toolkit.getScreenSize();
	
	void LOGIN_MAIN (){	
		setSize(500, 500);
		setLocation(SizeDimension.width/2 - getWidth()/2, SizeDimension.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#424242"));
		setResizable(false);
		setTitle("Account Login");
		setIconImage(LogoImage.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon backgroundImage = new ImageIcon("BG.png");
        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);

		JLabel User_NameText = new JLabel();
		User_NameText.setBounds(180, 130, 250, 50);
		User_NameText.setText("USERNAME");
		User_NameText.setFont(new Font("Saira Condensed", Font.BOLD, 20));
		User_NameText.setForeground(Color.black);
		
		User_Name.setBounds(120, 170, 240, 35);
		User_Name.setFont(new Font("Saira Condensed", Font.PLAIN, 18));
		User_Name.setBackground(null);
		User_Name.setForeground(Color.black);
		User_Name.setCaretColor(Color.black);
		User_Name.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
				
		JLabel PassText = new JLabel();	
		PassText.setBounds(180, 200, 250, 50);
		PassText.setText("PASSWORD");
		PassText.setFont(new Font("Saira Condensed", Font.BOLD, 20));
		PassText.setForeground(Color.black);
		
		User_Pass.setBounds(120, 240, 240, 35);
		User_Pass.setFont(new Font("Saira Condensed", Font.BOLD, 18));
		User_Pass.setBackground(null);
		User_Pass.setForeground(Color.black);
		User_Pass.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		User_Pass.setCaretColor(Color.black);
		
		
		Login.setText("LOGIN");
		Login.setBounds(140, 300, 200, 35);
		Login.setFont(new Font("Saira Condensed", Font.BOLD, 16));
		Login.setForeground(Color.black);
		Login.setBackground(Color.decode("#FFCEB4"));
		Login.setOpaque(true);
		Login.setBorder(null);
		Login.setFocusable(false);
		Login.addActionListener(this);
		Login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//Add
		add(User_NameText);
		add(User_Name);
		add(PassText);
		add(User_Pass);
		add(Login);
		setLayout(null);
		setVisible(true);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == Login) {
			if((User_Name.getText().equals(null) || User_Name.getText().equals("")) && (new String(User_Pass.getPassword()).equals(null) || new String(User_Pass.getPassword()).equals(""))) {
				JOptionPane.showMessageDialog(this, "Please enter your Username and password", "Please try again", JOptionPane.WARNING_MESSAGE);
			} else if(User_Name.getText().equals(null) || User_Name.getText().equals("")){
				JOptionPane.showMessageDialog(this, "Please enter your Username", "Please try again", JOptionPane.WARNING_MESSAGE);
			} else if(new String(User_Pass.getPassword()).equals(null) || new String(User_Pass.getPassword()).equals("")){
				JOptionPane.showMessageDialog(this, "Please enter your password", "Please try again", JOptionPane.WARNING_MESSAGE);
			} else if(User_Name.getText().equals(FinalUser_Name) && new String(User_Pass.getPassword()).equals(Password_String)) {
				JOptionPane.showMessageDialog(this, "Successfully Logged In!", "Successful Login", JOptionPane.INFORMATION_MESSAGE);
				Dashboard dashboard = new Dashboard();
				dashboard.Dashboard_Table();
				dispose();
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect Username or password", "Incorrect Account Details", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
