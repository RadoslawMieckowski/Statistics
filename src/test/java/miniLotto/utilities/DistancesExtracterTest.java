package miniLotto.utilities;

import miniLotto.models.Two;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

class DistancesExtracterTest {

    @Test
    void ListOfTwosToMapOfDistances() {
        Two two = Two.builder()
                .firstNumber(1)
                .secondNumber(2)
                .distances(List.of(1, 2, 3))
                .build();
        Two two2 = Two.builder()
                .firstNumber(4)
                .secondNumber(5)
                .distances(List.of(7, 8, 9, 10))
                .build();
        List<Two> listOfTwos = List.of(two, two2);
        Map<Two, List<Integer>> expectedMap = Map.of(
                two, List.of(1, 2, 3),
                two2, List.of(7, 8, 9, 10)
        );

        Map<Two, List<Integer>> actualMap = Extracter.ListOfTwosToMapOfDistances(listOfTwos);

        assertThat(actualMap).hasSize(2);
        assertThat(actualMap).containsAllEntriesOf(expectedMap);
        assertThat(actualMap).isEqualTo(expectedMap);
    }
}