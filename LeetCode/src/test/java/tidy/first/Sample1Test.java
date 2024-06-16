package tidy.first;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Sample1Test {

    Sample1 sut;

    @BeforeEach
    void init() {
        sut = new Sample1();
    }

    @Test
    @DisplayName("10보다 크면 10으로 변환한다.")
    void test1() {
        int actual = sut.boundAdjust(11);
        assertThat(actual).isEqualTo(10);
    }

    @Test
    @DisplayName("0보다 작으면 0으로 변환한다.")
    void test2() {
        int actual = sut.boundAdjust(-1);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @DisplayName("0~9면 1을 더한다.")
    void test3() {
        int actual = sut.boundAdjust(5);
        assertThat(actual).isEqualTo(6);
    }
}