import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test cases for Playlist using Playlist1L and PlaylistSecondary.
 * Tests the secondary methods and overall behavior of Playlist.
 */
public class PlaylistSecondaryTest {

    /**
     * Helper to create a Song with a given title.
     */
    private Song song(String title) {
        return new Song(title, "Test Artist", 180);
    }

    /**
     * Helper to create a new empty Playlist.
     */
    private Playlist createEmpty() {
        return new Playlist1L();
    }

    /**
     * Test length method for zero.
     */
    @Test
    public void testLengthForZero() {
        Playlist p = this.createEmpty();

        assertEquals(0, p.length());
    }

    /**
     * Test length method for one.
     */
    @Test
    public void testLengthForOne() {
        Playlist p = this.createEmpty();
        p.add(this.song("Song A"));

        assertEquals(1, p.length());
    }

    /**
     * Test length method for many.
     */
    @Test
    public void testLengthForMany() {
        Playlist p = this.createEmpty();
        p.add(this.song("Song A"));
        p.add(this.song("Song B"));
        p.add(this.song("Song C"));

        assertEquals(3, p.length());
    }

    /**
     * Test skip method for a single-song playlist (should be a no-op).
     */
    @Test
    public void testSkipForOne() {
        Playlist p = this.createEmpty();
        Song s = this.song("Song A");
        p.add(s);

        p.skip();

        assertEquals(1, p.length());
        assertEquals(s, p.currentSong());
    }

    /**
     * Test skip method for many songs.
     */
    @Test
    public void testSkipForMany() {
        Playlist p = this.createEmpty();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");
        Song s3 = this.song("Song C");

        p.add(s1);
        p.add(s2);
        p.add(s3);

        p.skip();

        assertEquals(3, p.length());
        assertEquals(s2, p.currentSong());
    }

    /**
     * Test currentSong method (does not remove).
     */
    @Test
    public void testCurrentSongDoesNotRemove() {
        Playlist p = this.createEmpty();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");

        p.add(s1);
        p.add(s2);

        Song current = p.currentSong();

        assertEquals(s1, current);
        assertEquals(2, p.length());
        assertEquals(s1, p.currentSong());
    }

    /**
     * Test shuffle method for zero (no exception, no change).
     */
    @Test
    public void testShuffleForZero() {
        Playlist p = this.createEmpty();

        p.shuffle();

        assertTrue(p.isEmpty());
        assertEquals(0, p.length());
    }

    /**
     * Test shuffle method for one (should not change).
     */
    @Test
    public void testShuffleForOne() {
        Playlist p = this.createEmpty();
        Song s = this.song("Song A");
        p.add(s);

        p.shuffle();

        assertEquals(1, p.length());
        assertEquals(s, p.currentSong());
    }

    /**
     * Test shuffle method for many (length and contents preserved).
     */
    @Test
    public void testShuffleForMany() {
        Playlist p = this.createEmpty();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");
        Song s3 = this.song("Song C");

        p.add(s1);
        p.add(s2);
        p.add(s3);

        int beforeLen = p.length();
        p.shuffle();
        int afterLen = p.length();

        assertEquals(beforeLen, afterLen);

        // All original songs still present somewhere by skipping through
        boolean hasA = false, hasB = false, hasC = false;
        for (int i = 0; i < afterLen; i++) {
            Song cur = p.currentSong();
            if (cur == s1) {
                hasA = true;
            }
            if (cur == s2) {
                hasB = true;
            }
            if (cur == s3) {
                hasC = true;
            }
            p.skip();
        }

        assertTrue(hasA && hasB && hasC);
    }

    /**
     * Test equals method for zero.
     */
    @Test
    public void testEqualsForZero() {
        Playlist p1 = this.createEmpty();
        Playlist p2 = this.createEmpty();

        assertTrue(p1.equals(p2));
    }

    /**
     * Test equals method for one.
     */
    @Test
    public void testEqualsForOne() {
        Playlist p1 = this.createEmpty();
        Playlist p2 = this.createEmpty();
        Song s = this.song("Song A");

        p1.add(s);
        p2.add(s);

        assertTrue(p1.equals(p2));
    }

    /**
     * Test equals method for many.
     */
    @Test
    public void testEqualsForMany() {
        Playlist p1 = this.createEmpty();
        Playlist p2 = this.createEmpty();

        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");
        Song s3 = this.song("Song C");

        // Use the same Song objects in both playlists
        p1.add(s1);
        p1.add(s2);
        p1.add(s3);

        p2.add(s1);
        p2.add(s2);
        p2.add(s3);

        assertTrue(p1.equals(p2));
    }

    /**
     * Test equals method for different playlists.
     */
    @Test
    public void testEqualsForDifferent() {
        Playlist p1 = this.createEmpty();
        Playlist p2 = this.createEmpty();

        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");

        p1.add(s1);
        p2.add(s2);

        assertEquals(false, p1.equals(p2));
    }

    /**
     * Test equals method for the same instance.
     */
    @Test
    public void testEqualsForSameInstance() {
        Playlist p = this.createEmpty();
        p.add(this.song("Song A"));
        p.add(this.song("Song B"));

        assertTrue(p.equals(p));
    }

    /**
     * Test toString method for zero.
     */
    @Test
    public void testToStringForZero() {
        Playlist p = this.createEmpty();

        assertEquals("[]", p.toString());
    }

    /**
     * Test toString method for one.
     */
    @Test
    public void testToStringForOne() {
        Playlist p = this.createEmpty();
        Song s = this.song("Song A");

        p.add(s);

        String expected = "[" + s.toString() + "]";
        assertEquals(expected, p.toString());
    }

    /**
     * Test toString method for many.
     */
    @Test
    public void testToStringForMany() {
        Playlist p = this.createEmpty();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");
        Song s3 = this.song("Song C");

        p.add(s1);
        p.add(s2);
        p.add(s3);

        String expected = "[" + s1.toString() + ", "
                + s2.toString() + ", " + s3.toString() + "]";

        assertEquals(expected, p.toString());
    }
}
