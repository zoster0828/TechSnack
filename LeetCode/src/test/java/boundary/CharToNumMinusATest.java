package boundary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CharToNumMinusATest {
    CharToNumMinusA sut;

    @BeforeEach
    void init() {
        sut = new CharToNumMinusA();
    }

    @Test
    @DisplayName("a에 대한 반환값은 0이다")
    void test1() {
        assertThat(sut.convert('a'), is(0));
    }
}