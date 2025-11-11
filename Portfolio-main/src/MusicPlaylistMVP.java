import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MusicPlaylistMVP
 *
 * Proof-of-concept (MVP) for a playlist component.
 *
 * Why this design? It’s small but realistic: it models songs, supports core edits
 * (add/remove), and shows secondary behaviors users expect (shuffle/skip/current).
 * Using a single file and standard Java collections keeps scope tight while proving
 * the idea is feasible to adapt to the OSU discipline later (kernel + secondary).
 */
public class MusicPlaylistMVP {

    /* ------------------------- Simple inner data type ------------------------- */
    /** Minimal Song record to avoid extra files for the MVP. */
    public static class Song {
        private final String title;
        private final String artist;
        private final int durationSec; // optional metadata

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

    /* ---------------------------- Representation ----------------------------- */
    private final List<Song> songs = new ArrayList<>();
    /** Index of the “current” song for playback semantics; -1 means empty. */
    private int currentIndex = -1;

    /* ----------------------------- Kernel methods ---------------------------- */

    /** Adds a song to the end of the playlist. */
    public void add(Song s) {
        if (s == null) throw new IllegalArgumentException("song is null");
        songs.add(s);
        if (currentIndex == -1) currentIndex = 0; // first add -> make current
    }

    /**
     * Removes and returns the last added song (stack-like remove).
     * If empty, throws IllegalStateException.
     */
    public Song remove() {
        if (isEmpty()) throw new IllegalStateException("playlist is empty");
        Song removed = songs.remove(songs.size() - 1);
        if (songs.isEmpty()) {
            currentIndex = -1;
        } else if (currentIndex >= songs.size()) {
            // If we removed the last element and current pointed past end, step back.
            currentIndex = songs.size() - 1;
        }
        return removed;
    }

    /** Reports whether the playlist is empty. */
    public boolean isEmpty() {
        return songs.isEmpty();
    }

    /* --------------------------- Secondary methods --------------------------- */

    /** Reorders songs randomly; preserves a valid currentIndex. */
    public void shuffle() {
        if (songs.size() <= 1) return;
        Song current = currentSong(); // remember the current track
        Collections.shuffle(songs);
        // restore currentIndex so current song stays current after shuffle
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i) == current) { currentIndex = i; break; }
        }
    }

    /** Moves to the next song (wraps around). No-op on empty. */
    public void skip() {
        if (songs.isEmpty()) return;
        currentIndex = (currentIndex + 1) % songs.size();
    }

    /** Returns the current song without removing it; null if empty. */
    public Song currentSong() {
        return isEmpty() ? null : songs.get(currentIndex);
    }

    /** Returns the number of songs in the playlist. */
    public int length() {
        return songs.size();
    }

    /** Convenience: prints the playlist with the current song highlighted. */
    public void print() {
        if (isEmpty()) {
            System.out.println("[empty]");
            return;
        }
        for (int i = 0; i < songs.size(); i++) {
            String marker = (i == currentIndex) ? "▶ " : "  ";
            System.out.println(marker + (i + 1) + ". " + songs.get(i));
        }
    }

    /* --------------------------------- Demo ---------------------------------- */

    /**
     * Main method shows the component in action (required by rubric):
     * - Constructs the component
     * - Uses a variety of methods
     * - Demonstrates value (managing and navigating a playlist)
     */
    public static void main(String[] args) {
        MusicPlaylistMVP pl = new MusicPlaylistMVP();

        // Add a handful of songs (kernel: add)
        pl.add(new Song("Primavera", "Ludovico Einaudi", 218));
        pl.add(new Song("Dreams", "Fleetwood Mac", 257));
        pl.add(new Song("HUMBLE.", "Kendrick Lamar", 177));
        pl.add(new Song("As It Was", "Harry Styles", 167));

        System.out.println("Initial playlist:");
        pl.print();
        System.out.println("Current: " + pl.currentSong()); // secondary: currentSong

        // Skip a couple of times (secondary: skip)
        System.out.println("\nSkip twice:");
        pl.skip();
        pl.skip();
        pl.print();

        // Shuffle the playlist (secondary: shuffle) while preserving current
        System.out.println("\nShuffle (current preserved):");
        pl.shuffle();
        pl.print();

        // Remove last-added (kernel: remove)
        System.out.println("\nRemove last-added: " + pl.remove());
        pl.print();
        System.out.println("Length: " + pl.length()); // secondary: length

        // Show empty handling quickly
        System.out.println("\nClearing playlist:");
        while (!pl.isEmpty()) {
            System.out.println("Removed: " + pl.remove());
        }
        System.out.println("Empty? " + pl.isEmpty());
        pl.print();
    }
}
