package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.Extracter;
import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.Statistics;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class SimilarDistancesFinderDemo {
    public static void main(String[] args) {
       final String path = "src/main/resources/Twos_serialized.ser";
        List<Two> deserializedList = Serializer.deserialize(path);
        Map<String, Double> mapOfDistances = new LinkedHashMap<>();
        for(int i = 0; i < deserializedList.size(); i++) {
            for (int j = i + 1; j < deserializedList.size(); j++) {
                double similarity = Statistics.cosDistance(
                        deserializedList.get(i).getDistances(),
                        deserializedList.get(j).getDistances()
                );
                mapOfDistances.put(
                        deserializedList.get(i).getFirstNumber() + "|" +
                        deserializedList.get(i).getSecondNumber() + " i " +
                        deserializedList.get(j).getFirstNumber() + "|" +
                        deserializedList.get(j).getSecondNumber(),
                        similarity);
            }
        }
        Presenter.presentMap(mapOfDistances, "similarity", "");
    }
}
