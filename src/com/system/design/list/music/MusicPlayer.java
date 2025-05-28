package com.system.design.list.music;

public class MusicPlayer {
    private PlayList playlist;
    private static MusicPlayer musicPlayer;

    private MusicPlayer() {
    }

    public static MusicPlayer getIns() {
        if (musicPlayer == null) {
            synchronized (MusicPlayer.class) {
                if (musicPlayer == null) {
                    musicPlayer = new MusicPlayer();
                }
            }
        }
        return musicPlayer;
    }

    public PlayList getPlaylist() {
        return playlist;
    }

    public void setPlaylist(PlayList playlist) {
        this.playlist = playlist;
    }
}
