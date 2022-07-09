package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ListFactory {
    private ListFactory() {}

    public static List<List<Two>> toListOfListOfTwos(@NonNull List<Two> twoList, long batchSize) {
        if (twoList.isEmpty()) {
            throw new IllegalArgumentException("passed list should not be empty");
        }
        if (batchSize <= 0) {
            throw new IllegalArgumentException("batch size must be positive!");
        }
        if (batchSize > 1_000) {
            throw new IllegalArgumentException("batch size can't be greater than 1 000!");
        }
        List<List<Two>> returnList = new ArrayList<>();
        int lastIndex = 0;
        int twoListSize = twoList.size();
        Iterator<Two> iterator = twoList.iterator();
            List<Two> subList = null;
            while (iterator.hasNext()) {
                subList = new LinkedList<>();
                while (lastIndex != batchSize && iterator.hasNext()) {
                    subList.add(iterator.next());
                    lastIndex++;
//                    System.out.println("subList.size():" + subList.size());
                }
                returnList.add(subList);
                lastIndex = 0;
            }
        return returnList;
    }
}
