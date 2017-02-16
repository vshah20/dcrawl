package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.JList;


public class Frame2 {

	private JFrame frame;
	private JTextField textField;
	public Client_UI ui = new Client_UI();
	String hostName;
	int portNumber;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 window = new Frame2();
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
	public Frame2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 525, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSearchEngine = new JLabel("SEARCH ENGINE");
		lblSearchEngine.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchEngine.setBounds(180, 5, 150, 14);
		frame.getContentPane().add(lblSearchEngine);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		textField.setBounds(153, 25, 202, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterSearchQuery = new JLabel("Enter Search Query:");
		lblEnterSearchQuery.setBounds(10, 28, 150, 14);
		frame.getContentPane().add(lblEnterSearchQuery);
		
		JButton btnSearch = new JButton("Search!");
		final JTextArea textArea = new JTextArea();;
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query;
				query = textField.getText();
				if(textField.getText().length()==0)
					JOptionPane.showMessageDialog(null, "Please Enter Something!");
				else
				{
					hostName = "134.68.51.16";
					portNumber = 4401;
					ui.init(hostName, portNumber);
					String search_result = ui.Search(query);
					textArea.setText(search_result+"\n");
				}
					
			}
		});
		btnSearch.setBounds(185, 56, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 489, 429);
		frame.getContentPane().add(scrollPane);
		 
		textArea.setTabSize(12);
		textArea.setRows(10);
		scrollPane.setViewportView(textArea);
		
		
		JButton btnNext = new JButton("Next-->");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result_next = ui.NextList();
				
				textArea.setText(result_next+"\n");
			}
		});
		btnNext.setBounds(185, 525, 89, 23);
		frame.getContentPane().add(btnNext);
		
	}
}
