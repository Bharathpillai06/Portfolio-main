import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * JUnit test cases for Playlist1L using the OSU Components API.
 * Tests the kernel and Standard methods for Playlist.
 */
public class Playlist1LTest {

    /**
     * Helper to create a Song with a given title.
     */
   private Song song(String title) {
    // Song(String title, String artist, int durationSec)
    return new Song(title, "Test Artist", 180);
}


    /**
     * Test default constructor: playlist should be empty.
     */
    @Test
    public void testConstructorEmpty() {
        Playlist p = new Playlist1L();

        assertTrue(p.isEmpty());
        assertEquals(0, p.length());
    }

    /**
     * Test add kernel method with 0 songs.
     */
    @Test
    public void testAddZeroToOne() {
        Playlist p = new Playlist1L();
        Song s = this.song("Song A");

        p.add(s);

        assertTrue(!p.isEmpty());
        assertEquals(1, p.length());
        assertEquals(s, p.currentSong());
    }

    /**
     * Test add method when 1 song is already present.
     */
    @Test
    public void testAddOneToTwo() {
        Playlist p = new Playlist1L();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");

        p.add(s1);
        p.add(s2);

        assertEquals(2, p.length());
        assertEquals(s1, p.currentSong());
    }

    /**
     * Test add method with many songs.
     */
    @Test
    public void testAddMany() {
        Playlist p = new Playlist1L();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");
        Song s3 = this.song("Song C");

        p.add(s1);
        p.add(s2);
        p.add(s3);

        assertEquals(3, p.length());
        assertEquals(s1, p.currentSong());
    }

    /**
     * Test isEmpty method when there are 0 songs.
     */
    @Test
    public void testIsEmptyZero() {
        Playlist p = new Playlist1L();

        assertTrue(p.isEmpty());
    }

    /**
     * Test isEmpty method when there is 1 song.
     */
    @Test
    public void testIsEmptyOne() {
        Playlist p = new Playlist1L();
        p.add(this.song("Song A"));

        assertTrue(!p.isEmpty());
    }

    /**
     * Test remove method with 1 song in the playlist.
     */
    @Test
    public void testRemoveOne() {
        Playlist p = new Playlist1L();
        Song s = this.song("Song A");
        p.add(s);

        Song removed = p.remove();

        assertEquals(s, removed);
        assertTrue(p.isEmpty());
        assertEquals(0, p.length());
    }

    /**
     * Test remove method with many songs in the playlist.
     */
    @Test
    public void testRemoveMany() {
        Playlist p = new Playlist1L();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");

        p.add(s1);
        p.add(s2);

        Song removed = p.remove();

        assertEquals(s1, removed);
        assertEquals(1, p.length());
        assertEquals(s2, p.currentSong());
    }

    /**
     * Test clear method for one.
     */
    @Test
    public void testClearForOne() {
        Playlist p = new Playlist1L();
        p.add(this.song("Song A"));

        p.clear();

        assertTrue(p.isEmpty());
        assertEquals(0, p.length());
    }

    /**
     * Test clear method for many.
     */
    @Test
    public void testClearForMany() {
        Playlist p = new Playlist1L();
        p.add(this.song("Song A"));
        p.add(this.song("Song B"));
        p.add(this.song("Song C"));

        p.clear();

        assertTrue(p.isEmpty());
        assertEquals(0, p.length());
    }

    /**
     * Test newInstance method for zero.
     */
    @Test
    public void testNewInstanceForZero() {
        Playlist p = new Playlist1L();
        Playlist p2 = p.newInstance();

        assertTrue(p2.isEmpty());
        assertEquals(0, p2.length());
    }

    /**
     * Test newInstance method when the original has songs.
     */
    @Test
    public void testNewInstanceForNonEmpty() {
        Playlist p = new Playlist1L();
        p.add(this.song("Song A"));
        p.add(this.song("Song B"));

        Playlist p2 = p.newInstance();

        assertTrue(p2.isEmpty());
        assertEquals(0, p2.length());
        // Original is unchanged
        assertEquals(2, p.length());
    }

    /**
     * Test transferFrom method for zero.
     */
    @Test
    public void testTransferFromForZero() {
        Playlist target = new Playlist1L();
        Playlist source = new Playlist1L();

        target.transferFrom(source);

        assertTrue(target.isEmpty());
        assertTrue(source.isEmpty());
    }

    /**
     * Test transferFrom method for one.
     */
    @Test
    public void testTransferFromForOne() {
        Playlist target = new Playlist1L();
        Playlist source = new Playlist1L();
        Song s = this.song("Song A");

        source.add(s);
        target.transferFrom(source);

        assertEquals(1, target.length());
        assertEquals(s, target.currentSong());
        assertTrue(source.isEmpty());
    }

    /**
     * Test transferFrom method for many.
     */
    @Test
    public void testTransferFromForMany() {
        Playlist target = new Playlist1L();
        Playlist source = new Playlist1L();
        Song s1 = this.song("Song A");
        Song s2 = this.song("Song B");
        Song s3 = this.song("Song C");

        source.add(s1);
        source.add(s2);
        source.add(s3);

        target.transferFrom(source);

        assertEquals(3, target.length());
        assertEquals(s1, target.currentSong());
        assertTrue(source.isEmpty());
    }
}
