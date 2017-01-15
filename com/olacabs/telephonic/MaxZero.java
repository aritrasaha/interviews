package com.olacabs.telephonic;

/**
 * @author aritra
 */
public class MaxZero {

  public static void main(String[] args) {
    int[][] arr = {{0, 0, 1, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 1}};

    System.out.println(maxZero(arr));
  }

  private static int maxZero(int[][] arr) {
    int pos = -1;

    for (int i = 0; i < arr.length; i++) {
      int a = pos > -1 ? pos : 0;
      int b = arr[i].length - 1;

      if (arr[i][a] == 1) {
        continue;
      }

      if (arr[i][b] == 0) {
        pos = arr[i].length;
        break;
      }

      while (a < b) {
        int mid = (a + b) / 2;

        if (arr[i][mid] == 0) {
          if (arr[i][mid + 1] == 1) {
            pos = mid;
            break;
          } else {
            a = mid + 1;
          }
        } else {
          if (arr[i][mid - 1] == 0) {
            pos = mid - 1;
            break;
          } else {
            b = mid - 1;
          }
        }
      }
    }

    return pos + 1;
  }

}
