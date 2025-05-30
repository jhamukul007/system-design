package com.system.design.list.directory;

public class PhoneDirectoryTest {
    public static void main(String[] args) {
        // 0,1,2
        PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        System.out.println(phoneDirectory.check(1));
        System.out.println(phoneDirectory.get());
        System.out.println(phoneDirectory.check(0));
        phoneDirectory.release(0);
        System.out.println(phoneDirectory.check(0));
    }
}
