import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int
	INSERTION = 0,
	MERGE = 1
			;
	public static final String[] names =
		{ "Insertion" , "Merge" };
	
	JPanel containerPanel, choicePanel, arrayCtrlPanel;
	JScrollPane listScroller;
	JLabel titleLabel, choiceLabel, statusLabel;
	JTextArea outputArea;
	JComboBox<String> choiceBox;
	JButton sortButton, addButton, removeButton, randomArrayButton;
	JList<String> arrayList;
	DefaultListModel<String> dlm;
	
	ArrayList<Integer> array;
	
	long time = 0;
	
	public AppFrame() {
		super("Sorting");
		
		//array
		array = new ArrayList<>();
		
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
		containerPanel.add(choicePanel, BorderLayout.NORTH);
		
		choiceLabel = new JLabel("Choose your algorithm:");
		choicePanel.add(choiceLabel);
		
		choiceBox = new JComboBox<>();
		for(int i = 0 ; i < names.length; i++)
			choiceBox.addItem(names[i]);
		choicePanel.add(choiceBox);
		
		//sort button
		sortButton = new JButton("Sort");
		sortButton.addActionListener(handler);
		choicePanel.add(sortButton);
		
		//list
//		outputArea = new JTextArea();
//		outputArea.setEditable(false);
//		containerPanel.add(outputArea);
		arrayList = new JList<>();
//		arrayList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//		arrayList.setVisibleRowCount(-1);
		listScroller = new JScrollPane(arrayList);
		containerPanel.add(listScroller);
		dlm = new DefaultListModel<>();
		arrayList.setModel(dlm);			
		
		//array control panel
		arrayCtrlPanel = new JPanel();
		this.add(arrayCtrlPanel, BorderLayout.SOUTH);
		
		//add and remove buttons
		addButton = new JButton("Add New Element");
		addButton.addActionListener(handler);
		arrayCtrlPanel.add(addButton);
		
		removeButton = new JButton("Remove Element");
		removeButton.addActionListener(handler);
		arrayCtrlPanel.add(removeButton);
		
		//random array button
		randomArrayButton = new JButton("Generate Random Array");
		randomArrayButton.addActionListener(handler);
		arrayCtrlPanel.add(randomArrayButton);
	}
	
	public void activate() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,400);
		this.setVisible(true);
	}
	class AppHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == sortButton) {
				if(array.size() == 0) {
					JOptionPane.showMessageDialog(AppFrame.this, "You don't have any elements!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int[] toSort = new int[array.size()];
				for(int i = 0 ; i < toSort.length; i++)
					toSort[i] = array.get(i);
				//System.out.println(choiceBox.getSelectedIndex());
				switch(choiceBox.getSelectedIndex()) {
				case INSERTION: time = InsertionSort.sort(toSort); break;
				case MERGE: time = MergeSort.sort(toSort); break;
					default: time = -1;
				}
				if(time >= 0) {
					array.removeAll(array);
					dlm.removeAllElements();
					for(int i = 0; i < toSort.length; i++) {
						array.add(toSort[i]);
						dlm.addElement(String.format("(%d)", toSort[i]));
					}
					JOptionPane.showMessageDialog(AppFrame.this, String.format("%s%sns!", "Array sorted! Execution time: ", NumberFormat.getInstance().format(time)));
				}
				
			}
			else if(event.getSource() == addButton) {
				Integer input;
				do {
					String inputText = JOptionPane.showInputDialog("Enter the value:");
					if(inputText == null || inputText.equals(""))
						return;
					try {
						input = Integer.parseInt(inputText);
						break;
					}
					catch(NumberFormatException exception) {
						JOptionPane.showMessageDialog(AppFrame.this, "Invalid input! Try again!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} while (true);
				array.add(input);
				dlm.addElement(String.format("(%d)", input.intValue()));
			}
			else if(event.getSource() == removeButton) {
				int selectedIndex = arrayList.getSelectedIndex();
				if(selectedIndex < 0) {
					JOptionPane.showMessageDialog(AppFrame.this, "You don't have any item selected!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int input = JOptionPane.showConfirmDialog(AppFrame.this, "Are you sure you want to remove this element?", "Remove", JOptionPane.YES_NO_OPTION);
				if(input != JOptionPane.YES_OPTION)
					return;
				dlm.remove(selectedIndex);
				array.remove(selectedIndex);
			}
			else if(event.getSource() == randomArrayButton) {
				String inputString;
				int input;
				do {
					inputString = JOptionPane.showInputDialog("Enter the size of the array!");
					try {
						if(inputString == null || inputString.equals(""))
							return;
						input = Integer.parseInt(inputString.trim());
						if(input <= 0)
							JOptionPane.showMessageDialog(AppFrame.this, "Size should be positive!", "Error", JOptionPane.ERROR_MESSAGE);
						else
							break;
					}
					catch(NumberFormatException exception) {
						JOptionPane.showMessageDialog(AppFrame.this, "Invalid input! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} while(true);
				
				if(array.size() != 0) {
					int check = JOptionPane.showConfirmDialog(AppFrame.this, "Doing this will remove previously entered data. Are you sure you want to proceed?", "Random", JOptionPane.YES_NO_OPTION);
					if(check != JOptionPane.YES_OPTION)
						return;
				}
				
				array.removeAll(array);
				dlm.removeAllElements();
				int value;
				Random randomGenerator = new Random();
				for(int i = 0; i < input; i++) {
					value = randomGenerator.nextInt(Integer.MAX_VALUE);
					array.add(value);
					dlm.addElement(String.format("(%d)", value));
					
				}
				
				JOptionPane.showMessageDialog(AppFrame.this, String.format("%s%d%s", "Generated an array of ", input, " elements successfully!"),"Sucess",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
