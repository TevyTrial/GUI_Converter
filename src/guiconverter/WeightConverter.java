package guiconverter;

/**
 *
 * @author tevy0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightConverter extends JFrame{
	private JLabel message;
	private JTextField kg;
	private JButton btn;
	private JPanel panel;
	
	public WeightConverter() {
		setLayout(new BorderLayout());
		message = new JLabel("Enter a weight in kg");
		kg = new JTextField(10);
		btn = new JButton("Calculate");
		panel = new JPanel();
		
		buildPanel();
		add(panel);
		setTitle("Poubd-Kg Converter");
		setSize(320,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void buildPanel() { 
		
		panel.add(message, BorderLayout.LINE_START);
		panel.add(kg, BorderLayout.LINE_END);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double pounds = Double.parseDouble(kg.getText()) *  2.20462;
                                String formattedPounds = String.format("%.2f", pounds);
				JLabel v = new JLabel(kg.getText() + "kg is: " + formattedPounds +" pounds");
				panel.add(v, BorderLayout.AFTER_LAST_LINE);
				//This method tells Swing that an area of the window is dirty.
				repaint();
				//This method tells the layout manager to recalculate the layout that is necessary when adding components.
				revalidate();
				
			}
		});
		panel.add(btn, BorderLayout.PAGE_END);
	}
	
	
	public static void main(String[] args) {
		new WeightConverter();
	}
	
}

