package room;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DoctorFeesUpdate {

	private JFrame frame;
	private JTable table;
	private JTextField textFielPatientID;
	private JTextField textFieldFees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorFeesUpdate window = new DoctorFeesUpdate();
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
	
	public DoctorFeesUpdate() {
		connection = DConnection.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 6, 574, 156);
		frame.getContentPane().add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblPatientID = new JLabel("Patient ID");
		lblPatientID.setBounds(10, 194, 56, 16);
		frame.getContentPane().add(lblPatientID);
		
		textFielPatientID = new JTextField();
		textFielPatientID.setBounds(110, 191, 116, 22);
		frame.getContentPane().add(textFielPatientID);
		textFielPatientID.setColumns(10);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setBounds(10, 234, 56, 16);
		frame.getContentPane().add(lblFees);
		
		textFieldFees = new JTextField();
		textFieldFees.setBounds(110, 234, 116, 22);
		frame.getContentPane().add(textFieldFees);
		textFieldFees.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String query ="select pat_id  from patient where pat_id  = " + textFielPatientID.getText() ;
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					if(rs.next()){						
						String updatequery ="update patient set fees = " + textFieldFees.getText() + " where pat_id = " + textFielPatientID.getText() ;
						PreparedStatement pst1 = connection.prepareStatement(updatequery);
						pst1.execute();
						JOptionPane.showMessageDialog(null,"Patient Details Updated");
						pst1.close();
					}
						
					else
						JOptionPane.showMessageDialog(null,"Patient Doesn't Exist","warning",JOptionPane.ERROR_MESSAGE);
					textFielPatientID.setText("");
					textFieldFees.setText("");					
					rs.close();
					pst.close();
					
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(71, 287, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnLoadPatientDetails = new JButton("Load Patient Details");
		btnLoadPatientDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query ="select * from patient";
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
		btnLoadPatientDetails.setBounds(358, 206, 188, 37);
		frame.getContentPane().add(btnLoadPatientDetails);
	}

}
