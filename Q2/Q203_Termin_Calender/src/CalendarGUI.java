import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CalendarGUI {
    private JPanel paMain;
    private JTextField tfMonth;
    private JButton btCreate;
    private JLabel lbMonth;
    private JEditorPane edPaMonths;
    private JButton btCreateMeeting;
    private JButton btDeleteMeeting;

    public CalendarGUI() {
        btCreate.addActionListener(this::onGenerateDaysOfMonth);
        btCreateMeeting.addActionListener(this::onGenerateEvents);
        btDeleteMeeting.addActionListener(this::onRemoveEvents);
    }

    private void onGenerateDaysOfMonth(ActionEvent e) {
        edPaMonths.setText(CalendarBL.generateDaysOfMonth(tfMonth.getText()));
    }

    public void onGenerateEvents(ActionEvent e) {
        edPaMonths.setText(CalendarBL.generateEvents(tfMonth.getText(), edPaMonths.getText()));
    }

    public void onRemoveEvents(ActionEvent e) {
        JLabel label = new JLabel();
        label.setText("Enter the day you want to delete:");
        String day = JOptionPane.showInputDialog(new JLabel(), label, "");
        if(day != null) {
            if(!day.equals("")) {
                int index = Integer.parseInt(day) - 1;
                String[] calender = edPaMonths.getText().split("<br>");
                calender[index] = calender[index].substring(0, calender[index].indexOf("-") + 1);

                String output = "";

                for (String value : calender) {
                    output += value + "<br>";
                }

                edPaMonths.setText(output);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TerminKalender");
        frame.setContentPane(new CalendarGUI().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
