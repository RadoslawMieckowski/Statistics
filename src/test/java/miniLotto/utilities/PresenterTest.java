package miniLotto.utilities;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PresenterTest {

    @Test
    void presentTest() {
        List<Integer> list = List.of(1, 2, 3);
        String expectedString = "1\n\n2\n\n3\n\n";

        String actualString = Presenter.presentList(list);

        assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    void presentMapWithNameForKeysAndValuesShouldReturnAppropriateString() {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap();
        linkedMap.put(1, "one");
        linkedMap.put(2, "two");
        linkedMap.put(3, "three");

        String expectedString = "key:1\tvalue:one\nkey:2\tvalue:two\nkey:3\tvalue:three\n";

        String actualString = Presenter.presentMap(linkedMap, "value", "key");

        assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    void presentMapWithNameForValuesShouldReturnAppropriateString() {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap();
        linkedMap.put(1, "one");
        linkedMap.put(2, "two");
        linkedMap.put(3, "three");


        String expectedString = "1\tvalue:one\n2\tvalue:two\n3\tvalue:three\n";

        String actualString = Presenter.presentMap(linkedMap, "value", "");

        assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    void presentMapWithNameForKeysShouldReturnAppropriateString() {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap();
        linkedMap.put(1, "one");
        linkedMap.put(2, "two");
        linkedMap.put(3, "three");

        String expectedString = "key:1\tone\nkey:2\ttwo\nkey:3\tthree\n";

        String actualString = Presenter.presentMap(linkedMap, "", "key");

        assertThat(actualString).isEqualTo(expectedString);
    }

    @Test
    void presentMapWithoutNamesForKeysAndValuesShouldReturnAppropriateString() {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap();
        linkedMap.put(1, "one");
        linkedMap.put(2, "two");
        linkedMap.put(3, "three");

        String expectedString = "1\tone\n2\ttwo\n3\tthree\n";

        String actualString = Presenter.presentMap(linkedMap, "", "");

        assertThat(actualString).isEqualTo(expectedString);
    }

}