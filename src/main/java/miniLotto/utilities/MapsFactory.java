package miniLotto.utilities;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class MapsFactory {
    private MapsFactory() {}

    // divides very large map to a few smaller maps placed in a list
    public static <K, V> List<LinkedHashMap<K ,V>> divideMapToListOfMaps(@NonNull LinkedHashMap<K, V> map, long batchSize) {
        if (batchSize <= 0) {
            throw new IllegalArgumentException("batch size must be positive!");
        }
        if (batchSize > 30_000) {
            throw new IllegalArgumentException("batch size can't be greater than 30 000!");
        }
        List<K> keys = new ArrayList<>(map.keySet());
        long elementsToSkip = batchSize;
        long limitOfElements = batchSize;
        List<LinkedHashMap<K, V>> listOfMaps = new ArrayList<>(keys.size());
        LinkedHashMap<K,V> subMap1 = new LinkedHashMap<>(
                keys.stream().limit(limitOfElements)
                        .collect(Collectors.toMap(
                                Function.identity(), map::remove
                                )
                        )
        );
        int i = 0;
        listOfMaps.add(subMap1);
        System.out.println("Mapa nr 1 dodana do listOfMaps");
        i++;
        while (elementsToSkip < keys.size()) {
            listOfMaps.add(
                    new LinkedHashMap<>(
                            keys.stream().skip(elementsToSkip)
                                    .limit(limitOfElements)
                                    .collect(Collectors.toMap(
                                            Function.identity(), map::remove
                                            )
                                    )
                    )
            );
            i++;
            elementsToSkip += 10_000;
            System.out.println("Mapa nr " + i + " dodana do listOfMaps");
        }
    return listOfMaps;
    }
}
