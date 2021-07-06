package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void contains() {
        String[] test = "1,2".split(",");
        assertThat(test).contains("1");
    }

    @Test
    @DisplayName("테스")
    void containsExactly() {
        String[] test = "1,2".split(",");
        assertThat(test).containsExactly("1", "2");
    }

    @Test
    void subString() {
        String test = "(1,2)";
        assertThat(test.substring(1,4)).contains("1,2");
    }


    @Test
    @DisplayName("OutOfIndex 테스트")
    void indexOfTest() {
        assertThatThrownBy(() -> {
            "abc".charAt(6);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("Index: 2, Size: 2");
    }

    @Test
    @DisplayName("OutOfIndex 테스트2")
    void indexOfTest2() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(6);
        }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
