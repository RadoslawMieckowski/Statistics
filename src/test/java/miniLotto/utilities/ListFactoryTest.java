package miniLotto.utilities;

import miniLotto.models.Two;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ListFactoryTest {

    @Test
    void toListOfListOfTwosTestWithUnevenNumberOfElements() {
        Two two1 = Two.builder().firstNumber(1).secondNumber(2).build();
        Two two2 = Two.builder().firstNumber(1).secondNumber(3).build();
        Two two3 = Two.builder().firstNumber(1).secondNumber(4).build();
        Two two4 = Two.builder().firstNumber(1).secondNumber(5).build();
        Two two5 = Two.builder().firstNumber(1).secondNumber(6).build();
        Two two6 = Two.builder().firstNumber(1).secondNumber(7).build();
        Two two7 = Two.builder().firstNumber(1).secondNumber(8).build();
        List<Two> twoList = List.of(two1, two2, two3, two4, two5, two6, two7);

        List<List<Two>> actualList = ListFactory.toListOfListOfTwos(twoList, 2);

        assertThat(actualList.size()).isEqualTo(4);
        assertThat(actualList.get(2).get(0).getSecondNumber()).isEqualTo(6);
    }


    @Test
    void toListOfListOfTwosTestWithEvenNumberOfElements() {
        Two two1 = Two.builder().firstNumber(1).secondNumber(2).build();
        Two two2 = Two.builder().firstNumber(1).secondNumber(3).build();
        Two two3 = Two.builder().firstNumber(1).secondNumber(4).build();
        Two two4 = Two.builder().firstNumber(1).secondNumber(5).build();
        Two two5 = Two.builder().firstNumber(1).secondNumber(6).build();
        Two two6 = Two.builder().firstNumber(1).secondNumber(7).build();
        List<Two> twoList = List.of(two1, two2, two3, two4, two5, two6);

        List<List<Two>> actualList = ListFactory.toListOfListOfTwos(twoList, 2);

        assertThat(actualList.size()).isEqualTo(3);
        assertThat(actualList.get(2).get(1).getSecondNumber()).isEqualTo(7);
    }

    void toListOfListOfTwosTestWithUnevenNumberOfElementsAndOddBatchSize() {
        Two two1 = Two.builder().firstNumber(1).secondNumber(2).build();
        Two two2 = Two.builder().firstNumber(1).secondNumber(3).build();
        Two two3 = Two.builder().firstNumber(1).secondNumber(4).build();
        Two two4 = Two.builder().firstNumber(1).secondNumber(5).build();
        Two two5 = Two.builder().firstNumber(1).secondNumber(6).build();
        Two two6 = Two.builder().firstNumber(1).secondNumber(7).build();
        Two two7 = Two.builder().firstNumber(1).secondNumber(8).build();
        List<Two> twoList = List.of(two1, two2, two3, two4, two5, two6, two7);

        List<List<Two>> actualList = ListFactory.toListOfListOfTwos(twoList, 3);

        assertThat(actualList.size()).isEqualTo(3);
        assertThat(actualList.get(2).get(0).getSecondNumber()).isEqualTo(8);
    }

    @Test
    void toListOfListOfTwosTestWithEvenNumberOfElementsAndOddBatchSize() {
        Two two1 = Two.builder().firstNumber(1).secondNumber(2).build();
        Two two2 = Two.builder().firstNumber(1).secondNumber(3).build();
        Two two3 = Two.builder().firstNumber(1).secondNumber(4).build();
        Two two4 = Two.builder().firstNumber(1).secondNumber(5).build();
        Two two5 = Two.builder().firstNumber(1).secondNumber(6).build();
        Two two6 = Two.builder().firstNumber(1).secondNumber(7).build();
        List<Two> twoList = List.of(two1, two2, two3, two4, two5, two6);

        List<List<Two>> actualList = ListFactory.toListOfListOfTwos(twoList, 3);

        assertThat(actualList.size()).isEqualTo(2);
        assertThat(actualList.get(1).get(1).getSecondNumber()).isEqualTo(6);
    }

    @Test
    void toListOfListOfTwosTestWithBatchSizeEqualToZeroThrowsIllegalArgumentException() {

        assertThatThrownBy(() -> ListFactory.toListOfListOfTwos(List.of(new Two(1,3)), 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("batch size must be positive!");
    }

    @Test
    void toListOfListOfTwosTestWithBatchSizeGreaterThan1000ThrowsIllegalArgumentException() {

        assertThatThrownBy(() -> ListFactory.toListOfListOfTwos(List.of(new Two(1,3)), 1_001))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("batch size can't be greater than 1 000!");
    }

    @Test
    void toListOfListOfTwosTestWithEmptyListThrowsIllegalArgumentException() {

        assertThatThrownBy(() -> ListFactory.toListOfListOfTwos(new ArrayList<>(), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("passed list should not be empty");
    }

    @Test
    void readFileTest() throws Exception{

        List<Integer[]>actualList = ListFactory.readFile("src/test/java/miniLotto/testDraw.txt",
                "\t");

        assertThat(actualList).hasSize(2);
        assertThat(actualList.get(0)).contains(4, 12, 15, 16, 20);
        assertThat(actualList.get(1)).contains(3, 4, 20, 29, 32);
    }

    @Test
    void readFileTest2() throws Exception {
        final String PATH = "src/main/java/miniLotto/wyniki-minilotto-sortowane-parsed.csv";
        List<Integer[]> integerRecordsList = ListFactory.readFile(PATH, "\t");;
//        Presenter.presentList(integerRecordsList);
        System.out.println(integerRecordsList.size());
        System.out.println((Arrays.toString(integerRecordsList.get(integerRecordsList.size() - 1))));
    }
}