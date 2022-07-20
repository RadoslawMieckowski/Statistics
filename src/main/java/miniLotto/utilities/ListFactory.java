package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.util.*;

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

    public static <K, V> List<List<Map<K, V>>> toListOfListOfMaps(@NonNull List<Map<K, V>> listMap, long batchSize) {
        if (listMap.isEmpty()) {
            throw new IllegalArgumentException("passed list should not be empty");
        }
        if (batchSize <= 0) {
            throw new IllegalArgumentException("batch size must be positive!");
        }
        if (batchSize > 1_000) {
            throw new IllegalArgumentException("batch size can't be greater than 1 000!");
        }
        List<List<Map<K, V>>> returnList = new ArrayList<>();
        int lastIndex = 0;
        Iterator<Map<K, V>> iterator = listMap.iterator();
        List<Map<K, V>> subList = null;
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
