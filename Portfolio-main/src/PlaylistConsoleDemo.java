/**
 * Simple demo showing basic usage of the Playlist component.
 */
public final class PlaylistConsoleDemo {

    private PlaylistConsoleDemo() {
    }

    /**
     * Main program.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {

        Playlist playlist = new Playlist1L();

        // Add some songs
        playlist.add(new Song("Intro", "Lo-Fi Beats", 90));
        playlist.add(new Song("Focus Flow", "Lo-Fi Beats", 180));
        playlist.add(new Song("Night Coding", "Lo-Fi Beats", 240));

        // Show initial playlist
        System.out.println("Initial playlist:");
        System.out.println(playlist);
        System.out.println("Length: " + playlist.length() + " songs");
        System.out.println("Current song: " + playlist.currentSong());
        System.out.println();

        // Skip the current song
        System.out.println("Skipping current song...");
        playlist.skip();
        System.out.println("Now playing: " + playlist.currentSong());
        System.out.println("Playlist order after skip:");
        System.out.println(playlist);
        System.out.println();

        // Shuffle the playlist
        System.out.println("Shuffling playlist...");
        playlist.shuffle();
        System.out.println("Playlist after shuffle:");
        System.out.println(playlist);
        System.out.println("Now playing: " + playlist.currentSong());
        System.out.println();

        // Remove songs one by one
        System.out.println("Clearing playlist by removing songs one at a time:");
        while (!playlist.isEmpty()) {
            Song removed = playlist.remove();
            System.out.println("Removed: " + removed);
        }

        System.out.println("Playlist empty? " + playlist.isEmpty());
    }
}
