package com.olacabs.fs;

import java.util.*;

/**
 * @author aritra
 */
public class OcDirectory extends OcBase {

  private final Set<OcDirectory> ocDirectories;

  private final Set<OcFile> ocFiles;

  private final Map<String, OcBase> names;

  OcDirectory(String name, OcDirectory parent) {
    super(name, parent);

    ocDirectories = new HashSet<>();
    ocFiles = new HashSet<>();
    names = new HashMap<>();
  }

  public Collection<OcDirectory> getOcDirectories() {
    return ocDirectories;
  }

  public Collection<OcFile> getOcFiles() {
    return ocFiles;
  }

  public void removeAllOcDirectories() {
    for (OcDirectory ocDirectory : ocDirectories) {
      ocDirectories.remove(ocDirectory);
      names.remove(ocDirectory.getName());
    }
  }

  public void removeAllOcFiles() {
    for (OcFile ocFile : ocFiles) {
      ocFiles.remove(ocFile);
      names.remove(ocFile.getName());
    }
  }

  public boolean removeDirectory(OcDirectory ocDirectory) {
    if (names.keySet().contains(ocDirectory.getName())) {
      OcBase ocBase = names.get(ocDirectory.getName());

      if (ocBase instanceof OcDirectory) {
        ocDirectories.remove(ocDirectory);
        names.remove(ocDirectory.getName());
        return true;
      }
    }

    return false;
  }

  public boolean removeFile(OcFile ocFile) {
    if (names.keySet().contains(ocFile.getName())) {
      OcBase ocBase = names.get(ocFile.getName());

      if (ocBase instanceof OcFile) {
        ocFiles.remove(ocFile);
        names.remove(ocFile.getName());
        return true;
      }
    }

    return false;
  }

  public Collection<OcBase> list() {
    return names.values();
  }

  public OcDirectory createDirectory(String name) {
    if (names.keySet().contains(name)) {
      return null;
    }

    OcDirectory ocDirectory = new OcDirectory(name, this);
    names.put(ocDirectory.getName(), ocDirectory);
    ocDirectories.add(ocDirectory);

    return ocDirectory;
  }

  public OcFile createFile(String name) {
    if (names.keySet().contains(name)) {
      return null;
    }

    OcFile ocFile = new OcFile(name, this);
    names.put(ocFile.getName(), ocFile);
    ocFiles.add(ocFile);

    return ocFile;
  }

}
