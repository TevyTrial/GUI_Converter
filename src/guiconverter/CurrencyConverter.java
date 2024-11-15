/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guiconverter;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author tevy0
 */
public class CurrencyConverter extends JFrame{
    private JLabel HKD, USD;
    private JTextField inputHkd, inputUsd;
    private JButton calc;
    private JPanel panel;
    
    public CurrencyConverter(){
        setTitle("Currency Converter");
        setSize(300,150);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        HKD = new JLabel("HK$");
        inputHkd = new JTextField(10);

        USD = new JLabel("US$");
        inputUsd = new JTextField(10);
        
        calc = new JButton("Calculate");
        
        panel = new JPanel();
        buildpanel();
        add(panel);
        setVisible(true);
    }

    private void buildpanel() {
        panel.add(HKD);
        panel.add(inputHkd);
        panel.add(USD);
        panel.add(inputUsd);
        panel.add(calc);
        calc.addActionListener(new CalcButtonListener());
    }

    private class CalcButtonListener implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            final double RATE = 7.78;
            String in; // To hold the user's input
            double result; // The number of pounds
            // Get the text entered by the user into the text field.
            if (inputHkd.getText().isEmpty() && !(inputUsd.getText().isEmpty())) {
                in = inputUsd.getText();
                result = Double.parseDouble(in) * RATE;
                // Display the result.
                inputHkd.setText(String.format("%.4f", result));
            } else if (inputUsd.getText().isEmpty() && !(inputHkd.getText().isEmpty())) {
                in = inputHkd.getText();
                result = Double.parseDouble(in) / RATE;
                // Display the result.
                inputUsd.setText(String.format("%.4f", result));
            }
        }

    }
    public static void main(String[] args) {
        new CurrencyConverter();
    }
    
}