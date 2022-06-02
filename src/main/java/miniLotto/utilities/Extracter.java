package miniLotto.utilities;

import miniLotto.models.Two;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Extracter {
    private Extracter() {}

    public static Map<Two, List<Integer>> ListOfTwosToMapOfDistances(List<Two> twoList) {

        return twoList.stream().collect(
                Collectors.toMap(
                        Function.identity(),
                        Two::getDistances)
        );
    }
}
