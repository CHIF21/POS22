import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateTimeGUI {
    private JCheckBox dateBtn;
    private JCheckBox timeBtn;
    private JButton formatBtn;
    private JTextField tfFormat;
    private JTextField tfDay;
    private JTextField tfMonth;
    private JTextField tfYear;
    private JTextField tfHour;
    private JTextField tfMinute;
    private JPanel paMain;
    private JPanel paOutput;
    private JLabel laDay;
    private JLabel laMonth;
    private JLabel laYear;
    private JLabel laHour;
    private JLabel laMinute;
    private JPanel paFormat;
    private JPanel paInput;

    public DateTimeGUI() {
        formatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int day, month, year, hour, minute;

                if(dateBtn.isSelected() && !timeBtn.isSelected()) {
                    try {
                        day = Integer.parseInt(tfDay.getText());
                        month = Integer.parseInt(tfMonth.getText());
                        year = Integer.parseInt(tfYear.getText());
                        tfFormat.setText(DateTimeFormater.format("D", day, month, year));
                    } catch(NumberFormatException ex) {
                        JLabel label = new JLabel();
                        label.setText("Die Daten für das Datum sind leer oder ungültig!");
                        JOptionPane.showMessageDialog(new JLabel(), label, "Fehler!", JOptionPane.ERROR_MESSAGE);
                    }
                } else if(timeBtn.isSelected() && !dateBtn.isSelected()) {
                    try {
                        hour = Integer.parseInt(tfHour.getText());
                        minute = Integer.parseInt(tfMinute.getText());
                        tfFormat.setText(DateTimeFormater.format("T", hour, minute));
                    } catch(NumberFormatException ex) {
                        JLabel label = new JLabel();
                        label.setText("Die Daten für die Uhrzeit sind entweder leer oder ungültig!");
                        JOptionPane.showMessageDialog(new JLabel(), label, "Fehler!", JOptionPane.ERROR_MESSAGE);
                    }
                } else if(dateBtn.isSelected() && timeBtn.isSelected()) {
                    try {
                        day = Integer.parseInt(tfDay.getText());
                        month = Integer.parseInt(tfMonth.getText());
                        year = Integer.parseInt(tfYear.getText());
                        hour = Integer.parseInt(tfHour.getText());
                        minute = Integer.parseInt(tfMinute.getText());
                        tfFormat.setText(DateTimeFormater.format("DT", day, month, year, hour, minute));
                    } catch(NumberFormatException ex) {
                        JLabel label = new JLabel();
                        label.setText("Die Daten für das Datum und der Uhrzeit sind entweder leer oder ungültig!");
                        JOptionPane.showMessageDialog(new JLabel(), label, "Fehler!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DateTimeGUI");
        frame.setContentPane(new DateTimeGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
