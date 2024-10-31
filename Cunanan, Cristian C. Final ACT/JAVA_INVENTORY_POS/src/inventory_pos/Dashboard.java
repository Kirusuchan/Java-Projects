package inventory_pos;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Dashboard extends JFrame {
	
	ImageIcon Logo = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	
	
	void Dashboard_Table() {
		setSize(700, 500);
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#424242"));
		setResizable(false);
		setTitle("Dashboard");
		setIconImage(Logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon backgroundImage = new ImageIcon("dashboard.png");
        ImageIcon resizedBackgroundImage = new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), java.awt.Image.SCALE_SMOOTH));
        JLabel backgroundLabel = new JLabel(resizedBackgroundImage);
        backgroundLabel.setSize(getWidth(), getHeight());
        setContentPane(backgroundLabel);
        
        JButton POS_BTN = new JButton("Point of Sales");
        POS_BTN.setBounds(getWidth() - 580, 350, 150, 30);
        POS_BTN.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        POS_BTN.setBackground(Color.WHITE);
        POS_BTN.setForeground(Color.BLACK);
        POS_BTN.setFocusable(false);
        POS_BTN.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        POS_BTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JButton INV_BTN = new JButton("Inventory");
        INV_BTN.setBounds(getWidth() - 260, 350, 150, 30);
        INV_BTN.setFont(new Font("Saira Condensed", Font.BOLD, 16));
        INV_BTN.setBackground(Color.WHITE);
        INV_BTN.setForeground(Color.BLACK);
        INV_BTN.setFocusable(false);
        INV_BTN.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        INV_BTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       
       
        add(POS_BTN);
        add(INV_BTN);

        
        setVisible(true);
         
        
        POS_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int Conf = JOptionPane.showConfirmDialog(null, "Proceed to POS?", "POS", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(Conf == JOptionPane.YES_OPTION) {
					POS Main = new POS();
					Main.setVisible(true);
					dispose();
				}
            }
        });

        INV_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// TODO Auto-generated method stub
				int Conf = JOptionPane.showConfirmDialog(null, "Proceed to the inventory?", "Inventory", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(Conf == JOptionPane.YES_OPTION) {
					Table Main = new Table();
					Main.Table_Inventory();
					dispose();
				}
            }
        });

	}
}
