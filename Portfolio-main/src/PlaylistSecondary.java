import java.util.Objects;
import java.util.Random;

public abstract class PlaylistSecondary implements Playlist {

    @Override
    public final void skip() {
        assert !this.isEmpty() : "Violation of: this is not empty";
        this.add(this.remove());
    }

    @Override
    public final Song currentSong() {
        assert !this.isEmpty() : "Violation of: this is not empty";
        int n = this.length();
        Song first = this.remove();
        this.add(first);
        for (int i = 1; i < n; i++) {
            this.add(this.remove());
        }
        return first;
    }
@Override
public final int length() {
    Playlist temp = this.newInstance();
    int count = 0;

    while (!this.isEmpty()) {
        Song s = this.remove();
        temp.add(s);
        count++;
    }

    this.transferFrom(temp);

    return count;
}

    @Override
    public final void shuffle() {
        int n = this.length();
        if (n <= 1) return;
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            int k = rnd.nextInt(n);    
            for (int r = 0; r < k; r++) {
                this.add(this.remove()); 
            }
        }
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int n = this.length();
        for (int i = 0; i < n; i++) {
            Song x = this.remove();
            if (i > 0) sb.append(", ");
            sb.append(x);
            this.add(x);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Playlist)) return false;
        Playlist other = (Playlist) obj;

        int n1 = this.length(), n2 = other.length();
        if (n1 != n2) return false;

        boolean eq = true;
        for (int i = 0; i < n1; i++) {
            Song a = this.remove();
            Song b = other.remove();
            if (!Objects.equals(a, b)) eq = false;
            this.add(a);
            other.add(b);
        }
        return eq;
    }

    @Override
    public final int hashCode() {
        int n = this.length();
        int h = 1;
        for (int i = 0; i < n; i++) {
            Song x = this.remove();
            h = 31 * h + Objects.hashCode(x);
            this.add(x);
        }
        return h;
    }
}
