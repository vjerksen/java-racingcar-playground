package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingTest {

    Racing racing = new Racing();

    ArrayList<Car> racingArrayList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        racingArrayList.add(new Car("apple", 1));
        racingArrayList.add(new Car("bear", 2));
        racingArrayList.add(new Car("cream", 5));
        racingArrayList.add(new Car("dry", 5));
        racingArrayList.add(new Car("egg", 3));
        racingArrayList.add(new Car("funky", 1));
    }

    @DisplayName("쉼표로 이름 구분해서 파싱")
    @Test
    void divideNameByCommaTest() {
        String[] dividedName = {"hi", "hello", "name"};
        assertThat(racing.divideNameByComma("hi,hello,name")).isEqualTo(dividedName);
    }

    @DisplayName("반복문 통해서 다섯 글자 이하 여부 확인")
    @Test
    void checkValidInIterationTest() throws Exception {

    }

    @DisplayName("이름 다섯 글자 이하 여부 확인")
    @Test
    void isNameLengthUnderFiveTest() {
        assertThatThrownBy(() -> {racing.isNameLengthUnderFive("google");})
                .isInstanceOf(Exception.class)
                .hasMessageContaining("name length is over five or under one");
    }

    @DisplayName("최고 값 출력")
    @Test
    void returnMaxValueTest() {
        assertThat(racing.returnMaxValue(racingArrayList)).isEqualTo(5);
    }

    @DisplayName("우승자 확인")
    @Test
    void checkWhoAreWinnersTest() {
        assertThat(racing.checkWhoAreWinners(racingArrayList)).contains("cream", "dry");
    }

}
