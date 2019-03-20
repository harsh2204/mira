package JavaGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
<<<<<<< HEAD
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
=======
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
>>>>>>> 77dd795d00dbca8e28a0fd95dc0eaeddcfd9c1c6

public class mIRa {

	private JFrame frame;
	private JTextField txtEnterTheDrugs;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTabbedPane tabbedPane_1;
	private JLabel lblNewLabel;

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
		frame.getContentPane().setBackground(new Color(204, 153, 153));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(mIRa.class.getResource("/JavaGUI/resources/pill.png")));
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(150, 150, 759, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.gray);
		
<<<<<<< HEAD
		txtEnterTheDrugs = new JTextField();
		txtEnterTheDrugs.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		txtEnterTheDrugs.setText("enter the drug's name here");
		txtEnterTheDrugs.setForeground(new Color(211, 211, 211));
		txtEnterTheDrugs.setBounds(15, 85, 707, 40);
		frame.getContentPane().add(txtEnterTheDrugs);
		txtEnterTheDrugs.setColumns(10);
		
		JButton btnSubmitQuery = new JButton("submit");
		btnSubmitQuery.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 18));
		btnSubmitQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmitQuery.setForeground(new Color(0, 0, 0));
		btnSubmitQuery.setBounds(279, 141, 180, 29);
=======
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel label = new JLabel("Top 3 Drugs:");
				panel.add(label);
				frame.setVisible(true);
				
				
			}
		});
		textField.setBounds(155, 6, 119, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmitQuery = new JButton("submit");
		btnSubmitQuery.setBounds(157, 34, 117, 29);
>>>>>>> 77dd795d00dbca8e28a0fd95dc0eaeddcfd9c1c6
		frame.getContentPane().add(btnSubmitQuery);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		tabbedPane.setBounds(15, 180, 707, 365);
		frame.getContentPane().add(tabbedPane);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("drug info", null, tabbedPane_1, null);
		
		panel = new JPanel();
<<<<<<< HEAD
		panel.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("reviews", null, panel, null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(mIRa.class.getResource("/JavaGUI/resources/logo2.PNG")));
		lblNewLabel.setBounds(279, 0, 180, 69);
		frame.getContentPane().add(lblNewLabel);
=======
		tabbedPane.addTab("drugs", null, panel, null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("reviews", null, tabbedPane_1, null);
>>>>>>> 77dd795d00dbca8e28a0fd95dc0eaeddcfd9c1c6
		
	}
}






/* TEST CODE FOR GUI */
/* ................. */
/* ................. */
/* ................. */
/* ................. */
/* ................. */
/* ................. */
/* ................. */
/* ................. */
/* TEST CODE FOR GUI */
















