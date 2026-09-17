import java.util.HashSet;
import java.util.Set;

public class LeetCode3483 {

    public static int totalNumbers(int[] digits) {

        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < digits.length; i++) {

            // Hàng trăm không được là 0
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < digits.length; j++) {

                // Không dùng lại phần tử ở vị trí i
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < digits.length; k++) {

                    // Không dùng lại i hoặc j
                    if (k == i || k == j) {
                        continue;
                    }

                    // Số chẵn -> chữ số cuối phải chẵn
                    if (digits[k] % 2 != 0) {
                        continue;
                    }

                    int number =
                            digits[i] * 100
                            + digits[j] * 10
                            + digits[k];

                    numbers.add(number);
                }
            }
        }

        return numbers.size();
    }

    public static void main(String[] args) {

        int[] digits = {1, 2, 3, 4};

        int result = totalNumbers(digits);

        System.out.println("So luong so chan co 3 chu so: " + result);
    }
}