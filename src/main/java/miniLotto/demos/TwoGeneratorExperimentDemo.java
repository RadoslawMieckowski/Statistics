package miniLotto.demos;

import miniLotto.experiments.TwoGeneratorExperiment;
import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Rounder;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

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
        List<Integer[]> integerRecordsList = null;
        int RECORDS_NUMBER = 0;
        int[] previousDraw = new int[5];
        List<Set<Integer>> listOfSets = null;
        try {
             integerRecordsList = ListFactory.readFile(PATH, "\t");
             RECORDS_NUMBER = integerRecordsList.size();
            //wygenerowanie zbiorów z liczbami z kolejnych pięciu losowań
              listOfSets = TwoGeneratorExperiment
                     .generateSearchedSetsToGivenPointInCSVFile(100, PATH);

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < RECORDS_NUMBER - 4; i++) {
            //wczytanie pojedyńczego rekordu
            for (int j = 0; j < 5; j++) {
                previousDraw[j] = integerRecordsList.get(i)[j];
            }
            List<List<Map.Entry<String, Double>>> suggestedInNextDraws = null;
            try {
                //wybór trzech najbardziej podobnych do każdej dwójki
                suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                        previousDraw, listListOfTwos, 3
                );
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        //generowanie zbioru pozbawionego liczb z poprzedniego losowania, zawierającego najczęstsze liczby, które mają licznik wynoszący > 1
            Set<Integer> actualBroadSet = TwoGeneratorExperiment.generateNarrowProposedSet(suggestedInNextDraws, previousDraw);
            //wczytanie szukanego setu
            Set<Integer> setToLookAt = listOfSets.get(i);
            int actualBroadSetSize = actualBroadSet.size();
            setToLookAt.retainAll(actualBroadSet);
            int numberOfFoundElements = setToLookAt.size();
            double accuracy = numberOfFoundElements / actualBroadSetSize * 100;
            accuracy = Rounder.round(accuracy, 2);
            System.out.println("próba nr " + i + "\twskaźnik znalezionych liczb" +
                    "w  proponowanym zbiorze w ciągu kolejnych 5-ciu losowan: "
                    + accuracy);
        }
    }
}
