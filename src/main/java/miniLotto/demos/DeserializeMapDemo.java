package miniLotto.demos;

import miniLotto.utilities.Serializer;

import java.util.TreeMap;

import static miniLotto.utilities.Presenter.presentMap;

public class DeserializeMapDemo {
    public static void main(String[] args) {
        final String filepath = "src/main/resources/mapOfDistances_serialized.ser";
        TreeMap<String, Double> deserializedMap = new TreeMap<>(Serializer.deserializeMap(filepath));
        System.out.println("size of map: " + deserializedMap.size());
        //presentMap(deserializedMap, "similarity", "numbers");
        deserializedMap.forEach((k, v) -> System.out.println(k + "\t" + v));// drukuje tylko ok 32 000 rekordów..
    }


}
