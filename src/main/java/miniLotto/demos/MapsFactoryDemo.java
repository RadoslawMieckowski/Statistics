package miniLotto.demos;

import miniLotto.utilities.MapsFactory;
import miniLotto.utilities.Serializer;

import java.util.LinkedHashMap;
import java.util.List;

public class MapsFactoryDemo {
    public static void main(String[] args) {
        final String filepath = "src/main/resources/mapOfDistances_serialized.ser";
        LinkedHashMap<String, Double> deserializedMap = new LinkedHashMap<>(Serializer.deserializeMap(filepath));
        List<LinkedHashMap<String, Double>> listOfMaps = MapsFactory.divideMapToListOfMaps(
                deserializedMap, 10_000);
        Serializer.serializeListOfMaps(listOfMaps, "src/main/resources/list_of_mapped_distances.ser");
    }
}
