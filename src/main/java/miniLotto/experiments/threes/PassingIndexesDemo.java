package miniLotto.experiments.threes;

import miniLotto.experiments.ResultsOfFiveDrawsGlobal;
import miniLotto.utilities.Serializer;

import java.util.List;

public class PassingIndexesDemo {
    public static void main(String[] args) {
        //rozpakowanie list
        List<int[]> oldTabsList = Serializer.deserialize("src/main/resources/oldTabListToSerialize.ser");
        List<int[]> newTabsList = Serializer.deserialize("src/main/resources/newTabListToSerialize.ser");
        ResultsOfFiveDrawsGlobal resultsOfFiveDrawsGlobal = new ResultsOfFiveDrawsGlobal();
        final int NUMBER_OF_ROWS = oldTabsList.size();
        //sprawdzanie, które indeksy się przechodzą do nasępnego losowania i wypychanie indeksów do rezulatów
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < 5; j++) {
                for (int x : oldTabsList.get(i)) {
                    if (x == newTabsList.get(i)[j]) {
                        resultsOfFiveDrawsGlobal.add(j);
                        break;
                    }
                }
            }
        }
       resultsOfFiveDrawsGlobal.showResults();

    /*wyniki wskazują, że nie ma żadnej różnicy:

    Zero	32
    Jedynka	39
    Dwójka	38
    Trójka	35
    Czwórka	36
    Piątka	0
   */

    }
}

