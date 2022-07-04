package miniLotto.demos;

import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;

import java.util.List;
import java.util.Map;

public class TwoGenerotorDemo {
    public static void main(String[] args) throws Throwable {
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");//to chyba za duża lista, żeby na niej operować!!!
        Presenter.presentList(listOfSimilarities);
//        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
//                new int[]{4, 18, 21, 40, 41}, listOfSimilarities, 1
//        );
//        Presenter.presentList(suggestedInNextDraws);
    }
}
