package inventory_pos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Discount extends JFrame{
	ImageIcon Logo = new ImageIcon(new ImageIcon("Logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	
	private POS main;
	
	public Discount(POS main) {
        this.main = main;
    }
	
	JButton Ok_Btn;
	JRadioButton[] Radio_Buttons = new JRadioButton[5];
	String[] Rad = {
		"None(0%)",
		"Student(3%)",
		"Regular Customer(25%)",
		"Senior/PWD(20%)",
		"Employee(15%)",
	};
	ButtonGroup Btn_Group = new ButtonGroup();
	
	public void Discount_Design() {
		setSize(500, 300);
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
		
		JLabel Discount_Text = new JLabel("CHOOSE DISCOUNT");
		Discount_Text.setFont(new Font("Saira Condensed", Font.BOLD, 30));
		Discount_Text.setForeground(Color.black);
		Discount_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Discount_Text.setOpaque(false);
		Discount_Text.setBackground(null);
		Discount_Text.setBounds(4, 0, 470, 53);
		
		JLabel Label1 = new JLabel();
		Label1.setOpaque(true);
		Label1.setBackground(Color.decode("#FFD05B"));
		Label1.setBounds(0, 0, 496, 51);
		
		JLabel Holder = new JLabel();
		Holder.setOpaque(true);
		Holder.setBackground(Color.decode("#FFD05B"));
		Holder.setBounds(4, 4, 492, 292);
		
		int x = 20, y = 70;
		int width = 250, height = 40;
		int gap = 15;

		for (int i = 0; i < Radio_Buttons.length; i++) {
		    Radio_Buttons[i] = new JRadioButton(Rad[i]);
		    Radio_Buttons[i].setFont(new Font("Saira Condensed", Font.BOLD, 16));
		    Radio_Buttons[i].setForeground(Color.black);
		    Radio_Buttons[i].setFocusable(false);
		    Radio_Buttons[i].setOpaque(false);
		    Radio_Buttons[i].setBackground(null);
		    if (i == 4) {
		        Radio_Buttons[i].setBounds(((getWidth() - width) / 2) + 35, y + 2 * (height + gap), width, height);
		    } else {
		        Radio_Buttons[i].setBounds(x + ((i % 2) * (width + gap)), y + ((i / 2) * (height + gap)), width, height);
		    }
		    Btn_Group.add(Radio_Buttons[i]);
		    Holder.add(Radio_Buttons[i]);
		}	
		
		Radio_Buttons[0].setSelected(true);
		
		
	    
		Ok_Btn = new JButton("Okay");
		Ok_Btn.setBounds(140, 235, 200, 35);
		Ok_Btn.setFont(new Font("Saira Condensed", Font.BOLD, 12));
		Ok_Btn.setForeground(Color.black);
		Ok_Btn.setBackground(Color.WHITE);
		Ok_Btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		Ok_Btn.setFocusable(false);
		Ok_Btn.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.updateTotal();
				main.setEnabled(true);
				setVisible(false);
			}
			
		});
		
		Ok_Btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		
		add(Holder);
		Holder.add(Ok_Btn);
		Holder.add(Label1);
		Label1.add(Discount_Text);
		setLayout(null);
		setVisible(true);
	}
}
