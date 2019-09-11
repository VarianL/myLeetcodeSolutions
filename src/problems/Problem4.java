package problems;

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
        boolean isOdd = (totalLength & 1) == 1 ? true : false;
        if (nums1.length == 0) {
            return isOdd ? nums2[nums2.length / 2] : (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
        } else if (nums2.length == 0) {
            return isOdd ? nums1[nums1.length / 2] : (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
        }
        int i = 0, j = 0;
        int[] result = new int[totalLength / 2 + 1];
        for (int m = 0; m < result.length; ++m) {
            if (i < nums1.length && j < nums2.length) {
                result[m] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (i == nums1.length && j < nums2.length) {
                result[m] = nums2[j++];
            } else if (j == nums2.length && i < nums1.length) {
                result[m] = nums1[i++];
            }
        }
        return isOdd ? result[result.length - 1] : (result[result.length - 1] + result[result.length - 2]) / 2.0;
  }

  public static void main(String[] args) {
    Problem4 p = new Problem4();
    int[] nums2 = {};
    int[] nums1 = { 3, 4 };
    System.out.println(p.findMedianSortedArrays(nums1, nums2));
  }
}