import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class LoginPage extends JFrame {
	JLabel info,uname,pass;
	JButton login,register;
	JTextField username;JPasswordField password;
	
	public LoginPage(String title)
	{
		super(title);
		info=new JLabel("Enter login details");
		login=new JButton("LOGIN");
		register=new JButton("REGISTER");
		uname=new JLabel("Username:");
		pass=new JLabel("Password:");
		username=new JTextField(20);
		password=new JPasswordField(10);
		password.setEchoChar('*');
		
		JPanel pan=new JPanel();
		pan.add(info);
		pan.add(uname);
		pan.add(username);
		pan.add(pass);
		pan.add(password);
		pan.add(login);
		pan.add(register);
		setContentPane(pan);
		setLayout(new GridLayout(0,1));
		
	}
	
	public static void main(String[] args) 
	{
		LoginPage lp=new LoginPage("Login Page");
		lp.setVisible(true);
		lp.setSize(500,700);
		lp.setResizable(false);
	}

}
