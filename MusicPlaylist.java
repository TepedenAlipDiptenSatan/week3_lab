/**
 * MusicPlaylist class
 * Doubly linked list for the music playlist
 *
 * Name Kerem Dündar
 * Student ID 250446034
 * Date 19 10 2026
 */
public class MusicPlaylist {

    private SongNode head;
    private SongNode tail;
    private SongNode current;

    public MusicPlaylist() {
        head = null;
        tail = null;
        current = null;
    }

    // add song at the end
    public void addSong(String title) {
        SongNode newNode = new SongNode(title);

        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeSong(String title) {
        SongNode target = head;

        while (target != null && !target.title.equals(title)) {
            target = target.next;
        }

        if (target == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        // keep current valid if it is removed
        if (current == target) {
            if (target.next != null) {
                current = target.next;
            } else {
                current = target.prev;
            }
        }

        // update the links
        if (target.prev != null) {
            target.prev.next = target.next;
        } else {
            head = target.next;
        }

        if (target.next != null) {
            target.next.prev = target.prev;
        } else {
            tail = target.prev;
        }

        System.out.println("Removed: " + target.title);
    }

    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }

    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }

    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        } else {
            System.out.println("No song is playing.");
        }
    }

    public void displayPlaylist() {
        SongNode node = head;

        while (node != null) {
            System.out.print(node.title + " <-> ");
            node = node.next;
        }

        System.out.println("END");
    }
}
