package interesting;

import java.util.Random;

class HelloWorld {

  private static int[] arr = { -229985452, -147909649 };

  /**
   * 利用给定的随机数种子生成HelloWorld. 原作者不详. 给定随机数种子后，生成的随机数为固定的序列.
   * 
   * @return
   */
  private static String randomString() {
    StringBuffer sb = new StringBuffer();
    for (int x : arr) {
      Random random = new Random(x);
      while (true) {
        int k = random.nextInt(27);
        if (k == 0) {
          break;
        }
        sb.append((char) ('`' + k));
      }
      sb.append(" ");
    }

    return sb.toString();
  }

  public static void main(String[] args) {

    System.out.println(randomString());

  }
}