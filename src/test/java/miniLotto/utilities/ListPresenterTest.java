package miniLotto.utilities;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListPresenterTest {

    @Test
    void presentTest() {
        List<Integer> list = List.of(1, 2, 3);
        String expectedString = "1\n\n2\n\n3\n\n";

        String actualString = ListPresenter.present(list);

        assertThat(actualString).isEqualTo(expectedString);
    }

}