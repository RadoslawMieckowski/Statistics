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

        final int LIMIT_OF_EACH = 6;
        final int LIMIT_OF_OCCURENCES = 2;

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
                        previousDraw, listListOfTwos, LIMIT_OF_EACH
                );
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        //generowanie zbioru pozbawionego liczb z poprzedniego losowania, zawierającego najczęstsze liczby, które mają licznik wynoszący > ...
            Set<Integer> narrowSet = TwoGeneratorExperiment
                    .generateNarrowProposedSetWithLimit(suggestedInNextDraws, previousDraw, LIMIT_OF_OCCURENCES);
            //wczytanie szukanego setu
            System.out.println("narrowSet: " + narrowSet);
            int narrowSetSize = narrowSet.size();
            System.out.println("ilość do skreślania na kuponie: " + narrowSet.size());
            Set<Integer> setToLookAt = listOfSets.get(i);
            System.out.println("setToLookAt: " + setToLookAt);
            narrowSet.retainAll(setToLookAt);
            System.out.println("wspólne liczby: " + narrowSet);
            int numberOfFoundElements = narrowSet.size();
           // System.out.println(numberOfFoundElements + "\t"+ broadSetSize);
            System.out.println("trafione " + numberOfFoundElements + " na " + narrowSetSize + " liczb");
            double accuracy = ((double)numberOfFoundElements / narrowSetSize) * 100;//trzeba zrzutować, bo dzielenie intów może dać 0
            accuracy = Rounder.round(accuracy, 2);
            System.out.println("próba nr " + i + "\twskaźnik znalezionych liczb" +
                    " w  narrowSetSize: " + accuracy);
            System.out.println("==========================================");
        }
    }
}
