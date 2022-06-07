package miniLotto.demos;

import miniLotto.utilities.Serializer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static miniLotto.utilities.Presenter.presentMap;
//dzieli dużą mapę na listę małych map do serializacji do wskazanego pliku
public class DeserializeMapDemo {
    public static void main(String[] args) {
        final String filepath = "src/main/resources/mapOfDistances_serialized.ser";
        LinkedHashMap<String, Double> deserializedMap = new LinkedHashMap<>(Serializer.deserializeMap(filepath));
//        System.out.println("size of map: " + deserializedMap.size());
        List<String> keys = new ArrayList<>(deserializedMap.keySet());
        long elementsToSkip = 10_000;
        long limitOfElements = 10_000;
        List<LinkedHashMap<String, Double>> listOfMaps= new ArrayList<>(keys.size());
        String currentKey;
        LinkedHashMap<String, Double> subMap1 = new LinkedHashMap<>(
                keys.stream().limit(elementsToSkip)
                .collect(Collectors.toMap(
                        Function.identity(), deserializedMap::remove
                        )
                )
        );
        currentKey = keys.get(subMap1.size() - 1);
        int i = 0;
        listOfMaps.add(subMap1);
        i++;
        while (!currentKey.equals(keys.get(keys.size() - 1))) {
            listOfMaps.add(
                    new LinkedHashMap<>(
                            keys.stream().skip(elementsToSkip)
                                    .limit(limitOfElements)
                                    .collect(Collectors.toMap(
                                            Function.identity(), deserializedMap::remove
                                            )
                                    )
                    )
            );
            i++;
            elementsToSkip += 10_000;
            currentKey += keys.get(listOfMaps.get(listOfMaps.size() - 1).size());
            System.out.println("Mapa nr " + i + "dodana do listOfMaps");
        }//na ten moment stworzona jest lista map
        Serializer.serializeListOfMaps(listOfMaps, "src/main/resources/list_of_mapped_distances.ser");
//        System.out.println("Size of listOfMaps: " + listOfMaps.size());
//        System.out.println(subMap1);
//        presentMap(deserializedMap, "similarity", "numbers");
//        deserializedMap.forEach((k, v) -> System.out.println(k + "\t" + v));// drukuje tylko ok 32 000 rekordów.. ale zawiera wszystkie wejścia
    }


}
