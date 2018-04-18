import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class DoctorDetailsPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorDetailsPage window = new DoctorDetailsPage();
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
	public DoctorDetailsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterDoctorDetails = new JLabel("Enter Doctor Details:");
		lblEnterDoctorDetails.setBounds(152, 20, 142, 16);
		frame.getContentPane().add(lblEnterDoctorDetails);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(42, 62, 104, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Number");
		lblNewLabel_1.setBounds(42, 92, 104, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Degree:");
		lblNewLabel_2.setBounds(42, 123, 104, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Consultancy Fee:");
		lblNewLabel_3.setBounds(42, 151, 132, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email ID:");
		lblNewLabel_4.setBounds(42, 179, 104, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Timings:");
		lblNewLabel_5.setBounds(42, 207, 104, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(200, 57, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 87, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 118, 130, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 146, 130, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(200, 174, 130, 26);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnampmnightShift = new JRadioButton("12am-12pm(Night Shift)");
		rdbtnampmnightShift.setBounds(189, 203, 192, 16);
		frame.getContentPane().add(rdbtnampmnightShift);
		
		JRadioButton rdbtnpmammorningShift = new JRadioButton("12pm-12am(Morning Shift)");
		rdbtnpmammorningShift.setBounds(189, 222, 204, 16);
		frame.getContentPane().add(rdbtnpmammorningShift);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(126, 243, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		
	}
}
