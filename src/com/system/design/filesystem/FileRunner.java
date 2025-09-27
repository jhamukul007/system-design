package com.system.design.filesystem;

import java.io.FileNotFoundException;

public class FileRunner {
    public static void main(String[] args) throws FileNotFoundException {
        Directory fileSystem = new Directory("home");
        FileManager fileManager = new FileManager(fileSystem);

        fileManager.ls();
        fileManager.mkdir("Amazon");
        fileManager.mkdir("Google");
        fileManager.mkdir("Roku");
        fileManager.ls();
        fileManager.cd("Amazon");
        fileManager.touch("amazon-dev.xml", 400);
        fileManager.touch("amazon-stage.xml", 500);
        fileManager.touch("amazon-prod.xml", 900);

        fileManager.getSize();
        fileManager.cd_prev();
        fileManager.ls();

        fileManager.getSize();
        fileManager.cd("Amazon");
        fileManager.ls();
        fileManager.mkdir("temp");
        fileManager.ls();

        fileManager.delete("temp");
        fileManager.ls();

        fileManager.delete("amazon-prod.xml");

        fileManager.ls();

        fileManager.rename("amazon-stage.xml", "amazon-uat.xml");
        fileManager.ls();
    }
}
