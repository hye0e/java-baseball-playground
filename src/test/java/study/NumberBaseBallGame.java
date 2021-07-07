package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class NumberBaseBallGame {

    public void inputView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력해 주세요: ");
        int input = scanner.nextInt();
    }

    public String resultView(int input, int answer) {
        int tmp = 100;
        int strikeCnt = 0;
        int ballCnt = 0;
        int answerTmp = answer;
        while (tmp != 0) {
            strikeCnt += strike(0, input / tmp, answer / tmp);
            ballCnt += strike(0, input / tmp, answerTmp);
            input %= tmp;
            answer %= tmp;
            tmp /= 10;
        }

        if (strikeCnt == 3) {
            return strikeCnt + "스트라이크 \n" + "3개의 숫자를 모두 맞히셨습니다! 게임종료";
        }

        String returnVal = "";
        if (ballCnt > 0) {
            returnVal += ballCnt + "볼";
        }

        if (strikeCnt > 0) {
            returnVal += strikeCnt + "스트라이크";
        }

        return returnVal;
    }

    public int strike(int count, int input, int answer) {
        if (input == answer) {
            count++;
        }
        return count;
    }

    public int setAnswer() {
        return (int) (Math.random() * 10) * 100 + (int) (Math.random() * 10) * 10 + (int) (
            Math.random() * 10);
    }

    @Test
    void resultView() {
        assertThat(resultView(123, 713)).isEqualTo("1볼 1스트라이크");
    }
}
