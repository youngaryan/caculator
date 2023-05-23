import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator extends JFrame{

    public Calculator() {

        setTitle("Calculator");
        setSize(350,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting the location of appearance
        Dimension dimension = getToolkit().getScreenSize();
        setLocation(dimension.width/4,dimension.height/8);

        //adding numbers
        JButton jButtonNumbers = new JButton();
        jButtonNumbers.setLayout(new GridLayout(3,0));
        JButton[] buttons = new JButton[9];
        jButtonNumbers.setBorder(null);

        for (int i = 0; i < 9; i++) {
            JButton button = new JButton(Integer.toString(i + 1));
            jButtonNumbers.add(button);
            buttons[i] = button;
        }


        //add zero,. and = signs
        JButton jButtonEqual = new JButton();
        jButtonEqual.setLayout(new GridLayout(0,3));
        jButtonEqual.setPreferredSize(new Dimension(getWidth(),50));
        jButtonEqual.setBorder(null);
        JButton button0 = new JButton("0");
        JButton buttonDot = new JButton(".");
        JButton buttonEqual = new JButton("=");

        jButtonEqual.add(button0);
        jButtonEqual.add(buttonDot);
        jButtonEqual.add(buttonEqual);

        //adding operations
        JButton jButtonOperations = new JButton();
        jButtonOperations.setLayout(new GridLayout(5,0));
        jButtonOperations.setPreferredSize(new Dimension(90,getHeight()));
        jButtonOperations.setBorder(null);
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivide = new JButton("/");
        JButton buttonAdd = new JButton("+");
        JButton buttonSubtract = new JButton("-");
        JButton buttonModulo = new JButton("%");

        jButtonOperations.add(buttonMultiply);
        jButtonOperations.add(buttonDivide);
        jButtonOperations.add(buttonAdd);
        jButtonOperations.add(buttonSubtract);
        jButtonOperations.add(buttonModulo);

        //adding more operations such as pow, sqr ...
        JButton jButtonMoreOperations = new JButton();
        jButtonMoreOperations.setLayout(new GridLayout(4,0));
        jButtonMoreOperations.setBorder(null);
        JButton buttonClear = new JButton("Clear");
        JButton buttonPow = new JButton("Pow");
        JButton buttonSqr = new JButton("sqr");
        JButton buttonPlusMinus = new JButton("+/-");

        jButtonMoreOperations.add(buttonClear);
        jButtonMoreOperations.add(buttonPow);
        jButtonMoreOperations.add(buttonSqr);
        jButtonMoreOperations.add(buttonPlusMinus);

        //adding textField for displaying the result
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(getWidth(),100));
        jTextField.setEditable(false);
        jTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        jTextField.setBorder(null);

        //adding listeners
        for (JButton button : buttons) {
            button.addActionListener(e -> {
                String buttonText = button.getText();
                jTextField.setText(jTextField.getText() + buttonText);
            });
        }

        button0.addActionListener(e -> {
            String butt0 = button0.getText();
            jTextField.setText(jTextField.getText() + butt0);
        });

        buttonDot.addActionListener(e -> {
            String buttDot = buttonDot.getText();
            jTextField.setText(jTextField.getText() + buttDot);
        });

//        buttonEqual.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                double result = Double.parseDouble(String.valueOf(jTextField.getText().charAt(0)));
//                for (int i = 1; i < jTextField.getText().length(); i += 2) {
//                    String operator = String.valueOf(jTextField.getText().charAt(i));
//                    double value = Double.parseDouble(String.valueOf((jTextField.getText().charAt(i+1))));
//                    if (operator.equals("+")) {
//                        result += value;
//                    } else if (operator.equals("-")) {
//                        result -= value;
//                    }
//                }
//                jTextField.setText(String.valueOf(result));
//            }
//        });

        buttonEqual.addActionListener(e -> {
            try {
                ArrayList<Double> doubleArrayList = new ArrayList<>();
                ArrayList<Integer> index = new ArrayList<>();

                for (int i = 0; i < jTextField.getText().length(); i++) {
                    if (jTextField.getText().charAt(i) == '*') {
                        doubleArrayList.add(0,Double.parseDouble(jTextField.getText().substring(0, i)));
                        doubleArrayList.add(1,Double.parseDouble(jTextField.getText().substring(i + 1)));
                        index.add(i);
                    }
                    if (jTextField.getText().charAt(i) == '/') {
                        doubleArrayList.add(0,Double.parseDouble(jTextField.getText().substring(0, i)));
                        doubleArrayList.add(1,Double.parseDouble(jTextField.getText().substring(i + 1)));
                        index.add(i);
                    }
                    if (jTextField.getText().charAt(i) == '%') {
                        doubleArrayList.add(0,Double.parseDouble(jTextField.getText().substring(0, i)));
                        doubleArrayList.add(1,Double.parseDouble(jTextField.getText().substring(i + 1)));
                        index.add(i);
                    }
                    if (jTextField.getText().charAt(i) == '-') {
                        doubleArrayList.add(0,Double.parseDouble(jTextField.getText().substring(0, i)));
                        doubleArrayList.add(1,Double.parseDouble(jTextField.getText().substring(i + 1)));
                        index.add(i);
                    }
                    if (jTextField.getText().charAt(i) == '^') {
                        doubleArrayList.add(0,Double.parseDouble(jTextField.getText().substring(0, i)));
                        doubleArrayList.add(1,Double.parseDouble(jTextField.getText().substring(i + 1)));
                        index.add(i);
                    }
                    if (jTextField.getText().charAt(i) == '+') {
                        doubleArrayList.add(0,Double.parseDouble(jTextField.getText().substring(0, i)));
                        doubleArrayList.add(1,Double.parseDouble(jTextField.getText().substring(i + 1)));
                        index.add(i);
                    }
                }
                if (doubleArrayList.get(0)!= null && jTextField.getText().charAt(index.get(0))=='*') {
                    double result = doubleArrayList.get(0) * doubleArrayList.get(1);
                    jTextField.setText(String.valueOf(result));
                    index.remove(0);
                }
                if (doubleArrayList.get(0)!= null && jTextField.getText().charAt(index.get(0))=='/') {
                    double result = doubleArrayList.get(0) / doubleArrayList.get(1);
                    jTextField.setText(String.valueOf(result));
                    index.remove(0);
                }
                if (doubleArrayList.get(0)!= null && jTextField.getText().charAt(index.get(0))=='%') {
                    double result = doubleArrayList.get(0) % doubleArrayList.get(1);
                    jTextField.setText(String.valueOf(result));
                    index.remove(0);
                }
                if (doubleArrayList.get(0)!= null && jTextField.getText().charAt(index.get(0))=='-') {
                    double result = doubleArrayList.get(0) - doubleArrayList.get(1);
                    jTextField.setText(String.valueOf(result));
                    index.remove(0);
                }
                if (doubleArrayList.get(0)!= null && jTextField.getText().charAt(index.get(0))=='^') {
                    double result = Math.pow(doubleArrayList.get(0),doubleArrayList.get(1));
                    jTextField.setText(String.valueOf(result));
                    index.remove(0);
                }
                if (doubleArrayList.get(0)!= null && jTextField.getText().charAt(index.get(0))=='+') {
                    double result = doubleArrayList.get(0) + doubleArrayList.get(1);
                    jTextField.setText(String.valueOf(result));
                    index.remove(0);
                }
            }catch (Exception ignored){
                }
        });

        buttonMultiply.addActionListener(e -> {
            String buttMulti = buttonMultiply.getText();
            jTextField.setText(jTextField.getText() + buttMulti);
        });

        buttonDivide.addActionListener(e -> {
            String buttDivide = buttonDivide.getText();
            jTextField.setText(jTextField.getText() + buttDivide);
        });

        buttonModulo.addActionListener(e -> {
            String buttMod = buttonModulo.getText();
            jTextField.setText(jTextField.getText() + buttMod);
        });

        buttonSubtract.addActionListener(e -> {
            String buttSub = buttonSubtract.getText();
            jTextField.setText(jTextField.getText() + buttSub);
        });

        buttonClear.addActionListener(e -> jTextField.setText(""));

        buttonPlusMinus.addActionListener(e -> {
            if (jTextField.getText().charAt(0) == '-') {
                jTextField.setText(jTextField.getText().substring(1));
            }else
                jTextField.setText("-"+jTextField.getText());
        });

        buttonPow.addActionListener(e -> jTextField.setText(jTextField.getText() + "^"));

        buttonSqr.addActionListener(e -> jTextField.setText(String.valueOf(Math.sqrt(Double.parseDouble(jTextField.getText())))));

        buttonAdd.addActionListener(e -> {
            String buttAdd = buttonAdd.getText();
            jTextField.setText(jTextField.getText() + buttAdd);
        });

        //adding elements to the container
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(jButtonNumbers,BorderLayout.CENTER);
        container.add(jButtonEqual,BorderLayout.SOUTH);
        container.add(jButtonOperations,BorderLayout.EAST);
        container.add(jButtonMoreOperations,BorderLayout.WEST);
        container.add(jTextField,BorderLayout.NORTH);
        container.setVisible(true);
    }
}