package com.system.design.filesystem;

import java.util.Date;

public abstract class FileSystemObject implements Auditable {
    protected String name;
    protected Date createdAt;

    public abstract long getSize();

    public abstract void rename(String newName);

    public String getName() {
        return name;
    }

    @Override
    public Date createdAt() {
        return this.createdAt;
    }

    @Override
    public void createdAt(Date date) {
        this.createdAt = date;
    }
}
