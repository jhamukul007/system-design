package com.system.design.list.editor;

public class NotepadTest {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();
        notepad.write('M')
                .write('U')
                .write('K')
                .write('U')
                .write('L')
                .write(' ')
                .write('J')
                .write('H')
                .write('A')
                .content()
                .undo()
                .content()
                .undo()
                .content()
                .undo()
                .content()
                .redo()
                .write('A')
                .write('C')
                .write('K')
                .content();
    }
}
