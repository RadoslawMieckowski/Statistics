package miniLotto.demos;

import miniLotto.utilities.Finder;
import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;

import java.util.*;

public class MaxSimilaritiesInListOfMapsDemo {
    public static void main(String[] args) {
        final String path = "src/main/resources/list_of_mapped_distances.ser";
        List<Map<String, Double>> deserializedListOfMaps = Serializer.deserializeListOfMaps(path);
        int size = deserializedListOfMaps.size();
        HashMap<String, Double> mapOfMaxSimilarities = new HashMap<>(size);
        for (Map<String, Double> map : deserializedListOfMaps) {
            Map.Entry maxEntry = Finder.findEntryWithHighestSimilarity(map);
            mapOfMaxSimilarities.put(
                    (String) maxEntry.getKey(),
                    (Double) maxEntry.getValue()
            );
        }
        Presenter.presentMap(mapOfMaxSimilarities, "similarity","");
    }
}
