package bl;

import beans.Song;

import java.util.Comparator;

public class ComperatorLength implements Comparator<Song> {
    @Override
    public int compare(Song o1, Song o2) {
        return o1.getLength() - o2.getLength();
    }
}
