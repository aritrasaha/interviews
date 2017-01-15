package com.olacabs;

import java.util.List;

/**
 * @author aritra
 */
public class HiddenTree {

  static int[] verMin;
  static int[] verMax;
  static int[] horMin;
  static int[] horMax;

  public static void main(String[] args) {

  }

  public static List<Node> findHiddenNodes(Node root) {
    int height = findHeight(root, 0);

    verMin = new int[4 * height - 3];
    verMax = new int[4 * height - 3];
    horMin = new int[2 * height - 1];
    horMax = new int[2 * height - 1];

    for (int i = 0; i < verMax.length; i++) {
      verMin[i] = verMax[i] = -1;
    }

    for (int i = 0; i < horMax.length; i++) {
      horMin[i] = horMax[i] = -1;
    }

    something(root, horMin.length / 2, 0);

  }

  static void something(Node node, int x, int y) {
    if (node == null) {
      return;
    }

    if (verMin[x] == -1) {
      verMin[x] = y;
    }

    if (verMax[x] < y) {
      verMax[x] = y;
    }

    if (horMin[y] == -1 || horMin[y] > x) {
      horMin[y] = x;
    }

    if (horMax[y] < x) {
      horMax[y] = x;
    }

    if (node.getLeft() != null) {
      something(node.getLeft(), x - 1, y + 1);
    }

    if (node.getRight() != null) {
      something(node.getRight(), x + 1, y + 1);
    }
  }

  static int findHeight(Node node, int level) {
    if (node == null) {
      return level;
    }

    return Math.max(findHeight(node.getLeft(), level + 1), findHeight(node.getRight(), level + 1));
  }

  class Node {
    private Node left;
    private Node right;

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }
  }

}
