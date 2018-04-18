import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;


public class userCategory extends JFrame
{
	JLabel lb;
	JButton submit;
	JRadioButton rb1,rb2,rb3;
	
	public userCategory(String title)
	{
		super(title);
		lb=new JLabel("Select the category of user:");
		rb1=new JRadioButton("RECEPTION STAFF");
		rb2=new JRadioButton("DOCTOR");
		rb3=new JRadioButton("MANAGEMENT STAFF");
		submit=new JButton("SUBMIT");
		JPanel pan=new JPanel();
		pan.add(lb);
		pan.add(rb1);
		pan.add(rb2);
		pan.add(rb3);
		pan.add(submit);
		setContentPane(pan);
		setLayout(new GridLayout(0,1));
		
	}
	
	public static void main(String[] args) 
	{
		userCategory uc=new userCategory("User Category Page");
		uc.setVisible(true);
		uc.setSize(400,500);
		uc.setResizable(false);

	}

}
