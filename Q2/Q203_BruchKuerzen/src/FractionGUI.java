import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FractionGUI {
    private JPanel paMain;
    private JPanel paInput;
    private JTextField tfZaehler1;
    private JTextField tfNenner1;
    private JTextField tfZaehler2;
    private JTextField tfNenner2;
    private JLabel lbSeperator;
    private JLabel lbSperator;
    private JLabel lbBruch1;
    private JLabel lbBruch2;
    private JButton btCalculate;
    private JPanel paOutput;

    public FractionGUI() {
        /* JDialog dialog = new JDialog();
        dialog.setSize(200, 100);
        dialog.setTitle("Fehler!");
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null); */

        JLabel label = new JLabel();

        btCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Fraction frac = new Fraction(Integer.parseInt(tfZaehler1.getText()), Integer.parseInt(tfNenner1.getText()));
                    frac.cancel();
                    tfZaehler2.setText(String.valueOf(frac.getNumerator()));
                    tfNenner2.setText(String.valueOf(frac.getDenominator()));
                } catch(ArithmeticException ex) {
                    System.out.println(ex.getMessage());
                    label.setText(ex.getMessage());
                    // dialog.setContentPane(label);
                    // dialog.setVisible(true);
                    JOptionPane.showMessageDialog(new JFrame(), label, "Fehler!", JOptionPane.ERROR_MESSAGE);
                } catch(NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                    label.setText(ex.getMessage());
                    // dialog.setContentPane(label);
                    // dialog.setVisible(true);
                    JOptionPane.showMessageDialog(new JFrame(), label, "Fehler!", JOptionPane.ERROR_MESSAGE);
                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BruchKuerzen");
        frame.setContentPane(new FractionGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
