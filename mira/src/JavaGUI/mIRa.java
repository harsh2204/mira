package JavaGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JLayeredPane;
import java.awt.Panel;
import javax.swing.JTabbedPane;

public class mIRa {

	private JFrame frame;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTabbedPane tabbedPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mIRa window = new mIRa();
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
	public mIRa() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 150, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.red);
		
		textField = new JTextField();
		textField.setBounds(155, 6, 119, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmitQuery = new JButton("Submit Query");
		btnSubmitQuery.setBounds(157, 34, 117, 29);
		frame.getContentPane().add(btnSubmitQuery);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 64, 391, 195);
		frame.getContentPane().add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
		
	}
}
