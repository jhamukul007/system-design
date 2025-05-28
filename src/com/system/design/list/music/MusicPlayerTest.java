package com.system.design.list.music;

public class MusicPlayerTest {

    public static void main(String[] args) {
        MusicPlayer musicPlayer = MusicPlayer.getIns();

        String[] songTitles = {
                "Channa Mereya",
                "Tujhe Dekha To",
                "Tum Hi Ho",
                "Kal Ho Na Ho",
                "Kesariya",
                "Zinda",
                "Badtameez Dil",
                "Galliyan",
                "Shayad"
        };

        PlayList playList = new PlayList("Hindi Song");

        for (String title : songTitles) {
            playList.addSong(new Song(title));
        }

        musicPlayer.setPlaylist(playList);

        PlayList hindiSongPlaylist = musicPlayer.getPlaylist();

        hindiSongPlaylist.play();

        hindiSongPlaylist.displayCurrentSong();

        hindiSongPlaylist.next();

        hindiSongPlaylist.displayCurrentSong();

        hindiSongPlaylist.previous();

        hindiSongPlaylist.displayCurrentSong();

        hindiSongPlaylist.next().next();
        hindiSongPlaylist.displayCurrentSong();
    }
}
