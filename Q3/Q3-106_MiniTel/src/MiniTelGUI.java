import beans.MiniTelEntry;
import bl.MiniTelModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class MiniTelGUI extends JFrame {
    private JPanel paMain;
    private JList<MiniTelEntry> liTelNumbers;
    private JButton btSave;
    private JButton btDelete;
    private JTextField tfName;
    private JTextField tfNumber;
    private JRadioButton rbPrivate;
    private JRadioButton rbWork;
    private JPanel paNumbers;
    private JLabel laNumber;
    private JLabel laName;
    private JPanel paAction;
    private JPopupMenu pmMenu;
    private JMenuItem imFilterByAll;
    private JMenuItem imFilterByPrivat;
    private JMenuItem imFilterByOffical;

    private MiniTelModel mtm = new MiniTelModel();

    public MiniTelGUI() {
        initComponents();

        liTelNumbers.setModel(mtm);
        liTelNumbers.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        btSave.addActionListener(e -> onSaveEntry());
        btDelete.addActionListener(e -> onRemoveEntry());
        liTelNumbers.addListSelectionListener(e -> onSelectEntry());
        imFilterByAll.addActionListener(e -> onDisplayAllEntries());
        imFilterByPrivat.addActionListener(e -> onDisplayPrivatEntries());
        imFilterByOffical.addActionListener(e -> onDisplayOfficalEntries());
    }

    public void initComponents() {
        this.setTitle("MiniTelGUI");
        this.setContentPane(paMain);

        pmMenu = new JPopupMenu();

        imFilterByAll = new JMenuItem("all");
        imFilterByPrivat = new JMenuItem("privat");
        imFilterByOffical = new JMenuItem("offical");

        liTelNumbers.setComponentPopupMenu(pmMenu);

        pmMenu.add(imFilterByAll);
        pmMenu.add(imFilterByPrivat);
        pmMenu.add(imFilterByOffical);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private void onRemoveEntry() {
        mtm.removeEntry(liTelNumbers.getSelectedValuesList());
    }

    private void onSaveEntry() {
        if(isBlank()) return;
        if(!tfNumber.getText().contains("/") || !tfNumber.getText().startsWith("0")) {
            JOptionPane.showMessageDialog(new JLabel(), "The number format is: 0XXX/XXXXXXX", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return;
        }

        mtm.insertEntry(new MiniTelEntry(tfName.getText(), tfNumber.getText(), rbWork.isSelected()));
    }

    public void onSelectEntry() {
        MiniTelEntry entry = liTelNumbers.getSelectedValue();
        tfName.setText(entry.getName());
        tfNumber.setText(entry.getNumber());
        if(entry.isOffical()) {
            rbWork.setSelected(true);
        } else {
            rbPrivate.setSelected(true);
        }
    }

    public boolean isBlank() {
        if(tfName.getText().isBlank()) {
            JOptionPane.showMessageDialog(new JLabel(), "Please type a name!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return true;
        } else if(tfNumber.getText().isBlank()) {
            JOptionPane.showMessageDialog(new JLabel(), "Please type a number!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
            return true;
        } else {
            return false;
        }
    }

    private void onDisplayOfficalEntries() {
        mtm.filterEntries("offical");
    }

    private void onDisplayPrivatEntries() {
        mtm.filterEntries("privat");
    }

    private void onDisplayAllEntries() {
        mtm.filterEntries("all");
    }

    public static void main(String[] args) {
        MiniTelGUI gui = new MiniTelGUI();
        gui.setVisible(true);
    }
}
