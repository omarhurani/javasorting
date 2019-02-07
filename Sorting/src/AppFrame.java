import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int
	INSERTION = 0
			;
	public static final String[] names =
		{ "Insertion" };
	
	JPanel containerPanel, choicePanel, arrayPanel;
	JLabel titleLabel, choiceLabel, timeLabel;
	JTextArea outputArea;
	JComboBox<String> choiceBox;
	JButton sortButton;
	
	public AppFrame() {
		super("Sorting");
		
		//title
		titleLabel = new JLabel("Array Sorting");
		titleLabel.setFont(new Font(titleLabel.getFont().getFontName(), Font.BOLD, 32));
		this.add(titleLabel,BorderLayout.NORTH);
		
		//handler
		AppHandler handler = new AppHandler();
		
		//content panel
		containerPanel = new JPanel();
		containerPanel.setLayout(new BorderLayout());
		this.add(containerPanel);
		
		//choice
		choicePanel = new JPanel();
		containerPanel.add(choicePanel);
		
		choiceLabel = new JLabel("Choose your algorithm:");
		choicePanel.add(choiceLabel);
		
		choiceBox = new JComboBox<>();
		for(int i = 0 ; i < names.length; i++)
			choiceBox.addItem(names[i]);
		choicePanel.add(choiceBox);
		
		//sort button
		sortButton = new JButton("Sort");
		sortButton.addActionListener(handler);
		
	}
	
	public void activate() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(400,400);
		this.setVisible(true);
	}
	class AppHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == sortButton) {
				//
				
			}
		}
	}
}
