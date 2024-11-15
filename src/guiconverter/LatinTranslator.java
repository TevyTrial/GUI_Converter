package guiconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author tevy0
 * @version 1.0
 * @since 13/3/2024
 */
public class LatinTranslator extends JFrame {

    private JLabel Eng;
    private JButton btnLeft, btnRight, btnCenter;
    private JPanel panel;

    public LatinTranslator() {
        setLayout(new BorderLayout());
        Eng = new JLabel("English Translation");
        btnLeft = new JButton("Sinister");
        btnRight = new JButton("Dexter");
        btnCenter = new JButton("Medium");

        panel = new JPanel();
        buildPanel();
        add(panel);

        setTitle("Latin Translator");
        setSize(280, 280);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void buildPanel() {
        panel.add(Eng, BorderLayout.PAGE_START);
        panel.add(new JLabel("                             "));
        panel.add(btnLeft, BorderLayout.LINE_START);

        		/**
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JLabel v = new JLabel("English of Sinister is left.");
				panel.add(v, BorderLayout.AFTER_LAST_LINE);
				//This method tells Swing that an area of the window is dirty.
				repaint();
				//This method tells the layout manager to recalculate the layout that is necessary when adding components.
				revalidate();
				
			}
			
		});*/

        panel.add(btnRight, BorderLayout.CENTER);
        panel.add(btnCenter, BorderLayout.LINE_END);
        

        
        btnLeft.addActionListener(new btnListener());
        btnRight.addActionListener(new btnListener());
        btnCenter.addActionListener(new btnListener());
    }

    public static void main(String[] args) {
        new LatinTranslator();
    }

    private class btnListener implements ActionListener {

        private JLabel label = new JLabel();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnLeft) {
                label.setText("English of Sinster is left.\n");
            }
            if (e.getSource() == btnRight) {
                label.setText("English of Dexter is right.\n");
            }
            if (e.getSource() == btnCenter) {
                label.setText("English of Medium is center.");
            }
            
            panel.add(label, BorderLayout.AFTER_LAST_LINE);
			repaint();
			revalidate();    

        }
    }

}
