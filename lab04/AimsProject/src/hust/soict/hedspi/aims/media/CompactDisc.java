package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String artist) {
        super(title);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists!");
            return;
        }
        tracks.add(track);
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
            System.out.println("Track does not exist!");
        }
        tracks.remove(track);
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public void play() {
        System.out.println("Playing disc: " + this.getTitle());
        System.out.println("Disc length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return getId() + ". Compact disc - " + this.getTitle() + " - " +
                this.getCategory() + " - " + artist + " - " +
                getLength() + " minutes: " + getCost() + " $";
    }
}
