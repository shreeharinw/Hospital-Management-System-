import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class AdminPage {

	private JFrame frmWelcomeAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.frmWelcomeAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomeAdmin = new JFrame();
		frmWelcomeAdmin.setResizable(false);
		frmWelcomeAdmin.setTitle("Welcome Admin!");
		frmWelcomeAdmin.setBounds(100, 100, 450, 300);
		frmWelcomeAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnAddremoveDoctor = new JButton("Add/Remove Doctor");
		
		JButton btnAddremoveRooms = new JButton("Add/Remove Rooms");
		
		JButton btnAddremoveOperator = new JButton("Add/Remove Operator");
		
		JLabel lblNewLabel = new JLabel("Choose an operation:");
		GroupLayout groupLayout = new GroupLayout(frmWelcomeAdmin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(148)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddremoveDoctor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(btnAddremoveRooms, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnAddremoveOperator))
					.addContainerGap(155, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addGap(32)
					.addComponent(btnAddremoveDoctor)
					.addGap(18)
					.addComponent(btnAddremoveRooms)
					.addGap(18)
					.addComponent(btnAddremoveOperator)
					.addContainerGap(94, Short.MAX_VALUE))
		);
		frmWelcomeAdmin.getContentPane().setLayout(groupLayout);
	}
}
