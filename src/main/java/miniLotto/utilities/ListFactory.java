package miniLotto.utilities;

import lombok.NonNull;
import miniLotto.models.Two;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static List<Integer[]> readFile(String fileName, String separator) throws IOException {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            result = lines.collect(Collectors.toList());
        }
        List<String[]> intermediateList = result.stream()
                .map(line -> line.split(separator))
                .collect(Collectors.toList());

        int SIZE_OF_RECORD = intermediateList.size();
        List<Integer[]> returnList = new ArrayList<>(SIZE_OF_RECORD);
        int x = 0;
        //inicjacja tablic w liście
        while (x != SIZE_OF_RECORD) {
            returnList.add(new Integer[5]);
            x++;
        }

        for (int i = 0; i < SIZE_OF_RECORD; i++) {
            for (int j = 0; j < SIZE_OF_RECORD; j++) {
                returnList.get(i)[j] = Integer.parseInt(intermediateList.get(i)[j]);
            }
        }
        return returnList;
    }
}
