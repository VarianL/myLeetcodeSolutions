package problems;

class Problem2 {

  /**
   * Runtime: 2ms ,Memory: 37MB.
   * 
   * @param l1 ListNode
   * @param l2 ListNode
   * @return
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = new ListNode(0);
    ListNode temp = result;
    boolean flag = false;
    while (l1 != null || l2 != null) {
      byte res = 0;
      if (l1 != null) {
        res += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        res += l2.val;
        l2 = l2.next;
      }
      if (flag) {
        res += 1;
      }
      if (res >= 10) {
        res -= 10;
        flag = true;
      } else {
        flag = false;
      }
      temp.next = new ListNode(res);
      temp = temp.next;
    }
    if (flag) {
      temp.next = new ListNode(1);
      temp = temp.next;
    }
    return result.next;
  }

  /**
   * Runtime: 2ms ,Memory: 44.1MB.
   * 
   * @param l1 ListNode
   * @param l2 ListNode
   * @return
   */
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    }
    ListNode result;
    int val = l1.val + l2.val;
    if (val >= 10) {
      result = new ListNode(val - 10);
      if (l1.next == null) {
        l1.next = new ListNode(1);
      } else {
        l1.next.val += 1;
        if (l1.next.val == 10) {
          l1.next.val = 0;
          l1.next.next = addTwoNumbers(l1.next.next, new ListNode(1));
        }
      }
    } else {
      result = new ListNode(val);
    }
    result.next = addTwoNumbers(l1.next, l2.next);
    return result;
  }

}