package problems;

/**
 * Probllem405 Convert a Number to Hexadecimal
 */
public class Probllem405 {

    public String toHex(int num) {
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
}