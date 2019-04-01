package JavaGUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mira.Condition;
import mira.Drug;
import mira.Parse;
import mira.Review;
import search.BinarySearch;
import search.Trie;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;

public class mIRa {

	private JFrame frame;
	private JTextField txtEnterTheDrugs;
	private JTabbedPane tabbedPane;
	private JLabel lblNewLabel;
	private static Trie t;
	private static List<Condition> l;
	private JPanel drugPane;
	private JScrollPane scrollPane;
	private JPanel reviewPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t = new Trie();
					l = Parse.loadData();
					for (int i = 0; i < l.size(); i++) {
						Condition condition = l.get(i);
//		    			System.out.println("["+i+"] "+condition.getName() +" : "+ condition.getDrugs().size());
						t.insert(condition.getName());
					}
//					List<String> a= t.autocomplete("B");
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
	public static String upperCaseWords(String sentence) {
        String words[] = sentence.replaceAll("\\s+", " ").trim().split(" ");
        String newSentence = "";
        for (String word : words) {
            for (int i = 0; i < word.length(); i++)
                newSentence = newSentence + ((i == 0) ? word.substring(i, i + 1).toUpperCase(): 
                    (i != word.length() - 1) ? word.substring(i, i + 1).toLowerCase() : word.substring(i, i + 1).toLowerCase().toLowerCase() + " ");
        }

        return newSentence;
    }
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(mIRa.class.getResource("/JavaGUI/resources/pill.png")));
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(150, 150, 759, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.gray);


		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		tabbedPane.setBounds(15, 180, 707, 365);
		frame.getContentPane().add(tabbedPane);

		
		JPanel conditionPane = new JPanel();
		tabbedPane.addTab("Condition", null, conditionPane, null);
		conditionPane.setLayout(new BoxLayout(conditionPane, BoxLayout.Y_AXIS));
		
		drugPane = new JPanel();
		tabbedPane.addTab("Drugs", null, drugPane, null);
		drugPane.setLayout(new BoxLayout(drugPane, BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		tabbedPane.addTab("Reviews", null, scrollPane, null);
		
		reviewPane = new JPanel();
		scrollPane.setViewportView(reviewPane);
		reviewPane.setLayout(new BoxLayout(reviewPane, BoxLayout.Y_AXIS));

		txtEnterTheDrugs = new JTextField();
		txtEnterTheDrugs.getDocument().addDocumentListener(new DocumentListener() {
			// implement the methods
			public void changedUpdate(DocumentEvent e) {
				warn();
			}

			public void removeUpdate(DocumentEvent e) {
			    warn();
			}

			public void insertUpdate(DocumentEvent e) {
			    warn();
			}

			public void warn() {
				String search = txtEnterTheDrugs.getText();
				conditionPane.removeAll();
				if(search.length() != 0) {
					if(tabbedPane.getSelectedIndex() != 0) {
						tabbedPane.setSelectedIndex(0);
					}
					search = upperCaseWords(search).trim();
					List<String> a = t.autocomplete(search);
					System.out.println("SEARCH: \""+search + "\" Autocomplete Size: "+ a.size());
					for (String string : a) {
						JLabel j = new JLabel(string);
						j.setFont(new Font("Calibri", Font.BOLD, 20));
						j.addMouseListener(new MouseAdapter()  
						{  
						    public void mouseClicked(MouseEvent e)  
						    {  
//						    	System.out.println("Clicked: " + string + "!");
//						    	conditionPane.removeAll();
						    	tabbedPane.setSelectedIndex(1);
						    	int index = BinarySearch.linSearch_C(l, string);
						    	Condition c = l.get(index);
						    	drugPane.removeAll();
						    	for (Comparable drug : c.getDrugs()) {
						    		Drug d = (Drug) drug;
						    		JLabel k = new JLabel(d.getName());
									k.setFont(new Font("Calibri", Font.BOLD, 20));
									drugPane.add(k);
									k.addMouseListener(new MouseAdapter()  
									{  
									    public void mouseClicked(MouseEvent e)  
									    {  
									    	reviewPane.removeAll();
									    	tabbedPane.setSelectedIndex(2);
									    	for (Comparable review : d.getReviews()) {
									    		Review r = (Review) review;
									    		
									    		String rTitle = "Review:";
									    		JLabel title = new JLabel(rTitle);
									    		title.setFont(new Font("Calibri", Font.BOLD, 25));
									    		reviewPane.add(title);
									    		
									    		JLabel star = new JLabel(""+r.getSrating());
									    		star.setIcon(new ImageIcon(mIRa.class.getResource("/JavaGUI/resources/gstar.png")));
									    		star.setAlignmentX(Component.LEFT_ALIGNMENT);
									    		reviewPane.add(star);
									    		
//									    		JLabel l = new JLabel("<html><br><html>");
//									    		reviewPane.add(l);
									    		
									    		String toSay = "The reviwer's experience:";
									    		JLabel say = new JLabel(toSay);
									    		say.setFont(new Font("Calibri", Font.BOLD, 21));
									    		reviewPane.add(say);
									    		
					
//									    		reviewPane.add(l);
									    		
									    		String toAdd = r.getReview();
									    		String labelText = String.format("<html><div WIDTH=%d>%s</div></html>", reviewPane.getSize().width - 10, toAdd);
//									    		toAdd = "<html>" + toAdd + "<html>";
									    		JLabel z = new JLabel(labelText);
									    		z.setFont(new Font("Calibri", Font.BOLD, 20));
									    		reviewPane.add(z);
									    		
			
//									    		reviewPane.add(l);
									    		
									    		String usefulness = "Usefulness:";
									    		JLabel use = new JLabel(usefulness);
									    		use.setFont(new Font("Calibri", Font.BOLD, 21));
									    		reviewPane.add(use);
									    		
//									    		reviewPane.add(l);
									    		
									    		String useful = Integer.toString(r.getUseful());
									    		JLabel u = new JLabel(useful);
									    		u.setFont(new Font("Calibri", Font.BOLD, 20));
									    		reviewPane.add(u);
									    	}
									    	reviewPane.revalidate();
									    	reviewPane.repaint();
									    	
									    }
									});
									
								}
						    	drugPane.updateUI();
						    }  
						}); 
						conditionPane.add(j);
					}
				}
				conditionPane.updateUI();
			}
		});
		txtEnterTheDrugs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtEnterTheDrugs.setText("");
			}
		});
		txtEnterTheDrugs.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 16));
		txtEnterTheDrugs.setText("Enter the condition here");
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

		JButton btnSubmitQuery1 = new JButton("submit");
		btnSubmitQuery.setBounds(157, 34, 117, 29);

		frame.getContentPane().add(btnSubmitQuery1);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(mIRa.class.getResource("/JavaGUI/resources/logo2.PNG")));
		lblNewLabel.setBounds(279, 0, 180, 69);
		frame.getContentPane().add(lblNewLabel);

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
