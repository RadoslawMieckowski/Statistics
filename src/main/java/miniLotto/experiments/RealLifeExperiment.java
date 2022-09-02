package miniLotto.experiments;

import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RealLifeExperiment {
    public static void main(String[] args) {
        final String PATH = "src/main/resources/wyniki-minilotto-sortowane100.csv";

        final int LIMIT_OF_EACH = 3;
        final int LIMIT_OF_OCCURENCES = 1;

        //stworzenie listy podobieństw dwójek
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory
                .toListOfListOfMaps(listOfSimilarities, 1_000);

        List<Integer[]> integerRecordsList;
        int RECORDS_NUMBER;
        int[] previousDraw = new int[5];

        try {
            //wczytanie losowań jako tablice Integer
            integerRecordsList = ListFactory.readFile(PATH, "\t");
            RECORDS_NUMBER = integerRecordsList.size();
            int i = 0;
            while (i < RECORDS_NUMBER) {
                Integer[] previousBuffer = integerRecordsList.get(i);
                //zapełnienie poprzedniego losowania
                for (int j = 0; j < previousDraw.length; j++) {
                    previousDraw[j] = previousBuffer[j];
                }
                //wybieranie proponowanych liczb
                List<List<Map.Entry<String, Double>>> suggestedInNextDraws = null;
                try {
                    suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                            previousDraw, listListOfTwos, LIMIT_OF_EACH);

                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                Set<Integer> narrowSet = TwoGeneratorExperiment
                        .generateNarrowProposedSetWithLimit(suggestedInNextDraws, previousDraw, LIMIT_OF_OCCURENCES);
                //wczytanie następnego losowania jako Set
                for (int x = 1; x <= 5; x++) {
                    int proposedSetSize = narrowSet.size();
                    Set<Integer> nextDrawnSet = Arrays.stream(integerRecordsList.get(i + x)).collect(Collectors.toSet());
                    nextDrawnSet.retainAll(narrowSet);
                    int result = nextDrawnSet.size();
                    //zapis result do DrawStatics
                }
                i += 5;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
