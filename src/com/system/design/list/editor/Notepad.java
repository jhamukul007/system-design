package com.system.design.list.editor;

import com.system.design.utils.DoublyLinkedNode;

public class Notepad {
    private DoublyLinkedNode<Character> content;
    private DoublyLinkedNode<Character> currentPosition;

    public Notepad() {
        this.content = new DoublyLinkedNode<>(null);
        this.currentPosition = content;
    }

    public Notepad write(Character text) {
        DoublyLinkedNode<Character> newNode = new DoublyLinkedNode<>(text);
        currentPosition.setNext(newNode);
        newNode.setPrevious(currentPosition);
        currentPosition = newNode;
        return this;
    }

    public Notepad undo() {
        if (currentPosition != null && currentPosition != content) {
            currentPosition = currentPosition.getPrevious();
        }
        return this;
    }

    public Notepad redo() {
        if (currentPosition != null) {
            currentPosition = currentPosition.getNext();
        }
        return this;
    }

    public Notepad content() {
        StringBuilder contentOutput = new StringBuilder();
        DoublyLinkedNode<Character> current = content.getNext();

        while (current != null) {
            if (current == currentPosition) {
                contentOutput.append(current.getData());
                break;
            }

            contentOutput.append(current.getData());
            current = current.getNext();
        }

        System.out.println("---------------------------------");
        System.out.println(contentOutput);
        System.out.println("---------------------------------");
        return this;
    }
}
