package miniLotto.experiments;

import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class RealLifeExperiment {
    public static void main(String[] args) {
        final String PATH = "src/main/resources/wyniki-minilotto-sortowane100.csv";

        final int LIMIT_OF_EACH = 3;
        final int LIMIT_OF_OCCURENCES = 1;
        final int THRESHOLD_iNDEX = 10;//określa, losowania które mają być nie brane pod uwagę.
        final int NARROW_SET_SIZE_LIMIT = 12;   //jeżeli jest zbyt duży, nie zagramy, ale usuniemy z niego losowania
        // uzasadnienie: te losowania mogą zaniżać statystyki

        //stworzenie listy podobieństw dwójek
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory
                .toListOfListOfMaps(listOfSimilarities, 1_000);

        List<Integer[]> integerRecordsList;
        int RECORDS_NUMBER;
        int[] previousDraw = new int[5];
        ResultsOfFiveDrawsGlobal resultsGlobal = new ResultsOfFiveDrawsGlobal();

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
                ResultsOfFiveDraws results = new ResultsOfFiveDraws();
                System.out.println("proponowane na następne 5 losowań: " + narrowSet);
                System.out.println();
                for (int x = 1; x <= 5; x++) {
                    if (i + x == RECORDS_NUMBER) {
                        break;
                    }
                    if (x > THRESHOLD_iNDEX) {//jak chcesz, żeby wszystkie były brane pod uwagę, to daj np.10. x nigdy nie jest 10
                        continue;
                    }
                    Set<Integer> nextDrawnSet = Arrays.stream(integerRecordsList.get(i + x)).collect(Collectors.toSet());
                    if (narrowSet.size() > NARROW_SET_SIZE_LIMIT) {
                        narrowSet.removeAll(nextDrawnSet);
                        continue;
                    }
                    System.out.println("losowanie: " + nextDrawnSet);
                    nextDrawnSet.retainAll(narrowSet);
                    int result = nextDrawnSet.size();
                    //zapis result do ResultsOfFiveDraws
                    results.add(result);
                    resultsGlobal.add(result);
                    narrowSet.removeAll(nextDrawnSet);
                }
                i += 5;
                if (i >= RECORDS_NUMBER) {
                    break;
                }
                System.out.println("numer ostatniego losowania: " + i);
                System.out.println();
                results.showResults();
                System.out.println("=======================================");
            }
            System.out.println("*******************************************");
            System.out.println("Podsumowanie: \n" + resultsGlobal.showResults());
            System.out.println("udział wygranych w ogólnej liczbie zakładów: " + resultsGlobal.getSuccessFactor());
            System.out.println("*******************************************");
// sprawdź na małym zbiorze, czy wszystko działa dobrze
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// sprawdź, ile trójek czwórek, i w których losowaniach
//zbór skresleń na podstawie dopełnienia zbioru z proponowanymi liczbami
//zrób track liste trójek/czwórek
