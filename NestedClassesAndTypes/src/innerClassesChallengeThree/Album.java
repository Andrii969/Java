package innerClassesChallengeThree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {

        Song checkedSong = songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String trackTitle, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(trackTitle);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + trackTitle + " is not in this album");
        return false;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Album: ").append(name).append(" (").append(artist).append(")\n");
//        sb.append("Songs:\n");
//        for (Song song : songs.songs) {
//            sb.append(song).append("\n");
//        }
//        return sb.toString();
//    }

    public static class SongList {

        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            }
            for (Song s : songs) {
                if (s.getTitle().equalsIgnoreCase(song.getTitle())) {
                    return false;
                }
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String songTitle) {
            for (Song s : songs) {
                if (s.getTitle().equalsIgnoreCase(songTitle)) {
                    return s;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int songIndex = trackNumber - 1;
            if (songIndex >= 0 && songIndex < songs.size()) {
                return songs.get(songIndex);
            }
            return null;
        }
    }
}