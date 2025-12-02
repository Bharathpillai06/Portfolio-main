import components.queue.Queue;
import components.queue.Queue1L;

/**
 * Playlist kernel implementation using an OSU Queue as the representation.
 *
 * Convention:
 *  - this.rep is not null
 *  - this.rep contains no null Song references
 *
 * Correspondence:
 *  - The abstract value of this Playlist is the sequence of Songs stored in
 *    this.rep from front to back. If this.rep = <s0, s1, ..., s_(n-1)>,
 *    then this playlist = <s0, s1, ..., s_(n-1)>.
 */
public final class Playlist1L extends PlaylistSecondary {

    /**
     * Underlying representation: a queue of songs.
     * The front of the queue is the front of the playlist.
     */
    private Queue<Song> rep;

    /**
     * Creates a new, empty representation.
     */
    private void createNewRep() {
        this.rep = new Queue1L<>();
    }

    /**
     * Default constructor: initializes this to an empty playlist.
     */
    public Playlist1L() {
        this.createNewRep();
    }

    // ---------------------------------------------------------------------
    // Kernel methods (from PlaylistKernel)
    // ---------------------------------------------------------------------

    @Override
    public void add(Song song) {
        assert song != null : "Violation of: song is not null";
        this.rep.enqueue(song); // adds to the back of the playlist
    }

    @Override
    public Song remove() {
        assert !this.isEmpty() : "Violation of: this is not empty";
        return this.rep.dequeue(); // removes from the front
    }

    @Override
    public boolean isEmpty() {
        return this.rep.length() == 0;
    }

    // ---------------------------------------------------------------------
    // Standard methods (from Standard<Playlist>)
    // ---------------------------------------------------------------------

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Playlist newInstance() {
        return new Playlist1L();
    }

    @Override
    public void transferFrom(Playlist source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Playlist1L
                : "Violation of: source is of dynamic type Playlist1L";

        Playlist1L local = (Playlist1L) source;
        this.rep = local.rep;
        local.createNewRep();
    }
}
