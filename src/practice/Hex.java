package practice;


/**
 * ToHex
 */
public final class Hex {

    private Hex() {
    }

    public static String transform(int num) {
        int n = 0;
        int x = num;
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            sb.append(0);
            return sb.toString();
        }
        do {
            ++n;
            x = x >>> 1;
        } while (x != 0);
        n = (n - 1) / 4 + 1;
        int y;
        for (int i = 0; i < n; i++) {
            y = num & 15;
            if (y < 10) {
                if (i == n - 1 && y == 0) {
                    break;
                }
                sb.append(y);
            } else {
                switch (y) {
                case 10:
                    sb.append("a");
                    break;
                case 11:
                    sb.append("b");
                    break;
                case 12:
                    sb.append("c");
                    break;
                case 13:
                    sb.append("d");
                    break;
                case 14:
                    sb.append("e");
                    break;
                case 15:
                    sb.append("f");
                    break;
                default:
                    break;
                }
            }
            num = num >> 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Hex.transform(32));
        System.out.println(Integer.toHexString(32));
        // boolean flag = true;
        // for (int i = 0; i < Integer.MAX_VALUE; i++) {
        //     if (!Hex.transform(i).equals(Integer.toHexString(i))) {
        //         System.out.println(i);
        //         System.out.println("you sucks!");
        //         flag = false;
        //     }
        // }
        // if (flag) {
        //     System.out.println("牛逼啊老铁!");
        // }
    }
}