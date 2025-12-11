// PlaylistKernel.java
import components.standard.Standard;

public interface PlaylistKernel extends Standard<Playlist> {
    /**
     * Adds a song to the back of this playlist.
     * @param song the song to add
     * @updates this
     * @ensures this = #this * <song>
     */
    void add(Song song);

    /**
     * Removes and returns the front song in this playlist.
     * @updates this
     * @requires !this.isEmpty()
     * @return the song removed
     * @ensures remove is the front of #this  &&  this = [#this without its front]
     */
    Song remove();

    /**
     * Reports whether this playlist is empty.
     * @return true iff this has no songs
     */
    boolean isEmpty();
}
