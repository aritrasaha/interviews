package com.olacabs.fs;

/**
 * @author aritra
 */
public class OcFile extends OcBase {

  private byte[] bytes;

  OcFile(String name, OcDirectory parent) {
    super(name, parent);
  }

  public byte[] getBytes() {
    return bytes;
  }

  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }

  public OcFile copyToFile(OcFile ocFile) {
    ocFile.setBytes(getBytes());
    return ocFile;
  }

}
