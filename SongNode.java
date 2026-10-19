/**
 * SongNode class
 * Represents a song in the playlist
 *
 * Name Kerem Dündar
 * Student ID 250446034
 * Date 19 10 2026
 */
public class SongNode {

    String title;

    SongNode prev;
    SongNode next;

    public SongNode(String title) {
        this.title = title;
        this.prev = null;
        this.next = null;
    }
}
