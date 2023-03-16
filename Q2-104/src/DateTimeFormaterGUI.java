import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class DateTimeFormaterGUI {
    private JPanel paMain;
    private JCheckBox cbDate;
    private JCheckBox cbTime;
    private JTextField tfDay;
    private JLabel lbDay;
    private JTextField tfMonth;
    private JTextField tfYear;
    private JTextField tfHour;
    private JPanel paOutput;
    private JPanel paInput;
    private JButton btFormat;
    private JTextField tfFormat;
    private JLabel lbMonth;
    private JLabel lbYear;
    private JLabel lbHour;
    private JLabel lbMinute;
    private JTextField tfMinute;
    private JPanel paFormat;

    public DateTimeFormaterGUI(){
        btFormat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(cbDate.isSelected() && !cbTime.isSelected()){
                        try {
                            tfFormat.setText(DateTimeFormater.format("D", Integer.parseInt(tfDay.getText()),
                                    Integer.parseInt(tfMonth.getText()), Integer.parseInt(tfYear.getText())));
                        } catch(NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Sie müssen alle Werte für das Datum ausfüllen.", "Fehler!", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                     if(cbTime.isSelected() && !cbDate.isSelected()){
                         try {
                             tfFormat.setText(DateTimeFormater.format("T", Integer.parseInt(tfHour.getText()),
                                     Integer.parseInt(tfMinute.getText())));
                         } catch(NumberFormatException ex) {
                             JOptionPane.showMessageDialog(null, "Sie müssen alle Werte für die Uhrzeit ausfüllen", "Fehler!", JOptionPane.ERROR_MESSAGE);
                         }
                    }

                     if(cbDate.isSelected() && cbTime.isSelected()){
                         try {
                             tfFormat.setText(DateTimeFormater.format("DT", Integer.parseInt(tfDay.getText()),
                                     Integer.parseInt(tfMonth.getText()),
                                     Integer.parseInt(tfYear.getText()), Integer.parseInt(tfHour.getText()),
                                     Integer.parseInt(tfMinute.getText())));
                         } catch(NumberFormatException ex) {
                             JOptionPane.showMessageDialog(null, "Sie müssen alle Werte für das Datum und die Uhrzeit ausfüllen.", "Fehler!", JOptionPane.ERROR_MESSAGE);
                         }
                    }

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Fehler bei Übergabeparameter", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DateTimeFormaterGUI");
        frame.setContentPane(new DateTimeFormaterGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
