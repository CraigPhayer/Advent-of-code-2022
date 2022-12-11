package Day07;

import java.util.ArrayList;

public class Directory {
    int size;
    ArrayList<file> files;
    String name;
    Directory parent;
    ArrayList<Directory> child;

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        files = new ArrayList<file>();
        child = new ArrayList<Directory>();
    }

    public void addChild(String name, Directory parent) {
        Directory child = new Directory(name, parent);
        parent.child.add(child);
    }

    public void addFile(String name, int size, Directory dir) {
        file file = new file(name, size);
        dir.files.add(file);
    }
}