package room;

import java.awt.EventQueue;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import com.mysql.jdbc.Connection;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.sql.*;


public class AddOrRemoveRoom {

	private JFrame frame;
	private JTable table;
	private JTextField txtRoomno;
	private JTextField txtRoomCategory;
	private JTextField txtRoomCharges;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddOrRemoveRoom window = new AddOrRemoveRoom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection connection=null;
	
	
	public AddOrRemoveRoom() {
		connection = DConnection.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(182, 218, -139, -122);
		frame.getContentPane().add(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(282, 76, 277, 250);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnLoadDatabase = new JButton("Load Database");
		btnLoadDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query ="select * from room";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					pst.close();
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnLoadDatabase.setBounds(415, 27, 122, 23);
		frame.getContentPane().add(btnLoadDatabase);
		
		txtRoomno = new JTextField();
		txtRoomno.setText("");
		txtRoomno.setBounds(124, 28, 116, 22);
		frame.getContentPane().add(txtRoomno);
		txtRoomno.setColumns(10);
		
		JLabel lblRoomno = new JLabel("Room_No");
		lblRoomno.setBounds(22, 31, 56, 16);
		frame.getContentPane().add(lblRoomno);
		
		JLabel lblRoomCategory = new JLabel("Room Category");
		lblRoomCategory.setBounds(22, 75, 88, 16);
		frame.getContentPane().add(lblRoomCategory);
		
		txtRoomCategory = new JTextField();
		txtRoomCategory.setText("");
		txtRoomCategory.setBounds(124, 74, 116, 22);
		frame.getContentPane().add(txtRoomCategory);
		txtRoomCategory.setColumns(10);
		
		JLabel lblRoomCharges = new JLabel("Room Charges");
		lblRoomCharges.setBounds(22, 112, 88, 25);
		frame.getContentPane().add(lblRoomCharges);
		
		txtRoomCharges = new JTextField();
		txtRoomCharges.setText("");
		txtRoomCharges.setBounds(124, 113, 116, 22);
		frame.getContentPane().add(txtRoomCharges);
		txtRoomCharges.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query ="insert into room (room_number,room_category,room_charges) values (?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,txtRoomno.getText());
					pst.setString(2,txtRoomCategory.getText());
					pst.setString(3,txtRoomCharges.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null,"Data added to table");
					txtRoomno.setText("");
					txtRoomCategory.setText("");
					txtRoomCharges.setText("");
					pst.close();
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(22, 188, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query ="select room_number,room_category,room_charges from room where room_number = " + txtRoomno.getText() ;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
						String delquery ="delete from room where room_number = " + txtRoomno.getText() ;
						PreparedStatement pst1 = connection.prepareStatement(delquery);
						pst1.execute();
						JOptionPane.showMessageDialog(null,"Room delted");
					}
						
					else
						JOptionPane.showMessageDialog(null,"Room does not exist in the hospital","warning",JOptionPane.ERROR_MESSAGE);
					txtRoomno.setText("");
					txtRoomCategory.setText("");
					txtRoomCharges.setText("");
					rs.close();
					pst.close();
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			});
		btnRemove.setBounds(150, 188, 97, 25);
		frame.getContentPane().add(btnRemove);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(88, 235, 97, 25);
		frame.getContentPane().add(btnBack);
		
		JButton btnFindButton = new JButton("Find");
		btnFindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query ="select room_number,room_category,room_charges from room where room_number =" + txtRoomno.getText() ;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null,"Room exist in the hospital");
						txtRoomCategory.setText(rs.getString("room_category"));
						txtRoomCharges.setText(String.valueOf((rs.getInt("room_charges"))));
					}
						
					else
						JOptionPane.showMessageDialog(null,"Room does not exist in the hospital","warning",JOptionPane.ERROR_MESSAGE);
					rs.close();
					pst.close();
					
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnFindButton.setBounds(255, 26, 117, 25);
		frame.getContentPane().add(btnFindButton);
	}
}
