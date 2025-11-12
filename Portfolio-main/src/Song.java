// Song.java
public final class Song {
    private final String title;
    private final String artist;
    private final int durationSec;

    public Song(String title, String artist, int durationSec) {
        this.title = title;
        this.artist = artist;
        this.durationSec = durationSec;
    }
    public String title()    { return title; }
    public String artist()   { return artist; }
    public int durationSec() { return durationSec; }

    @Override public String toString() {
        return "\"" + title + "\" — " + artist + " (" + durationSec + "s)";
    }
}
