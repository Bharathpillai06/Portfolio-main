public interface PlaylistKernel extends Standard<Playlist> {
    /**
     * Adds a song to this playlist.
     * 
     * @param song the song to add
     * @updates this
     * @ensures this = #this * <song>
     */
    void add(String song);

    /**
     * Removes and returns the first song in this playlist.
     *
     * @updates this
     * @ensures remove = [the song removed from this]
     */
    String remove();
}
