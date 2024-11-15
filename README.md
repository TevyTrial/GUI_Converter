# GUI_Converter
- A practice of GUI using Swing and AWY classes in Java
- A practice of aggregation, inheritance concepts
- Design GUI for practical application

CurrencyConverter.java
## Description
This project is a simple GUI-based Currency Converter built using Java Swing. The application allows users to convert amounts between Hong Kong Dollars (HKD) and US Dollars (USD) based on a fixed conversion rate. The GUI provides fields for users to input either HKD or USD and displays the converted amount in the respective field.

## Features
- Convert HKD to USD and vice versa.
- Simple and intuitive GUI with real-time conversion.
- Error handling for empty input fields.

## Usage

### How to Use the Currency Converter
1. **Input Amount**: Enter the amount in either the HKD or USD field.
2. **Calculate**: Click the "Calculate" button to see the converted amount in the other field.
   - If you enter an amount in the HKD field, the equivalent amount in USD will be displayed.
   - If you enter an amount in the USD field, the equivalent amount in HKD will be displayed.

### Code Explanation

#### CurrencyConverter Class
The `CurrencyConverter` class extends `JFrame` and sets up the GUI components and event handling.

1. **Constructor**:
    ```java
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
    ```

2. **buildpanel Method**:
    ```java
    private void buildpanel() {
        panel.add(HKD);
        panel.add(inputHkd);
        panel.add(USD);
        panel.add(inputUsd);
        panel.add(calc);
        calc.addActionListener(new CalcButtonListener());
    }
    ```

3. **CalcButtonListener Inner Class**:
    This inner class handles the button click event to perform the currency conversion.
    ```java
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
    ```

4. **main Method**:
    ```java
    public static void main(String[] args) {
        new CurrencyConverter();
    }
    ```
    
WeightConverter.java 
## Description
This project is a simple GUI-based Weight Converter built using Java Swing. The application allows users to convert weights from kilograms (kg) to pounds (lbs). The GUI provides a field for the user to input a weight in kilograms and displays the converted weight in pounds.

### Code Explanation

#### WeightConverter Class
The `WeightConverter` class extends `JFrame` and sets up the GUI components and event handling.

1. **Constructor**:
    ```java
    public WeightConverter() {
        setLayout(new BorderLayout());
        message = new JLabel("Enter a weight in kg");
        kg = new JTextField(10);
        btn = new JButton("Calculate");
        panel = new JPanel();
        
        buildPanel();
        add(panel);
        setTitle("Pound-Kg Converter");
        setSize(320, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    ```

2. **buildPanel Method**:
    ```java
    public void buildPanel() { 
        panel.add(message, BorderLayout.LINE_START);
        panel.add(kg, BorderLayout.LINE_END);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double pounds = Double.parseDouble(kg.getText()) *  2.20462;
                String formattedPounds = String.format("%.2f", pounds);
                JLabel v = new JLabel(kg.getText() + "kg is: " + formattedPounds + " pounds");
                panel.add(v, BorderLayout.AFTER_LAST_LINE);
                repaint();
                revalidate();
            }
        });
        panel.add(btn, BorderLayout.PAGE_END);
    }
    ```

3. **main Method**:
    ```java
    public static void main(String[] args) {
        new WeightConverter();
    }
    ```

LatinTranslator.java
## Description
This project is a simple GUI-based Latin Translator built using Java Swing. The application translates Latin words "Sinister", "Dexter", and "Medium" to their English equivalents when the corresponding button is pressed.

## Usage

### Code Explanation

#### LatinTranslator Class
The `LatinTranslator` class extends `JFrame` and sets up the GUI components and event handling.

1. **Constructor**:
    ```java
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
    ```

2. **buildPanel Method**:
    ```java
    private void buildPanel() {
        panel.add(Eng, BorderLayout.PAGE_START);
        panel.add(new JLabel("                             "));
        panel.add(btnLeft, BorderLayout.LINE_START);
        panel.add(btnRight, BorderLayout.CENTER);
        panel.add(btnCenter, BorderLayout.LINE_END);

        btnLeft.addActionListener(new btnListener());
        btnRight.addActionListener(new btnListener());
        btnCenter.addActionListener(new btnListener());
    }
    ```

3. **btnListener Inner Class**:
    This inner class handles the button click events to display the English translation.
    ```java
    private class btnListener implements ActionListener {
        private JLabel label = new JLabel();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnLeft) {
                label.setText("English of Sinister is left.\n");
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
    ```

4. **main Method**:
    ```java
    public static void main(String[] args) {
        new LatinTranslator();
    }
    ```

