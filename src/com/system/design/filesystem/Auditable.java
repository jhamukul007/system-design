package com.system.design.filesystem;

import java.util.Date;

public interface Auditable {
    Date createdAt();
    void createdAt(Date date);
}
