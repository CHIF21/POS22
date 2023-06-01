import beans.Song;
import bl.PlayListData;
import bl.SongModel;

import javax.swing.*;
import java.util.Arrays;

public class PlayListGUI extends JFrame implements PlayListData {
    private JButton btnAdd;
    private JButton btnRemove;
    private JLabel laPlaytimeSongs;
    private JLabel laPlaytimeBack;
    private JPanel paSongs;
    private JList<Song> liSongsData;
    private JList<Song> liPlaybackData;
    private JPanel paPlayback;
    private JPanel paMain;

    private SongModel allsongsALM = new SongModel(Arrays.asList(songs));
    private SongModel playbackALM = new SongModel();
    private JMenu menu;
    private JMenuItem miSortByLength;
    private JMenuItem miSortByTitle;
    private JMenuItem miFilterByInterpret;
    private JPopupMenu pmSortFilter;


    public PlayListGUI() {
        liSongsData.setModel(allsongsALM);
        liPlaybackData.setModel(playbackALM);

        liSongsData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        liPlaybackData.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        init();

        btnAdd.addActionListener(e -> onAddSong());
        btnRemove.addActionListener(e -> onRemoveSong());
        miSortByTitle.addActionListener(e -> {
            try {
                allsongsALM.sort(e.getActionCommand());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JLabel(), ex.getMessage(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
            }
        });
        miSortByLength.addActionListener(e -> {
            try {
                allsongsALM.sort(e.getActionCommand());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new JLabel(), ex.getMessage(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
            }
        });
        miFilterByInterpret.addActionListener(e -> onFilterByInterpret());
    }

    private void onFilterByInterpret() {
        String interpret = JOptionPane.showInputDialog("What interpret do you want to filter: ");
        try {
            allsongsALM.filterByInterpret(interpret);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JLabel(), "Please define the interpret!", "Something went wrong", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onRemoveSong() {
        playbackALM.removeSong(liPlaybackData.getSelectedValuesList());
        laPlaytimeBack.setText(String.format("Playtime: %02d:%02d", playtime(playbackALM)/60, playtime(playbackALM)%60));
    }

    private void onAddSong() {
        try {
            playbackALM.addSong(liSongsData.getSelectedValue());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JLabel(), e.getMessage(), "Warning!", JOptionPane.INFORMATION_MESSAGE);
        }
        laPlaytimeBack.setText(String.format("Playtime: %02d:%02d", playtime(playbackALM)/60, playtime(playbackALM)%60));
    }

    public int playtime(SongModel alm) {
        int playtime = 0;
        for(int i = 0; i < alm.getSize(); i++) {
            playtime += alm.getElementAt(i).getLength();
        }

        return playtime;
    }

    public void init() {
        setTitle("PlayListGUI");
        setContentPane(paMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        laPlaytimeSongs.setText(String.format("Playtime: %02d:%02d", playtime(allsongsALM)/60, playtime(allsongsALM)%60));

        pmSortFilter = new JPopupMenu();
        liSongsData.setComponentPopupMenu(pmSortFilter);

        menu = new JMenu("sort by");

        miSortByTitle = new JMenuItem("title");
        miSortByTitle.setActionCommand("title");
        menu.add(miSortByTitle);

        miSortByLength = new JMenuItem("length");
        miSortByLength.setActionCommand("length");
        menu.add(miSortByLength);

        miFilterByInterpret = new JMenuItem("filter by interpret");
        pmSortFilter.add(menu);
        pmSortFilter.add(miFilterByInterpret);

        pack();
        setLocationRelativeTo(null);
        setSize(450, 500);
    }

    public static void main(String[] args) {
        PlayListGUI gui = new PlayListGUI();
        gui.setVisible(true);
    }
}
