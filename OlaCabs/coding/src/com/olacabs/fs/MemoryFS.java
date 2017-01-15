package com.olacabs.fs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author aritra
 */
public class MemoryFS {

  private final OcDirectory root;

  public MemoryFS() {
    this.root = new OcDirectory("root", null);
  }

  public OcDirectory getRoot() {
    return root;
  }

  public static Collection<OcBase> list(OcDirectory ocDirectory) {
    return ocDirectory.list();
  }

  public static void printList(OcDirectory ocDirectory) {
    Set<OcBase> ocBases = new HashSet<>(list(ocDirectory));

    for (OcBase ocBase : ocBases) {
      if (ocBase instanceof OcDirectory) {
        System.out.print("Dirc : ");
      } else {
        System.out.print("File : ");
      }

      printPath(ocBase);
    }
  }

  public static void printPath(OcBase ocBase) {
    for (OcBase parent : ocBase.getPath()) {
      System.out.print("\"" + parent.getName() + "\"/");
    }

    System.out.println();
  }

}
