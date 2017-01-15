package com.olacabs.fs;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author aritra
 */
public class OcBase {

  private final String name;

  private final OcDirectory parent;

  public OcBase(String name, OcDirectory parent) {
    this.name = name;
    this.parent = parent;
  }

  public String getName() {
    return name;
  }

  public OcDirectory getParent() {
    return parent;
  }

  public Set<OcBase> getPath() {
    Set<OcBase> ancestors = new LinkedHashSet<>();
    OcBase parent = this;

    while (parent != null) {
      ancestors.add(parent);
      parent = parent.getParent();
    }

    return ancestors;
  }

}
