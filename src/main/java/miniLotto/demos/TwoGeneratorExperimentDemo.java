package miniLotto.demos;

import miniLotto.experiments.TwoGeneratorExperiment;
import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoGeneratorExperimentDemo {
    public static void main(String[] args) {
        final String PATH = "src/main/resources/wyniki-minilotto-sortowane100.csv";

        //stworzenie listy podobieństw dwójek
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory
                .toListOfListOfMaps(listOfSimilarities, 1_000);

        //pobranie całego pliku jako lista tablic Integer
        List<Integer[]> integerList = null;
        int RECORDS = 0;
        int[] previousDraw = new int[5];
        try {
             integerList = ListFactory.readFile(PATH, "\t");
             RECORDS = integerList.size();

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < RECORDS; i++) {
            for (int j = 0; j < 5; j++) {
                previousDraw[j] = integerList.get(i)[j];
            }
            List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                    previousDraw, listListOfTwos, 3
            );

            Set<Integer> actualBroadSet = TwoGeneratorExperiment.generateNarrowProposedSet(suggestedInNextDraws, previousDraw);
        }
    }
}
