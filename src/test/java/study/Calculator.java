package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Calculator {

    public int stringCal(String value) {
        String[] values = value.split(" ");

        int num1 = Integer.parseInt(values[0]);
        int num2 = Integer.parseInt(values[2]);
        int answer = calculate(values[1], num1, num2);
        for (int i = 3; i < values.length; i++) {
            if (i % 2 != 0) {
                answer = calculate(values[i],
                    answer, Integer.parseInt(values[i + 1])
                );
            }
        }
        return answer;
    }

    public int calculate(String cal, int num1, int num2) {
        switch (cal) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    @Test
    void 계산기() {
        assertThat(stringCal("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
