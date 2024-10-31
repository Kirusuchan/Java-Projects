package IntentoryActivity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class Discount extends JFrame implements ActionListener {
	
	JRadioButton Student = new JRadioButton();
	JRadioButton Senior = new JRadioButton();
	JRadioButton RegularCustomer = new JRadioButton();
	JRadioButton Employee = new JRadioButton();
	ButtonGroup group = new ButtonGroup();
	JLabel dc = new JLabel();
	JButton Ok = new JButton();
	JFrame Dcframe = new JFrame();
public Discount () {
	//JFrame settings
	Dcframe.setSize(400,250);
	//this.setUndecorated(true);
	Dcframe.setVisible(true);
	Dcframe.setTitle("DISCOUNT");
	Dcframe.setLocationRelativeTo(null);
	Dcframe.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	Dcframe.setResizable(false);
	Dcframe.setLayout(null);
	Dcframe.add(Student);
	Dcframe.add(Senior);
	Dcframe.add(RegularCustomer);
	Dcframe.add(Employee);
	Dcframe.add(dc);
	Dcframe.add(Ok);
	group.add(Student);
	group.add(Senior);
	group.add(RegularCustomer);
	group.add(Employee);
	
	
	
	dc.setBounds(100,10,200,50);
	dc.setText("SELECT DISCOUNT");
	dc.setFont(new Font("ARIAL", Font.BOLD, 20));
	
	
	//Student
	Student.setBounds(25,60,130,30);
	Student.setText("Student 3%");
	Student.setFont(new Font("ARIAL", Font.BOLD, 15));
	
	//SENIOR
	Senior.setBounds(25,120,150,30);
	Senior.setText("Senior/ PWD 20%");
	Senior.setFont(new Font("ARIAL", Font.BOLD, 15));
	
	//Regular Customer
	RegularCustomer.setBounds(180,60,200,30);
	RegularCustomer.setText("Regular Customer 25%");
	RegularCustomer.setFont(new Font("ARIAL", Font.BOLD, 15));
	
	//Employee Customer
	Employee.setBounds(180,120,200,30);
	Employee.setText("Employee 15%");
	Employee.setFont(new Font("ARIAL", Font.BOLD, 15));
	
	//OK button
	Ok.setBounds(135,160,100,30);
	Ok.setText("OK");
	Ok.addActionListener(this);
	
	
		}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}




}
