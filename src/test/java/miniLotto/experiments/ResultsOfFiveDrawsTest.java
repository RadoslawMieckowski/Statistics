package miniLotto.experiments;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class ResultsOfFiveDrawsTest {

    @Test
    void addElementsShouldWork1() {
        ResultsOfFiveDraws results = new ResultsOfFiveDraws();
        results.add(1);
        results.add(2);
        results.add(2);
        results.add(4);
        results.add(4);

        assertThat(results.get("Zero")).isEqualTo(0);
        assertThat(results.get("Jedynka")).isEqualTo(1);
        assertThat(results.get("Dwójka")).isEqualTo(2);
        assertThat(results.get("Trójka")).isEqualTo(0);
        assertThat(results.get("Czwórka")).isEqualTo(2);
        assertThat(results.get("Piątka")).isEqualTo(0);
    }

    @Test
    void addToManyElementsShouldthrowRuntimeException() {
        ResultsOfFiveDraws results = new ResultsOfFiveDraws();
        results.add(1);
        results.add(2);
        results.add(2);
        results.add(4);
        results.add(4);

        assertThatThrownBy(() ->results.add(5)).
                isInstanceOf(RuntimeException.class)
                .hasMessage("Zbyt duża ilość wywołań metody add na obiekcie klasy ResultsOfFiveDraws !");
    }
}