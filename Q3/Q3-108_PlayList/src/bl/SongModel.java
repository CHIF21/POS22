package bl;

import beans.Song;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SongModel extends AbstractListModel<Song> {

    private List<Song> allSongs;
    private List<Song> filteredSongs;

    private String strFilter = "none";

    public SongModel() {
        allSongs = new ArrayList<>();
        filteredSongs = new ArrayList<>(allSongs);
    }

    public SongModel(List<Song> songs) {
        allSongs = new ArrayList<>(songs);
        filteredSongs = new ArrayList<>(allSongs);
    }

    @Override
    public int getSize() {
        return filteredSongs.size();
    }

    @Override
    public Song getElementAt(int index) {
        return filteredSongs.get(index);
    }

    public void addSong(Song song) throws Exception {
        if(!allSongs.contains(song)) {
            allSongs.add(song);
            filterByInterpret();
        } else {
            throw new Exception("This song already exists!");
        }
    }

    public void removeSong(List<Song> values) {
        allSongs.removeAll(values);
        filterByInterpret();
    }

    public void sort(String sortBy) throws Exception {
        switch (sortBy.toLowerCase()) {
            case "title" -> {
                Collections.sort(allSongs, new ComperatorTitel());
            }

            case "length" -> {
                Collections.sort(allSongs, new ComperatorLength());
            }

            default -> {
                throw new Exception("Error: wrong sort key!");
            }
        }

        filterByInterpret();
    }

    public void filterByInterpret() {
        filterByInterpret(strFilter);
    }

    public void filterByInterpret(String interpret) {
        filteredSongs.clear();
        if(interpret.equalsIgnoreCase("none"))
        {
            filteredSongs.addAll(allSongs);
        } else {
            allSongs.forEach(song -> {
                if(song.getArtist().equalsIgnoreCase(interpret))
                    filteredSongs.add(song);
            });
        }

        this.fireContentsChanged(this, 0, filteredSongs.size()-1);
    }
}
