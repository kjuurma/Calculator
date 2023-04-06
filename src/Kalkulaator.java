import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Kalkulaator {
    private JPanel Kalkulaator;
    private JTextField txtDisplay;
    private JButton buttonAC;
    private JButton buttonMinus;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonEquals;
    private JButton buttonPlus;
    private JButton button7;
    private JButton button4;
    private JButton button1;
    private JButton button00;
    private JButton button2;
    private JButton button3;
    private JButton button5;
    private JButton button6;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonDot;
    private JButton buttonPM;
    private JButton buttonBack;
    private BigDecimal a, b; // Variables for two numbers and result
    private BigDecimal result = null;
    private char op; // Character for storing operation

    // Helper function to check if the number equals to 0
    private void isFirstNum() {
        if (txtDisplay.getText().length() > 1) return;

        long num = Long.parseLong(txtDisplay.getText());
        if (num == 0) txtDisplay.setText("");
    }

    // Helper function to check if a calculation has been done
    private void isNull() {
        if (result != null) {
            result = null;
            txtDisplay.setText("0");
        }
    }
    public Kalkulaator() {
        txtDisplay.setText("0");
        // Sets the display to zero
        buttonAC.addActionListener(actionEvent -> txtDisplay.setText("0"));
        // Adds numbers from 0 to 9
        button1.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "1");
        });
        button2.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "2");
        });
        button3.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "3");
        });
        button4.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "4");
        });
        button5.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "5");
        });
        button6.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "6");
        });
        button7.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "7");
        });
        button8.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "8");
        });
        button9.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "9");
        });
        button0.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 7) return;
            isNull();
            isFirstNum();
            txtDisplay.setText(txtDisplay.getText() + "0");
        });
        button00.addActionListener(actionEvent -> {
            if (txtDisplay.getText().length() > 6) return;
            isNull();
            if(!txtDisplay.getText().equals("0")) txtDisplay.setText(txtDisplay.getText() + "00");
        });
        // Adds comma
        buttonDot.addActionListener(actionEvent -> {
            if(!txtDisplay.getText().contains(".")) {
                txtDisplay.setText(txtDisplay.getText() + ".");
            }
        });
        // Changes number value to positive or negative
        buttonPM.addActionListener(actionEvent -> {
            if(txtDisplay.getText().equals("0")) return;

            StringBuilder str = new StringBuilder(txtDisplay.getText());
            if(str.charAt(0) == '-') {
                str.deleteCharAt(0);
                txtDisplay.setText(str.toString());
            } else {
                str.insert(0, '-');
                txtDisplay.setText(str.toString());
            }
        });
        // Deletes last symbol
        buttonBack.addActionListener(actionEvent -> {
           if(txtDisplay.getText().equals("0")) return;

           StringBuilder str = new StringBuilder(txtDisplay.getText());
           if(str.toString().equals("-0.")) {
               txtDisplay.setText("0");
               return;
           }
           if(str.length() == 1) txtDisplay.setText("0");
           else if(str.length() == 2) {
               if(str.charAt(0) != '-') {
                   str.deleteCharAt(1);
                   txtDisplay.setText(str.toString());
               } else txtDisplay.setText("0");
           } else {
               str.deleteCharAt(str.length() - 1);
               txtDisplay.setText(str.toString());
           }
        });
        // Actions for different operations
        buttonPlus.addActionListener(actionEvent -> {
            a = new BigDecimal(txtDisplay.getText());
            op = '+';
            txtDisplay.setText("0");
        });
        buttonMinus.addActionListener(actionEvent -> {
            a = new BigDecimal(txtDisplay.getText());
            op = '-';
            txtDisplay.setText("0");
        });
        buttonMultiply.addActionListener(actionEvent -> {
            a = new BigDecimal(txtDisplay.getText());
            op = '*';
            txtDisplay.setText("0");
        });
        buttonDivide.addActionListener(actionEvent -> {
            a = new BigDecimal(txtDisplay.getText());
            op = '/';
            txtDisplay.setText("0");
        });
        // Different cases for calculations
        buttonEquals.addActionListener(actionEvent -> {
            b = new BigDecimal(txtDisplay.getText());
            switch (op) {
                case '+' -> {
                    result = a.add(b);
                    txtDisplay.setText(result.stripTrailingZeros().toPlainString());
                }
                case '-' -> {
                    result = a.subtract(b);
                    txtDisplay.setText(result.stripTrailingZeros().toPlainString());
                }
                case '*' -> {
                    result = a.multiply(b);
                    txtDisplay.setText(result.stripTrailingZeros().toPlainString());
                }
                case '/' -> {
                    if (b.equals(BigDecimal.valueOf(0))) {
                        txtDisplay.setText("Can't divide by zero");
                        return;
                    }
                    result = a.divide(b, 10, RoundingMode.DOWN);
                    txtDisplay.setText(result.stripTrailingZeros().toPlainString());
                }
                default -> {
                }
            }
            op = '\0';
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulaator");
        frame.setContentPane(new Kalkulaator().Kalkulaator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
