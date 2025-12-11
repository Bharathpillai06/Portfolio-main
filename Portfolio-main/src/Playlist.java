// Playlist.java
public interface Playlist extends PlaylistKernel {
    /**
     * Shuffles the playlist randomly.
     * @updates this
     * @ensures this = [a permutation of #this]
     */
    void shuffle();

    /**
     * Advances the current song (front) to the back.
     * @updates this
     * @requires !this.isEmpty()
     * @ensures this = tail(#this) * <front(#this)>
     */
    void skip();

    /**
     * Returns (but does not remove) the current song (front).
     * @requires !this.isEmpty()
     * @return the front song
     * @ensures currentSong is in this  && this = #this
     */
    Song currentSong();

    /**
     * Returns the number of songs.
     * @return this
     */
    int length();
}
