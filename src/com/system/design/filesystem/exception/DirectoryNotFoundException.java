package com.system.design.filesystem.exception;

public class DirectoryNotFoundException extends FileSystemException {
    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
