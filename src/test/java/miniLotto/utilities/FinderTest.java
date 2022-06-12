package miniLotto.utilities;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.*;

class FinderTest {

    @Test
    void filterListOfMapsByFirstAndSecondNumberTest() {
        Map<String, Double> map1 = new LinkedHashMap<>();
        map1.put("1|2 i 2|3", 0.2);
        map1.put("1|2 i 3|4", 0.1);
        map1.put("5|6 i 2|3", 0.7);
        Map<String, Double> map2 = new LinkedHashMap<>();
        map1.put("1|2 i 5|6", 0.2);
        map1.put("4|1 i 3|4", 0.1);
        map1.put("5|6 i 2|7", 0.7);
        List<Map<String, Double>> list = new LinkedList<>();
        list.add(map1);
        list.add(map2);

        List<Map.Entry<String, Double>> entryList = Finder.
                filterListOfMapsByFirstAndSecondNumber("1", "2", list);

        Assertions.assertThat(entryList).hasSize(3);
        Assertions.assertThat(entryList.get(0).getKey()).isEqualTo("1|2 i 2|3");
        Assertions.assertThat(entryList.get(0).getValue()).isEqualTo(0.2);
        Assertions.assertThat(entryList.get(1).getKey()).isEqualTo("1|2 i 3|4");
        Assertions.assertThat(entryList.get(1).getValue()).isEqualTo(0.1);
        Assertions.assertThat(entryList.get(2).getKey()).isEqualTo("1|2 i 5|6");
        Assertions.assertThat(entryList.get(2).getValue()).isEqualTo(0.2);
    }

    @Test
    void filterListOfMapsByFirstAndSecondNumberWithReversedKeyTest() {
        Map<String, Double> map1 = new LinkedHashMap<>();
        map1.put("2|3 i 1|2", 0.2);
        map1.put("1|2 i 3|4", 0.1);
        map1.put("5|6 i 2|3", 0.7);
        Map<String, Double> map2 = new LinkedHashMap<>();
        map1.put("1|2 i 5|6", 0.2);
        map1.put("4|1 i 3|4", 0.1);
        map1.put("5|6 i 2|7", 0.7);
        List<Map<String, Double>> list = new LinkedList<>();
        list.add(map1);
        list.add(map2);

        List<Map.Entry<String, Double>> entryList = Finder.
                filterListOfMapsByFirstAndSecondNumber("1", "2", list);

        Assertions.assertThat(entryList).hasSize(3);
        Assertions.assertThat(entryList.get(0).getKey()).isEqualTo("2|3 i 1|2");
        Assertions.assertThat(entryList.get(0).getValue()).isEqualTo(0.2);
        Assertions.assertThat(entryList.get(1).getKey()).isEqualTo("1|2 i 3|4");
        Assertions.assertThat(entryList.get(1).getValue()).isEqualTo(0.1);
        Assertions.assertThat(entryList.get(2).getKey()).isEqualTo("1|2 i 5|6");
        Assertions.assertThat(entryList.get(2).getValue()).isEqualTo(0.2);
    }


    @Test
    void filterListOfMapsByFirstAndSecondNumberWithReversedInnerPairKeyTest() {
        Map<String, Double> map1 = new LinkedHashMap<>();
        map1.put("2|1 i 2|3", 0.2);
        map1.put("1|2 i 3|4", 0.1);
        map1.put("5|6 i 2|3", 0.7);
        Map<String, Double> map2 = new LinkedHashMap<>();
        map1.put("1|2 i 5|6", 0.2);
        map1.put("4|1 i 3|4", 0.1);
        map1.put("5|6 i 2|7", 0.7);
        List<Map<String, Double>> list = new LinkedList<>();
        list.add(map1);
        list.add(map2);

        List<Map.Entry<String, Double>> entryList = Finder.
                filterListOfMapsByFirstAndSecondNumber("1", "2", list);

        Assertions.assertThat(entryList).hasSize(3);
        Assertions.assertThat(entryList.get(0).getKey()).isEqualTo("2|1 i 2|3");
        Assertions.assertThat(entryList.get(0).getValue()).isEqualTo(0.2);
        Assertions.assertThat(entryList.get(1).getKey()).isEqualTo("1|2 i 3|4");
        Assertions.assertThat(entryList.get(1).getValue()).isEqualTo(0.1);
        Assertions.assertThat(entryList.get(2).getKey()).isEqualTo("1|2 i 5|6");
        Assertions.assertThat(entryList.get(2).getValue()).isEqualTo(0.2);
    }

    @Test
    void findMostSimilarEntryWithGivenTwoTest() {
        List<Map.Entry<String, Double>> entryList = new LinkedList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        map.put("1|2 i 2|3", 0.2);
        map.put("1|2 i 3|4", 0.1);
        map.put("1|2 i 3|4", 0.3);
        map.put("1|2 i 4|5", 0.17);
        map.put("1|2 i 5|6", 0.7);
        map.put("1|2 i 6|7", 0.8);

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            entryList.add(entry);
        }

//        Mockito.when(Finder.filterListOfMapsByFirstAndSecondNumber(
//                Mockito.anyString(),
//                Mockito.anyString(),
//                Mockito.anyList()))
//                .thenReturn(entryList);
    }
}

