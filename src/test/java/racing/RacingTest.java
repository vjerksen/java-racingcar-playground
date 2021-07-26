package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    Racing racing = new Racing();

    @DisplayName("쉼표로 이름 구분해서 파싱")
    @Test
    void divideNameByCommaTest() {
        String[] dividedName = {"hi","hello","name"};
        assertThat(racing.divideNameByComma("hi,hello,name")).isEqualTo(dividedName);
    }

    @DisplayName("이름 다섯 글자 이하 여부 확인")
    @Test
    void isNameLengthUnderFiveTest() {
        assertThat(racing.isNameLengthUnderFive("")).isFalse();
        assertThat(racing.isNameLengthUnderFive("big")).isTrue();
        assertThat(racing.isNameLengthUnderFive("apple")).isTrue();
        assertThat(racing.isNameLengthUnderFive("google")).isFalse();
    }
}
