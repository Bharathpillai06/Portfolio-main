import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MusicPlaylistMVP {

    public static class Song {
        private final String title;
        private final String artist;
        private final int durationSec;

        public Song(String title, String artist, int durationSec) {
            this.title = title;
            this.artist = artist;
            this.durationSec = durationSec;
        }
        public String title()   { return title; }
        public String artist()  { return artist; }
        public int durationSec(){ return durationSec; }
        @Override public String toString() {
            return "\"" + title + "\" — " + artist + " (" + durationSec + "s)";
        }
    }

    private final List<Song> songs = new ArrayList<>();
    private int currentIndex = -1;

    public void add(Song s) {
        if (s == null) throw new IllegalArgumentException("song is null");
        songs.add(s);
        if (currentIndex == -1) currentIndex = 0;
    }

    public Song remove() {
        if (isEmpty()) throw new IllegalStateException("playlist is empty");
        Song removed = songs.remove(songs.size() - 1);
        if (songs.isEmpty()) currentIndex = -1;
        else if (currentIndex >= songs.size()) currentIndex = songs.size() - 1;
        return removed;
    }

    public boolean isEmpty() { return songs.isEmpty(); }

    public void shuffle() {
        if (songs.size() <= 1) return;
        Song current = currentSong();
        Collections.shuffle(songs);
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i) == current) { currentIndex = i; break; }
        }
    }

    public void skip() {
        if (songs.isEmpty()) return;
        currentIndex = (currentIndex + 1) % songs.size();
    }

    public Song currentSong() {
        return isEmpty() ? null : songs.get(currentIndex);
    }

    public int length() { return songs.size(); }

    public void print() {
        if (isEmpty()) { System.out.println("[empty]"); return; }
        for (int i = 0; i < songs.size(); i++) {
            String marker = (i == currentIndex) ? "▶ " : "  ";
            System.out.println(marker + (i + 1) + ". " + songs.get(i));
        }
    }

    public static void main(String[] args) {
        MusicPlaylistMVP pl = new MusicPlaylistMVP();

        pl.add(new Song("Primavera", "Ludovico Einaudi", 218));
        pl.add(new Song("Dreams", "Fleetwood Mac", 257));
        pl.add(new Song("HUMBLE.", "Kendrick Lamar", 177));
        pl.add(new Song("As It Was", "Harry Styles", 167));

        System.out.println("Initial playlist:");
        pl.print();
        System.out.println("Current: " + pl.currentSong());

        System.out.println("\nSkip twice:");
        pl.skip(); pl.skip();
        pl.print();

        System.out.println("\nShuffle (current preserved):");
        pl.shuffle();
        pl.print();

        System.out.println("\nRemove last-added: " + pl.remove());
        pl.print();
        System.out.println("Length: " + pl.length());

        System.out.println("\nClearing playlist:");
        while (!pl.isEmpty()) System.out.println("Removed: " + pl.remove());
        System.out.println("Empty? " + pl.isEmpty());
        pl.print();
    }
}