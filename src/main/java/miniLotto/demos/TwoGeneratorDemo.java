package miniLotto.demos;

import miniLotto.experiments.TwoGeneratorExperiment;
import miniLotto.models.Two;
import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TwoGeneratorDemo {
    private static final int LIMIT_OF_OCCURENCES = 1;

    public static void main(String[] args) throws Throwable {

        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");//to chyba za duża lista, żeby na niej operować!!!
//        System.out.println("List size:" + listOfSimilarities.size());
//        Presenter.presentList(listOfSimilarities);
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);


        int previousDraw[] = new int[]{7, 16, 21, 31, 42};
        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                    previousDraw, listListOfTwos, 3
            );

        Set<Integer> narrowSet = TwoGeneratorExperiment
                .generateNarrowProposedSetWithLimit(suggestedInNextDraws, previousDraw, LIMIT_OF_OCCURENCES);

        Presenter.presentList(suggestedInNextDraws);
        System.out.println();
        System.out.println("narrowSet: " + narrowSet);
    }
}

