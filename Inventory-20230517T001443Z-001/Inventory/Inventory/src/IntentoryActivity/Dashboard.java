package IntentoryActivity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Dashboard extends JFrame {
	
	//Global declaration
		//Frame
		JFrame frame = new JFrame();
		
		//Buttons
		
		JButton Inventory = new JButton();
		JButton POS = new JButton();
		
		
		Dashboard() {
			//JFrame settings
			this.setSize(470,380);

			this.setVisible(true);
			this.setTitle("Dashboard");
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setLayout(null);
			ImageIcon image = new ImageIcon("7Evelyn.png");
			ImageIcon resized = new ImageIcon(image.getImage().getScaledInstance(this.getWidth(),this.getHeight(),java.awt.Image.SCALE_SMOOTH));
			JLabel BL = new JLabel(resized);
			BL.setSize(this.getWidth(),this.getHeight());
			this.setContentPane(BL);
			
			
			
			
			
			
			//POS BUTTON settings;
			POS.setBounds(38,98,186,186);
			POS.setOpaque(false);
			POS.setBackground(new Color(0xFFFFFF));
			POS.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			
			this.add(POS);
			
			//INVENTORY BUTTON settings;
			Inventory.setBounds(246,98,186,186);
			Inventory.setOpaque(false);
			Inventory.setBackground(new Color(0xFFFFFF));
			Inventory.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			
			this.add(Inventory);
		
			
			POS.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new PointOfSale();
					
				}
				
			});
			
			Inventory.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new Inventory();
				}
				
			});
		}
}
