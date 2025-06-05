package com.system.design.list.music;

import com.system.design.utils.DoublyLinkedNode;

import java.util.Objects;

public class PlayList {

    private String name;
    private DoublyLinkedNode<Song> songs;
    private DoublyLinkedNode<Song> lastSong;
    private DoublyLinkedNode<Song> currentSong;

    public PlayList(String name) {
        this.songs = new DoublyLinkedNode<>(null);
        lastSong = songs;
    }

    public void addSong(Song song) {
        DoublyLinkedNode<Song> newSong = new DoublyLinkedNode<>(song);
        newSong.setPrevious(lastSong);
        lastSong.setNext(newSong);
        lastSong = newSong;
    }

    public void removeSong(Song song) {
        DoublyLinkedNode<Song> current = songs;

        while (current != null) {
            if (Objects.equals(current.getData(), song)) {
                DoublyLinkedNode<Song> prev = current.getPrevious();
                DoublyLinkedNode<Song> next = current.getNext();

                if (prev != null) {
                    prev.setNext(next);
                }
                if (next != null) {
                    next.setPrevious(prev);
                }
                break;
            }
            current = current.getNext();
        }
    }

    public void play() {
        this.currentSong = songs.getNext();
    }

    public void displayCurrentSong() {
        System.out.println("----------------------------------");
        System.out.println("Playing ----- " + currentSong != null ? currentSong.getData().getName() : "NONE !!!");
        System.out.println("----------------------------------");
    }

    public PlayList next() {
        if (currentSong == null) {
            currentSong = songs.getNext();
        }
        currentSong = currentSong.getNext();
        return this;
    }

    public PlayList previous() {
        if (currentSong.getPrevious() != songs) {
            currentSong = currentSong.getPrevious();
        }
        return this;
    }
}
