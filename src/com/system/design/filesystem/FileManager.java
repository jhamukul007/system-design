package com.system.design.filesystem;

import java.io.FileNotFoundException;
import java.util.Stack;

public class FileManager {
    private Directory directory;
    private final Stack<Directory> lastDirectory;

    public FileManager(Directory directory) {
        this.directory = directory;
        this.lastDirectory = new Stack<>();
    }

    public void ls() {
        validateDirectory();
        directory.ls();
    }

    public void cd(String targetDirectoryName) {
        validateDirectory();
        Directory recentDirectory = this.directory;
        Directory targetDir = (Directory) this.directory.cd(targetDirectoryName);
        lastDirectory.push(recentDirectory);
        this.directory = targetDir;
    }

    public void cd_prev() {
        if (lastDirectory.isEmpty()) {
            throw new IllegalStateException("No Prev Directory");
        }
        this.directory = this.lastDirectory.pop();
    }

    public void pwd() {
        validateDirectory();
        System.out.println(this.directory.getName());
    }

    public void mkdir(String dirName) {
        validateDirectory();
        this.directory.mkdir(dirName);
    }

    public void touch(String fileName, int size) {
        validateDirectory();
        this.directory.touch(fileName, size);
    }

    public void delete(String name) throws FileNotFoundException {
        validateDirectory();
        this.directory.delete(name);
    }

    public void rename(String name, String newName) throws FileNotFoundException {
        validateDirectory();
        this.directory.rename(name, newName);
    }

    public long getSize() {
        validateDirectory();
        long size = this.directory.getSize();
        System.out.println("Size: " + size + " KB");
        return size;
    }

    private void validateDirectory() {
        if (this.directory == null) {
            throw new IllegalStateException("No Directory Exist");
        }
    }
}
