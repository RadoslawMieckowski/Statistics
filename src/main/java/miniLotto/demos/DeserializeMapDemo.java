package miniLotto.demos;

import miniLotto.utilities.Serializer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static miniLotto.utilities.Presenter.presentMap;

public class DeserializeMapDemo {
    public static void main(String[] args) {
        final String filepath = "src/main/resources/mapOfDistances_serialized.ser";
        LinkedHashMap<String, Double> deserializedMap = new LinkedHashMap<>(Serializer.deserializeMap(filepath));
        System.out.println("size of map: " + deserializedMap.size());
        List<String> keys = new ArrayList<>(deserializedMap.keySet());
        long elementsToSkip = 10_000;
        long limitOfElements = 10_000;
        List<LinkedHashMap<String, Double>> listOfMaps= new LinkedList<>();
        String currentKey;
        LinkedHashMap<String, Double> subMap1 = new LinkedHashMap<>(
                keys.stream().limit(elementsToSkip)
                .collect(Collectors.toMap(
                        Function.identity(), deserializedMap::get
                        )
                )
        );
        currentKey = keys.get(subMap1.size() - 1);
        listOfMaps.add(subMap1);
        while (!currentKey.equals(keys.get(keys.size() - 1))) {
            listOfMaps.add(
                    new LinkedHashMap<>(
                            keys.stream().skip(elementsToSkip)
                                    .limit(limitOfElements)
                                    .collect(Collectors.toMap(
                                            Function.identity(), deserializedMap::get
                                            )
                                    )
                    )
            );
            elementsToSkip += 10_000;
            currentKey += keys.get(listOfMaps.get(listOfMaps.size() - 1).size());
        }//na ten moment stworzona jest lista map
//        System.out.println("Size of listOfMaps: " + listOfMaps.size());
        System.out.println(listOfMaps);
        //presentMap(deserializedMap, "similarity", "numbers");
//        deserializedMap.forEach((k, v) -> System.out.println(k + "\t" + v));// drukuje tylko ok 32 000 rekordów.. ale zawiera wszystkie wejścia
    }


}
