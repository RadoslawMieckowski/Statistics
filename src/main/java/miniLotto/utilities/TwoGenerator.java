package miniLotto.utilities;

import miniLotto.models.Two;

import java.util.LinkedList;
import java.util.List;

public final class TwoGenerator {
    private TwoGenerator() {}

    public static List<Two> generateListOfTwos(int[] numbers) {
        List<Two> list = new LinkedList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                list.add(new Two(i, j));
            }
        }
        return list;
    }
}
