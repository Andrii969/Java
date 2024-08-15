import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return false;
            }
        }
        Song theSong = new Song(title, duration);
        songs.add(theSong);
        return true;
    }

    private Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()) {
            Song songToAdd = songs.get(index);
            if (!playList.contains(songToAdd)) {
                playList.add(songToAdd);
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song song = findSong(title);
        if (song != null && !playList.contains(song)) {
                playList.add(song);
                return true;
            }
        return false;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Album: ").append(name).append(" (").append(artist).append(")\n");
//        sb.append("Songs:\n");
//        for (Song song : songs) {
//            sb.append(song).append("\n");
//        }
//        return sb.toString();
//    }
}

class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + duration;
    }
}
