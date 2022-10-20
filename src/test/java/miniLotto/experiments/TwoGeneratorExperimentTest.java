package miniLotto.experiments;

import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class TwoGeneratorExperimentTest {
    final static String PATH = "src/main/resources/wyniki-minilotto-sortowane100.csv";

    @Test
    void generateSearchedSetShouldReturnSetI() throws Exception {
        Set<Integer> actualSet = TwoGeneratorExperiment.generateSearchedSet(PATH, 1);
//szukany set NIE uwzględnia poprzedniego losowania!
        assertThat(actualSet).hasSize(19);
        assertThat(actualSet).contains(4);
        assertThat(actualSet).contains(3);
        assertThat(actualSet).contains(20);
        assertThat(actualSet).contains(29);
        assertThat(actualSet).contains(32);
        assertThat(actualSet).contains(10);
        assertThat(actualSet).contains(13);
        assertThat(actualSet).contains(18);
        assertThat(actualSet).contains(35);
        assertThat(actualSet).contains(40);
        assertThat(actualSet).contains(7);
        assertThat(actualSet).contains(8);
        assertThat(actualSet).contains(21);
        assertThat(actualSet).contains(24);
        assertThat(actualSet).contains(6);
        assertThat(actualSet).contains(12);
        assertThat(actualSet).contains(17);
        assertThat(actualSet).contains(22);
        assertThat(actualSet).contains(28);
        assertThat(actualSet).doesNotContain(1);
        assertThat(actualSet).doesNotContain(2);
    }

    @Test
    void generateSearchedSetShouldReturnSetII() throws Exception {
        Set<Integer> actualSet = TwoGeneratorExperiment.generateSearchedSet(PATH, 95);

        assertThat(actualSet).hasSize(17);
        assertThat(actualSet).contains(8);
        assertThat(actualSet).contains(25);
        assertThat(actualSet).contains(36);
        assertThat(actualSet).contains(38);
        assertThat(actualSet).contains(40);
        assertThat(actualSet).contains(7);
        assertThat(actualSet).contains(9);
        assertThat(actualSet).contains(34);
        assertThat(actualSet).contains(39);
        assertThat(actualSet).contains(2);
        assertThat(actualSet).contains(11);
        assertThat(actualSet).contains(12);
        assertThat(actualSet).contains(28);
        assertThat(actualSet).contains(41);
        assertThat(actualSet).contains(14);
        assertThat(actualSet).contains(15);
        assertThat(actualSet).contains(37);
        assertThat(actualSet).doesNotContain(6);
        assertThat(actualSet).doesNotContain(17);
    }

    @Test
    void generateSearchedSetsToGivenPointInCSVFileShouldReturn96SetsFrom100Lines() throws Exception {
        List<Set<Integer>> listOfSets = TwoGeneratorExperiment.generateSearchedSetsToGivenPointInCSVFile(
                100, PATH);

        assertThat(listOfSets.size()).isEqualTo(96);

        assertThat(listOfSets.get(0)).hasSize(17);
        assertThat(listOfSets.get(0)).contains(4);
        assertThat(listOfSets.get(0)).contains(12);
        assertThat(listOfSets.get(0)).contains(15);
        assertThat(listOfSets.get(0)).contains(16);
        assertThat(listOfSets.get(0)).contains(20);
        assertThat(listOfSets.get(0)).contains(3);
        assertThat(listOfSets.get(0)).contains(29);
        assertThat(listOfSets.get(0)).contains(32);
        assertThat(listOfSets.get(0)).contains(10);
        assertThat(listOfSets.get(0)).contains(13);
        assertThat(listOfSets.get(0)).contains(18);
        assertThat(listOfSets.get(0)).contains(35);
        assertThat(listOfSets.get(0)).contains(40);
        assertThat(listOfSets.get(0)).contains(7);
        assertThat(listOfSets.get(0)).contains(8);
        assertThat(listOfSets.get(0)).contains(21);
        assertThat(listOfSets.get(0)).contains(24);
        assertThat(listOfSets.get(0)).doesNotContain(6);
        assertThat(listOfSets.get(0)).doesNotContain(17);

        assertThat(listOfSets.get(95)).hasSize(17);//ciekawe, że ten set też ma taki sam rozmiar co w pierszej szufladzie
        assertThat(listOfSets.get(95)).contains(8);
        assertThat(listOfSets.get(95)).contains(25);
        assertThat(listOfSets.get(95)).contains(36);
        assertThat(listOfSets.get(95)).contains(38);
        assertThat(listOfSets.get(95)).contains(40);
        assertThat(listOfSets.get(95)).contains(7);
        assertThat(listOfSets.get(95)).contains(9);
        assertThat(listOfSets.get(95)).contains(34);
        assertThat(listOfSets.get(95)).contains(39);
        assertThat(listOfSets.get(95)).contains(2);
        assertThat(listOfSets.get(95)).contains(11);
        assertThat(listOfSets.get(95)).contains(12);
        assertThat(listOfSets.get(95)).contains(28);
        assertThat(listOfSets.get(95)).contains(41);
        assertThat(listOfSets.get(95)).contains(14);
        assertThat(listOfSets.get(95)).contains(15);
        assertThat(listOfSets.get(95)).contains(37);
        assertThat(listOfSets.get(95)).doesNotContain(6);
        assertThat(listOfSets.get(95)).doesNotContain(17);
    }

    @Test//nie wiem, czy nazwa nie jest myląca
    void generateSearchedSetsToGivenPointInCSVFileShouldReturn95SetsFrom100Lines() throws Exception {
        List<Set<Integer>> listOfSets = TwoGeneratorExperiment.generateSearchedSetsToGivenPointInCSVFile(
                100, PATH);

        assertThat(listOfSets.get(94)).hasSize(17);
        assertThat(listOfSets.get(94)).contains(31);
        assertThat(listOfSets.get(94)).contains(32);
        assertThat(listOfSets.get(94)).contains(33);
        assertThat(listOfSets.get(94)).contains(41);
        assertThat(listOfSets.get(94)).contains(8);
        assertThat(listOfSets.get(94)).contains(25);
        assertThat(listOfSets.get(94)).contains(36);
        assertThat(listOfSets.get(94)).contains(38);
        assertThat(listOfSets.get(94)).contains(40);
        assertThat(listOfSets.get(94)).contains(7);
        assertThat(listOfSets.get(94)).contains(9);
        assertThat(listOfSets.get(94)).contains(34);
        assertThat(listOfSets.get(94)).contains(39);
        assertThat(listOfSets.get(94)).contains(2);
        assertThat(listOfSets.get(94)).contains(12);
        assertThat(listOfSets.get(94)).contains(28);
        assertThat(listOfSets.get(94)).contains(11);
        assertThat(listOfSets.get(94)).doesNotContain(6);
        assertThat(listOfSets.get(94)).doesNotContain(17);
    }

    @Test
    void parseTest() {
        ArrayList<Integer> actualList = new ArrayList<>();
        TwoGeneratorExperiment.parse("2|17 i 10|23", actualList);

        assertThat(actualList).hasSize(4);
        assertThat(actualList).contains(2, 17, 10, 23);
        assertThat(actualList).doesNotContain(1, 7, 0, 3);
    }

    @Test//przy eksperymentach tego typu w zależności od tego,
        // jakie są mapy podobieństwa dwójek (będzie OK, jak nie będą zmieniane)
        // mogą wychodzić różne wyniki w przyszłości
    void generateNarrowProposedSetTest() throws Throwable {
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);
        int[] previousDraw = new int[]{10, 23, 24, 28, 35};
        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                previousDraw, listListOfTwos, 3
        );

        Set<Integer> actualSet = TwoGeneratorExperiment.generateNarrowProposedSet(suggestedInNextDraws, previousDraw);

        assertThat(actualSet).contains(17,11,6,26,36,8,30,1,33,19,4,32,27,16,37,42);
        assertThat(actualSet).hasSize(16);
        assertThat(actualSet).doesNotContain(5,9,10,13,14,18,20,23,24,	28,29,34,35,40);
    }

    @Test
    void generateNarrowProposedSetTestWithAnotherData() throws Throwable {
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);
        int[] previousDraw = new int[]{1, 7, 37, 39, 45};// rzuci wyjątek. w mini lotto było na samym początku 49 liczb!
        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                previousDraw, listListOfTwos, 45
        );
        System.out.println(suggestedInNextDraws);

        Set<Integer> narrowSet = TwoGeneratorExperiment
                .generateNarrowProposedSetWithLimit(suggestedInNextDraws, previousDraw, 15);
        assertThat(narrowSet).isNotNull();
        assertThat(narrowSet).isNotEmpty();

        System.out.println(narrowSet);

//        assertThat(actualBroadSet).contains(18,12,26,29,6,27,31,3,33,20,22,2,10,32,34);
//        assertThat(actualBroadSet).hasSize(15);
//        assertThat(actualBroadSet).doesNotContain(4, 5, 8, 9, 14, 15, 16, 19, 23, 28, 37, 38);
    }

    @Test
    void generateNarrowProposedSetTestWithAnotherData2() throws Throwable {
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);
        int[] previousDraw = new int[]{4,19,22,26,29};
        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                previousDraw, listListOfTwos, 3
        );

        Set<Integer> actualBroadSet = TwoGeneratorExperiment.generateNarrowProposedSet(suggestedInNextDraws, previousDraw);

        assertThat(actualBroadSet).contains(27,10,2,12,6,42,14,36,17,37,1,35,34,15,31);
        assertThat(actualBroadSet).hasSize(15);
        assertThat(actualBroadSet).doesNotContain(4,19,22,26,29,5,19,21,24,32,38,41,3,7,8,9,11,13,16,18,20,23,25,28,30,33,39,40);
    }

    @Test
    void generateNarrowProposedSetTestWithAnotherData3() throws Throwable {
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);
        int[] previousDraw = new int[]{4, 12, 15, 16, 20};
        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                previousDraw, listListOfTwos, 3
        );

        Set<Integer> actualBroadSet = TwoGeneratorExperiment.generateNarrowProposedSet(suggestedInNextDraws, previousDraw);

        assertThat(actualBroadSet).contains(17, 18, 3, 6, 39, 8, 24, 40, 9, 42, 27, 14);
        assertThat(actualBroadSet).hasSize(12);
    }
}