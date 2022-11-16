package miniLotto.experiments.threes;

import miniLotto.experiments.ResultsOfFiveDraws;
import miniLotto.experiments.ResultsOfFiveDrawsGlobal;
import miniLotto.experiments.TwoGeneratorExperiment;
import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RepetingThreesDemo {
    public static void main(String[] args) {
        final int LIMIT_OF_EACH = 45;
        final int LIMIT_OF_OCCURENCES = 15;
        //rozpakowanie list
        List<int[]> oldTabsList = Serializer.deserialize("src/main/resources/oldTabListToSerialize.ser");
        List<int[]> newTabsList = Serializer.deserialize("src/main/resources/newTabListToSerialize.ser");
        //stworzenie listy podobieństw dwójek
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory
                .toListOfListOfMaps(listOfSimilarities, 1_000);

        ResultsOfFiveDrawsGlobal resultsGlobal = new ResultsOfFiveDrawsGlobal();
        for (int i = 0; i < oldTabsList.size(); i++) {
            ResultsOfFiveDraws resultsLocal = new ResultsOfFiveDraws();
            int[] previousDraw = oldTabsList.get(i);
            System.out.println("pooprzednie losowanie: " + Arrays.toString(previousDraw));
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
            //dodawanie wszystkich liczb z poprzedniego losowania
            narrowSet.addAll(Arrays.stream(previousDraw).boxed().collect(Collectors.toSet()));
            System.out.println("Proponowane na następne losowanie: " + narrowSet);
            //wczytanie następnego losowania jako Set
            Set<Integer> nextDrawnSet = Arrays.stream(newTabsList.get(i)).boxed().collect(Collectors.toSet());
            System.out.println("Następne losowanie: " + nextDrawnSet);
            nextDrawnSet.retainAll(narrowSet);
            int result = nextDrawnSet.size();
            //zapis result do ResultsOfFiveDraws i Global
            resultsLocal.add(result);
            resultsGlobal.add(result);
            resultsLocal.showResults();
            System.out.println("=======================================");
        }
        System.out.println("##########################################");
        resultsGlobal.showResults();
    }
}
