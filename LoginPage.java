package login;

import javax.swing.*;
import com.mysql.jdbc.Connection;
import room.DConnection;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class LoginPage extends JFrame implements ActionListener {
	JLabel info,uname,pass;
	JButton login,register;
	JTextField username;JPasswordField password;	
	Connection connection = DConnection.dbConnector();
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
		login.addActionListener(this);
		register.addActionListener(this);
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
	public void actionPerformed(ActionEvent evt)
	{
		String uname=username.getText();		
		char pass[]=password.getPassword();
		String passw=Arrays.toString(pass);		
		try{
			if(evt.getSource()==register)
			{
				//move to userCategory Page and type is reception staff and managment staff then
				String selectquery = "Select * from users where user_id = '"+uname+"'";
				PreparedStatement pst1 = connection.prepareStatement(selectquery);
				ResultSet rs = pst1.executeQuery();
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"user exist already","warning",JOptionPane.ERROR_MESSAGE);
					pst1.close();
				}
				else
				{
					String insertquery ="insert into users (user_id,password) values (?,?)";					
					PreparedStatement pst = connection.prepareStatement(insertquery);
					pst.setString(1,username.getText());
					pst.setString(2,passw);
					pst.execute();
					JOptionPane.showMessageDialog(null,"Registerd Successfully","information",JOptionPane.INFORMATION_MESSAGE);
					username.setText("");
					password.setText("");
					pst.close();
				}								
			}
			if(evt.getSource()==login)
			{	
				String query ="Select * from users where user_id = '"+uname+"' and password = '"+passw+"'";                     
				PreparedStatement pst = connection.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"Login success!!Welcome to HMS","information",JOptionPane.INFORMATION_MESSAGE);
					username.setText("");
					password.setText("");
				}
				else
					JOptionPane.showMessageDialog(null,"Invalid password! IF not a member please regsiter","warning",JOptionPane.ERROR_MESSAGE);
				
				pst.close();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		LoginPage lp=new LoginPage("Login Page");
		lp.setVisible(true);
		lp.setSize(5000,7000);
		//lp.setResizable(false);
	}
}