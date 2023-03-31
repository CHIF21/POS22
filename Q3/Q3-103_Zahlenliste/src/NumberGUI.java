import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class NumberGUI {
    private JPanel paMain;
    private JTextArea taContent;
    private JSlider slElement;
    private JSlider slRandomValue;
    private JButton btInit;
    private JTextField tfFinal;
    private JRadioButton raIndex;
    private JRadioButton raValue;
    private JTextField tfChange;
    private JButton btRemove;
    private JButton btInsert;
    private JLabel lbElement;
    private JLabel lbChange;
    private JRadioButton raRandom;
    private JRadioButton raFinal;

    private List<Integer> numberList = new LinkedList<>();

    public NumberGUI() {
        btInit.addActionListener(this::onInit);
        btRemove.addActionListener(this::onDelete);
        btInsert.addActionListener(this::onInsert);
    }

    public void onInit(ActionEvent e) {
        Random rand = new Random();
        numberList.clear();

        for(int i = 0; i < slElement.getValue(); i++) {
            if(raRandom.isSelected()) {
                numberList.add(rand.nextInt(0, slRandomValue.getValue() + 1));
            } else {
                numberList.add(Integer.parseInt(tfFinal.getText()));
            }
        }
        printList();
    }

    public void onDelete(ActionEvent e) {
        if(raIndex.isSelected()) {
            if((Integer.parseInt(tfChange.getText()) - 1) >= 0 && (Integer.parseInt(tfChange.getText()) - 1) < numberList.size()) {
                numberList.remove(Integer.parseInt(tfChange.getText()) - 1);
            } else {
                JOptionPane.showMessageDialog(new JLabel(), "The index is not valid!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if(raValue.isSelected()) {
            for(int i = numberList.size() - 1; i >= 0; i--) {
                if(numberList.get(i) == Integer.parseInt(tfChange.getText())) {
                    numberList.remove(i);
                }
            }
        }
        printList();
    }

    public void onInsert(ActionEvent e)  {
        if(raValue.isSelected()) {
            numberList.add(Integer.parseInt(tfChange.getText()));
        } else if(raIndex.isSelected()) {
            int index = Integer.parseInt(tfChange.getText()) - 1;
            if(index >= 0 && index < numberList.size()) {
                if (raRandom.isSelected()) {
                    Random rand = new Random();
                    numberList.add(index, rand.nextInt(0, slRandomValue.getValue() + 1));
                } else {
                    numberList.add(index, Integer.parseInt(tfFinal.getText()));
                }
            } else {
                JOptionPane.showMessageDialog(new JLabel(), "The index is not valid!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        printList();
    }

    public void printList() {
        String output = "";
        for(int i = 0; i < numberList.size(); i++) {
            output += String.format("%4d", numberList.get(i));
            output += ((i+1) % 10 == 0) ? "\n" : ",";
        }
        taContent.setText(output);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NumberGUI");
        frame.setContentPane(new NumberGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
