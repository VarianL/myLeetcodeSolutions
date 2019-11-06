package interesting;

/**
 * NarcissisticNumber
 */
public class NarcissisticNumber {

    public NarcissisticNumber() {

        for (int i = 101; i < 10000; i++) {
            if (i % 100 == 0 || (i & (i - 1)) == 0) {
                continue;
            }
            if (pow(i % 10) + pow(i / 10 % 10) + pow(i / 100 % 10) == i) {
                System.out.println(i);
            }
        }
    }

    private int pow(int num) {
        return num * num * num;
    }
}