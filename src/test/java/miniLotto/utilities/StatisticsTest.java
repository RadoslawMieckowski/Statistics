package miniLotto.utilities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class StatisticsTest {
    @Test
    void findQ3test() {
        List<Integer> listEven = new LinkedList<>(List.of(23,56,1,2,4,89));
        List<Integer> listOdd = new LinkedList<>(List.of(23,56,1,4,89));

        assertThat(Statistics.findQ3(listEven)).isEqualTo(56.0);
        assertThat(Statistics.findQ3(listOdd)).isEqualTo(72.5);
    }

    @Test
    void findMediaTest() {
        List<Integer> listEven = new LinkedList<>(List.of(23,56,1,2,4,89));
        List<Integer> listOdd = new LinkedList<>(List.of(23,56,1,4,89));

        assertThat(Statistics.findMedian(listEven)).isEqualTo(13.5);
        assertThat(Statistics.findMedian(listOdd)).isEqualTo(23.0);
    }

    @Test
    void isListAfterFindmedianTheSame() {
        List<Integer> listEven = new LinkedList<>(List.of(23,56,1,2,4,89));

        List<Integer> expectedList = new LinkedList<>(List.of(23,56,1,2,4,89));
        double median = Statistics.findMedian(listEven);

        assertThat(expectedList).isEqualTo(listEven);
    }

    @Test
    void isListAfterFindQ3TheSame() {
        List<Integer> listEven = new LinkedList<>(List.of(23,56,1,2,4,89));

        List<Integer> expectedList = new LinkedList<>(List.of(23,56,1,2,4,89));
        double q3 = Statistics.findQ3(listEven);

        assertThat(expectedList).isEqualTo(listEven);
    }
}