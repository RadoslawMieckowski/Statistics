package miniLotto.utilities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class StatisticsTest {
    @Test
    void findQ3test() {
        List<Integer> listEven = new LinkedList<>(List.of(23,56,1,2,4,89));
        List<Integer> listOdd = new LinkedList<>(List.of(23,56,1,4,89));

        Assertions.assertThat(Statistics.findQ3(listEven)).isEqualTo(56.0);
        Assertions.assertThat(Statistics.findQ3(listOdd)).isEqualTo(72.5);
    }

    @Test
    void findMediaTest() {
        List<Integer> listEven = new LinkedList<>(List.of(23,56,1,2,4,89));
        List<Integer> listOdd = new LinkedList<>(List.of(23,56,1,4,89));

        Assertions.assertThat(Statistics.findMedian(listEven)).isEqualTo(13.5);
        Assertions.assertThat(Statistics.findMedian(listOdd)).isEqualTo(23.0);
    }
}