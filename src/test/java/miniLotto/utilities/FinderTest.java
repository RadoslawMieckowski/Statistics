package miniLotto.utilities;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FinderTest {
    @Test
    void DoIKnowRegexTestII() {
        Pattern p = Pattern.compile(".xx.");
        Matcher m = p.matcher("AxxB");
        boolean b = m.matches();
        System.out.println(p.toString());

        assertThat(b).isTrue();
    }

    @Test
    void DoIKnowRegexTest() {
//        Pattern p = Pattern.compile("a"+Pattern.quote("a|b"));
        Pattern p = Pattern.compile("a\\|b");
        Matcher m = p.matcher("a|b");
        boolean b = m.matches();
        System.out.println(p.toString());

        assertThat(b).isTrue();
    }

    @Test
    void checkPatternAndMatcher() {
        Pattern searched = Pattern.compile(
                "1" + "\\|" + "2" + " i [1-9][0-9]?\\|[1-9][0-9]?"
        );
        Matcher text = searched.matcher("1|2 i 5|6");
        System.out.println(searched.toString());
        boolean actualValue = text.matches();

        assertThat(actualValue).isTrue();
    }

    @Test
    void filterListOfMapsByFirstAndSecondNumberTest() {
        Map<String, Double> map1 = new LinkedHashMap<>();
        map1.put("1|2 i 2|3", 0.2);
        map1.put("3|4 i 1|2", 0.1);
        map1.put("5|6 i 2|3", 0.7);
        Map<String, Double> map2 = new LinkedHashMap<>();
        map2.put("2|1 i 5|6", 0.2);
        map2.put("4|1 i 3|4", 0.1);
        map2.put("5|6 i 2|7", 0.7);
        map2.put("5|1 i 2|1", 0.7);
        List<Map<String, Double>> list = new LinkedList<>();
        list.add(map1);
        list.add(map2);
Presenter.presentList(list);
        List<Map.Entry<String, Double>> entryList = Finder.
                filterListOfMapsByFirstAndSecondNumber("1", "2", list);

        assertThat(entryList).hasSize(4);
        assertThat(entryList.get(0).getKey()).isEqualTo("1|2 i 2|3");
        assertThat(entryList.get(0).getValue()).isEqualTo(0.2);
        assertThat(entryList.get(1).getKey()).isEqualTo("3|4 i 1|2");
        assertThat(entryList.get(1).getValue()).isEqualTo(0.1);
        assertThat(entryList.get(2).getKey()).isEqualTo("2|1 i 5|6");
        assertThat(entryList.get(2).getValue()).isEqualTo(0.2);
        assertThat(entryList.get(3).getKey()).isEqualTo("5|1 i 2|1");
        assertThat(entryList.get(3).getValue()).isEqualTo(0.7);
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

        assertThat(entryList).hasSize(3);
        assertThat(entryList.get(0).getKey()).isEqualTo("2|3 i 1|2");
        assertThat(entryList.get(0).getValue()).isEqualTo(0.2);
        assertThat(entryList.get(1).getKey()).isEqualTo("1|2 i 3|4");
        assertThat(entryList.get(1).getValue()).isEqualTo(0.1);
        assertThat(entryList.get(2).getKey()).isEqualTo("1|2 i 5|6");
        assertThat(entryList.get(2).getValue()).isEqualTo(0.2);
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

        assertThat(entryList).hasSize(3);
        assertThat(entryList.get(0).getKey()).isEqualTo("2|1 i 2|3");
        assertThat(entryList.get(0).getValue()).isEqualTo(0.2);
        assertThat(entryList.get(1).getKey()).isEqualTo("1|2 i 3|4");
        assertThat(entryList.get(1).getValue()).isEqualTo(0.1);
        assertThat(entryList.get(2).getKey()).isEqualTo("1|2 i 5|6");
        assertThat(entryList.get(2).getValue()).isEqualTo(0.2);
    }

    @Test
    void findMostSimilarEntryWithGivenTwoTest() throws Throwable {
        List<Map.Entry<String, Double>> entryList = new LinkedList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        map.put("1|2 i 2|3", 0.2);
        map.put("1|2 i 3|4", 0.1);
        map.put("1|2 i 4|5", 0.17);
        map.put("1|2 i 5|6", 0.7);
        map.put("1|2 i 6|7", 0.8);

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            entryList.add(entry);
        }

        assertThat(entryList).hasSize(5);

        List<Map.Entry<String, Double>> results = Finder.findMostSimilarEntriesWithGivenTwo(entryList, 3);
        assertThat(results).hasSize(3);
        assertThat(results.get(0).getValue()).isEqualTo(0.8);
        assertThat(results.get(0).getKey()).isEqualTo("1|2 i 6|7");
        assertThat(results.get(1).getValue()).isEqualTo(0.7);
        assertThat(results.get(1).getKey()).isEqualTo("1|2 i 5|6");
        assertThat(results.get(2).getValue()).isEqualTo(0.2);
        assertThat(results.get(2).getKey()).isEqualTo("1|2 i 2|3");
    }
}

