package miniLotto.experiments.threes;

import miniLotto.utilities.Presenter;
import miniLotto.utilities.Serializer;
import miniLotto.utilities.Statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RepetingThreesSerializer {
    static int oldTab[]=new int[5];
    static int newTab[]=new int[5];
    static int counter=0;
    static LinkedList<Integer> winningDistances;
    static int counterOfDistancesBetweenThrees = 1;
    static LinkedList<int[]> oldTabListToSerialize;
    static LinkedList<int[]> newTabListToSerialize;
    final static String OLD_TAB_LIST_SER_FILE ="src/main/resources/oldTabListToSerialize.ser";
    final static String NEW_TAB_LIST_SER_FILE ="src/main/resources/newTabListToSerialize.ser";

    public static void main(String[] args) {
        winningDistances = new LinkedList<>();
        oldTabListToSerialize = new LinkedList<>();
        newTabListToSerialize = new LinkedList<>();
        Scanner in = readFile("src/main/java/miniLotto/wyniki-minilotto-sortowane-parsed.csv");
        lookForThreesAndMakeWinningDistancesList(in);// mamy obliczone znalezione winning distances
        System.out.println();
        System.out.println("==========================================");
        Statistics.showStatistics(winningDistances);
        in.close();
//        System.out.println("tuż przed serializacją: ");
//        Presenter.presentListOfIntTables(newTabListToSerialize);
//        System.out.println();
//        Presenter.presentListOfIntTables(oldTabListToSerialize);
        Serializer.serialize(oldTabListToSerialize, OLD_TAB_LIST_SER_FILE);
        Serializer.serialize(newTabListToSerialize, NEW_TAB_LIST_SER_FILE);
    }

    static Scanner readFile(String fileName) {
        Scanner in = null;
        try {
            in = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }

    static void lookForThreesAndMakeWinningDistancesList(Scanner in) {
        for (int i = 0; i < 5; i++){
            oldTab[i] = in.nextInt();
        }
//        System.out.println(Arrays.toString(oldTab));
        for (int i = 0; i < 5; i++){
            newTab[i] = in.nextInt();
        }
//        System.out.println(Arrays.toString(newTab));

        findingWinningDistancesAndCountWins();
        System.out.println(counter);

        while (in.hasNextLine()) {
            oldTab = Arrays.copyOf(newTab,5);
//            System.out.println(Arrays.toString(oldTab));
            newTab = new int[5];
            for (int i = 0; i < 5; i++){
                newTab[i] = in.nextInt();
            }
//            System.out.println(Arrays.toString(newTab));
            findingWinningDistancesAndCountWins();
          /*  System.out.println("liczba znalezionych przypadków (trójek z poprzedniego losowania): "
                    + counter);*/
        }
    }

    static void findingWinningDistancesAndCountWins() {
        boolean isSuccess = false;
        int counterThree = 0;
        stop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (oldTab[i] == newTab[j]) {
                    counterThree++;
                    if (counterThree == 3) {
                        counter++;
                        isSuccess = true;
                        winningDistances.add(counterOfDistancesBetweenThrees);
                        counterOfDistancesBetweenThrees = 1;
                        System.out.println(Arrays.toString(oldTab));
                        oldTabListToSerialize.add(oldTab);
                        System.out.println(Arrays.toString(newTab));
                        newTabListToSerialize.add(newTab);
                        System.out.println();
                        break stop;
                    }
                }
            }
        }
        if (isSuccess == false) {
            counterOfDistancesBetweenThrees++;
        }
    }
}
