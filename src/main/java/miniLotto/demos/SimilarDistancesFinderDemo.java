package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.Extracter;
import miniLotto.utilities.Serializer;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class SimilarDistancesFinderDemo {
    public static void main(String[] args) {
       final String path = "src/main/resources/Twos_serialized.ser";
        List<Two> deserializedList = Serializer.deserialize(path);
//        BiConsumer<String, List> biConsumer =
        Map<Two, List<Integer>> mapOfDistances = Extracter.ListOfTwosToMapOfDistances(deserializedList);
        List<>
//        mapOfDistances.forEach((k, v) -> );
    }
}
