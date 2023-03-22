import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MinMaxSuche {
    private JPanel paMain;
    private JButton btCalculate;
    private JTextArea taArray;
    private JTextField tfMax;
    private JTextField tfMin;
    private JLabel lbMax;
    private JLabel lbMin;
    private JLabel lbArray;

    private int[] array = new int[100];
    private int min = 0;
    private int max = 0;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void calculateMinMax() {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(min > array[i]) {
                min = array[i];
            }
        }
        setMin(min);

        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        setMax(max);
    }

    public MinMaxSuche() {
        Random rand = new Random();

        for(int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0, 1000);
        }

        btCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String output = "";
                for(int i = 0; i < array.length; i++) {
                    output += ((i-9) % 10 == 0) ? String.format("%4d\n", array[i]) : String.format("%4d,", array[i]);
                }
                taArray.setText(output);
                calculateMinMax();
                tfMin.setText(String.valueOf(getMin()));
                tfMax.setText(String.valueOf(getMax()));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MinMaxSuche");
        frame.setContentPane(new MinMaxSuche().paMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(350, 400);
        frame.setVisible(true);
    }
}
