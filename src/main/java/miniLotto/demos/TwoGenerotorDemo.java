package miniLotto.demos;

import miniLotto.models.Two;
import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.util.List;
import java.util.Map;

public class TwoGenerotorDemo {
    public static void main(String[] args) throws Throwable {

        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");//to chyba za duża lista, żeby na niej operować!!!
//        System.out.println("List size:" + listOfSimilarities.size());
//        Presenter.presentList(listOfSimilarities);
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);

            List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                    new int[]{17, 33, 18, 24}, listListOfTwos, 3
            );

       Presenter.presentList(suggestedInNextDraws);
    }
}

