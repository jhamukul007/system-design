package com.system.design.filesystem;

import java.util.Date;

public class File extends FileSystemObject {
    private final long size;

    public File(String name, long size) {
        this.name = name;
        this.size = size;
        this.createdAt = new Date();
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void rename(String name) {
        this.name = name;
    }

}
