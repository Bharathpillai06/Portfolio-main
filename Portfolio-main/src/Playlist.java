public interface Playlist extends PlaylistKernel {
    /**
     * Shuffles the playlist randomly.
     *
     * @updates this
     * @ensures this = [a permutation of #this]
     */
    void shuffle();

    /**
     * Returns the current song being played.
     *
     * @return the current song
     * @ensures currentSong is in this
     */
    String currentSong();
}
