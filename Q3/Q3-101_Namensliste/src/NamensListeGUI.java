import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class NamensListeGUI {
    private JTextField tfName;
    private JButton btInsert;
    private JButton btDelete;
    private JTextField tfNameOut;
    private JTextField tfPositionOut;
    private JButton btUp;
    private JButton btDown;
    private JLabel laName;
    private JLabel laPosition;
    private JPanel paName;
    private JPanel paList;
    private JPanel paMain;

    private List<String> list = new LinkedList<>();
    private int index = 0;

    public NamensListeGUI() {
        btInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfName.getText().matches("\\w") && !list.contains(tfName.getText())) {
                    list.add(tfName.getText());
                    tfNameOut.setText(list.get(list.size()-1));
                    Collections.sort(list);
                    tfPositionOut.setText(String.format("%d of %d", list.indexOf(tfNameOut.getText()) + 1, list.size()));
                    index = list.indexOf(tfNameOut.getText());
                } else {
                    JOptionPane.showMessageDialog(new Label(), "The name is invalid or exist already. Please try again!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(list.contains(tfName.getText())) {
                    list.remove(tfName.getText());

                    if(list.size() > 0) {
                        Collections.sort(list);
                        tfNameOut.setText(list.get(0));
                        tfPositionOut.setText(String.format("%d of %d", 1, list.size()));
                        index = 0;
                    } else {
                        tfNameOut.setText("");
                        tfPositionOut.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(new Label(), String.format("The name \"%s\" you want to delete doesn't exist!", tfName.getText()), "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        btUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index < list.size() - 1) {
                    tfNameOut.setText(list.get(++index));
                    tfPositionOut.setText(String.format("%d of %d", list.indexOf(tfNameOut.getText()) + 1, list.size()));
                }
            }
        });

        btDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index > 0) {
                    tfNameOut.setText(list.get(--index));
                    tfPositionOut.setText(String.format("%d of %d", list.indexOf(tfNameOut.getText()) + 1, list.size()));
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NamensListeGUI");
        frame.setContentPane(new NamensListeGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
