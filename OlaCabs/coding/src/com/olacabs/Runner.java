package com.olacabs;

import com.olacabs.fs.MemoryFS;
import com.olacabs.fs.OcDirectory;
import com.olacabs.fs.OcFile;

/**
 * @author aritra
 */
public class Runner {

  public static void main(String[] args) {
    MemoryFS memoryFS = new MemoryFS();
    OcDirectory root = memoryFS.getRoot();

    MemoryFS.printList(root);

    OcDirectory dirc1 = root.createDirectory("L1D1");
    OcFile file1 = root.createFile("L1F1");
    root.createDirectory("L1D2");
//    OcFile file2 = dirc1.createFile("L2F1");

//    file1.setBytes("Sarath".getBytes());
//    System.out.println(new String(file1.getBytes()));
//    System.out.println();
//
//    String text = "Aritra Saha";
//    file2.setBytes(text.getBytes());
//
//    String text2 = new String(file2.getBytes());
//    System.out.println(text2);
//    System.out.println();

    MemoryFS.printList(root);
    System.out.println();

//    MemoryFS.printList(dirc1);
//    System.out.println();

    root.removeFile(file1);

    MemoryFS.printList(root);
    System.out.println();

//    MemoryFS.printList(dirc1);
//    System.out.println();

//    MemoryFS.printPath(dirc1);
//    System.out.println();
//
//    MemoryFS.printPath(file2);
//    System.out.println();
  }

}
