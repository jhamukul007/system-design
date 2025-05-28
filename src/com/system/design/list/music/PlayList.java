package com.system.design.list.music;

import com.system.design.utils.DoublyLinkedList;

import java.util.Objects;

public class PlayList {

    private String name;
    private DoublyLinkedList<Song> songs;
    private DoublyLinkedList<Song> lastSong;
    private DoublyLinkedList<Song> currentSong;

    public PlayList(String name) {
        this.songs = new DoublyLinkedList<>(null);
        lastSong = songs;
    }

    public void addSong(Song song) {
        DoublyLinkedList<Song> newSong = new DoublyLinkedList<>(song);
        newSong.setPrevious(lastSong);
        lastSong.setNext(newSong);
        lastSong = newSong;
    }

    public void removeSong(Song song) {
        DoublyLinkedList<Song> current = songs;

        while (current != null) {
            if (Objects.equals(current.getData(), song)) {
                DoublyLinkedList<Song> prev = current.getPrevious();
                DoublyLinkedList<Song> next = current.getNext();

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
