package miniLotto.experiments;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class TwoGeneratorExperimentTest {
    final static String PATH = "src/main/resources/wyniki-minilotto-sortowane100.csv";

    @Test
    void generateSearchedSetShouldReturnSet() throws Exception {
        Set<Integer> actualSet = TwoGeneratorExperiment.generateSearchedSet(PATH, 0);

        assertThat(actualSet).hasSize(17);
        assertThat(actualSet).contains(4);
        assertThat(actualSet).contains(12);
        assertThat(actualSet).contains(15);
        assertThat(actualSet).contains(16);
        assertThat(actualSet).contains(20);
        assertThat(actualSet).contains(3);
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
        assertThat(actualSet).doesNotContain(6);
        assertThat(actualSet).doesNotContain(17);
    }

    @Test
    void generateSearchedSetShouldReturn20SetsFrom100Lines() throws Exception {
        List<Set<Integer>> listOfSets = new ArrayList<>(95);
        int numberOfLines = 101 - 6;//ostatnia linia jest pusta
        final int RECORDS_INTO_ACCOUNT = 95;//na tej linii ostatnia piątka
        while (numberOfLines != 0) {
            Set<Integer> actualSet = TwoGeneratorExperiment.generateSearchedSet(
                    PATH,
                    RECORDS_INTO_ACCOUNT - numberOfLines);
            listOfSets.add(actualSet);
            numberOfLines--;
        }

        assertThat(listOfSets.size()).isEqualTo(95);

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

        assertThat(listOfSets.get(94)).hasSize(17);//ciekawe, że ten set też ma taki sam rozmiar co w pierszej szufladzie
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
        assertThat(listOfSets.get(94)).contains(11);
        assertThat(listOfSets.get(94)).contains(12);
        assertThat(listOfSets.get(94)).contains(28);
        assertThat(listOfSets.get(94)).contains(41);
        assertThat(listOfSets.get(94)).contains(14);
        assertThat(listOfSets.get(94)).contains(15);
        assertThat(listOfSets.get(94)).contains(37);
        assertThat(listOfSets.get(94)).doesNotContain(6);
        assertThat(listOfSets.get(94)).doesNotContain(17);

    }
}