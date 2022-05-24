package miniLotto.utilities;

import miniLotto.models.Two;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class FilterTest {

    Two pair1 = Two.builder()
            .firstNumber(1)
            .secondNumber(2)
            .lastOccurence(6)
            .medOfintervals(61)
            .q3Ofintervals(125)
            .build();
    Two pair2 = Two.builder()
            .firstNumber(1)
            .secondNumber(3)
            .lastOccurence(110)
            .medOfintervals(82)
            .q3Ofintervals(140)
            .build();
    Two pair3 = Two.builder()
            .firstNumber(1)
            .secondNumber(4)
            .lastOccurence(319)
            .medOfintervals(67)
            .q3Ofintervals(167)
            .build();
    Two pair4 = Two.builder()
            .firstNumber(1)
            .secondNumber(5)
            .lastOccurence(116)
            .medOfintervals(65)
            .q3Ofintervals(145)
            .build();
    List<Two> list = List.of(pair1, pair2, pair3, pair4);

    @Test
    void filterTwosWithLastBiggerthanMedTest() {
        List<Two> actualList = Filter.filterTwosWithLastBiggerthanMed(list);
        List<Two> expectedList = List.of(pair2, pair3, pair4);
        System.out.println(list);

        Assertions.assertThat(actualList).isEqualTo(expectedList);
        assertThat(actualList, containsInAnyOrder(pair2, pair3, pair4));
        assertThat(actualList, hasSize(3));
    }

    @Test
    void filterTwosWithLastBiggerthan3QTest() {
        List<Two> actualList = Filter.filterTwosWithLastBiggerthan3Q(list);
        System.out.println(list);

        assertThat(actualList,contains(pair3));
        assertThat(actualList, hasSize(1));
    }

    @Test
    void filterTwosWithLastLessthanMedTest() {
        List<Two> actualList = Filter.filterTwosWithLastLessthanMed(list);

        assertThat(actualList,contains(pair1));
        assertThat(actualList, hasSize(1));
    }

    @Test
    void filterTwosWithLastLessthan3QTest() {
        List<Two> actualList = Filter.filterTwosWithLastLessthan3Q(list);

        assertThat(actualList,contains(pair1, pair2, pair4));
        assertThat(actualList, hasSize(3));
    }
}