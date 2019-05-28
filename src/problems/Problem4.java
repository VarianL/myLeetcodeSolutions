package problems;

import java.util.ArrayList;

class Problem4 {

  /**
   * There are two sorted arrays nums1 and nums2 of size m and n respectively.
   * Find the median of the two sorted arrays. The overall run time complexity
   * should be O(log (m+n)). You may assume nums1 and nums2 cannot be both empty.
   * 
   * @param nums1 int[]
   * @param nums2 int[]
   * @return
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int totalLength = nums1.length + nums2.length;
    boolean isOdd = (totalLength & 1) == 0 ? false : true;
    if (nums1.length == 0) {
      return isOdd ? nums2[nums2.length / 2] : (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
    } else if (nums2.length == 0) {
      return isOdd ? nums1[nums1.length / 2] : (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    int i = 0;
    int j = 0;

    while ((i + j) < totalLength) {
      while ((nums1[i] < nums2[j])) {
        list.add(nums1[i]);
        ++i;
        if (i == nums1.length) {
          while (j < nums2.length) {
            list.add(nums2[j]);
            ++j;
          }
          break;
        } 
      }
      if (i >= nums1.length && j >= nums2.length) {
        break;
      }
      while ((nums1[i] >= nums2[j])) {
        list.add(nums2[j]);
        ++j;
        if (j == nums2.length) {
          while (i < nums1.length) {
            list.add(nums1[i]);
            ++i;
          }
          break;
        }
      }
      if (list.size() >= totalLength / 2 + 1) {
        break;
      }
    }
    if (isOdd) {
      return list.get(totalLength / 2);
    } else {
      return (list.get(totalLength / 2) + list.get(totalLength / 2 - 1)) / 2.0;
    }
  }

  public static void main(String[] args) {
    Problem4 p = new Problem4();
    int[] nums2 = {};
    int[] nums1 = { 3, 4 };
    System.out.println(50 / 2.0);
    System.out.println(p.findMedianSortedArrays(nums1, nums2));
  }
}