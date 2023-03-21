import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Arrays;

public class EulerGUI {
    private JPanel paMain;
    private JButton btCalculate;
    private JTextArea taResult;
    private JCheckBox cb1;
    private JCheckBox cb2;
    private JCheckBox cb3;
    private JCheckBox cb4;
    private JCheckBox cb5;
    private JPanel paEulerCheckBox;
    private JPanel paResult;


    public EulerGUI() {
        btCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taResult.setText("");

                if(cb1.isSelected()) {
                    int sum = 0;
                    for(int i = 0; i < 1000; i++) {
                        sum += EulerBL.multiplesOf3_5(i);
                    }

                    taResult.append("Problem 1 (Multiples of 3 and 5):\n" + sum);
                    taResult.append("\n---------------------------------------------\n");
                }

                if(cb2.isSelected()) {
                    taResult.append("Problem 9 (Special Pythagorean triplet):\n" + EulerBL.triplet());
                    taResult.append("\n---------------------------------------------\n");
                }

                if(cb3.isSelected()) {
                    BigInteger factor = EulerBL.factorial(new BigInteger("100"));
                    int digitSum = EulerBL.digitSum(factor);
                    taResult.append("Problem 20 (Factorial Digit Sum):\n" + digitSum);
                    taResult.append("\n---------------------------------------------\n");
                }

                if(cb4.isSelected()) {
                    int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                    String result = Arrays.toString(EulerBL.lexicographeSort(number));
                    taResult.append("Problem 24 (Lexicographic Permutitions):\n" + result);
                    taResult.append("\n---------------------------------------------\n");
                }

                if(cb5.isSelected()) {
                    taResult.append("Problem 48 (Self powers):\n" + EulerBL.selfPower());
                    taResult.append("\n---------------------------------------------\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Euler Problems");
        frame.setContentPane(new EulerGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
