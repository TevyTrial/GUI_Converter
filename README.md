# GUI_Converter
- A practice of GUI using Swing and AWY classes in Java
- A practice of aggregation, inheritance concepts
- Design GUI for practical application


CurrencyConverter.java
## Description
This project is a simple GUI-based Currency Converter built using Java Swing. The application allows users to convert amounts between Hong Kong Dollars (HKD) and US Dollars (USD) based on a fixed conversion rate. The GUI provides fields for users to input either HKD or USD and displays the converted amount in the respective field.

Code Explanation
CurrencyConverter Class
The CurrencyConverter class extends JFrame and sets up the GUI components and event handling.

Constructor:

public CurrencyConverter() {
    setTitle("Currency Converter");
    setSize(300, 150);
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
buildpanel Method:

private void buildpanel() {
    panel.add(HKD);
    panel.add(inputHkd);
    panel.add(USD);
    panel.add(inputUsd);
    panel.add(calc);
    calc.addActionListener(new CalcButtonListener());
}
CalcButtonListener Inner Class: This inner class handles the button click event to perform the currency conversion.

private class CalcButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        final double RATE = 7.78;
        String in;
        double result;
        
        if (inputHkd.getText().isEmpty() && !(inputUsd.getText().isEmpty())) {
            in = inputUsd.getText();
            result = Double.parseDouble(in) * RATE;
            inputHkd.setText(String.format("%.4f", result));
        } else if (inputUsd.getText().isEmpty() && !(inputHkd.getText().isEmpty())) {
            in = inputHkd.getText();
            result = Double.parseDouble(in) / RATE;
            inputUsd.setText(String.format("%.4f", result));
        }
    }
}
main Method:

public static void main(String[] args) {
    new CurrencyConverter();
}


WeightConverter.java 
LatinTranslator.java
