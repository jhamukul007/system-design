package com.system.design.filesystem;


import com.code.review.filesystem.exception.DirectoryNotFoundException;
import com.code.review.filesystem.exception.FileNotFoundException;
import com.code.review.filesystem.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static java.lang.String.format;

public class Directory extends FileSystemObject {
    private final List<FileSystemObject> fileSystemObjects;


    public Directory(String name) {
        this.name = name;
        this.fileSystemObjects = new ArrayList<>();
        this.createdAt = new Date();
    }

    public String getName() {
        return name;
    }

    @Override
    public long getSize() {
        return getSizeHelper(this);
    }

    @Override
    public void rename(String newName) {
        this.name = newName;
    }

    private long getSizeHelper(Directory directory) {
        long size = 0;
        for (FileSystemObject fileSystemObject : directory.fileSystemObjects) {
            size += fileSystemObject.getSize();
        }
        return size;
    }

    @Override
    public Date createdAt() {
        return this.createdAt;
    }

    @Override
    public void createdAt(Date date) {
        this.createdAt = date;
    }

    public void touch(String fileName, int size) {
        if (!isValidFileName(fileName) || size < 0) {
            throw new InvalidInputException("Invalid fileName or size");
        }
        File file = new File(fileName, size);
        this.fileSystemObjects.add(file);
    }

    public void ls() {
        lsHelper(this, 0);
    }


    public FileSystemObject cd(String targetFolderName) {
        FileSystemObject targetDirectory = this.fileSystemObjects.stream().filter(directory -> Objects.equals(directory.name, targetFolderName))
                .findAny()
                .orElseThrow(() -> new DirectoryNotFoundException("Directory not exist"));
        return targetDirectory;
    }

    public void mkdir(String dirName) {
        if (!isValidDirectoryName(dirName)) {
            throw new InvalidInputException("Invalid directory name passed");
        }
        Directory directory = new Directory(dirName);
        this.fileSystemObjects.add(directory);
    }

    public void delete(String name) throws FileNotFoundException {
        FileSystemObject toBeDeletedDir = fileSystemObjects.stream().filter(f -> Objects.equals(f.getName(), name)).findAny()
                .orElseThrow(() -> new FileNotFoundException(format("Directory or File with name %s not exist", name)));
        fileSystemObjects.remove(toBeDeletedDir);
    }

    public void rename(String name, String newName) throws FileNotFoundException {
        FileSystemObject fileToBeRenamed = fileSystemObjects.stream().filter(f -> Objects.equals(f.getName(), name)).findAny()
                .orElseThrow(() -> new FileNotFoundException(format("Directory or File with name %s not exist", name)));
        fileToBeRenamed.rename(newName);
    }

    private void lsHelper(Directory dir, int level) {
        String indent = "    ".repeat(level); // 4 spaces per level
        System.out.println(indent + dir.getName());

        // Print files in this directory

        for (FileSystemObject file : dir.fileSystemObjects) {
            if (file instanceof File) {
                System.out.println(indent + "    |-> " + file.getName());
            }
        }

        // Print subdirectories recursively
        for (FileSystemObject subDir : dir.fileSystemObjects) {
            if (subDir instanceof Directory) {
                lsHelper((Directory) subDir, level + 1);
            }
        }
    }

    /**
     * File name can be this README or .gitignore. also removing split check by extension
     * Only adding null check
     *
     * @param fileName
     * @return
     */
    private boolean isValidFileName(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return false;
        }
        return true;
    }

    private boolean isValidDirectoryName(String directoryName) {
        if (directoryName == null || directoryName.isBlank() || directoryName.contains(".")) {
            return false;
        }
        return true;
    }


}
