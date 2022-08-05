package miniLotto.experiments;

import miniLotto.utilities.ListFactory;
import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.TwoGenerator;
import org.junit.jupiter.api.Test;

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

    @Test
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
    void generateProposedBroadSetTest() throws Throwable {
        List<Map<String, Double>> listOfSimilarities = Serializer.deserializeListOfMaps(
                "src/main/resources/list_of_mapped_distances.ser");
        List<List<Map<String, Double>>> listListOfTwos = ListFactory.toListOfListOfMaps(listOfSimilarities, 1_000);
        int[] previousDraw = new int[]{4, 19, 22, 26, 29};
        List<List<Map.Entry<String, Double>>> suggestedInNextDraws = TwoGenerator.generateListOfTwos(
                previousDraw, listListOfTwos, 3
        );

        Set<Integer> actualBroadSet = TwoGeneratorExperiment.generateProposedBroadSet(suggestedInNextDraws, previousDraw);


    }
}