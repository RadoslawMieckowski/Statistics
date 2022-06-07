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
        List<LinkedHashMap<String, Double>> listOfMaps = new ArrayList<>(keys.size());
        LinkedHashMap<String, Double> subMap1 = new LinkedHashMap<>(
                keys.stream().limit(limitOfElements)
                .collect(Collectors.toMap(
                        Function.identity(), deserializedMap::remove
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
                                            Function.identity(), deserializedMap::remove
                                            )
                                    )
                    )
            );
            i++;
            elementsToSkip += 10_000;
            System.out.println("Mapa nr " + i + " dodana do listOfMaps");
        }
        Serializer.serializeListOfMaps(listOfMaps, "src/main/resources/list_of_mapped_distances.ser");
//        deserializedMap.forEach((k, v) -> System.out.println(k + "\t" + v));// drukuje tylko ok 32 000 rekordów.. ale zawiera wszystkie wejścia
        //strumienie mają więc ograniczenia
    }


}
