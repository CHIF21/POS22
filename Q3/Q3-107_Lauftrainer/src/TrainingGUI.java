import beans.Route;
import beans.Training;
import bl.TrainingsModel;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TrainingGUI extends JFrame {
    private JPanel paMain;
    private JList<Route> liRouteData;
    private JButton btSortByTime;
    private JList<Training> liTrainingData;
    private JButton btInsertTraining;
    private JTextField tfTime;
    private JTextField tfDate;
    private JButton btInsertRoute;
    private JTextField tfDistance;
    private JTextField tfName;
    private JPanel paRoute;
    private JPanel paTrainingList;
    private JLabel lbName;
    private JLabel lbDistance;
    private JPanel paTrainingAction;
    private JPanel paRouteAction;
    private JLabel lbDate;
    private JLabel lbTime;
    private JPanel paContainer;
    private final DefaultListModel<Route> dlm = new DefaultListModel<>();
    private final TrainingsModel tlm = new TrainingsModel();

    public TrainingGUI() {
        init();

        liRouteData.setModel(dlm);
        liTrainingData.setModel(tlm);

        liRouteData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        liTrainingData.setModel(tlm);

        btSortByTime.addActionListener(e -> onSort());
        btInsertRoute.addActionListener(e -> onAddRoute());
        btInsertTraining.addActionListener(e -> onAddTraining());

        liRouteData.addListSelectionListener(e -> tlm.filterTraining(liRouteData.getSelectedValue()));
    }

    public void onAddRoute() {
        if(tfName.getText().isEmpty() || tfDistance.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JLabel(), "Please fill all required fields!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Route route = null;

        try {
            route = new Route(tfName.getText(), Double.parseDouble(tfDistance.getText()));
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(new JLabel(), "The distance must be a number!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(!dlm.contains(route)) {
            dlm.addElement(route);
        } else {
            JOptionPane.showMessageDialog(new JLabel(), "This route already exist!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void onAddTraining() {
        if(liRouteData.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(new JLabel(), "Please select a route!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(tfDate.getText().isEmpty() || tfTime.getText().isEmpty()){
            JOptionPane.showMessageDialog(new JLabel(), "Please fill all required fields!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        LocalDate ld = null;
        LocalTime lt = null;

        try {
            ld = LocalDate.parse(tfDate.getText(), Training.getDtf_Date());
        } catch(DateTimeException e) {
            JOptionPane.showMessageDialog(new JLabel(), "The date format must be: dd.MMM.yyyy", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            lt = LocalTime.parse(tfTime.getText(), Training.getDtf_Time());
        } catch(DateTimeException e) {
            JOptionPane.showMessageDialog(new JLabel(), "The time format must be: HH:mm:ss", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Training training = new Training(ld, lt, liRouteData.getSelectedValue());
        try {
            tlm.addTraining(training);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JLabel(), "You can't add a training on the same day!", "Something went wrong", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void onSort() {
        tlm.sortTraining();
    }

    public void init() {
        setTitle("TrainingGUI");
        setContentPane(paMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        TrainingGUI gui = new TrainingGUI();
        gui.setVisible(true);
    }
}
