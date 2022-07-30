package miniLotto.demos;

import miniLotto.experiments.TwoGeneratorExperiment;

import java.io.FileNotFoundException;

public class TwoGeneratorExperimentDemo {
    public static void main(String[] args) {
        final String PATH = "src/main/resources/wyniki-minilotto-sortowane100.csv";
        try {
            TwoGeneratorExperiment.generateSearchedSet(PATH, 0);
        } catch (FileNotFoundException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
